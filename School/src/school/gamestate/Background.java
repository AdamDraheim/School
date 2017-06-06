package school.gamestate;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import school.anim.BufferedImageLoader;
import school.game.Game;
import school.game.Handler;

public class Background {

	Game game;
	Handler handler;
	private BufferedImage bg1 = null, bg2 = null, bg3 = null, bg4 = null, bg5 = null, bg6 = null, bg7 = null, bg60 = null, bg601 = null, bg602 = null,
			bg603 = null, bg604 = null, bg25 = null;
	
	public Background(Game game, Handler handler){
		this.handler = handler;
		this.game = game;
		
		BufferedImageLoader loader = new BufferedImageLoader();
		try{
			bg1 = loader.loadImage("/maps/OfficeBG.png");
			bg2 = loader.loadImage("/maps/FirstFloorBG.png");
			bg3 = loader.loadImage("/maps/EinsteinBG.png");
			bg4 = loader.loadImage("/maps/UpperFloorBG.png");
			bg5 = loader.loadImage("/maps/MPRBG.png");
			bg6 = loader.loadImage("/maps/BioBG.png");
			bg7 = loader.loadImage("/maps/OutsideBG.png");
			bg60 = loader.loadImage("/maps/RetreatBG.png");
			bg601 = loader.loadImage("/maps/BeardBG.png");
			bg602 = loader.loadImage("/maps/BoatBG.png");
			bg603 = loader.loadImage("/maps/BaseballBG.png");
			bg604 = loader.loadImage("/maps/HouseBG.png");
			bg25 = loader.loadImage("/maps/HelmersBG.png");
		}catch(Exception e){
			e.printStackTrace();
		}

	}
	public void render(Graphics g){
		if(handler.LEVEL == 1){
			g.drawImage(bg1, 0, 0, 1024, 1024, null);
		}else if(handler.LEVEL == 2){
			g.drawImage(bg2, 0, 0, 2048, 2048, null);
		}else if(handler.LEVEL == 3){
			g.drawImage(bg3, 0, 0, 1536, 2560, null);
		}else if(handler.LEVEL == 4){
			g.drawImage(bg4, 0, 0, 2432, 2432, null);
		}else if(handler.LEVEL == 5){
			g.drawImage(bg5, 0, 0, 50*32, 50*32, null);
		}else if(handler.LEVEL == 6){
			g.drawImage(bg6, 0, 0, 45*32, 64*32, null);
		}else if(handler.LEVEL == 7){
			g.drawImage(bg7, 0, 0, 48*32, 80*32, null);
		}else if(handler.LEVEL == 25){
			g.drawImage(bg25, 0, 0, 64*32, 64*32, null);
		}else if(handler.LEVEL == 60){
			if(Charsel.playerValue == 5 || Charsel.playerValue == 9 || Charsel.playerValue == 14 || Charsel.playerValue == 17){
				g.drawImage(bg60, 0, 0, 1280, 1280,null);
			}else if(Charsel.playerValue == 10){
				g.drawImage(bg601, 0, 0, 32*32, 32*32, null);
			}else if(Charsel.playerValue == 3){
				g.drawImage(bg602, 0, 0, 64 * 32, 64 * 32, null);
			}else if(Charsel.playerValue == 4){
				g.drawImage(bg603, 0, 0, 32*32, 32*32, null);
			}else if(Charsel.playerValue == 6 || Charsel.playerValue == 12 || Charsel.playerValue == 13 || Charsel.playerValue == 16){
				//House
				g.drawImage(bg604, 0, 0, 39*32, 40*32, null);
			}
		}
	}
	
}
