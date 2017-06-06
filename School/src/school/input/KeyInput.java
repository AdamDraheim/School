package school.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import school.creatures.Player;
import school.game.Game;
import school.game.Game.STATE;
import school.game.GameObject;
import school.game.Handler;
import school.game.ID;
import school.gamestate.Artifacts;
import school.gamestate.Charsel;
import school.gamestate.QuestList;
import school.objects.Dancefloor;
import school.objects.Pencil;


public class KeyInput extends KeyAdapter{

	private Handler handler;
	public static boolean userControl = true;
	public static int shieldTimer = 0;
	public static int reload = 5;
	
	public KeyInput(Handler handler){
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e){
		
		int key = e.getKeyCode();
		if(userControl == true){
			for(int i = 0; i < handler.object.size(); i++){
				GameObject tempObject = handler.object.get(i);
				
				if(tempObject.getId() == ID.player){
					//key event
					if(key == KeyEvent.VK_A){
						
						tempObject.setVelX(-5);
						Player.facing = 1;
					}
					
					if(key == KeyEvent.VK_D){
						tempObject.setVelX(5);
						Player.facing = 3;
					
					}
					
					if(key == KeyEvent.VK_W){
						tempObject.setVelY(-5);
						Player.facing = 2;
					}
					if(key == KeyEvent.VK_S){
						tempObject.setVelY(5);
						Player.facing = 4;
					}

					if(key == KeyEvent.VK_SPACE){
						if(reload <= 0){
							if(Player.facing == 1){
								handler.addObject(new Pencil(tempObject.getX() - 5, tempObject.getY() + 32, handler, ID.pencil, -10, 0));
							}else if(Player.facing == 2){
								handler.addObject(new Pencil(tempObject.getX() + 32, tempObject.getY() - 5, handler, ID.pencil, 0, -10));
							}else if(Player.facing == 3){
								handler.addObject(new Pencil(tempObject.getX() + 42, tempObject.getY() + 32,handler, ID.pencil, 10, 0));
							}else if(Player.facing == 4){
								handler.addObject(new Pencil(tempObject.getX() + 32, tempObject.getY() + 69,handler, ID.pencil, 0, 10));
							}
							reload = 5;
						}
					}
					if(key == KeyEvent.VK_ESCAPE){
						Game.gameState = STATE.menu;
						QuestList.Quests.clear();
					}
					if(key == KeyEvent.VK_Q){
						if(QuestList.questView == false){
							QuestList.questView = true;
							Artifacts.Artifacts = false;
						}else if(QuestList.questView == true){
							QuestList.questView = false;
						}
					}
					if(key == KeyEvent.VK_E){
						if(Artifacts.Artifacts == false){
							QuestList.questView = false;
							Artifacts.Artifacts = true;
						}else if(Artifacts.Artifacts == true){
							Artifacts.Artifacts = false;
						}
					}
					
					if(Charsel.playerValue == 3){
						if(Dancefloor.dance == 0){
							if(key == KeyEvent.VK_W){
								Dancefloor.danceStep[Dancefloor.dance] = true;
							}else{
								Dancefloor.danceStep[Dancefloor.dance] = false;
							}
						}
						if(Dancefloor.dance == 1){
							if(key == KeyEvent.VK_S){
								Dancefloor.danceStep[Dancefloor.dance] = true;
							}else{
								Dancefloor.danceStep[Dancefloor.dance] = false;
							}
						}
						if(Dancefloor.dance == 2){
							if(key == KeyEvent.VK_W){
								Dancefloor.danceStep[Dancefloor.dance] = true;
							}else{
								Dancefloor.danceStep[Dancefloor.dance] = false;
							}
						}
						if(Dancefloor.dance == 3){
							if(key == KeyEvent.VK_A){
								Dancefloor.danceStep[Dancefloor.dance] = true;
							}else{
								Dancefloor.danceStep[Dancefloor.dance] = false;
							}
						}
						if(Dancefloor.dance == 4){
							if(key == KeyEvent.VK_W){
								Dancefloor.danceStep[Dancefloor.dance] = true;
							}else{
								Dancefloor.danceStep[Dancefloor.dance] = false;
							}
						}
						if(Dancefloor.dance == 5){
							if(key == KeyEvent.VK_D){
								Dancefloor.danceStep[Dancefloor.dance] = true;
							}else{
								Dancefloor.danceStep[Dancefloor.dance] = false;
							}
						}
					}
				}
			}
		}
		
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		if(userControl == true){
			for(int i = 0; i < handler.object.size(); i++){
				GameObject tempObject = handler.object.get(i);
				
				if(tempObject.getId() == ID.player){
					//key event
					if(key == KeyEvent.VK_A){
						tempObject.setVelX(0);
					}
					if(key == KeyEvent.VK_D){
						tempObject.setVelX(0);
					
					}
					if(key == KeyEvent.VK_W){
						tempObject.setVelY(0);
					}
					if(key == KeyEvent.VK_S){
						tempObject.setVelY(0);
					}
				}
			}
		}
		
	}
}
