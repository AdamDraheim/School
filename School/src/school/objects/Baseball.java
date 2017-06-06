package school.objects;

import java.awt.Graphics;
import java.awt.Rectangle;

import school.anim.Texture;
import school.game.Game;
import school.game.GameObject;
import school.game.Handler;
import school.game.ID;

public class Baseball extends GameObject{

	Texture tex = Game.getInstance();
	public static int timer = 0;

	Handler handler;
	
	public Baseball(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	public void tick() {
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.player){
				if(tempObject.getBounds().intersects(this.getBounds())){
					handler.removeObject(this);
					timer = 500;
					Base.add = true;
				}
			}
		}
	}

	public void render(Graphics g) {
		g.drawImage(tex.artifact[4], 96,96, 16, 16,null);
	}

	public Rectangle getBounds() {
		return new Rectangle(96, 96, 16, 16);
	}

}
