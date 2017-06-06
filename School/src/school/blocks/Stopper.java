package school.blocks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import school.game.GameObject;
import school.game.ID;

public class Stopper extends GameObject{

	public Stopper(float x, float y, ID id) {
		super(x, y, id);
	}

	public void tick() {
		
	}

	public void render(Graphics g) {

	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 32, 32);
	}
}
