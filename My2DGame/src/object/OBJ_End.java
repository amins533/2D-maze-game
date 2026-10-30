package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_End  extends SuperObject{
	public OBJ_End() {
		name ="End";
		try {
			image = ImageIO.read(getClass().getResource("/tiles/doorlight.png"));
		}catch(IOException e){
			e.printStackTrace();
		}
		collision = true;
	}

}
