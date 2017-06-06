package school.game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Calendar;
import java.util.LinkedList;

import school.anim.BufferedImageLoader;
import school.blocks.Block;
import school.blocks.NPCBound;
import school.blocks.Removable;
import school.blocks.Stopper;
import school.creatures.CampMonster;
import school.creatures.Classmate;
import school.creatures.Conor;
import school.creatures.DualEnemy;
import school.creatures.Fire;
import school.creatures.Ghost;
import school.creatures.LabMonster;
import school.creatures.PlayFear;
import school.creatures.Player;
import school.creatures.Taco;
import school.gamestate.Artifacts;
import school.gamestate.Charsel;
import school.gamestate.QuestList;
import school.level.FirstHall;
import school.npc.Teachers;
import school.objects.AileenReward;
import school.objects.Apple;
import school.objects.Base;
import school.objects.ChaseReward;
import school.objects.Dancefloor;
import school.objects.ElifReward;
import school.objects.Food;
import school.objects.GreysonTimer;
import school.objects.HelmersPort;
import school.objects.JohnTimer;
import school.objects.NichReward;
import school.objects.RebeccaReward;
import school.objects.SamReward;
import school.objects.SavannahReward;
import school.level.*;


public class Handler {

	private Game game;
	private Camera cam;
	public static int LEVEL = 0;
	int day = Calendar.DAY_OF_WEEK;
	public static int enemyCount = 0;
	
	private BufferedImage Office = null, FirstFloor = null, Outside = null, UpperFloor = null, Retreat = null, MPR = null, Bio = null,
			Beard = null, Prom = null, Baseball = null, Outside2 = null, House = null, Helmers = null;
	public LinkedList<GameObject> object = new LinkedList<GameObject>();

