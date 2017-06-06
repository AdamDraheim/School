package school.objects;

import java.awt.Graphics;
import java.awt.Rectangle;

import school.game.GameObject;
import school.game.Handler;
import school.game.ID;
import school.gamestate.QuestList;

public class GreysonTimer extends GameObject{
	
	int timer = 1000;

	Handler handler;
	public GreysonTimer(float x, float y, ID id, Handler handler) {
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
						handler.addObject(new GreysonReward(2 * 32, 2 * 32, ID.artifact, handler));
						for(int ii = 0; ii < QuestList.Quests.size(); ii++){
							
							if((int)QuestList.Quests.elementAt(ii) == 81){
								QuestList.Quests.remove(ii);
								QuestList.Quests.push(82);
				
							}
						}
						handler.removeObject(this);
					}
				}
			}
			
		}
	}

	public void render(Graphics g) {
		
	}

	public Rectangle getBounds() {
		return new Rectangle(0, 0, 39*32, 40*32);
	}

}
