package school.gamestate;

import java.awt.Color;
import java.awt.Graphics;

import school.game.Game;
import school.game.Handler;

public class Filter {

	Handler handler;
	Game game;
	public Filter(Game game, Handler handler){
		this.handler = handler;
		this.game = game;
	}
	
	public void render(Graphics g){
		g.setColor(new Color(0, 0, 0, 127));
		
		if(handler.LEVEL == 60){
			if(Charsel.playerValue == 10 || Charsel.playerValue == 14){
				g.fillRect(0, 0, Game.width, Game.height);
			}
		}
		
	}
	
}
