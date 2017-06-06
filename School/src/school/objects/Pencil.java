package school.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import school.anim.BufferedImageLoader;
import school.game.GameObject;
import school.game.Handler;
import school.game.ID;
import school.gamestate.Artifacts;
import school.gamestate.Charsel;

public class Pencil extends GameObject{

	int velX;
	int velY;
	Handler handler;
	int timer;
	
	private BufferedImage p1 = null, p2 = null, p3 = null, p4 = null;
	
	public Pencil(float x, float y, Handler handler, ID id, int velX, int velY) {
		super(x, y, id);
		this.velX = velX;
		this.velY = velY;
		this.handler = handler;
		
		BufferedImageLoader loader = new BufferedImageLoader();
		
		p1 = loader.loadImage("/tex/Pencil.png");
		p2 = loader.loadImage("/tex/Pencil2.png");
		p3 = loader.loadImage("/tex/Pencil3.png");
		p4 = loader.loadImage("/tex/Pencil4.png");
		
		timer = 0;
	}

	public void tick() {
		timer++;
		x += velX;
		y += velY;
		Collision();
	}

	public void render(Graphics g) {
		if(timer % 8 == 0 || timer % 8 == 1){
			g.drawImage(p1, (int)x, (int)y, null);
		}else if(timer % 8 == 2 || timer % 8 == 3){
			g.drawImage(p2, (int)x, (int)y, null);
		}else if(timer % 8 == 4 || timer % 8 == 5){
			g.drawImage(p3, (int)x, (int)y, null);
		}else if(timer % 8 == 6 || timer % 8 == 7){
			g.drawImage(p4, (int)x, (int)y, null);
		}
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
					if(Charsel.playerValue == 13){
						if(Handler.LEVEL == 60){
							handler.addObject(new PortalGun(x, y + 64, ID.misc, handler));
						}
					}
				}			
			}else if(tempObject.getId() == ID.enemy){
				if(this.getBounds().intersects(tempObject.getBounds())){
					handler.removeObject(this);
					handler.decreaseHealth(tempObject, 20);
				}
			}else if(tempObject.getId() == ID.nolanBoss){
				if(Artifacts.Chase){
					handler.decreaseHealth(tempObject, 250);
					handler.removeObject(this);
				}else{
					handler.decreaseHealth(tempObject, 1);
					handler.removeObject(this);
				}
			}
		}
	}

}
