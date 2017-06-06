package school.gamestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import school.anim.Texture;
import school.game.Game;
import school.game.Handler;

public class Artifacts {

	Game game;
	Handler handler;
	public static boolean Artifacts = false;
	
	public static boolean Ari = false, Chase = false, Cole = false, Elif = false, Eric = false, Grace = false, Greyson = false,
	John = false, Lawrence = false, Matt = false, Nathaniel = false, Nicholas = false, Nolan = false, Rebecca = false, Sam = false,
	Savannah = false, Spencer = false, Aileen = false, Dante = false, Mira = false;
	
	Texture tex = Game.getInstance();

	
	public Artifacts(Game game, Handler handler){
		this.game = game;
		this.handler = handler;
		
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g){
		if(Artifacts == true){
			g.setColor(Color.gray);
			g.fillRect(50, 50, 700, 500);
			
			for(int i = 0; i < 5; i++){
				for(int ii = 0; ii < 4; ii ++){
					g.setColor(Color.black);
					g.fillRect((i * 64) + 225, (ii * 64) + 200, 64, 64);
					g.setColor(Color.white);
					g.drawRect((i * 64) + 225, (ii * 64) + 200, 64, 64);
				}
			}
			
			g.setColor(Color.white);
			g.setFont(new Font("Arial", 0, 50));
			g.drawString("ARTIFACTS", 250, 100);
			
			if(Ari == true){
				g.drawImage(tex.artifact[0], 225, 200, 64, 64, null);
			}
			if(Chase == true){
				g.drawImage(tex.artifact[1], 289, 200, 64, 64, null);
			}
			if(Cole == true){
				g.drawImage(tex.artifact[2], 353, 200, 64, 64, null);
			}
			if(Elif == true){
				g.drawImage(tex.artifact[3], 417, 200, 64, 64, null);
			}
			if(Eric == true){
				g.drawImage(tex.artifact[4], 481, 200, 64, 64, null);

			}
			if(Grace == true){
				g.drawImage(tex.artifact[5], 225, 264, 64, 64, null);
			}
			if(Greyson == true){
				g.drawImage(tex.artifact[6], 289, 264, 64, 64, null);
			}
			if(John == true){
				g.drawImage(tex.artifact[7], 353, 264, 64, 64, null);
			}
			if(Lawrence == true){
				g.drawImage(tex.artifact[8], 417, 264, 64, 64, null);
			}
			if(Matt == true){
				g.drawImage(tex.artifact[9], 481, 264, 64, 64, null);

			}
			if(Nathaniel == true){
				g.drawImage(tex.artifact[10], 225, 328, 64, 64, null);

			}if(Nicholas == true){
				g.drawImage(tex.artifact[11], 289, 328, 64, 64, null);
			}if(Nolan){
				g.drawImage(tex.artifact[12], 353, 328, 64, 64, null);

			}if(Rebecca){
				g.drawImage(tex.artifact[13], 417, 328, 64, 64, null);

			}if(Sam){
				g.drawImage(tex.artifact[14], 481, 328, 64, 64, null);

			}if(Savannah){
				g.drawImage(tex.artifact[15], 225, 394, 64, 64, null);

			}
			if(Spencer){
				g.drawImage(tex.artifact[16], 289, 394, 64, 64, null);
			}if(Aileen){
				g.drawImage(tex.artifact[17], 353, 394, 64, 64, null);
			}if(Dante){
				g.drawImage(tex.artifact[18], 417, 394, 64, 64, null);
			}if(Mira){
				g.drawImage(tex.artifact[19], 481, 394, 64, 64, null);
			}
			
		}
	}
	
}
