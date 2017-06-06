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
import school.gamestate.Charsel;

public class Classmate extends GameObject{

	private float width = 32, height = 32;
	private final float maxSpeed = 10;
	private Handler handler;
	public int facing = 1;
	private Game game;
	Texture tex = Game.getInstance();
	int student;
	int timer = 100;

	
	public Classmate(float x, float y, Handler handler, ID id, Game game, int student) {
		super(x, y, id);
		this.handler = handler;
		velX = 0;
		velY = 0;
		this.game = game;
		this.student = student;

		
	}

	public void tick() {
		
		timer--;
		x += velX;
		y += velY;
		if(timer <= 0){
			facing = (int)(Math.random()* 4) + 1;
			timer = 100;
		}
		if(facing == 1){
			velX = -2;
			velY = 0;
		}else if(facing == 2){
			velX = 0;
			velY = -2;
		}else if(facing == 3){
			velX = 2;
			velY = 0;
		}else if(facing == 4){
			velX = 0;
			velY = 2;
		}
		
		collision();
		
	}

	public void render(Graphics g) {
		if(facing == 1){
			if(student == 0){
				g.drawImage(tex.player[3], (int)x, (int)y, 64, 64, null);
			}
			if(student == 1){
				g.drawImage(tex.player[7], (int)x, (int)y,  64, 64,null);
			}
			if(student == 2){
				g.drawImage(tex.player[11], (int)x, (int)y,  64, 64,null);

			}
			if(student == 3){
				g.drawImage(tex.player[15],(int)x, (int)y,  64, 64,null);

			}
			if(student == 4){
				g.drawImage(tex.player[19], (int)x, (int)y,  64, 64,null);

			}
			if(student == 5){
				g.drawImage(tex.player[23], (int)x, (int)y,  64, 64,null);

			}
			if(student == 6){
				g.drawImage(tex.player[27], (int)x, (int)y,  64, 64,null);

			}
			if(student == 7){
				g.drawImage(tex.player[31], (int)x, (int)y,  64, 64,null);

			}
			if(student == 8){
				g.drawImage(tex.player[35], (int)x, (int)y,  64, 64,null);

			}
			if(student == 9){
				g.drawImage(tex.player[39], (int)x, (int)y,  64, 64,null);

			}
			if(student == 10){
				g.drawImage(tex.player[43], (int)x, (int)y,  64, 64,null);

			}
			if(student == 11){
				g.drawImage(tex.player[47], (int)x, (int)y,  64, 64,null);

			}
			if(student == 12){
				g.drawImage(tex.player[51], (int)x, (int)y,  64, 64,null);

			}
			if(student == 13){
				g.drawImage(tex.player[55], (int)x, (int)y,  64, 64,null);

			}
			if(student == 14){
				g.drawImage(tex.player[59], (int)x, (int)y,  64, 64,null);

			}
			if(student == 15){
				g.drawImage(tex.player[63], (int)x, (int)y,  64, 64,null);

			}
			if(student == 16){
				g.drawImage(tex.player[67], (int)x, (int)y,  64, 64,null);

			}
			if(student == 17){
				g.drawImage(tex.player[71], (int)x, (int)y,  64, 64,null);
			}
			if(student == 18){
				g.drawImage(tex.player[75], (int)x, (int)y,  64, 64,null);
			}
			if(student == 19){
				g.drawImage(tex.player[79], (int)x, (int)y,  64, 64,null);
			}
			if(student == 20){
				g.drawImage(tex.player[83], (int)x, (int)y,  64, 64,null);

			}
		}else if(facing == 2){
			if(student == 0){
				g.drawImage(tex.player[1], (int)x, (int)y,  64, 64,null);
			}
			if(student == 1){
				g.drawImage(tex.player[5], (int)x, (int)y, 64, 64, null);
			}
			if(student == 2){
				g.drawImage(tex.player[9], (int)x, (int)y,  64, 64,null);

			}
			if(student == 3){
				g.drawImage(tex.player[13],(int)x, (int)y,  64, 64,null);

			}
			if(student == 4){
				g.drawImage(tex.player[17], (int)x, (int)y,  64, 64,null);

			}
			if(student == 5){
				g.drawImage(tex.player[21], (int)x, (int)y,  64, 64,null);

			}
			if(student == 6){
				g.drawImage(tex.player[25], (int)x, (int)y,  64, 64,null);

			}
			if(student == 7){
				g.drawImage(tex.player[29], (int)x, (int)y,  64, 64,null);

			}
			if(student == 8){
				g.drawImage(tex.player[33], (int)x, (int)y,  64, 64,null);

			}
			if(student == 9){
				g.drawImage(tex.player[37], (int)x, (int)y,  64, 64,null);

			}
			if(student == 10){
				g.drawImage(tex.player[41], (int)x, (int)y,  64, 64,null);

			}
			if(student == 11){
				g.drawImage(tex.player[45], (int)x, (int)y,  64, 64,null);

			}
			if(student == 12){
				g.drawImage(tex.player[49], (int)x, (int)y,  64, 64,null);

			}
			if(student == 13){
				g.drawImage(tex.player[53], (int)x, (int)y,  64, 64,null);

			}
			if(student == 14){
				g.drawImage(tex.player[57], (int)x, (int)y,  64, 64,null);

			}
			if(student == 15){
				g.drawImage(tex.player[61], (int)x, (int)y,  64, 64,null);

			}
			if(student == 16){
				g.drawImage(tex.player[65], (int)x, (int)y,  64, 64,null);

			}
			if(student == 17){
				g.drawImage(tex.player[69], (int)x, (int)y,  64, 64,null);

			}
			if(student == 18){
				g.drawImage(tex.player[73], (int)x, (int)y,  64, 64,null);

			}
			if(student == 19){
				g.drawImage(tex.player[77], (int)x, (int)y,  64, 64,null);

			}
			if(student == 20){
				g.drawImage(tex.player[81], (int)x, (int)y,  64, 64,null);
			}
		}else if(facing == 3){
			if(student == 0){
				g.drawImage(tex.player[2], (int)x, (int)y,  64, 64,null);
			}
			if(student == 1){
				g.drawImage(tex.player[6], (int)x, (int)y,  64, 64,null);
			}
			if(student == 2){
				g.drawImage(tex.player[10], (int)x, (int)y,  64, 64,null);

			}
			if(student == 3){
				g.drawImage(tex.player[14],(int)x, (int)y,  64, 64,null);

			}
			if(student == 4){
				g.drawImage(tex.player[18], (int)x, (int)y,  64, 64,null);

			}
			if(student == 5){
				g.drawImage(tex.player[22], (int)x, (int)y,  64, 64,null);

			}
			if(student == 6){
				g.drawImage(tex.player[26], (int)x, (int)y,  64, 64,null);

			}
			if(student == 7){
				g.drawImage(tex.player[30], (int)x, (int)y,  64, 64,null);

			}
			if(student == 8){
				g.drawImage(tex.player[34], (int)x, (int)y,  64, 64,null);

			}
			if(student == 9){
				g.drawImage(tex.player[38], (int)x, (int)y,  64, 64,null);

			}
			if(student == 10){
				g.drawImage(tex.player[42], (int)x, (int)y,  64, 64,null);

			}
			if(student == 11){
				g.drawImage(tex.player[46], (int)x, (int)y,  64, 64,null);

			}
			if(student == 12){
				g.drawImage(tex.player[50], (int)x, (int)y,  64, 64,null);

			}
			if(student == 13){
				g.drawImage(tex.player[54], (int)x, (int)y,  64, 64,null);

			}
			if(student == 14){
				g.drawImage(tex.player[58], (int)x, (int)y,  64, 64,null);

			}
			if(student == 15){
				g.drawImage(tex.player[62], (int)x, (int)y,  64, 64,null);

			}
			if(student == 16){
				g.drawImage(tex.player[66], (int)x, (int)y,  64, 64,null);

			}
			if(student == 17){
				g.drawImage(tex.player[70], (int)x, (int)y,  64, 64,null);
			}
			if(student == 18){
				g.drawImage(tex.player[74], (int)x, (int)y,  64, 64,null);

			}
			if(student == 19){
				g.drawImage(tex.player[78], (int)x, (int)y,  64, 64,null);

			}
			if(student == 20){
				g.drawImage(tex.player[82], (int)x, (int)y,  64, 64,null);

			}
		}else if(facing == 4){
			if(student == 0){
				g.drawImage(tex.player[0], (int)x, (int)y,  64, 64,null);
			}
			if(student == 1){
				g.drawImage(tex.player[4], (int)x, (int)y,  64, 64,null);
			}
			if(student == 2){
				g.drawImage(tex.player[8], (int)x, (int)y,  64, 64,null);

			}
			if(student == 3){
				g.drawImage(tex.player[12],(int)x, (int)y,  64, 64,null);

			}
			if(student == 4){
				g.drawImage(tex.player[16], (int)x, (int)y,  64, 64,null);

			}
			if(student == 5){
				g.drawImage(tex.player[20], (int)x, (int)y,  64, 64,null);

			}
			if(student == 6){
				g.drawImage(tex.player[24], (int)x, (int)y,  64, 64,null);

			}
			if(student == 7){
				g.drawImage(tex.player[28], (int)x, (int)y,  64, 64,null);

			}
			if(student == 8){
				g.drawImage(tex.player[32], (int)x, (int)y,  64, 64,null);

			}
			if(student == 9){
				g.drawImage(tex.player[36], (int)x, (int)y,  64, 64,null);

			}
			if(student == 10){
				g.drawImage(tex.player[40], (int)x, (int)y,  64, 64,null);

			}
			if(student == 11){
				g.drawImage(tex.player[44], (int)x, (int)y,  64, 64,null);

			}
			if(student == 12){
				g.drawImage(tex.player[48], (int)x, (int)y,  64, 64,null);

			}
			if(student == 13){
				g.drawImage(tex.player[52], (int)x, (int)y,  64, 64,null);

			}
			if(student == 14){
				g.drawImage(tex.player[56], (int)x, (int)y,  64, 64,null);

			}
			if(student == 15){
				g.drawImage(tex.player[60], (int)x, (int)y,  64, 64,null);

			}
			if(student == 16){
				g.drawImage(tex.player[64], (int)x, (int)y,  64, 64,null);

			}
			if(student == 17){
				g.drawImage(tex.player[68], (int)x, (int)y,  64, 64,null);

			}
			if(student == 18){
				g.drawImage(tex.player[72], (int)x, (int)y,  64, 64,null);

			}
			if(student == 19){
				g.drawImage(tex.player[76], (int)x, (int)y,  64, 64,null);

			}
			if(student == 20){
				g.drawImage(tex.player[80], (int)x, (int)y,  64, 64,null);

			}
			
			
		}
		if(Charsel.playerValue == 14){
			if(Handler.LEVEL == 60){
				g.drawImage(tex.enemy[12], (int)x, (int)y + 10, 70, 70, null);
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
