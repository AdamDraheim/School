package school.objects;

import java.awt.Graphics;
import java.awt.Rectangle;

import school.anim.Texture;
import school.game.Game;
import school.game.GameObject;
import school.game.Handler;
import school.game.ID;
import school.gamestate.QuestList;

public class Food extends GameObject{

	int velX = 0;
	Handler handler;
	public static int food = 3;
	Texture tex = Game.getInstance();

	public Food(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	public void tick(){
		collision();
		System.out.println(x + "   " + y);
	}
	
	public void render(Graphics g){
		g.drawImage(tex.artifact[12], (int)x, (int)y, 32, 32, null);
	}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 32, 32);
		
	}
	
	public void collision(){
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.player){
				if(this.getBounds().intersects(tempObject.getBounds())){
					
					food--;
					handler.removeObject(this);
					if(food == 0){
						handler.addObject(new NolanReward(x, y, ID.artifact, handler));
					}
					
				}
			}else if(tempObject.getId() == ID.block){
				if(tempObject.getBounds().intersects(this.getBounds())){
					this.x = (int)(Math.random() * handler.getWidth());
					this.y = (int)(Math.random() * handler.getHeight());

				}
			}
		}
	}
	
}
