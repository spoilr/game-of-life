package life;

import javax.swing.JButton;
import javax.swing.JPanel;

public interface View {

	public JPanel getPanel();
	
	public void update(Model model);
	
	public JButton getButton(String text);
	
	public void disableCellButtons();
	
	public void enableCellButtons();
	
}
