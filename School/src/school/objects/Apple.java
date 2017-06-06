package school.objects;

import java.awt.Graphics;
import java.awt.Rectangle;

import school.anim.Texture;
import school.game.Game;
import school.game.GameObject;
import school.game.Handler;
import school.game.ID;
import school.gamestate.QuestList;

public class Apple extends GameObject{

	int velX = 0;
	Handler handler;
	boolean apple = false;
	public static boolean appleChase = false;
	Texture tex = Game.getInstance();

	public Apple(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	public void tick(){
		x += velX;
		collision();
	}
	
	public void render(Graphics g){
		g.drawImage(tex.artifact[1], (int)x, (int)y, 32, 32, null);
	}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 32, 32);
		
	}
	
	public void collision(){
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.player){
				if(this.getBounds().intersects(tempObject.getBounds())){
					if(apple == false){
						velX = -20;
						handler.addObject(new Portal((int)x - 200, (int)y - 32, ID.portal, handler));
						apple = true;
					}
				}
			}
			if(tempObject.getId() == ID.portal){
				if(this.getBounds().intersects(tempObject.getBounds())){
					velX = 0;
					handler.removeObject(this);
					handler.removeObject(tempObject);
					apple = false;
					
					for(int ii = 0; ii < QuestList.Quests.size(); ii++){
						
						if((int)QuestList.Quests.elementAt(ii) == 30){
							QuestList.Quests.remove(ii);
							QuestList.Quests.push(31);

						}
						if((int)QuestList.Quests.elementAt(ii) == 32){
							QuestList.Quests.remove(ii);
							QuestList.Quests.push(33);

						}
						if((int)QuestList.Quests.elementAt(ii) == 34){
							QuestList.Quests.remove(ii);
							QuestList.Quests.push(35);
							appleChase = true;

						}
					}
					
				}
			}
		}
	}
	
}
