package probe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import object.SuperObject;
import tile.TileManager;

public class game extends JPanel implements Runnable{
	final int originalTileSize=16;
	final int scale=3;
	
	public final int titleSize=originalTileSize * scale;
	public final int maxScreenCol = 30;
	public final int maxScreenRow = 16;
	public final int screenWidth =titleSize * maxScreenCol;
	public final int screenHeight =titleSize * maxScreenRow;
	
	//FPS
	int FPS =60;
	
	TileManager tileM=new TileManager(this);
	KeyHandler KeyH=new KeyHandler();
	Thread gameThread;
	public CollisionChecker cChecker = new CollisionChecker(this);
	public AssetSetter aSetter = new AssetSetter(this);
	public Player player=new Player(this,KeyH);
	public SuperObject obj[] = new SuperObject[10];
	public UI ui=new UI(this);
	
	
	//Default Position
	int playerX=100;
	int playerY=100;
	int playerSpeed = 4;
	
	public int titleState =0;
	
	
	public game() {
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.addKeyListener(KeyH);
		this.setFocusable(true);
	}
	public void setupGame() {
		aSetter.setObject();
	}
	
	
	public void startGameThread() {
		
		gameThread =new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		double drawInterval= 1000000000/FPS;
		double nextDrawTime= System.nanoTime()+ drawInterval;
		
		while(gameThread != null) {
			
			update();
			
			
			repaint();
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime/=1000000;
				if (remainingTime<0) {
					remainingTime =0;
				}
				Thread.sleep((long) remainingTime);
				nextDrawTime += drawInterval;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void update() {
		if(KeyH.spacePressed==true) {
			titleState=1;
		}
		player.update();
		
	}
	public void paintComponent(Graphics g) {
		if (titleState ==0) {
			Graphics2D g2=(Graphics2D)g;
			ui.draw(g2);
			g2.dispose();
		}else {
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
		tileM.draw(g2);
		for(int i = 0; i < obj.length;i++) {
			if(obj[i]!= null) {
				obj[i].draw(g2, this);
			}
		}
		player.draw(g2);
		
		ui.draw(g2);
		
		g2.dispose();
		}
	}
}
 