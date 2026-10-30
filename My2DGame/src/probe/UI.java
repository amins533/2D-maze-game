package probe;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

import object.OBJ_Key;
import object.SuperObject;

public class UI {
	 
	game pan;
	Font arial_40,arial_20;
	BufferedImage KeyImage;
	BufferedImage image;
	public boolean messageOn = true;
	public boolean start = true;
	public String message="";
	int messageCounter = 0;
	public boolean gameFinished =false;
	public UI(game pan){
		this.pan=pan;
		String text =" Find the key";
		arial_40 = new Font("Algerian",Font.ITALIC,40);
		arial_20 = new Font("Algerian",Font.ITALIC,20);
		OBJ_Key Key = new OBJ_Key();
		KeyImage = Key.image;
	}
	public void showMessage(String text) {
		message=text;
		messageOn = true;
	}
	
	
	
	public void draw(Graphics2D g2) {
		
		if(pan.titleState==0) {
			drawTitleScreen();
			g2.drawImage(image, 0, 0,1440, 768,null);
		}else{
			if(gameFinished == true  ) {
			try {
				image = ImageIO.read(getClass().getResource("/objects/win.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g2.drawImage(image, 0, 0,1440, 768,null);
			
		}else {
		g2.setFont(arial_40);
		g2.setColor(Color.LIGHT_GRAY);
		if(pan.player.hasKey>0) {
		g2.drawImage(KeyImage, 29*pan.titleSize, 15*pan.titleSize,pan.titleSize,pan.titleSize, null);
		g2.drawString("Open the door",0,750);
		}
		if(messageOn == true) {
			g2.setFont(arial_20);
			g2.drawString("Inventory",1275,750);
			messageCounter++;
			if(messageCounter>240) {
				messageCounter = 0;
				messageOn = false;
			}
		}
		
	}
	}
		}
	
	public void drawTitleScreen() {
		try {
			image = ImageIO.read(getClass().getResource("/objects/titlescreen.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
