package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import probe.game;

public class TileManager {
	
	game pan;
	public Tile[] tile;
	public int mapTileNum[][];
	
	public TileManager(game pan) {
		this.pan=pan;
		tile=new Tile[10];
		mapTileNum = new int[pan.maxScreenCol][pan.maxScreenRow];
		getTileImage();
		loadMap("/maps/map2.txt");
	}
	public void getTileImage() {
		try {
			tile[0]=new Tile();
			tile[0].image=ImageIO.read(getClass().getResourceAsStream("/tiles/rock.png"));
			
			tile[1]=new Tile();
			tile[1].image=ImageIO.read(getClass().getResourceAsStream("/tiles/wall2.png"));
			tile[1].collision = true;
			
			tile[2]=new Tile();
			tile[2].image=ImageIO.read(getClass().getResourceAsStream("/tiles/slot.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void loadMap(String filePath) {
		
		try {
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col= 0;
			int row = 0;
			while(col < pan.maxScreenCol && row <pan.maxScreenRow) {
				String line=br.readLine();
				
				while(col < pan.maxScreenCol) {
					String numbers[]=line.split(" ");
					int num =Integer.parseInt(numbers[col]);
					mapTileNum[col][row] = num;
					col++;
				}
				if(col==pan.maxScreenCol) {
					col =0;
					row++;
				}
			}
			br.close();
		}catch(Exception e){
			
		}
	}
	public void draw(Graphics2D g2) {
		
		int col = 0;
		int row = 0;
		int x = 0;
		int y = 0;
		while(col<pan.maxScreenCol && row<pan.maxScreenRow) {
			int tileNum = mapTileNum[col][row];
			g2.drawImage(tile[tileNum].image, x, y, pan.titleSize, pan.titleSize,null);
			col++;
			x+=pan.titleSize;
			
			if(col == pan.maxScreenCol) {
				col=0;
				x=0;
				row++;
				y+=pan.titleSize;
			}
			
		}
	}

}
