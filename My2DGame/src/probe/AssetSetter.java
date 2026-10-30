package probe;

import object.OBJ_Door;
import object.OBJ_End;
import object.OBJ_Key;

public class AssetSetter {
	
	game pan ;
	public AssetSetter(game pan) {
		this.pan=pan;
	}
	public void setObject() {
		pan.obj[0]= new OBJ_Key();
		pan.obj[0].worldX=28 * pan.titleSize;
		pan.obj[0].worldY=9 * pan.titleSize;
		
		pan.obj[2]= new OBJ_Door();
		pan.obj[2].worldX=2 * pan.titleSize;
		pan.obj[2].worldY=0 * pan.titleSize;
		
		pan.obj[1]= new OBJ_End();
		pan.obj[1].worldX=2 * pan.titleSize;
		pan.obj[1].worldY=0 * pan.titleSize;
	}
}
