package life;

import java.awt.Graphics;

import javax.swing.JApplet;

public class RandomGrid extends JApplet {

	Controllers controllers = new Controllers();
	Model model = controllers.getModel();
    View view = controllers.getView();
	
   public void paint (Graphics g)
   {
	  view.getPanel().paint(g);
   }

   public void init() {
	   
	   setSize(500,500);
	   model.addGrid(Patterns.randomBoard());
	   add(view.getPanel());
   }
	
}
