package school.blocks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import school.game.GameObject;
import school.game.Handler;
import school.game.ID;

public class NPCBound extends GameObject{


	Handler handler;
	public NPCBound(float x, float y, ID id, Handler handler) {
		super(x, y, id);

		this.handler = handler;
	}

	public void tick() {
	}

	public void render(Graphics g) {

	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 32, 32);
	}
	

}
