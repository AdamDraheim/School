package school.creatures;

import java.awt.Graphics;
import java.awt.Rectangle;

import school.anim.Texture;
import school.game.Game;
import school.game.GameObject;
import school.game.Handler;
import school.game.ID;
import school.gamestate.QuestList;
import school.objects.Antifun;
import school.objects.GraceReward;

public class Taco extends GameObject{

	Texture tex = Game.getInstance();
	int timer = 0;
	public static boolean active;
	public static int maxHealth;
	public static int HUDshow;
	Handler handler;
	int twoTimer = 40;

	public Taco(float x, float y, ID id, Handler handler, boolean active) {
		super(x, y, id);
		health = 500;
		this.maxHealth = health;
		this.handler = handler;
		this.active = active;

	}

	public void tick() {
		timer++;
		
		if(timer % 300 == 0){
			health += 100;
			
		}
		
		twoTimer--;
		if(twoTimer <= 0){
			handler.addObject(new Antifun((int)x + 100, (int) y + 105, handler, ID.antifun, -10, 0));
			handler.addObject(new Antifun((int)x + 100, (int) y + 105, handler, ID.antifun, -9, 1));
			handler.addObject(new Antifun((int)x + 100, (int) y + 105, handler, ID.antifun, -8, 2));
			handler.addObject(new Antifun((int)x + 100, (int) y + 105, handler, ID.antifun, -7, 3));
			handler.addObject(new Antifun((int)x + 100, (int) y + 105, handler, ID.antifun, -6, 4));
			handler.addObject(new Antifun((int)x + 100, (int) y + 105, handler, ID.antifun, -5, 5));
			handler.addObject(new Antifun((int)x + 100, (int) y + 105, handler, ID.antifun, -4, 6));
			handler.addObject(new Antifun((int)x + 100, (int) y + 105, handler, ID.antifun, -3, 7));
			handler.addObject(new Antifun((int)x + 100, (int) y + 105, handler, ID.antifun, -2, 8));
			handler.addObject(new Antifun((int)x + 100, (int) y + 105, handler, ID.antifun, -1, 9));
			handler.addObject(new Antifun((int)x + 100, (int) y + 105, handler, ID.antifun, 0,10));
			handler.addObject(new Antifun((int)x + 100, (int) y + 105, handler, ID.antifun, 1, 9));
			handler.addObject(new Antifun((int)x + 100, (int) y + 105, handler, ID.antifun, 2, 8));
			handler.addObject(new Antifun((int)x + 100, (int) y + 105, handler, ID.antifun, 3, 7));
			handler.addObject(new Antifun((int)x + 100, (int) y + 105, handler, ID.antifun, 4, 6));
			handler.addObject(new Antifun((int)x + 100, (int) y + 105, handler, ID.antifun, 5, 5));
			handler.addObject(new Antifun((int)x + 100, (int) y + 105, handler, ID.antifun, 6, 4));
			handler.addObject(new Antifun((int)x + 100, (int) y + 105, handler, ID.antifun, 7, 3));
			handler.addObject(new Antifun((int)x + 100, (int) y + 105, handler, ID.antifun, 8, 2));
			handler.addObject(new Antifun((int)x + 100, (int) y + 105, handler, ID.antifun, 9, 1));
			handler.addObject(new Antifun((int)x + 100, (int) y + 105, handler, ID.antifun, 10, 0));
			
			handler.addObject(new Antifun((int)x + 100, (int) y + 105, handler, ID.antifun, -9, -1));
			handler.addObject(new Antifun((int)x + 100, (int) y + 105, handler, ID.antifun, -8, -2));
			handler.addObject(new Antifun((int)x + 100, (int) y + 105, handler, ID.antifun, -7, -3));
			handler.addObject(new Antifun((int)x + 100, (int) y + 105, handler, ID.antifun, -6, -4));
			handler.addObject(new Antifun((int)x + 100, (int) y + 105, handler, ID.antifun, -5, -5));
			handler.addObject(new Antifun((int)x + 100, (int) y + 105, handler, ID.antifun, -4, -6));
			handler.addObject(new Antifun((int)x + 100, (int) y + 105, handler, ID.antifun, -3, -7));
			handler.addObject(new Antifun((int)x + 100, (int) y + 105, handler, ID.antifun, -2, -8));
			handler.addObject(new Antifun((int)x + 100, (int) y + 105, handler, ID.antifun, -1, -9));
			handler.addObject(new Antifun((int)x + 100, (int) y + 105, handler, ID.antifun, 0,-10));
			handler.addObject(new Antifun((int)x + 100, (int) y + 105, handler, ID.antifun, 1, -9));
			handler.addObject(new Antifun((int)x + 100, (int) y + 105, handler, ID.antifun, 2, -8));
			handler.addObject(new Antifun((int)x + 100, (int) y + 105, handler, ID.antifun, 3, -7));
			handler.addObject(new Antifun((int)x + 100, (int) y + 105, handler, ID.antifun, 4, -6));
			handler.addObject(new Antifun((int)x + 100, (int) y + 105, handler, ID.antifun, 5, -5));
			handler.addObject(new Antifun((int)x + 100, (int) y + 105, handler, ID.antifun, 6, -4));
			handler.addObject(new Antifun((int)x + 100, (int) y + 105, handler, ID.antifun, 7, -3));
			handler.addObject(new Antifun((int)x + 100, (int) y + 105, handler, ID.antifun, 8, -2));
			handler.addObject(new Antifun((int)x + 100, (int) y + 105, handler, ID.antifun, 9, -1));


			twoTimer = 40;

		}
	
		HUDshow = health;
		health = Game.clamp(health, 0, maxHealth);
		die();
		
	}

	public void render(Graphics g) {
		
		if(timer % 60 < 30){
			g.drawImage(tex.enemy[5], (int)x + 50, (int)y + 65, 96, 96, null);
		}else if(timer % 60 >= 30){
			g.drawImage(tex.enemy[6], (int)x + 50, (int)y + 65, 96, 96, null);
		}
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x + 50, (int)y + 65, 96, 96);
	}
	
	public void die(){
		if(health <= 0){
			handler.removeObject(this);
			this.active = false;
			handler.addObject(new GraceReward((int)x, (int)y, ID.artifact, handler));
			for(int ii = 0; ii < QuestList.Quests.size(); ii++){
				
				if((int)QuestList.Quests.elementAt(ii) == 71){
					QuestList.Quests.remove(ii);
					QuestList.Quests.push(72);
	
				}
			}
		
		}
	}

}
