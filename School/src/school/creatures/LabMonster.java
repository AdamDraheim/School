package school.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import school.anim.Texture;
import school.game.Game;
import school.game.GameObject;
import school.game.Handler;
import school.game.ID;
import school.gamestate.QuestList;
import school.objects.Antifun;
import school.objects.AriReward;

public class LabMonster extends GameObject{

	public static int HUDshow;
	double velX, velY;
	public static int maxHealth;
	Handler handler;
	public static double calc;
	public static boolean active;
	Game game;
	int texTimer = 90;
	Texture tex = Game.getInstance();

	
	public LabMonster(float x, float y, Handler handler, Game game, ID id, boolean active) {
		super(x, y, id);
		this.handler = handler;
		this.game = game;
		health = 1000; 
		this.maxHealth = health;
		this.active = active;
	}

	public void tick() {
		texTimer--;
		x+= velX;
		y +=velY;
		if(texTimer <= 0){
			texTimer = 80;
		}
		calc = 500 / maxHealth;
		health = Game.clamp((int)health, 0, 1000);
		collision();
		HUDshow = health;
		follow();
		die();
	}

	public void render(Graphics g) {
		if(texTimer >= 60){
			g.drawImage(tex.enemy[0], (int)x, (int)y, 200, 200, null);
		}else if(texTimer < 60 && texTimer >= 30){
			g.drawImage(tex.enemy[1], (int)x, (int)y, 200, 200, null);
		}else if(texTimer < 30){
			g.drawImage(tex.enemy[2], (int)x, (int)y, 200, 200, null);
		}

	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 200, 200);
	}
	
	public void collision(){
		
	}
	
	public void follow(){
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.player){
				
				double theta = Math.atan(-1 * ((tempObject.getY() - this.getY()) / (tempObject.getX() - this.getX())));
				
				if(tempObject.getX() > this.getX() && tempObject.getY() < this.getY()){
					velY = -3 * Math.sin(theta);
					velX = 3 * Math.cos(theta);
				}
				if(tempObject.getX() < this.getX() && tempObject.getY() < this.getY()){
					velY = 3 * Math.sin(theta);
					velX = -3 * Math.cos(theta);

				}
				if(tempObject.getX() > this.getX() && tempObject.getY() > this.getY()){
					velY = -3 * Math.sin(theta);
					velX = 3 * Math.cos(theta);

				}
				if(tempObject.getX() < this.getX() && tempObject.getY() > this.getY()){
					velY = 3 * Math.sin(theta);
					velX = -3 * Math.cos(theta);

				}				
				
				int playerDistance = (int)Math.sqrt(Math.pow(tempObject.getX() - this.getX(), 2) + Math.pow(tempObject.getY() - this.getY(),2));
				if(playerDistance < 400 && playerDistance > 5){
				
					if(tempObject.getX() - this.getX() <= 0){
					
						//velX = ((-1 / (2 * Math.sqrt(160000 - Math.pow(tempObject.getX() - this.getX(), 2)))) * 2000);
					
					}else if(tempObject.getX() - this.getX() > 0){
						
						//velX = -1 * ((-1 / (2 * Math.sqrt(160000 - Math.pow(tempObject.getX() - this.getX(), 2)))) * 2000);

					}
					
					if(tempObject.getY() - this.getY() < 0){
					
						//velY = ((-1 / (2 * Math.sqrt(160000 - Math.pow(tempObject.getY() - this.getY(), 2)))) * 2000);
					
					}else if(tempObject.getY() - this.getY() > 0){
						
						//velY = -1 * ((-1 / (2 * Math.sqrt(160000 - Math.pow(tempObject.getY() - this.getY(), 2)))) * 2000);

					}else if(tempObject.getVelY() - this.getY() == 0){
						//velY = 0;
					}
					
					
					if(Math.abs(tempObject.getX() - this.getX()) <= 1){
						//velX = 0;
					}
					if(Math.abs(tempObject.getY() - this.getY()) <= 1){
						//velY = 0;
					}
					
					
				}else if(playerDistance >= 800 || playerDistance < 5){
					velX = 0;
					velY = 0;
				}
			}
		}
	}
	
	public void die(){
		if(health <= 0){
			this.active = false;
			for(int i = 0; i < handler.object.size(); i++){
				GameObject tempObject = handler.object.get(i);
				if(tempObject.getId() == ID.removable){
					handler.removeObject(tempObject);
				}
			}
			for(int ii = 0; ii < QuestList.Quests.size(); ii++){
				
				if((int)QuestList.Quests.elementAt(ii) == 41){
					QuestList.Quests.remove(ii);
				}
			}
			QuestList.Quests.push(42);
			
			handler.removeObject(this);
			
		}
	}

}
