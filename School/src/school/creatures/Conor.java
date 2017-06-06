package school.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import school.anim.Texture;
import school.game.Camera;
import school.game.Game;
import school.game.GameObject;
import school.game.Handler;
import school.game.ID;
import school.gamestate.Artifacts;
import school.gamestate.Charsel;
import school.objects.SpencerReward;

public class Conor extends GameObject{

	private float width = 32, height = 32;
	private final float maxSpeed = 10;
	private Handler handler;
	public int facing = 1;
	private Game game;
	Texture tex = Game.getInstance();
	int student;
	int timer = 100;

	
	public Conor(float x, float y, Handler handler, ID id, Game game, int student) {
		super(x, y, id);
		this.handler = handler;
		velX = 0;
		velY = 0;
		this.game = game;
		this.student = student;

		
	}

	public void tick() {
		
		timer--;
		x += velX;
		y += velY;
		if(timer <= 0){
			facing = (int)(Math.random()* 4) + 1;
			timer = 100;
		}
		if(facing == 1){
			velX = -2;
			velY = 0;
		}else if(facing == 2){
			velX = 0;
			velY = -2;
		}else if(facing == 3){
			velX = 2;
			velY = 0;
		}else if(facing == 4){
			velX = 0;
			velY = 2;
		}
		
		collision();
		
	}

	public void render(Graphics g) {
		System.out.println(x + "   " + y);
		if(facing == 1){
			g.drawImage(tex.teacher[7], (int)x, (int)y, 64, 64, null);
		}else if(facing == 2){
			g.drawImage(tex.teacher[5], (int)x, (int)y, 64, 64, null);
		}else if(facing == 3){
			g.drawImage(tex.teacher[6], (int)x, (int)y, 64, 64, null);
		}else if(facing == 4){
			g.drawImage(tex.teacher[4], (int)x, (int)y, 64, 64, null);

		}
		
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 64, 64);
	}
	public Rectangle getUpper(){
		return new Rectangle((int)x + 8, (int)y, 40, 2);
	}
	public Rectangle getLower(){
		return new Rectangle((int)x + 8, (int)y + 62, 40, 2);
	}
	public Rectangle getR(){
		return new Rectangle((int)x + 12, (int)y + 16, 2, 24);
	}
	public Rectangle getL(){
		return new Rectangle((int) x + 48, (int) y + 16, 2, 24);
	}
	
	public void collision(){
		
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.npcBound || tempObject.getId() == ID.block){
				
				
				if(this.getL().intersects(tempObject.getBounds())){
					
					this.setX(this.x - 5);
				}
				
				if(this.getR().intersects(tempObject.getBounds())){
					this.setX(this.x + 5);

				}
				
				if(this.getUpper().intersects(tempObject.getBounds())){
					this.setY(this.y + 5);

				}
				
				if(this.getLower().intersects(tempObject.getBounds())){
					this.setY(this.y - 5);

				}
			}if(tempObject.getId() == ID.player){
				if(tempObject.getBounds().intersects(this.getBounds())){
					if(Artifacts.Spencer == false){
						handler.addObject(new SpencerReward(x, y, ID.artifact, handler));
					}
				}
			}
		}
	}	

}
