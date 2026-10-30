package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import probe.game;

public class SuperObject {
	public BufferedImage image;
	public String name;
	public boolean collision = false;
	public int worldX,worldY;
	public Rectangle solidArea = new Rectangle(0,0,48,48);
	public int solidAreaDefaultX = 0;
	public int solidAreaDefaultY = 0;
	public void draw(Graphics2D g2, game pan) {
		
		
		int screenX =worldX ;
		int screenY = worldY;
		
	     g2.drawImage(image, screenX, screenY, pan.titleSize, pan.titleSize,null);
		
	
	}
}
