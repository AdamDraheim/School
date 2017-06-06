package school.objects;

import java.awt.Graphics;
import java.awt.Rectangle;

import school.anim.Texture;
import school.game.Game;
import school.game.GameObject;
import school.game.Handler;
import school.game.ID;
import school.gamestate.Artifacts;
import school.gamestate.QuestList;

public class ElifReward extends GameObject{

	//Admission Ticket
	
	Texture tex = Game.getInstance();
	
	Handler handler;
	public ElifReward(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	public void tick() {
		Collision();
	}

	public void render(Graphics g) {
		g.drawImage(tex.artifact[3], (int)x,  (int)y, 32, 32, null);
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x,  (int)y, 32, 32);
	}
	
	public void Collision(){
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.player){
				if(tempObject.getBounds().intersects(this.getBounds())){
					Artifacts.Elif = true;
					for(int ii = 0; ii < QuestList.Quests.size(); ii++){
						
						if((int)QuestList.Quests.elementAt(ii) == 51){
							QuestList.Quests.remove(ii);
						}
					}
					handler.removeObject(this);
				}
			}
		}
	}

}
