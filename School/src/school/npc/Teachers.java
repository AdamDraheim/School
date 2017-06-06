package school.npc;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import school.anim.Texture;
import school.game.Camera;
import school.game.Game;
import school.game.GameObject;
import school.game.Handler;
import school.game.ID;
import school.gamestate.Charsel;
import school.gamestate.QuestList;
import school.objects.ColeReward;

public class Teachers extends GameObject{

	private float width = 32, height = 32;
	private final float maxSpeed = 10;
	private Handler handler;
	public int facing = 1;
	public String speech1 = "", speech2 = "", speech3 = "";
	boolean speechwork = false;
	int delay = 3;
	private Game game;
	Texture tex = Game.getInstance();
	int teacher;
	int timer = 100;
	int speech = 200;

	
	public Teachers(float x, float y, Handler handler, ID id, Game game, int teacher) {
		super(x, y, id);
		this.handler = handler;
		velX = 0;
		velY = 0;
		this.game = game;
		this.teacher = teacher;

		
	}

	public void tick() {
		
		timer--;

		if(timer <= 0){
			facing = (int)(Math.random()* 4) + 1;
			timer = 100;
		}

		
		collision();
		
	}

	public void render(Graphics g) {
		if(facing == 1){
			if(teacher == 0){
				g.drawImage(tex.teacher[3], (int)x, (int)y, 64, 64, null);
			}

		}else if(facing == 2){
			if(teacher == 0){
				g.drawImage(tex.teacher[1], (int)x, (int)y,  64, 64,null);
			}

		}else if(facing == 3){
			if(teacher == 0){
				g.drawImage(tex.teacher[2], (int)x, (int)y,  64, 64,null);
			}

		}else if(facing == 4){
			if(teacher == 0){
				g.drawImage(tex.teacher[0], (int)x, (int)y,  64, 64,null);
			}
		}
		
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.player){
				if(tempObject.getBounds().intersects(this.speechBounds())){
					if(speechwork == false){
						delay--;
						if(delay <= 0){
							speech--;
							delay = 10;
						}
						if(teacher == 0){
							if(speech > 133){
								speech1 = "Thank you for";
								speech2 = "saving me! That";
								speech3 = "proves my theory...";
							}else if(speech <= 133 && speech > 67){
								speech1 = "The Fickle Finger";
								speech2 = "Of Fate chose wisely";
								speech3 = "Watson would be proud";
							}else if(speech <= 67 && speech > 0){
								speech1 = "May this artifact";
								speech2 = "help you out more than";
								speech3 = "it helped me!";
							}else if(speech <= 0){
								speech1 = "";
								speech2 = "";
								speech3 = "";
								handler.addObject(new ColeReward((int)x, (int)y + 96, ID.artifact, handler));
								speechwork = true;
								for(int ii = 0; ii < QuestList.Quests.size(); ii++){
									
									if((int)QuestList.Quests.elementAt(ii) == 42){
										QuestList.Quests.remove(ii);
									}
								}
								QuestList.Quests.push(43);
							}
						}
					}
					g.setColor(Color.white);
					g.fillRect((int)x + 60, (int) y - 16, 150, 30);
					g.setColor(Color.black);
					g.setFont(new Font("Arial", 0, 13));
					g.drawString(speech1, (int)x + 62, (int)y - 6);
					g.drawString(speech2, (int)x + 62, (int)y + 3);
					g.drawString(speech3, (int)x + 62, (int)y+ 12);

					
					
				}
			}
		}
		
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 64, 64);
	}
	public Rectangle getUpper(){
		return new Rectangle((int)x + 8, (int)y, 40, 2);
	}
	public Rectangle getLower(){
		return new Rectangle((int)x + 8, (int)y + 62, 40, 2);
	}
	public Rectangle getR(){
		return new Rectangle((int)x + 12, (int)y + 16, 2, 24);
	}
	public Rectangle getL(){
		return new Rectangle((int) x + 48, (int) y + 16, 2, 24);
	}
	public Rectangle speechBounds(){
		return new Rectangle((int)x - 32, (int) y - 32, 96, 96);
	}
	
	public void collision(){
		
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.npcBound || tempObject.getId() == ID.block){
				
				
				if(this.getL().intersects(tempObject.getBounds())){
					
					this.setX(this.x - 5);
				}
				
				if(this.getR().intersects(tempObject.getBounds())){
					this.setX(this.x + 5);

				}
				
				if(this.getUpper().intersects(tempObject.getBounds())){
					this.setY(this.y + 5);

				}
				
				if(this.getLower().intersects(tempObject.getBounds())){
					this.setY(this.y - 5);

				}
			}
		}
	}	

}
