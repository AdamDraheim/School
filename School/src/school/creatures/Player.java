package school.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import school.anim.Texture;
import school.game.Camera;
import school.game.Game;
import school.game.GameObject;
import school.game.Handler;
import school.game.ID;
import school.gamestate.Artifacts;
import school.gamestate.Charsel;
import school.gamestate.QuestList;
import school.input.KeyInput;
import school.objects.DanteReward;
import school.objects.Explosion;

public class Player extends GameObject{

	private float width = 32, height = 32;
	float gravity = 0.38f;
	private final float maxSpeed = 10;
	private Handler handler;
	public static int facing = 1;
	private Game game;
	private Camera cam;
	Texture tex = Game.getInstance();
	int DanteSign = 0;
	
	public boolean first = false, second = false, third = false;
	public boolean NolanSpawn = false;

	
	public Player(float x, float y, Handler handler, Camera cam, ID id, Game game) {
		super(x, y, id);
		this.handler = handler;
		velX = 0;
		velY = 0;
		this.game = game;
		this.cam = cam;

		
	}

	public void tick() {
		
		if(Charsel.playerValue == 18){
			
			for(int i = 0; i < handler.object.size(); i++){
				GameObject tempObject = handler.object.get(i);
				if(tempObject.getId() == ID.student){
					if(tempObject.getBounds().intersects(this.getBounds())){
						handler.removeObject(tempObject);
						DanteSign++;
						
						if(DanteSign == 3){
							handler.addObject(new DanteReward(x,y,ID.artifact, handler));
						}
					}
				}
			}
			
		}
		
		if(Charsel.playerValue == 10){
			
			if(handler.LEVEL == 60){

				if(y <= 800){
					
					if(first == false){
						
						for(int i = 0; i < 30; i++){
							handler.addObject(new Explosion((int)x - 50, y, ID.misc, handler, 250, 250, 250, "all", 5));
							handler.addObject(new Explosion((int)x + 114, y, ID.misc, handler, 250, 250, 250, "all", 5));
						}
						first = true;
					}
					
				}if( y <= 660){
					
					if(second == false){
						for(int i = 0; i < 30; i++){

						handler.addObject(new Explosion((int)x - 50, y, ID.misc, handler, 250, 250, 250, "all", 5));
						handler.addObject(new Explosion((int)x + 114, y, ID.misc, handler, 250, 250, 250, "all", 5));
						}
						second = true;
					}
					
				}if( y <= 530){
					
					if(third == false){
						for(int i = 0; i < 30; i++){

						handler.addObject(new Explosion((int)x - 50, y, ID.misc, handler, 250, 250, 250, "all", 5));
						handler.addObject(new Explosion((int)x + 114, y, ID.misc, handler, 250, 250, 250, "all", 5));
						}
						third = true;
					}
					
				}
			}
			
		}
		
		if(handler.LEVEL == 60){
			if(Charsel.playerValue == 10){
		if(this.getBounds().intersects(new Rectangle(12 * 32, 7 * 32, 7 * 32, 7 * 32))){
			
			if(NolanSpawn == false){
				handler.addObject(new NolanGhost(x, y + 400, handler, game, ID.nolanBoss, true));
				NolanSpawn = true;
				for(int ii = 0; ii < QuestList.Quests.size(); ii++){
				if(Artifacts.Chase){
					if((int)QuestList.Quests.elementAt(ii) == 121){
						QuestList.Quests.remove(ii);
						QuestList.Quests.push(123);

					}
				}else if(!Artifacts.Chase){
					if((int)QuestList.Quests.elementAt(ii) == 121){

						QuestList.Quests.remove(ii);
						QuestList.Quests.push(122);

					}
				}
				}
				
				for(int i = 0; i < handler.object.size(); i++){
					GameObject tempObject = handler.object.get(i);
					if(tempObject.getId() == ID.student){
						handler.removeObject(tempObject);
						
					}
				}
				
			}
			
		}
		}
		}
		
		x += velX;
		y += velY;
		
		KeyInput.reload--;
		
		collision(handler.object);
		
	}

