package spelKlasser;


import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*;

public class DisplayMap extends JFrame {

	private static final long serialVersionUID = 1L;

	private GameMap gameMap;
	private JPanel gamePanel;
	
	public DisplayMap() {
		super();
		gamePanel = new JPanel();
		gamePanel.setSize(55, 55);
		add(gamePanel);
		pack();
		createMap();

		displayTiles();
		repaint();
	}
	
	private void createMap(){
		gameMap = new MapBuilder(50, 50)
				.createRooms()
				.build();
	}
	
	private void displayTiles() {
		for (int x = 0; x < 50; x++) {
			for (int y = 0; y < 50; y++) {
				System.out.printf("%5d ", gameMap.glyph(x, y));
				//add(new JLabel());
			}
		}
	}
	
	public static void main(String[] args) {
		DisplayMap displayMap = new DisplayMap();
		displayMap.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		displayMap.setVisible(true);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		super.repaint();
	}
}
