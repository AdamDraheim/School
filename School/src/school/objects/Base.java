package school.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import school.game.GameObject;
import school.game.Handler;
import school.game.ID;

public class Base extends GameObject{

	public boolean active;
	Handler handler;
	public static boolean add = false;
	public static int count;
	public boolean complete = false;
	
	public Base(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	public void tick() {
		if(Baseball.timer <= 0){
			if(this.active == true){
				this.active = false;
				count = 0;
			}
			if(add == true){
				handler.addObject(new Baseball(1, 1, ID.misc, handler));
				add = false;
			}
		}
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.player){
				if(tempObject.getBounds().intersects(this.getBounds())){
					if(active == false){
						this.active = true;
						count++;
					}
				}
				
			}
		}
		if(count == 5){
			complete = true;
			count++;
		}
		if(complete == true){

			handler.addObject(new EricReward(96, 96, ID.artifact, handler));
			complete = false;
			
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int)x, (int)y, 32, 32);
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 32, 32);
	}

}
