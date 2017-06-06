package school.game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.Random;

import school.anim.BufferedImageLoader;
import school.anim.Texture;
import school.blocks.Block;
import school.creatures.Player;
import school.gamestate.MenuState;
import school.gamestate.QuestList;
import school.gamestate.Artifacts;
import school.gamestate.Background;
import school.gamestate.Charsel;
import school.gamestate.Filter;
import school.gamestate.HUD;
import school.input.KeyInput;


public class Game extends Canvas implements Runnable{

	private boolean running = false;
	private Thread thread;
	public static int width, height;
	Handler handler;
	static Texture tex;
	HUD hud;
	Camera cam;
	QuestList questList;
	Background bg;
	Artifacts art;
	Filter filter;

	MenuState menu;
	Charsel character;
	
	public enum STATE{
		
		menu,
		game,
		charsel
		
	}
	
	public static STATE gameState = STATE.menu;

	
	private void init(){
		
		width = getWidth();
		height = getHeight();
		handler = new Handler(cam, this);
		tex = new Texture();
		questList = new QuestList();
		bg = new Background(this, handler);
		hud = new HUD(this, handler);
		filter = new Filter(this, handler);
		
		BufferedImageLoader loader = new BufferedImageLoader();
		
		cam = new Camera(0, 0, handler);
		menu = new MenuState(this, handler);
		character = new Charsel(this, handler, cam);
		art = new Artifacts(this, handler);
		
		this.addKeyListener(new KeyInput(handler));
		
		this.addMouseListener(menu);
		this.addMouseListener(character);

		
	}
	
	public synchronized void start(){
		
		if(running)
			return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
		
		
	}
	
	public synchronized void stop(){
		if(!running) return;
		
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run(){
	
	init();
	this.requestFocus();
	long lastTime = System.nanoTime();
	double amountOfTicks = 60.0;
	double ns = 1000000000 / amountOfTicks;
	double delta = 0;
	long timer = System.currentTimeMillis();
	int updates = 0;
	int frames = 0;
	while(running){
		long now = System.nanoTime();
		delta += (now - lastTime) / ns;
		lastTime = now;
		while(delta >= 1){
			tick();
			updates++;
			delta--;
		}
		render();
		frames++;
		
		if(System.currentTimeMillis() - timer > 1000){
			timer += 1000;
			System.out.println("FPS: " + frames + " Ticks: " + updates);
			frames = 0;
			updates = 0;
		}
	}
	
}

	public void tick(){
	
		if(gameState == STATE.game){
			handler.tick();
			questList.tick();
			hud.tick();
			for(int i = 0; i < handler.object.size(); i++){
				if(handler.object.get(i).getId() == ID.player){
					cam.tick(handler.object.get(i));
				}
			}
		}else if(gameState == STATE.menu){
			menu.tick();
		}else if(gameState == STATE.charsel){
			character.tick();
		}
}

public void render(){
	
	BufferStrategy bs = this.getBufferStrategy();
	if(bs == null){
		this.createBufferStrategy(3);
		return;
		
	}
	
	Graphics g = bs.getDrawGraphics();
	
	Graphics2D g2d = (Graphics2D) g;
	
	if(gameState != STATE.game){
		g.setColor(Color.white);
		g.fillRect(0, 0, width, height);
	}else{
		g.setColor(Color.black);
		g.fillRect(0, 0, width, height);

	}
	if(gameState == STATE.game){
				
		g2d.translate(cam.getX(), cam.getY());//begin cam
		
		bg.render(g);
		handler.render(g);
		
		g2d.translate(-cam.getX(), -cam.getY());
		
		filter.render(g);
		questList.render(g);
		art.render(g);
		hud.render(g);

		
	}else if(gameState == STATE.menu){
		menu.render(g);
	}else if(gameState == STATE.charsel){
		character.render(g);
	}
	
		g.dispose();
		bs.show();
	}
		
	public static Texture getInstance(){
		return tex;
	}
	
	public static void main(String[] args) {
		
		new Window(800, 600,"School" , new Game());

	}

	public static int clamp(int var, int min, int max){
		if(var >= max){
			return max;
		}else if(var <= min){
			return min;
		}else{
			return var;
		}
	}

}
