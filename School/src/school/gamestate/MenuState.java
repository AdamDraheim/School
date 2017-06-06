package school.gamestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import school.game.Game;
import school.game.Game.STATE;
import school.game.Handler;

public class MenuState extends MouseAdapter{
	private Game game;
	private Handler handler;
	public MenuState(Game game, Handler handler){
		this.game = game;
		this.handler = handler;
	}
	
	public void mousePressed(MouseEvent e){
		
		int mx = e.getX();
		int my = e.getY();
		
		if(game.gameState == STATE.menu){
			
			if(mouseOver(mx, my, 250, 200, 300, 100)){
				game.gameState = STATE.charsel;
			}else if(mouseOver(mx, my, 250, 350, 300, 100)){
				System.exit(1);
			}
			
		}
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
		if(mx > x && mx < x + width){
			if(my > y && my < y + height){
				return true;
			}else return false;
		}else return false;
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g){
		g.setColor(Color.black);
		g.setFont(new Font("KodchiangUPC", 1, 150));
		
		g.drawString("School", 250, 150);
		g.setColor(Color.red);
		g.fillRect(249,199,302,102);
		g.fillRect(249, 349, 302, 102);
		g.setColor(Color.green);
		g.fillRect(250, 200, 300, 100);
		g.fillRect(250,  350,  300,  100);
		
		g.setColor(Color.black);
		g.setFont(new Font("KodchiangUPC", 1, 95));
		g.drawString("PLAY", 318, 270);
		g.drawString("QUIT", 318, 425);
		g.setFont(new Font("KodchaingUPC", 1, 20));
		g.setColor(Color.black);
		g.drawString("Einstein 2017 RPG", Game.width - 200, Game.height - 20);
	}

}
