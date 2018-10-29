package spelKlasser;



public class DisplayMap {


	private GameMap gameMap;
	
	public DisplayMap() {
		//super();
		//gamePanel = new JPanel();
		//gamePanel.setSize(55, 55);
		//add(gamePanel);
		//pack();
		createMap();

		displayTiles();
		//repaint();
	}
	
	private void createMap(){
		gameMap = new MapBuilder(50, 50)
				.createRooms()
				.build();
	}
	
	private void displayTiles() {
		for (int x = 0; x < 50; x++) {
			for (int y = 0; y < 50; y++) {
				System.out.print(gameMap.glyph(x, y));
				//System.out.printf("%5d ", gameMap.glyph(x, y));
				//add(new JLabel());
			}
		}
	}
	
	public static void main(String[] args) {new DisplayMap();}
	
	//public void paintComponent(Graphics g) {
		//super.paintComponents(g);
		//super.repaint();
	//}
}
