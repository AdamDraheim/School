package school.level;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import school.game.GameObject;
import school.game.Handler;
import school.game.ID;

public class Bio extends GameObject{

	Handler handler;
	int pos;
	public Bio(float x, float y, ID id, Handler handler, int pos) {
		super(x, y, id);
		this.handler = handler;
		this.pos = pos;
	}

	public void tick() {
	}

	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect((int)x,(int) y, 32, 32);
		Collision(g);

	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 32, 32);
	}
	
	public void Collision(Graphics g){
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.player){
				if(this.getBounds().intersects(tempObject.getBounds())){
					handler.SwitchLevel(6, pos);
				}
			}
		}
	}
}

