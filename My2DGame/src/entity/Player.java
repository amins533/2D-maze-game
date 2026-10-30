package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import probe.KeyHandler;
import probe.UI;
import probe.game;

public class Player extends Entity{
	game pan;
	KeyHandler KeyH;
	UI ui;
	
	public int hasKey = 0;
	public Player(game pan , KeyHandler KeyH) {
		this.pan= pan;
		this.KeyH=KeyH;
		
		solidArea = new Rectangle();
		solidArea.x=8;
		solidArea.y=16;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width=30;
		solidArea.height=30;
		
		
		setDefaultValue();
		getPlayerImage();
	}
	public void setDefaultValue() {
		x = 48;
		y = 47;
		speed =4;
		direction="down";
		
	}
	public void getPlayerImage() {
		try {
			up1 =ImageIO.read(getClass().getResourceAsStream("/player/up1.png"));
			up2 =ImageIO.read(getClass().getResourceAsStream("/player/up2.png"));
			down1 =ImageIO.read(getClass().getResourceAsStream("/player/down1.png"));
			down2 =ImageIO.read(getClass().getResourceAsStream("/player/down2.png"));
			left1 =ImageIO.read(getClass().getResourceAsStream("/player/links1.png"));
			left2 =ImageIO.read(getClass().getResourceAsStream("/player/links2.png"));
			right1 =ImageIO.read(getClass().getResourceAsStream("/player/recht1.png"));
			right2 =ImageIO.read(getClass().getResourceAsStream("/player/recht2.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void update() {
		if(KeyH.upPressed==true || KeyH.downPressed==true ||KeyH.leftPressed==true ||KeyH.rightPressed==true ) {
			if (KeyH.upPressed ==true) {
				direction="up";
			}else if (KeyH.downPressed ==true) {
				direction="down";
			}else if (KeyH.leftPressed ==true) {
				direction="left";
			}else if (KeyH.rightPressed ==true) {
				direction="right";
			}
			//Check tile collision
			collisionOn =false;
			pan.cChecker.checkTile(this);
			
			//check object collision
			int objIndex = pan.cChecker.checkObject(this, true);
			pickUpObject(objIndex);
			// ifcollision is false, player can move
			if(collisionOn == false) {
				switch(direction) {
				case "up":
					y -=speed;
					break;
				case "down":
					y +=speed;
					break;
				case "left":
					x -=speed;
					break;
				case "right":
					x +=speed;
					break;

				}
			}
			
			spriteCounter++;
			if(spriteCounter > 12) {
				if(spriteNum==1) {
					spriteNum=2;
				}
				else if(spriteNum==2) {
					spriteNum=1;
				}
				spriteCounter=0;
			}
		}
		
	}
	public void pickUpObject(int i) {
		if(i != 999) {
			String objectName = pan.obj[i].name;
			
			switch(objectName) {
			case "Key":
				hasKey++;
				pan.obj[i]=null;
				pan.ui.showMessage("now go back and open the door");
				
				break;
			case "Door":
				if(hasKey >0) {
					pan.obj[i]=null;
					hasKey--;
				}
				break;
			case "End":
				pan.ui.gameFinished = true;
				break;
			}
		}
	}
	public void draw(Graphics2D g2) {
		BufferedImage image=null;
		switch(direction) {
		case "up":
			if(spriteNum==1) {
				image = up1;
			}
			if(spriteNum==2) {
				image=up2;
			}
			break;
		case "down":
			if(spriteNum==1) {
				image = down1;
			}
			if(spriteNum==2) {
				image=down2;
			}
			break;
		case "left":
			if(spriteNum==1) {
				image = left1;
			}
			if(spriteNum==2) {
				image=left2;
			}
			break;
		case "right":
			if(spriteNum==1) {
				image = right1;
			}
			if(spriteNum==2) {
				image=right2;
			}
			break;
		}
		g2.drawImage(image, x , y , pan.titleSize , pan.titleSize , null);
	}
}
