package school.objects;

import java.awt.Graphics;
import java.awt.Rectangle;

import school.anim.Texture;
import school.game.Game;
import school.game.GameObject;
import school.game.Handler;
import school.game.ID;

public class HelmersPort extends GameObject{

	Texture tex = Game.getInstance();
	Handler handler;
	
	public HelmersPort(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	public void tick() {
		
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.player){
				if(tempObject.getBounds().intersects(this.getBounds())){
					handler.SwitchLevel(25, 0);
				}
			}
			
		}
		
	}
	

	public void render(Graphics g) {
		g.drawImage(tex.enemy[11], (int)x, (int)y, 64, 64, null);
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 64, 64);
	}

	
	
}
