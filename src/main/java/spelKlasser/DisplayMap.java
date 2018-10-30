package spelKlasser;



public class DisplayMap {


	private GameMap gameMap;
	
	public DisplayMap() {
		createMap();
		displayTiles();
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
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {new DisplayMap();}
	
}
