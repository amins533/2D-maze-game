package probe;

import entity.Entity;

public class CollisionChecker {
	game pan;
	
	public CollisionChecker(game pan) {
		this.pan=pan;
	}
	public void checkTile(Entity entity) {
		

		int entityLeftWorldX=entity.x+ entity.solidArea.x;
		int entityRightWorldX=entity.x+ entity.solidArea.x + entity.solidArea.width;
		int entityTopWorldY=entity.y+ entity.solidArea.y;
		int entityDownWorldY=entity.y+ entity.solidArea.y+entity.solidArea.height;
		
		int entityLeftCol = entityLeftWorldX/pan.titleSize;
		int entityRightCol = entityRightWorldX/pan.titleSize;
		int entityTopRow = entityTopWorldY/pan.titleSize;
		int entityDownRow = entityDownWorldY/pan.titleSize;
		
		int tileNum1,tileNum2;
		
		switch(entity.direction) {
		case "up":
			entityTopRow = (entityTopWorldY-entity.speed)/pan.titleSize;
			tileNum1 = pan.tileM.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = pan.tileM.mapTileNum[entityRightCol][entityTopRow];
			if(pan.tileM.tile[tileNum1].collision == true ||pan.tileM.tile[tileNum2].collision == true ) {
				entity.collisionOn = true;
			}
			break;
		case "down":
			entityDownRow = (entityDownWorldY+entity.speed)/pan.titleSize;
			tileNum1 = pan.tileM.mapTileNum[entityLeftCol][entityDownRow];
			tileNum2 = pan.tileM.mapTileNum[entityRightCol][entityDownRow];
			if(pan.tileM.tile[tileNum1].collision == true ||pan.tileM.tile[tileNum2].collision == true ) {
				entity.collisionOn = true;
			}
			break;
		case "left":
			entityLeftCol = (entityLeftWorldX-entity.speed)/pan.titleSize;
			tileNum1 = pan.tileM.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = pan.tileM.mapTileNum[entityLeftCol][entityDownRow];
			if(pan.tileM.tile[tileNum1].collision == true ||pan.tileM.tile[tileNum2].collision == true ) {
				entity.collisionOn = true;
			}
			break;
		case "right":
			entityRightCol = (entityRightWorldX+entity.speed)/pan.titleSize;
			tileNum1 = pan.tileM.mapTileNum[entityRightCol][entityTopRow];
			tileNum2 = pan.tileM.mapTileNum[entityRightCol][entityDownRow];
			if(pan.tileM.tile[tileNum1].collision == true ||pan.tileM.tile[tileNum2].collision == true ) {
				entity.collisionOn = true;
			}
			break;
	
		}
	}
	public int checkObject(Entity entity, boolean player) {
		
		int index = 999;
		for(int i=0; i< pan.obj.length;i++) {
			if(pan.obj[i] != null) {
				entity.solidArea.x = entity.x + entity.solidArea.x;
				entity.solidArea.y = entity.y + entity.solidArea.y;
				
				pan.obj[i].solidArea.x=pan.obj[i].worldX + pan.obj[i].solidArea.x;
				pan.obj[i].solidArea.y=pan.obj[i].worldY + pan.obj[i].solidArea.y;
			
				switch(entity.direction) {
				case "up":
					entity.solidArea.y -= entity.speed;
					if(entity.solidArea.intersects(pan.obj[i].solidArea)) {
						if(pan.obj[i].collision == true) {
							entity.collisionOn=true;
						}
						if(player == true) {
							index = i;
						}
					}
					break;
				case "down":
					entity.solidArea.y += entity.speed;
					if(entity.solidArea.intersects(pan.obj[i].solidArea)) {
						if(pan.obj[i].collision == true) {
							entity.collisionOn=true;
						}
						if(player == true) {
							index = i;
						}
					}
					break;
				case "left":
					entity.solidArea.x -= entity.speed;
					if(entity.solidArea.intersects(pan.obj[i].solidArea)) {
						if(pan.obj[i].collision == true) {
							entity.collisionOn=true;
						}
						if(player == true) {
							index = i;
						}
					}
					break;
				case "right":
					entity.solidArea.x += entity.speed;
					if(entity.solidArea.intersects(pan.obj[i].solidArea)) {
						if(pan.obj[i].collision == true) {
							entity.collisionOn=true;
						}
						if(player == true) {
							index = i;
						}
					}
					break;
				}
				entity.solidArea.x = entity.solidAreaDefaultX;
				entity.solidArea.y = entity.solidAreaDefaultY;
				pan.obj[i].solidArea.x = pan.obj[i].solidAreaDefaultX;
				pan.obj[i].solidArea.y = pan.obj[i].solidAreaDefaultY;
			}
			
		}
		return index;
	}

}
