package school.gamestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
import java.util.Stack;

import school.game.Handler;

public class QuestList extends MouseAdapter{

	public static boolean questView = false;
	Handler handler;
	public static int quests;
	public String Title;
	public String Objective;
	public static Stack Quests = new Stack();

	
	public void mousePressed(MouseEvent e, Handler handler) {
		
		int mx = e.getX();
		int my = e.getY();
		this.handler = handler;
		
	}

	public void tick() {
			
	}

	public void render(Graphics g) {
		
		if(questView == true){
						
			g.setColor(Color.gray);
			g.fillRect(50, 50, 700, 500);
			g.setColor(Color.black);
			g.setFont(new Font("Arial", 0, 50));
			g.drawString("QUEST MENU", 260, 100);

			for(int i = 0; i < Quests.size(); i++){
				
				int quest = (int)Quests.elementAt(i);
					
				if(quest == 10){
					Title = "Einstein";
					Objective = "Find the banana";
				}else if(quest == 20){
					Title = "A what?";
					Objective = "Attend the performance";
				}else if(quest == 21){
					Title = "A what?";
					Objective = "A test";
				}else if(quest == 22){
					Title = "A what?";
					Objective = "Collect the Admission Ticket";
				}else if(quest == 30){
					Title = "Fruit-mensions";
					Objective = "Find the Apple";
				}else if(quest == 31 || quest == 32){
					Title = "Fruit-mensions";
					Objective = "Find the Apple... again";
				}else if(quest == 33 || quest == 34){
					Title = "Fruit-mensions";
					Objective = "Find the Apple III";
				}else if(quest == 35){
					Title = "Fruit-mensions";
					Objective = "Ask Nathaniel where it went?";
				}else if(quest == 40){
					Title = "Fickle Fingers";
					Objective = "Dr. Farris wanted to see me";
				}else if(quest == 41){
					Title = "Fickle Fingers";
					Objective = "Kill the Scientific abomination";
				}else if(quest == 42){
					Title = "Fickle Fingers";
					Objective = "Talk to Dr. Farris";
				}else if(quest == 43){
					Title = "Fickle Fingers";
					Objective = "Collect the Flask";
				}else if(quest == 50){
					Title = "Don't Rock the Boat";
					Objective = "We're taking the bus?!";
				}else if(quest == 51){
					Title = "Don't Rock the Boat";
					Objective = "Make a memory";
				}else if(quest == 60){
					Title = "Homerun";
					Objective = "Play ball";
				}else if(quest == 61){
					Title = "Homerun";
					Objective = "Batter up";
				}else if(quest == 70){
					Title = "The Tacotrip";
					Objective = "Nothing like tacos outside";
				}else if(quest == 71){
					Title = "The Tacotrip";
					Objective = "Tacos can live, right?";
				}else if(quest == 72){
					Title = "The Tacotrip";
					Objective = "Am I eating its corpse?";
				}else if(quest == 80){
					Title = "On Men and Monsters"; 
					Objective = "Spenser must hear my retort";
				}else if(quest == 81){
					Title = "On Men and Monsters"; 
					Objective = "Let's DEBATE";
				}else if(quest == 82){
					Title = "On Men and Monsters"; 
					Objective = "He dropped a political treatise";
				}else if(quest == 90){
					Title = "Familiar Faces";
					Objective = "See your friends";
				}else if(quest == 100){
					Title = "Octoberfest";
					Objective = "Let's head out to the event!";
				}else if(quest == 101){
					Title = "Octoberfest";
					Objective = "Kill the evil pumpkins";
				}else if(quest == 102){
					Title = "Octoberfest";
					Objective = "Collect the mask";
				}else if(quest == 110){
					Title = "Wilderness";
					Objective = "Time for the retreat";
				}else if(quest == 111){
					Title = "Wilderness";
					Objective = "Bagel Error- Continuity Issues";
				}else if(quest == 112){
					Title = "Wilderness";
					Objective = "A BAGEL? NATHANIEL! ADAM!";
				}else if(quest == 120){
					Title = "Appeasing the Beardlords";
					Objective = "Go to the ritual";
				}else if(quest == 121){
					Title = "Appeasing the BeardLords";
					Objective = "Step up to the pedestal";
				}else if(quest == 122){
					Title = "Appeasing the Beardlords";
					Objective = "You aren't ready for this";
				}else if(quest == 123){
					Title = "Appeasing the Beardlords";
					Objective = "Banish the beard";
				}else if(quest == 130){
					Title = "Scrub";
					Objective = "Meet EVERYONE. EVERYONE.";
				}else if(quest == 140){
					Title = "Food Overdose";
					Objective = "FIND THE FOOOOOOOOD";
				}else if(quest == 150){
					Title = "It's Getting Hot in Here";
					Objective = "Find a way past the fire";
				}else if(quest == 160){
					Title = "Nightcrawlers";
					Objective = "Cool story bro.";
				}else if(quest == 170){
					Title = "Bring Out Ye Dead";
					Objective = "Attend the Performance";
				}else if(quest == 180){
					Title = "Don't Question";
					Objective = "It's better that way";
				}else if(quest == 190){
					Title = "Too Young and Clever";
					Objective = "Take some time off Aileen!";
				}else if(quest == 200){
					Title = "Another Page of History";
					Objective = "Get Signatures";
				}else if(quest == 210){
					Title = "In a Hole in the Ground...";
					Objective = "Time for some D&D";
				}

				int change = 100 * i;
				
				g.setColor(Color.white);
				g.drawRect(207, 139 + change, 351 ,101);
				g.setColor(Color.black);
				g.fillRect(208, 140 + change, 350 ,100);
				g.setColor(Color.white);
				g.setFont(new Font("Arial", 0, 30));
				g.drawString(Title, 218, 170 + change);
				g.setFont(new Font("Arial", 0, 20));
				g.drawString(Objective, (int) 218, (int) 200 + change);
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
	
}
