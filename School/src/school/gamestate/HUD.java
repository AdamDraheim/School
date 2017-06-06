package school.gamestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import school.creatures.Ghost;
import school.creatures.LabMonster;
import school.creatures.NolanGhost;
import school.creatures.PlayFear;
import school.creatures.Taco;
import school.game.Game;
import school.game.Handler;
import school.game.Game.STATE;

public class HUD {
	
	public static int health = 100;
	public static int maxHealth = 100;
	
	Game game;
	Handler handler;
	
	public HUD(Game game, Handler handler){
		
		this.game = game;
		this.handler = handler;
		
	}
	
	public void tick(){
		Game.clamp(health, 0, maxHealth);
		if(health == 0){
			game.gameState = STATE.menu;
			health = maxHealth;
			Taco.active = false;
			PlayFear.active = false;
			LabMonster.active = false;
		}
	}
	
	public void render(Graphics g){
		g.setColor(Color.gray);
		g.fillRect(10, 10, 102, 50);
		g.setColor(Color.red);
		g.fillRect(11, 11, health, 48);
		
		if(PlayFear.active == true){
			g.setColor(Color.gray);
			g.fillRect(149, 549, 501, 51);
			g.setColor(Color.red);
			g.fillRect(150, 550, PlayFear.HUDshow / 2, 50);
			g.setColor(Color.white);
			g.setFont(new Font("Arial", 0, 40));
			g.drawString("The Test", 305, 585);
		}
		if(LabMonster.active == true){
			g.setColor(Color.gray);
			g.fillRect(149, 549, 501, 51);
			g.setColor(Color.red);
			g.fillRect(150, 550, LabMonster.HUDshow / 2, 50);
			g.setColor(Color.white);
			g.setFont(new Font("Arial", 0, 40));
			g.drawString("LAB ABOMINATION", 250, 585);
		}
		if(Taco.active == true){
			g.setColor(Color.gray);
			g.fillRect(149, 549, 501, 51);
			g.setColor(Color.red);
			g.fillRect(150, 550, Taco.HUDshow, 50);
			g.setColor(Color.white);
			g.setFont(new Font("Arial", 0, 40));
			g.drawString("A... Taco?", 250, 585);
		}
		
		if(NolanGhost.active){
			g.setColor(Color.gray);
			g.fillRect(149, 549, 501, 51);
			g.setColor(Color.red);
			g.fillRect(150, 550, NolanGhost.HUDshow / 2, 50);
			g.setColor(Color.white);
			g.setFont(new Font("Arial", 0, 40));
			g.drawString("The Beard's Vestige", 250, 585);
		}
		if(Ghost.active){
			g.setColor(Color.gray);
			g.fillRect(149, 549, 501, 51);
			g.setColor(Color.red);
			g.fillRect(150, 550, Ghost.HUDshow / 2, 50);
			g.setColor(Color.white);
			g.setFont(new Font("Arial", 0, 40));
			g.drawString("D&D ESCAPED IMP", 250, 585);
		}
	}
	
}
