package school.gamestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import school.anim.Texture;
import school.creatures.Classmate;
import school.creatures.Player;
import school.game.Camera;
import school.game.Game;
import school.game.Game.STATE;
import school.game.Handler;
import school.game.ID;

public class Charsel extends MouseAdapter{
	private Game game;
	private Handler handler;
	Texture tex = Game.getInstance();
	Camera cam;
	public String name = "";

	
	public static int playerValue = 0;
	int timer = 5;
	
	public Charsel(Game game, Handler handler, Camera cam){
		this.game = game;
		this.handler = handler;
		this.cam = cam;
	}
	
	public void mousePressed(MouseEvent e){
		
		int mx = e.getX();
		int my = e.getY();
				
		if(game.gameState == STATE.charsel){
			if(mouseOver(mx, my, 250, 550, 300, 50)){
				game.gameState = STATE.game;
				handler.SwitchLevel(1, 0);
				QuestList.Quests.push(10);
				

				for(int i = 0; i < 20; i++){
					if(i != playerValue){
						//handler.addObject(new Classmate((int)(Math.random() * 1000), (int)(Math.random() * 1000), handler, ID.student, game, i));
					}
					
					if(i == playerValue){
						QuestList.Quests.push((i * 10) + 20);
					}
				}
				
			}else if(mouseOver(mx, my, 40, 240, 100, 100)){
				
				if(timer <= 0){
					playerValue -= 1;
					if(playerValue < 0){
						playerValue = 19;
					}
				}
				timer = 5;
				
			}else if(mouseOver(mx, my, 660, 240, 100, 100)){
				
				if(timer <= 0){
					playerValue += 1;
					if(playerValue > 19){
						playerValue = 0;
					}
				}
				timer = 5;
				
			}else if(mouseOver(mx, my, 250, 350, 300, 100)){
				//System.exit(1);
			}
			
		}
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
		if(mx > x && mx < x + width){
			if(my > y && my < y + height){
				return true;
			}else return false;
		}else return false;
	}
	
	public void tick(){
		timer--;
	}
	
	public void render(Graphics g){

		g.setColor(Color.red);
		g.fillRect(40, 240, 100, 100);
		g.fillRect(660, 240, 100, 100);
		g.fillRect(250, 550, 300, 50);
		
		g.setColor(Color.black);
		g.setFont(new Font("Courier New", 0, 60));
		g.drawString("<-", 50, 300);
		g.drawString("->", 680, 300);
		
		if(playerValue == 0){
			g.drawImage(tex.player[0], (int)(game.width / 2) - 64, (int)(game.height / 2) - 64, 128, 128, null);
			name = "Ari";
		}
		if(playerValue == 1){
			g.drawImage(tex.player[4], (int)(game.width / 2) - 64, (int)(game.height / 2) - 64, 128, 128,null);
			name = "Chase";
		}
		if(playerValue == 2){
			g.drawImage(tex.player[8], (int)(game.width / 2) - 64, (int)(game.height / 2) - 64,128, 128, null);
			name = "Cole";

		}
		if(playerValue == 3){
			g.drawImage(tex.player[12], (int)(game.width / 2) - 64, (int)(game.height / 2) - 64, 128, 128,null);
			name = "Elif";

		}
		if(playerValue == 4){
			g.drawImage(tex.player[16], (int)(game.width / 2) - 64, (int)(game.height / 2) - 64, 128, 128,null);
			name = "Eric";

		}
		if(playerValue == 5){
			g.drawImage(tex.player[20], (int)(game.width / 2) - 64, (int)(game.height / 2) - 64,128, 128, null);
			name = "Grace";

		}
		if(playerValue == 6){
			g.drawImage(tex.player[24], (int)(game.width / 2) - 64, (int)(game.height / 2) - 64, 128, 128,null);
			name = "Greyson";

		}
		if(playerValue == 7){
			g.drawImage(tex.player[28], (int)(game.width / 2) - 64, (int)(game.height / 2) - 64, 128, 128,null);
			name = "John";

		}
		if(playerValue == 8){
			g.drawImage(tex.player[32], (int)(game.width / 2) - 64, (int)(game.height / 2) - 64, 128, 128,null);
			name = "Lawrence";

		}
		if(playerValue == 9){
			g.drawImage(tex.player[36], (int)(game.width / 2) - 64, (int)(game.height / 2) - 64, 128, 128,null);
			name = "Matt";

		}
		if(playerValue == 10){
			g.drawImage(tex.player[40], (int)(game.width / 2) - 64, (int)(game.height / 2) - 64, 128, 128,null);
			name = "Nathaniel";

		}
		if(playerValue == 11){
			g.drawImage(tex.player[44], (int)(game.width / 2) - 64, (int)(game.height / 2) - 64,128, 128, null);
			name = "Nicholas";

		}
		if(playerValue == 12){
			g.drawImage(tex.player[48], (int)(game.width / 2) - 64, (int)(game.height / 2) - 64, 128, 128,null);			name = "Chase";
			name = "Nolan";

		}
		if(playerValue == 13){
			g.drawImage(tex.player[52], (int)(game.width / 2) - 64, (int)(game.height / 2) - 64, 128, 128,null);
			name = "Rebecca";

		}
		if(playerValue == 14){
			g.drawImage(tex.player[56], (int)(game.width / 2) - 64, (int)(game.height / 2) - 64, 128, 128,null);
			name = "Sam";

		}
		if(playerValue == 15){
			g.drawImage(tex.player[60], (int)(game.width / 2) - 64, (int)(game.height / 2) - 64, 128, 128,null);
			name = "Savannah";

		}
		if(playerValue == 16){
			g.drawImage(tex.player[64], (int)(game.width / 2) - 64, (int)(game.height / 2) - 64, 128, 128,null);
			name = "Spencer";

		}
		if(playerValue == 17){
			g.drawImage(tex.player[68], (int)(game.width / 2) - 64, (int)(game.height / 2) - 64, 128, 128,null);
			name = "Aileen";
		}
		if(playerValue == 18){
			g.drawImage(tex.player[72], (int)(game.width / 2) - 64, (int)(game.height / 2) - 64, 128, 128,null);
			name = "Dante";
		}
		
		if(playerValue == 19){
			g.drawImage(tex.player[76], (int)(game.width / 2) - 64, (int)(game.height / 2) - 64, 128, 128,null);
			name = "Mira";
		}
		
		g.setFont(new Font("Arial", 0, 32));
		g.setColor(Color.black);
		g.drawString(name, (int)(game.width / 2) - 64, (int)(game.height / 2) + 90);
		g.drawString("START", (int)(game.width / 2) - 64, (int)(game.height / 2) + 280);

		
	}

}
