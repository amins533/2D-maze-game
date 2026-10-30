package probe;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
 
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame window =new JFrame ();
		ImageIcon icon=new ImageIcon("Unbenannt.png");
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Spiel");
		window.setIconImage(icon.getImage());
		game pan=new game();
		window.add(pan);
		window.pack(); 
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		pan.setupGame();
		pan.startGameThread();
		
	}

}
