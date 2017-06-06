package school.level;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import school.anim.BufferedImageLoader;
import school.game.GameObject;
import school.game.Handler;
import school.game.ID;

public class Special extends GameObject{

	Handler handler;
	int pos;
	private BufferedImage bus;
	public Special(float x, float y, ID id, Handler handler, int pos) {
		super(x, y, id);
		this.handler = handler;
		this.pos = pos;
		
		BufferedImageLoader loader = new BufferedImageLoader();

		bus = loader.loadImage("/tex/Bus.png");
	}

	public void tick() {
	}

	public void render(Graphics g) {
		g.drawImage(bus, (int)x, (int)y,64,128, null);
		Collision(g);

	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 64, 128);
	}
	
	public void Collision(Graphics g){
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.player){
				if(this.getBounds().intersects(tempObject.getBounds())){
					handler.SwitchLevel(60, pos);
				}
			}
		}
	}
}

