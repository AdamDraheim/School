package school.creatures;

import java.awt.Graphics;
import java.awt.Rectangle;

import school.anim.Texture;
import school.game.Game;
import school.game.GameObject;
import school.game.Handler;
import school.game.ID;
import school.gamestate.HUD;

public class Fire extends GameObject{

	Handler handler;
	int timer = 10;
	int rand = 10;
	Texture tex = Game.getInstance();
	public Fire(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	public void tick() {
		
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.player){
				if(tempObject.getBounds().intersects(this.getBounds())){
					HUD.health = 0;
				}
			}
		}
		
	}

	public void render(Graphics g) {
		timer--;
		if(timer == 0){
			timer = 10;
			rand = (int)(Math.random() * 2) + 9;
		}
		g.drawImage(tex.enemy[rand], (int)x, (int)y, null);
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 32, 32);
	}

}
