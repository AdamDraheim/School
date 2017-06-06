package school.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import school.anim.Texture;
import school.game.Game;
import school.game.GameObject;
import school.game.Handler;
import school.game.ID;
import school.gamestate.QuestList;
import school.objects.Antifun;
import school.objects.AriReward;

public class PlayFear extends GameObject{

	public static int HUDshow;
	public static int maxHealth;
	Handler handler;
	public static double calc;
	public static boolean active;
	Game game;
	int timer = 40;
	int texTimer = 80;
	Texture tex = Game.getInstance();

	
	public PlayFear(float x, float y, Handler handler, Game game, ID id, boolean active) {
		super(x, y, id);
		this.handler = handler;
		this.game = game;
		health = 1000;
		this.maxHealth = health;
		this.active = active;
	}

	public void tick() {
		texTimer--;
		if(texTimer <= 0){
			texTimer = 80;
		}
		timer--;
		if(timer <= 0){
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


			timer = 40;

		}
		calc = 500 / maxHealth;
		health = Game.clamp((int)health, 0, 1000);
		collision();
		HUDshow = health;
		die();
	}

	public void render(Graphics g) {
		if(texTimer >= 40){
			g.drawImage(tex.enemy[3], (int)x, (int)y, 200, 200, null);
		}else if(texTimer < 40){
			g.drawImage(tex.enemy[4], (int)x, (int)y, 200, 200, null);
		}

	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 200, 200);
	}
	
	public void collision(){
		
	}
	
	public void die(){
		if(health <= 0){
			this.active = false;
			handler.addObject(new AriReward((int)x + 100, (int) y + 100, ID.artifact, handler));
			for(int ii = 0; ii < QuestList.Quests.size(); ii++){
				
				if((int)QuestList.Quests.elementAt(ii) == 21){
					QuestList.Quests.remove(ii);
				}
			}
			QuestList.Quests.push(22);
			handler.removeObject(this);
			
		}
	}

}
