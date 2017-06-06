package school.objects;

import java.awt.Graphics;
import java.awt.Rectangle;

import school.game.GameObject;
import school.game.Handler;
import school.game.ID;

public class JohnTimer extends GameObject{
	
	int timer = 1000;

	Handler handler;
	public JohnTimer(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	public void tick() {
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.player){
				if(tempObject.getBounds().intersects(this.getBounds())){
					timer--;
					System.out.println(timer);
					if(timer <= 0){
						handler.addObject(new JohnReward(20 * 32, 60 * 32, ID.artifact, handler));
						handler.removeObject(this);
					}
				}
			}
			
		}
	}

	public void render(Graphics g) {
		
	}

	public Rectangle getBounds() {
		return new Rectangle(1 * 32, 45 * 32, 35 * 32, 20 * 32);
	}

}