	public Handler(Camera cam, Game game){
		this.game = game;
		this.cam = cam;
		
		BufferedImageLoader loader = new BufferedImageLoader();
		try{
		Office = loader.loadImage("/maps/Office.png");
		FirstFloor = loader.loadImage("/maps/FirstFloor.png");
		Outside = loader.loadImage("/maps/Einstein.png");
		UpperFloor = loader.loadImage("/maps/UpperFloor.png");
		Retreat = loader.loadImage("/maps/Retreat.png");
		MPR = loader.loadImage("/maps/MPR.png");
		Bio = loader.loadImage("/maps/Bio.png");
		Beard = loader.loadImage("/maps/Beard.png");
		Prom = loader.loadImage("/maps/Boat.png");
		Baseball = loader.loadImage("/maps/Baseball.png");
		Outside2 = loader.loadImage("/maps/Outside.png");
		House = loader.loadImage("/maps/House.png");
		Helmers = loader.loadImage("/maps/Helmers.png");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
public void tick(){
		
		for(int i = 0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			tempObject.tick();
		}
	}
	
	public void render(Graphics g){
		
		for(int i = 0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			
			tempObject.render(g);
		}
	}
	
	public void addObject(GameObject object){
		this.object.add(object);
	}
	public void removeObject(GameObject object){
		this.object.remove(object);
	}
	public void decreaseHealth(GameObject object, int decrease){
		object.health -= decrease;
	}
	
	public int getHealth(GameObject object){
		return object.health;
	}
	
	public int getFacing(GameObject object){
		return object.facing;
	}
	
	
	public int getWidth(){
		return Game.width;
	}
	
	public int getHeight(){
		return Game.height;
	}
	
	public void LoadImageLevel(BufferedImage image){
		int w = image.getWidth();
		int h = image.getHeight();
		
		for(int xx = 0; xx < w; xx++){
			for(int yy = 0; yy < h; yy++){
				
				int pixel = image.getRGB(xx, yy);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				
				//Blocks
				
				if(red == 255 && green == 255 && blue == 255){
					addObject(new Block(xx*32, yy*32, ID.block, this));
				}
				if(red == 33 && green == 33 && blue == 33){
					addObject(new Stopper(xx * 32, yy * 32, ID.stopper));
				}if(red == 0 && green == 230 && blue == 0){
					addObject(new NPCBound(xx*32, yy*32, ID.npcBound, this));
				}if(red == 200 && green == 200 && blue == 200){
					addObject(new Removable(xx*32, yy * 32, ID.removable, this));
				}
			}
		}
	}
	
	public void clearLevel(){
		object.clear();
	}
	
	public void SwitchLevel(int level, int spawn){
				
		if(level == 1){
			clearLevel();
			if(spawn == 0){
				addObject(new Player(448, 96, this, cam, ID.player, game));
			}else if(spawn == 1){
				addObject(new Player(4*32, 4*32, this, cam, ID.player, game));
			}
			
			LEVEL = 1;
			LoadImageLevel(Office);
			addObject(new FirstHall(0, 96, ID.door, this, 0));
			addObject(new FirstHall(0, 128, ID.door, this, 0));
			
			addObject(new UpperFloor(384, 0, ID.door, this, 1));
			addObject(new UpperFloor(416, 0, ID.door, this, 1));
			addObject(new UpperFloor(448, 0, ID.door, this, 1));
			addObject(new UpperFloor(480, 0, ID.door, this, 1));
			
			if(Charsel.playerValue == 1){
				for(int ii = 0; ii < QuestList.Quests.size(); ii++){
					
					if((int)QuestList.Quests.elementAt(ii) == 32){
						addObject(new Apple(7*32, 11 * 32, ID.misc, this));
					}
				}
			}

			
		}
		if(level == 2){
			clearLevel();
			LEVEL = 2;

			if(spawn == 0){
				addObject(new Player(1820, 1750, this, cam, ID.player, game));
			}else if(spawn == 1){
				addObject(new Player(256, 256, this, cam, ID.player, game));
			}else if(spawn == 2){
				addObject(new Player(320, 1152, this, cam, ID.player, game));
			}else if(spawn == 3){
				addObject(new Player(22* 32, 320, this, cam, ID.player, game));
			}
			LoadImageLevel(FirstFloor);
			
			if(Charsel.playerValue == 19){
				addObject(new Ghost(28 * 32, 26 * 32, this, game, ID.enemy, true));
			}

			addObject(new Outside(160, 250, ID.door, this, 0));
			addObject(new Outside(160, 282, ID.door, this, 0));
			
			addObject(new UpperFloor(192, 384, ID.door, this, 0));
			addObject(new UpperFloor(224, 384, ID.door, this, 0));
			addObject(new UpperFloor(256, 384, ID.door, this, 0));
			
			addObject(new UpperFloor(448, 1120, ID.door, this, 2));
			addObject(new UpperFloor(448, 1152, ID.door, this, 2));
			addObject(new UpperFloor(448, 1184, ID.door, this, 2));
			addObject(new UpperFloor(448, 1216, ID.door, this, 2));
			
			addObject(new MPR(26*32 + 16, 8*32, ID.door, this, 0));
			addObject(new MPR(26*32 + 16, 9*32, ID.door, this, 0));
			
			addObject(new Bio(24 * 32, (6 * 32) - 16, ID.door, this, 0));
			addObject(new Bio(25 * 32, (6 * 32) - 16, ID.door, this, 0));
			
			addObject(new Office(61 * 32, 54*32, ID.door, this, 1));
			addObject(new Office(61*32, 55*32, ID.door, this, 1));
			addObject(new Office(61 * 32, 56*32, ID.door, this, 1));
			addObject(new Office(61*32, 57*32, ID.door, this, 1));


			
			


		}
		if(level == 3){
			clearLevel();
			LEVEL = 3;

			if(spawn == 0){
				addObject(new Player(928, 1088, this, cam, ID.player, game));
			}if(spawn == 1){
				addObject(new Player(800, 1088, this, cam, ID.player, game));
			}
			
			addObject(new FirstHall(33*32, 33*32, ID.door, this, 1));
			addObject(new FirstHall(33*32, 34*32, ID.door, this, 1));

			
			LoadImageLevel(Outside);
			
			if(Charsel.playerValue == 3 || Charsel.playerValue == 4 || Charsel.playerValue == 5 || Charsel.playerValue == 6 || 
					Charsel.playerValue == 9 || Charsel.playerValue == 10 || Charsel.playerValue == 12 || Charsel.playerValue == 13 ||
					Charsel.playerValue == 14 || Charsel.playerValue == 17 || Charsel.playerValue == 16){
				addObject(new Special(672, 1056, ID.door, this, 20));
			}
			
			if(Charsel.playerValue == 7){
				addObject(new JohnTimer(0, 0, ID.misc, this));
			}
			
			if(Charsel.playerValue == 1){
				for(int ii = 0; ii < QuestList.Quests.size(); ii++){
					
					if((int)QuestList.Quests.elementAt(ii) == 30){
						addObject(new Apple(30*32, 50 * 32, ID.misc, this));
					}
				}
			}
			
			for(int i = 0; i < 20; i++){
				if(i != Charsel.playerValue){
					//anime (4,5,7,9,12,18) //704-1088, 1504-2048
					if(i == 4 || i == 5 || i == 7 || i == 9 || i == 12 || i == 18){
						addObject(new Classmate((int)(Math.random() * 304) + 704, (int)(Math.random() * 500) + 1504, this, ID.student, game, i));
					}
				}
			}
			

		}
		if(level == 4){
			clearLevel();
			LEVEL = 4;

			if(spawn == 0){
				addObject(new Player(672, 2304, this, cam, ID.player, game));
			}else if(spawn == 1){
				addObject(new Player(2304, 96, this, cam, ID.player, game));
			}else if(spawn == 2){
				addObject(new Player(1952, 2240, this, cam, ID.player, game));
			}
			LoadImageLevel(UpperFloor);
			
			addObject(new FirstHall(800, 2272, ID.door, this, 1));
			addObject(new FirstHall(800, 2304, ID.door, this, 1));
			addObject(new FirstHall(800, 2336, ID.door, this, 1));
			addObject(new FirstHall(800, 2368, ID.door, this, 1));
			
			addObject(new FirstHall(1856, 2272, ID.door, this, 2));
			addObject(new FirstHall(1856, 2304, ID.door, this, 2));
			addObject(new FirstHall(1856, 2336, ID.door, this, 2));
			
			addObject(new Office(2304, 32, ID.door, this, 0));
			addObject(new Office(2336, 32, ID.door, this, 0));
			addObject(new Office(2368, 32, ID.door, this, 0));

			if(Charsel.playerValue == 1){
				for(int ii = 0; ii < QuestList.Quests.size(); ii++){
					
					if((int)QuestList.Quests.elementAt(ii) == 34){
						System.out.println("HI");
						addObject(new Apple(5*32, 42 * 32, ID.misc, this));
					}
				}
			}
			
		}
		if(level == 5){
			clearLevel();
			LEVEL = 5;
			
			LoadImageLevel(MPR);
			if(spawn == 0){
				addObject(new Player(3 * 32, 34 * 32, this, cam, ID.player, game));
			}else if(spawn == 1){
				addObject(new Player(35 * 32, 35 * 32, this, cam, ID.player, game));
			}
			
			if(Charsel.playerValue == 15){
				for(int i = 0; i < 20; i++){
					if(i != Charsel.playerValue){
						//anime (4,5,7,9,12,18) //704-1088, 1504-2048
						addObject(new Classmate((int)(Math.random() * 300) + 32, (int)(Math.random() * 300) + 32, this, ID.student, game, i));
						
					}
				}	
				
				addObject(new SavannahReward(17 * 32, 4 * 32, ID.artifact, this));
			}
			
			addObject(new FirstHall(32, 44 * 32, ID.door, this, 3));
			addObject(new FirstHall(32, 45 * 32, ID.door, this, 3));
			addObject(new Outside2(37 * 32, 35 * 32, ID.door, this, 0));
			addObject(new Outside2(37 * 32, 34 * 32, ID.door, this, 0));
			
			if(day == 6){
				addObject(new Classmate(500, 500, this, ID.student, game, 20));
				if(Charsel.playerValue == 11){
					for(int ii = 0; ii < QuestList.Quests.size(); ii++){
						
						if((int)QuestList.Quests.elementAt(ii) == 130){
							QuestList.Quests.remove(ii);
						}
					}
					addObject(new NichReward(750, 750, ID.artifact, this));
				}
				
			}
			
			if(Charsel.playerValue == 0){
				if(Artifacts.Ari == false){
					addObject(new PlayFear(15 * 32, 3 * 32, this, game, ID.enemy, true));
					for(int ii = 0; ii < QuestList.Quests.size(); ii++){
						
						if((int)QuestList.Quests.elementAt(ii) == 20){
							QuestList.Quests.remove(ii);
						}
					}
					QuestList.Quests.push(21);
				}
			}
		}
		
		if(level == 6){
			clearLevel();
			LEVEL = 6;
			
			LoadImageLevel(Bio);
			addObject(new Player(40*32, 60*32 , this, cam, ID.player, game));
			if(Charsel.playerValue == 2){
				if(Artifacts.Cole == false){
					addObject(new LabMonster(15*32, 45*32, this, game, ID.enemy, true));
					addObject(new Teachers(64, 64, this, ID.student, game, 0));
					for(int ii = 0; ii < QuestList.Quests.size(); ii++){
						
						if((int)QuestList.Quests.elementAt(ii) == 40){
							QuestList.Quests.remove(ii);
						}
					}
					QuestList.Quests.push(41);

				}
			}

		}
		
		if(level == 25){
			clearLevel();
			LEVEL = 25;
			LoadImageLevel(Helmers);
			addObject(new Player(5*32, 5*32 , this, cam, ID.player, game));
			addObject(new AileenReward(50 * 32, 50 * 32, ID.artifact, this));

		}
		
		if(level == 7){
			clearLevel();
			LEVEL = 7;
			
			LoadImageLevel(Outside2);
			
			addObject(new Player(17 * 32, 23 * 32, this, cam, ID.player, game));
			
			addObject(new MPR(12*32, 22*32, ID.door, this, 1));
			addObject(new MPR(12*32, 23*32, ID.door, this, 1));
			
			if(Charsel.playerValue == 8){
				for(int ii = 0; ii < QuestList.Quests.size(); ii++){
					
					if((int)QuestList.Quests.elementAt(ii) == 100){
						QuestList.Quests.remove(ii);
						QuestList.Quests.push(101);
					}
				}
				for(int i = 0; i < 5; i++){
					enemyCount++;
					addObject(new DualEnemy(1000, 1000, ID.enemy, this));
				}
			}
			
		}
		if(level == 60){
			clearLevel();
			LEVEL = 60;
			
			//Retreat
			
			if(Charsel.playerValue == 17){
				addObject(new HelmersPort(32*24, 10*32, ID.misc, this));
			}
			
			if(Charsel.playerValue == 5 || Charsel.playerValue == 9 || Charsel.playerValue == 14 || Charsel.playerValue == 17){
				LoadImageLevel(Retreat);
				addObject(new Player(780,1100, this, cam, ID.player, game));
				
				addObject(new Outside(736, 1216, ID.door, this, 1));
				addObject(new Outside(768, 1216, ID.door, this, 1));			
				addObject(new Outside(800, 1216, ID.door, this, 1));
				addObject(new Outside(832, 1216, ID.door, this, 1));
				
				for(int i = 0; i < 20; i++){
					if(i != Charsel.playerValue){
						//anime (4,5,7,9,12,18) //704-1088, 1504-2048
						addObject(new Classmate((int)(Math.random() * 300) + 32, (int)(Math.random() * 300) + 32, this, ID.student, game, i));
						
					}
				}
				
				if(Charsel.playerValue == 14){
					addObject(new SamReward(getWidth(), getHeight(), ID.artifact, this));
				}
				
				if(Charsel.playerValue == 5){
					
					addObject(new Taco(10 * 32, 30 * 32, ID.enemy, this, true));
					
					for(int ii = 0; ii < QuestList.Quests.size(); ii++){
						
						if((int)QuestList.Quests.elementAt(ii) == 70){
							QuestList.Quests.remove(ii);
							QuestList.Quests.push(71);
			
						}
					}
				}else if(Charsel.playerValue == 9){
					for(int iii = 0; iii <= 5; iii++){
						this.enemyCount = iii;
						addObject(new CampMonster((int)(Math.random() * 300) + 32, (int)(Math.random() * 300) + 32, this, game, ID.enemy));

					}
					
					for(int ii = 0; ii < QuestList.Quests.size(); ii++){
						
						if((int)QuestList.Quests.elementAt(ii) == 110){
							QuestList.Quests.remove(ii);
							QuestList.Quests.push(111);
			
						}
					}
				}
				
				
				
				
			}else if(Charsel.playerValue == 10){
				LoadImageLevel(Beard);
				addObject(new Player(16 * 32 ,28 * 32, this, cam, ID.player, game));
				
				for(int i = 0; i < 20; i++){
					if(i != Charsel.playerValue){
						//anime (4,5,7,9,12,18) //704-1088, 1504-2048
						if(i == 1 || i == 6 || i == 12){
							addObject(new Classmate((int)(Math.random() * 300) + 32, (int)(Math.random() * 300) + 32, this, ID.student, game, i));
						}
					}
				}
				
				for(int ii = 0; ii < QuestList.Quests.size(); ii++){
					
					if((int)QuestList.Quests.elementAt(ii) == 120){
						QuestList.Quests.remove(ii);
					}
				}
				QuestList.Quests.add(121);
				
				if(Apple.appleChase == true){
					addObject(new ChaseReward(30 * 32, 64, ID.artifact, this));
				}

			}else if(Charsel.playerValue == 3){
				LoadImageLevel(Prom);
				addObject(new Player(50 * 32, 35 * 32, this, cam, ID.player, game));
				for(int i = 0; i < 20; i++){
					if(i != Charsel.playerValue){
						if(i == 1 || i == 5 || i == 9 || i == 11 || i == 13 || i == 15 || i == 17 || i == 19){
							addObject(new Classmate((int)(Math.random() * 864) + (18 * 13), (int)(Math.random() * 864) + (13 * 32), this, ID.student, game, i));
						}
					}
				}
				
				Dancefloor.complete = false;
				addObject(new Dancefloor(26 * 32, 17 * 32, ID.misc, this));
				addObject(new ElifReward(30 * 32, 40 * 32, ID.artifact, this));
				for(int ii = 0; ii < QuestList.Quests.size(); ii++){
					
					if((int)QuestList.Quests.elementAt(ii) == 50){
						QuestList.Quests.remove(ii);
						QuestList.Quests.push(51);
		
					}
				}
			}else if(Charsel.playerValue == 4){
				LoadImageLevel(Baseball);
				addObject(new Player(30 * 32, 15 * 32, this, cam, ID.player, game));
				addObject(new school.objects.Baseball(96, 96, ID.misc, this));
				
				addObject(new Base(8 * 32, 9 * 32, ID.misc, this));
				addObject(new Base(9 * 22, 22 * 32, ID.misc, this));
				addObject(new Base(15 * 32, 15 * 32, ID.misc, this));
				addObject(new Base(21 * 32, 9 * 32, ID.misc, this));
				addObject(new Base(21 * 32, 22 * 32, ID.misc, this));
				for(int ii = 0; ii < QuestList.Quests.size(); ii++){
					
					if((int)QuestList.Quests.elementAt(ii) == 60){
						QuestList.Quests.remove(ii);
						QuestList.Quests.push(61);
		
					}
				}

			}else if(Charsel.playerValue == 6 || Charsel.playerValue == 12 || Charsel.playerValue == 13 || Charsel.playerValue == 16){
				LoadImageLevel(House);
				addObject(new Player(35 * 32, 35 * 32, this, cam, ID.player, game));
				if(Charsel.playerValue == 16){
					addObject(new Conor((int)(Math.random() * 500) + 32, (int)(Math.random() * 500) + 32, this, ID.student, game, 0));
				}
				if(Charsel.playerValue == 6){
					for(int i = 0; i < 20; i++){
						if(i != Charsel.playerValue && Charsel.playerValue != 16){
							//anime (4,5,7,9,12,18) //704-1088, 1504-2048
							if(i == 14 || i == 16 || i == 10){
								addObject(new Classmate((int)(Math.random() * 500) + 32, (int)(Math.random() * 500) + 32, this, ID.student, game, i));
							}
						}

					}
					addObject(new GreysonTimer(0, 0, ID.misc, this));
					for(int ii = 0; ii < QuestList.Quests.size(); ii++){
						
						if((int)QuestList.Quests.elementAt(ii) == 80){
							QuestList.Quests.remove(ii);
							QuestList.Quests.push(81);
			
						}
					}
				}else if(Charsel.playerValue == 12){
					addObject(new Food((int)(Math.random() * getWidth()), (int)(Math.random() * getHeight()), ID.misc, this));
					addObject(new Food((int)(Math.random() * getWidth()), (int)(Math.random() * getHeight()), ID.misc, this));
					addObject(new Food((int)(Math.random() * getWidth()), (int)(Math.random() * getHeight()), ID.misc, this));
					for(int i = 0; i < 20; i++){
						if(i != Charsel.playerValue){
							//anime (4,5,7,9,12,18) //704-1088, 1504-2048
							if(i == 4 || i == 5 || i == 2 || i == 7 || i == 9){
								addObject(new Classmate((int)(Math.random() * 500) + 32, (int)(Math.random() * 500) + 32, this, ID.student, game, i));
							}
						}
					}
				}else if(Charsel.playerValue == 13){
					for(int i = 0; i < 20; i++){
						if(i != Charsel.playerValue){
							//anime (4,5,7,9,12,18) //704-1088, 1504-2048
							if(i == 0 || i == 3 || i == 11){
								addObject(new Classmate((int)(Math.random() * 500) + 32, (int)(Math.random() * 500) + 32, this, ID.student, game, i));
							}
						}
					}
					for(int i = 29; i < 33; i++){
						addObject(new Fire(17 * 32, i * 32, ID.misc, this));
					}
					for(int i = 4; i < 7; i++){
						addObject(new Fire(i * 32, 28 * 32, ID.misc, this));
					}
					addObject(new RebeccaReward(7 * 32, 35 * 32, ID.artifact, this));
					
					for(int i = 0; i < 30; i++){
						addObject(new Fire((int)(Math.random() * getWidth()), (int)(Math.random() * getHeight()), ID.misc, this));
						
					}
				}
			}
			
		}
		
		if(Charsel.playerValue == 1){
		for(int ii = 0; ii < QuestList.Quests.size(); ii++){
			
				if((int)QuestList.Quests.elementAt(ii) == 31){
					QuestList.Quests.remove(ii);
					QuestList.Quests.push(32);
	
				}
				if((int)QuestList.Quests.elementAt(ii) == 33){
					
					QuestList.Quests.remove(ii);
					QuestList.Quests.push(34);
					
	
				}

			}
		}
		
	}
	
	
}
