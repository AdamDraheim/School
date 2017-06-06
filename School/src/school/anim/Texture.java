package school.anim;

import java.awt.image.BufferedImage;

public class Texture {


	public BufferedImage[] player = new BufferedImage[84];
	public BufferedImage[] enemy = new BufferedImage[14];
	public BufferedImage[] artifact = new BufferedImage[20];
	public BufferedImage[] teacher = new BufferedImage[8];

	Spritesheet ps, t, as, ts;
	private BufferedImage player_sheet = null;
	private BufferedImage test_sheet = null;
	private BufferedImage artifact_sheet = null;
	private BufferedImage teacher_sheet = null;
	
	public Texture(){
		
		BufferedImageLoader loader = new BufferedImageLoader();
		
		try{
			
			player_sheet = loader.loadImage("/tex/Class.png");
			test_sheet = loader.loadImage("/tex/Blob.png");
			artifact_sheet = loader.loadImage("/tex/Artifact.png");
			teacher_sheet = loader.loadImage("/tex/Teachers.png");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		ps = new Spritesheet(player_sheet);
		t = new Spritesheet(test_sheet);
		as = new Spritesheet(artifact_sheet);
		ts = new Spritesheet(teacher_sheet);
		
		getTextures();
	}
	
	private void getTextures(){
		
		
		player[0] = ps.grabImage(1, 1, 32, 32);
		player[1] = ps.grabImage(2, 1, 32, 32);
		player[2] = ps.grabImage(3, 1, 32, 32);
		player[3] = ps.grabImage(4, 1, 32, 32);
		
		player[4] = ps.grabImage(1, 2, 32, 32);
		player[5] = ps.grabImage(2, 2, 32, 32);
		player[6] = ps.grabImage(3, 2, 32, 32);
		player[7] = ps.grabImage(4, 2, 32, 32);
		
		player[8] = ps.grabImage(1, 3, 32, 32);
		player[9] = ps.grabImage(2, 3, 32, 32);
		player[10] = ps.grabImage(3, 3, 32, 32);
		player[11] = ps.grabImage(4, 3, 32, 32);
		
		player[12] = ps.grabImage(1, 4, 32, 32);
		player[13] = ps.grabImage(2, 4, 32, 32);
		player[14] = ps.grabImage(3, 4, 32, 32);
		player[15] = ps.grabImage(4, 4, 32, 32);
		
		player[16] = ps.grabImage(1, 5, 32, 32);
		player[17] = ps.grabImage(2, 5, 32, 32);
		player[18] = ps.grabImage(3, 5, 32, 32);
		player[19] = ps.grabImage(4, 5, 32, 32);
		
		player[20] = ps.grabImage(1, 6, 32, 32);
		player[21] = ps.grabImage(2, 6, 32, 32);
		player[22] = ps.grabImage(3, 6, 32, 32);
		player[23] = ps.grabImage(4, 6, 32, 32);

		player[24] = ps.grabImage(1, 7, 32, 32);
		player[25] = ps.grabImage(2, 7, 32, 32);
		player[26] = ps.grabImage(3, 7, 32, 32);
		player[27] = ps.grabImage(4, 7, 32, 32);
		
		player[28] = ps.grabImage(1, 8, 32, 32);
		player[29] = ps.grabImage(2, 8, 32, 32);
		player[30] = ps.grabImage(3, 8, 32, 32);
		player[31] = ps.grabImage(4, 8, 32, 32);
		
		player[32] = ps.grabImage(1, 9, 32, 32);
		player[33] = ps.grabImage(2, 9, 32, 32);
		player[34] = ps.grabImage(3, 9, 32, 32);
		player[35] = ps.grabImage(4, 9, 32, 32);
		
		player[36] = ps.grabImage(1, 10, 32, 32);
		player[37] = ps.grabImage(2, 10, 32, 32);
		player[38] = ps.grabImage(3, 10, 32, 32);
		player[39] = ps.grabImage(4, 10, 32, 32);
		
		player[40] = ps.grabImage(1, 11, 32, 32);
		player[41] = ps.grabImage(2, 11, 32, 32);
		player[42] = ps.grabImage(3, 11, 32, 32);
		player[43] = ps.grabImage(4, 11, 32, 32);
		
		player[44] = ps.grabImage(1, 12, 32, 32);
		player[45] = ps.grabImage(2, 12, 32, 32);
		player[46] = ps.grabImage(3, 12, 32, 32);
		player[47] = ps.grabImage(4, 12, 32, 32);
		
		player[48] = ps.grabImage(1, 13, 32, 32);
		player[49] = ps.grabImage(2, 13, 32, 32);
		player[50] = ps.grabImage(3, 13, 32, 32);
		player[51] = ps.grabImage(4, 13, 32, 32);
		
		player[52] = ps.grabImage(1, 14, 32, 32);
		player[53] = ps.grabImage(2, 14, 32, 32);
		player[54] = ps.grabImage(3, 14, 32, 32);
		player[55] = ps.grabImage(4, 14, 32, 32);
		
		player[56] = ps.grabImage(1, 15, 32, 32);
		player[57] = ps.grabImage(2, 15, 32, 32);
		player[58] = ps.grabImage(3, 15, 32, 32);
		player[59] = ps.grabImage(4, 15, 32, 32);
		
		player[60] = ps.grabImage(1, 16, 32, 32);
		player[61] = ps.grabImage(2, 16, 32, 32);
		player[62] = ps.grabImage(3, 16, 32, 32);
		player[63] = ps.grabImage(4, 16, 32, 32);
		
		player[64] = ps.grabImage(1, 17, 32, 32);
		player[65] = ps.grabImage(2, 17, 32, 32);
		player[66] = ps.grabImage(3, 17, 32, 32);
		player[67] = ps.grabImage(4, 17, 32, 32);
		
		player[68] = ps.grabImage(1, 18, 32, 32);
		player[69] = ps.grabImage(2, 18, 32, 32);
		player[70] = ps.grabImage(3, 18, 32, 32);
		player[71] = ps.grabImage(4, 18, 32, 32);
		
		player[72] = ps.grabImage(1, 19, 32, 32);
		player[73] = ps.grabImage(2, 19, 32, 32);
		player[74] = ps.grabImage(3, 19, 32, 32);
		player[75] = ps.grabImage(4, 19, 32, 32);
		
		player[76] = ps.grabImage(1, 20, 32, 32);
		player[77] = ps.grabImage(2, 20, 32, 32);
		player[78] = ps.grabImage(3, 20, 32, 32);
		player[79] = ps.grabImage(4, 20, 32, 32);
		
		//brandon
		player[80] = ps.grabImage(1, 21, 32, 32);
		player[81] = ps.grabImage(2, 21, 32, 32);
		player[82] = ps.grabImage(3, 21, 32, 32);
		player[83] = ps.grabImage(4, 21, 32, 32);
				
		enemy[0] = t.grabImage(1, 1, 32, 32);
		enemy[1] = t.grabImage(2, 1, 32, 32);
		enemy[2] = t.grabImage(3, 1, 32, 32);
		enemy[3] = t.grabImage(1, 2, 32, 32);
		enemy[4] = t.grabImage(2, 2, 32, 32);
		enemy[5] = t.grabImage(1, 3, 32, 32);
		enemy[6] = t.grabImage(2, 3, 32, 32);
		enemy[7] = t.grabImage(3, 2, 32, 32);
		enemy[8] = t.grabImage(3, 3, 32, 32);
		enemy[9] = t.grabImage(1, 4, 32, 32);
		enemy[10] = t.grabImage(2, 4, 32, 32);
		enemy[11] = t.grabImage(3, 4, 32, 32);
		enemy[12] = t.grabImage(1, 5, 32, 32);
		enemy[13] = t.grabImage(2, 5, 32, 32);

		
		artifact[0] = as.grabImage(1, 1, 32, 32);
		artifact[1] = as.grabImage(2, 1, 32, 32);
		artifact[2] = as.grabImage(3, 1, 32, 32);
		artifact[3] = as.grabImage(4, 1, 32, 32);
		artifact[4] = as.grabImage(5, 1, 32, 32);
		artifact[5] = as.grabImage(1, 2, 32, 32);
		artifact[6] = as.grabImage(2, 2, 32, 32);
		artifact[7] = as.grabImage(3, 2, 32, 32);
		artifact[8] = as.grabImage(4, 2, 32, 32);
		artifact[9] = as.grabImage(5, 2, 32, 32);
		artifact[10] = as.grabImage(1, 3, 32, 32);
		artifact[11] = as.grabImage(2, 3, 32, 32);
		artifact[12] = as.grabImage(3, 3, 32, 32);
		artifact[13] = as.grabImage(4, 3, 32, 32);
		artifact[14] = as.grabImage(5, 3, 32, 32);
		artifact[15] = as.grabImage(1, 4, 32, 32);
		artifact[16] = as.grabImage(2, 4, 32, 32);
		artifact[17] = as.grabImage(3, 4, 32, 32);
		artifact[18] = as.grabImage(4, 4, 32, 32);
		artifact[19] = as.grabImage(5, 4, 32, 32);
		
		//Farris
		teacher[0] = ts.grabImage(1, 1, 32, 32);
		teacher[1] = ts.grabImage(2, 1, 32, 32);
		teacher[2] = ts.grabImage(3, 1, 32, 32);
		teacher[3] = ts.grabImage(4, 1, 32, 32);

		//Conor
		teacher[4] = ts.grabImage(1, 2, 32, 32);
		teacher[5] = ts.grabImage(2, 2, 32, 32);
		teacher[6] = ts.grabImage(3, 2, 32, 32);
		teacher[7] = ts.grabImage(4, 2, 32, 32);
	}
	
}
