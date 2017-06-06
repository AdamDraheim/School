package school.creatures;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import school.anim.Texture;
import school.game.Game;
import school.game.GameObject;
import school.game.Handler;
import school.game.ID;
import school.gamestate.QuestList;
import school.input.KeyInput;
import school.objects.Antifun;
import school.objects.LawrenceReward;

public class DualEnemy extends GameObject{

	Handler handler;
	int maxHealth;
	int speedCap = 5;
	int timer = 100;
	
	Texture tex = Game.getInstance();

	public DualEnemy(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		health  = 100;
		this.maxHealth = (int)health;
		
	}

	public void tick() {
		
		timer--;
		if(timer <= 0){
			direction(velX, velY);
			timer = 100;
		}
		
		health = Game.clamp((int)health, 0, 500);
		int changeX = (int)((Math.random() * 4) - 2);
		int changeY = (int)((Math.random() * 4) - 2);
		if(velX + changeX < speedCap && velX + changeX > -1 * speedCap){
			velX += changeX;
		}
		if(velY + changeY < speedCap && velY + changeX > -1 * speedCap){
			velY += changeY;
		}
		if(KeyInput.userControl == true){
			x += velX;
			y += velY;
		}
		collision();
		die();
	}

	public void render(Graphics g) {
	
		g.drawImage(tex.enemy[7], (int)x, (int)y, null);

	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 32, 32);
	}
	
	public Rectangle getUpper(){
		return new Rectangle((int)x + 2, (int)y, 28, 2);
	}
	public Rectangle getLower(){
		return new Rectangle((int)x + 2, (int)y + 28, 28, 2);
	}
	public Rectangle getR(){
		return new Rectangle((int)x, (int)y + 2, 2, 26);
	}
	public Rectangle getL(){
		return new Rectangle((int) x + 30, (int) y + 2, 2, 26);
	}
	
	public void direction(float velX, float velY){
		
		if(Math.abs(velX) > Math.abs(velY) && velX > 0){
			handler.addObject(new Antifun((int)x, (int) y, handler, ID.antifun, 10, -5));
			handler.addObject(new Antifun((int)x, (int) y, handler, ID.antifun, 10, 5));
		}else if(Math.abs(velY) > Math.abs(velX) && velY > 0){
			handler.addObject(new Antifun((int)x, (int) y, handler, ID.antifun, -5, 10));
			handler.addObject(new Antifun((int)x, (int) y, handler, ID.antifun, 5, 10));
		}else if(Math.abs(velX) > Math.abs(velY) && velX <= 0){
			handler.addObject(new Antifun((int)x, (int) y, handler, ID.antifun, -10, -5));
			handler.addObject(new Antifun((int)x, (int) y, handler, ID.antifun, 10, -5));
		}else if(Math.abs(velY) > Math.abs(velX) && velY <= 0){
			handler.addObject(new Antifun((int)x, (int) y, handler, ID.antifun, -5, -10));
			handler.addObject(new Antifun((int)x, (int) y, handler, ID.antifun, 5, -10));

		}
		
	}
	
	public void collision(){
			
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.block){
				if(this.getL().intersects(tempObject.getBounds())){
					
					this.setX(this.x - 5);
					velX *= -1;
					
				}
				if(this.getR().intersects(tempObject.getBounds())){
					this.setX(this.x + 5);
					velX *= -1;

				}
				if(this.getUpper().intersects(tempObject.getBounds())){
					this.setY(this.y + 5);
					velY *= -1;

				}
				if(this.getLower().intersects(tempObject.getBounds())){
					this.setY(this.y - 5);
					velY *= -1;

				}
				
			}
		}
	}
	
	public void die(){
		if(health <= 0){
			handler.removeObject(this);
			handler.enemyCount--;
			if(handler.enemyCount == 0){
				handler.addObject(new LawrenceReward((int)x, (int)y, ID.artifact, handler));
				for(int ii = 0; ii < QuestList.Quests.size(); ii++){
					
					if((int)QuestList.Quests.elementAt(ii) == 101){
						QuestList.Quests.remove(ii);
						QuestList.Quests.push(102);
					}
				}
			}
		}
	}

}
