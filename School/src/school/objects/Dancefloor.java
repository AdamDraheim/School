package school.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import school.game.GameObject;
import school.game.Handler;
import school.game.ID;

public class Dancefloor extends GameObject{

	public static int dance = 0;
	int timer = 50;
	public static boolean[] danceStep = new boolean[6];
	public static boolean complete = false;
	Handler handler;
	
	public Dancefloor(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	public void tick() {
		timer--;
		if(timer <= 0){
			dance++;
			
			if(dance == 6){
				dance = 0;
			}
			
			timer = 50;
		}
		
		if(danceStep[0] == true && danceStep[1] == true && danceStep[2] == true && danceStep[3] == true && danceStep[4] == true && danceStep[5] == true){
			complete = true;
			for(int i = 0; i < handler.object.size(); i++){
				GameObject tempObject = handler.object.get(i);
				if(tempObject.getId() == ID.removable){
					handler.removeObject(tempObject);
				}
			}
		}
	}

	public void render(Graphics g) {
		if(complete == false){
			g.setColor(Color.blue);
			for(int i = 0; i < 384; i += 64){
				for(int ii = 32; ii < 384; ii += 64){
					g.fillRect((int)(i + x), (int)(ii + y), 32, 32);
				}
			}

			
			if(dance == 0){
				for(int i = 0; i < 384; i += 64){
					g.setColor(Color.green);

					g.fillRect((int)(i + x), 17 * 32 + 32, 32, 32);
				}
			}
			if(dance == 1){
				for(int i = 0; i < 384; i += 64){
					g.setColor(Color.green);

					g.fillRect((int)(i + x), 27 * 32 + 32, 32, 32);
				}
			}
			
			if(dance == 2){
				for(int i = 0; i < 384; i += 64){
					g.setColor(Color.green);

					g.fillRect((int)(i + x), 17 * 32 + 32, 32, 32);
				}
			}
			if(dance == 3){
				for(int i = 0; i < 384; i += 64){
					g.setColor(Color.green);

					g.fillRect(26 * 32, (int)(i + y) + 32, 32, 32);
				}
			}
			if(dance == 4){
				for(int i = 0; i < 384; i += 64){
					g.setColor(Color.green);

					g.fillRect((int)(i + x), 17 * 32 + 32, 32, 32);
				}
			}
			if(dance == 5){
				for(int i = 0; i < 384; i += 64){
					g.setColor(Color.green);

					g.fillRect(36 * 32, (int)(i + y) + 32, 32, 32);
				}
			}
		}else if(complete == true){
			g.setColor(Color.green);
			for(int i = 0; i < 384; i += 64){
				for(int ii = 32; ii < 384; ii += 64){
					g.fillRect((int)(i + x), (int)(ii + y), 32, 32);
				}
			}

		}
		
	}

	public Rectangle getBounds() {
		return new Rectangle(1,1,1,1);
	}
	
	

}