	public void render(Graphics g) {
		if(facing == 1){
			if(Charsel.playerValue == 0){
				g.drawImage(tex.player[3], (int)x, (int)y, 64, 64, null);
			}
			if(Charsel.playerValue == 1){
				g.drawImage(tex.player[7], (int)x, (int)y,  64, 64,null);
			}
			if(Charsel.playerValue == 2){
				g.drawImage(tex.player[11], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 3){
				g.drawImage(tex.player[15],(int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 4){
				g.drawImage(tex.player[19], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 5){
				g.drawImage(tex.player[23], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 6){
				g.drawImage(tex.player[27], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 7){
				g.drawImage(tex.player[31], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 8){
				g.drawImage(tex.player[35], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 9){
				g.drawImage(tex.player[39], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 10){
				g.drawImage(tex.player[43], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 11){
				g.drawImage(tex.player[47], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 12){
				g.drawImage(tex.player[51], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 13){
				g.drawImage(tex.player[55], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 14){
				g.drawImage(tex.player[59], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 15){
				g.drawImage(tex.player[63], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 16){
				g.drawImage(tex.player[67], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 17){
				g.drawImage(tex.player[71], (int)x, (int)y,  64, 64,null);
			}
			if(Charsel.playerValue == 18){
				g.drawImage(tex.player[75], (int)x, (int)y,  64, 64,null);
			}
			if(Charsel.playerValue == 19){
				g.drawImage(tex.player[79], (int)x, (int)y,  64, 64,null);
			}
		}else if(facing == 2){
			if(Charsel.playerValue == 0){
				g.drawImage(tex.player[1], (int)x, (int)y,  64, 64,null);
			}
			if(Charsel.playerValue == 1){
				g.drawImage(tex.player[5], (int)x, (int)y, 64, 64, null);
			}
			if(Charsel.playerValue == 2){
				g.drawImage(tex.player[9], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 3){
				g.drawImage(tex.player[13],(int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 4){
				g.drawImage(tex.player[17], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 5){
				g.drawImage(tex.player[21], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 6){
				g.drawImage(tex.player[25], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 7){
				g.drawImage(tex.player[29], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 8){
				g.drawImage(tex.player[33], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 9){
				g.drawImage(tex.player[37], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 10){
				g.drawImage(tex.player[41], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 11){
				g.drawImage(tex.player[45], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 12){
				g.drawImage(tex.player[49], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 13){
				g.drawImage(tex.player[53], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 14){
				g.drawImage(tex.player[57], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 15){
				g.drawImage(tex.player[61], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 16){
				g.drawImage(tex.player[65], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 17){
				g.drawImage(tex.player[69], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 18){
				g.drawImage(tex.player[73], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 19){
				g.drawImage(tex.player[77], (int)x, (int)y,  64, 64,null);

			}
		}else if(facing == 3){
			if(Charsel.playerValue == 0){
				g.drawImage(tex.player[2], (int)x, (int)y,  64, 64,null);
			}
			if(Charsel.playerValue == 1){
				g.drawImage(tex.player[6], (int)x, (int)y,  64, 64,null);
			}
			if(Charsel.playerValue == 2){
				g.drawImage(tex.player[10], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 3){
				g.drawImage(tex.player[14],(int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 4){
				g.drawImage(tex.player[18], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 5){
				g.drawImage(tex.player[22], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 6){
				g.drawImage(tex.player[26], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 7){
				g.drawImage(tex.player[30], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 8){
				g.drawImage(tex.player[34], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 9){
				g.drawImage(tex.player[38], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 10){
				g.drawImage(tex.player[42], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 11){
				g.drawImage(tex.player[46], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 12){
				g.drawImage(tex.player[50], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 13){
				g.drawImage(tex.player[54], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 14){
				g.drawImage(tex.player[58], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 15){
				g.drawImage(tex.player[62], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 16){
				g.drawImage(tex.player[66], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 17){
				g.drawImage(tex.player[70], (int)x, (int)y,  64, 64,null);
			}
			if(Charsel.playerValue == 18){
				g.drawImage(tex.player[74], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 19){
				g.drawImage(tex.player[78], (int)x, (int)y,  64, 64,null);

			}
		}else if(facing == 4){
			if(Charsel.playerValue == 0){
				g.drawImage(tex.player[0], (int)x, (int)y,  64, 64,null);
			}
			if(Charsel.playerValue == 1){
				g.drawImage(tex.player[4], (int)x, (int)y,  64, 64,null);
			}
			if(Charsel.playerValue == 2){
				g.drawImage(tex.player[8], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 3){
				g.drawImage(tex.player[12],(int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 4){
				g.drawImage(tex.player[16], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 5){
				g.drawImage(tex.player[20], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 6){
				g.drawImage(tex.player[24], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 7){
				g.drawImage(tex.player[28], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 8){
				g.drawImage(tex.player[32], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 9){
				g.drawImage(tex.player[36], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 10){
				g.drawImage(tex.player[40], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 11){
				g.drawImage(tex.player[44], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 12){
				g.drawImage(tex.player[48], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 13){
				g.drawImage(tex.player[52], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 14){
				g.drawImage(tex.player[56], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 15){
				g.drawImage(tex.player[60], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 16){
				g.drawImage(tex.player[64], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 17){
				g.drawImage(tex.player[68], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 18){
				g.drawImage(tex.player[72], (int)x, (int)y,  64, 64,null);

			}
			if(Charsel.playerValue == 19){
				g.drawImage(tex.player[76], (int)x, (int)y,  64, 64,null);

			}
		}
		
		if(Charsel.playerValue == 14){
			if(Handler.LEVEL == 60){
				if(Artifacts.Sam){
					g.drawImage(tex.enemy[12], (int)x, (int)y + 10, 70, 70, null);
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
	
	public void collision(LinkedList<GameObject> object){
		
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.block || tempObject.getId() == ID.removable){
				
				
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
