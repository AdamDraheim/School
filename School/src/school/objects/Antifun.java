package school.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import school.anim.BufferedImageLoader;
import school.game.GameObject;
import school.game.Handler;
import school.game.ID;
import school.gamestate.HUD;

public class Antifun extends GameObject{

	int velX;
	int velY;
	Handler handler;
	int timer;
	
	
	public Antifun(float x, float y, Handler handler, ID id, int velX, int velY) {
		super(x, y, id);
		this.velX = velX;
		this.velY = velY;
		this.handler = handler;
		

	}

	public void tick() {
		
		x += velX;
		y += velY;
		Collision();
	}
	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 8, 8);
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 8, 8);
	}
	
	public void Collision(){
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.block || tempObject.getId() == ID.door){
				if(this.getBounds().intersects(tempObject.getBounds())){
					handler.removeObject(this);
				}
			}if(tempObject.getId() == ID.player){
				if(this.getBounds().intersects(tempObject.getBounds())){
					HUD.health -= 10;
					handler.removeObject(this);
				}
			}
		}
	}


}
