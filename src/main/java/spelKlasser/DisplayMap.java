package spelKlasser;



public class DisplayMap {


	private GameMap gameMap;
	private int displayNumber = 0;
	
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
				setDisplayNumber(getDisplayNumber() + 1);
			}
			System.out.println();
		}
	}
	
	public void setDisplayNumber(int displayNumber) {
		this.displayNumber = displayNumber;
	}
	public int getDisplayNumber() {return displayNumber;}
	
	public static void main(String[] args) {new DisplayMap();}
	
	
}
