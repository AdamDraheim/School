package school.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import school.game.GameObject;
import school.game.Handler;
import school.game.ID;

public class Portal extends GameObject{

	int velX = 0;
	Handler handler;
	public Portal(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	public void tick(){
	}
	
	public void render(Graphics g){
		g.setColor(Color.orange);
		g.fillRect((int)x, (int)y, 4, 64);
	}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 4, 64);
		
	}
	
}

