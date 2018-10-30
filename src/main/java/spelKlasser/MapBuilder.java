package spelKlasser;

public class MapBuilder {
	private Tile[][] tiles;
	private int width, height;
	private boolean mapBuildSuccessful;
	
	public MapBuilder(int width, int height) {
		this.width = width;
		this.height = height;
		this.tiles = new Tile[width][height];
	}
	
	public GameMap build() {
		return new GameMap(tiles);
	}
	
	private MapBuilder randomize() {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				if	(Math.random() < 0.5) {
					tiles[x][y] = Tile.FLOOR;
				} else {
					tiles[x][y] = Tile.WALL;
				}
			}
		}
		return this;
	}
	
	private MapBuilder mapFixer(int times) {
		Tile[][] tiles2 = new Tile[width][height];
		for	(int time = 0; time < times; time++) {
			
			for (int x = 0; x < width; x++) {
				for (int y = 0; y < height; y++) {
					int floors = 0;
					int walls = 0;
					
					for (int i = -1; i < 2; i++) {
						for (int j = -1; j < 2; j++) {
							if(x + i < 0 || x + i >= width || y + j < 0 || y + j >= height) {
								continue;
							}
							if (tiles[x + i][y + j] == Tile.FLOOR) {
								floors++;
							} else {
								walls++;
							}
						}
					}
					tiles2[x][y] = floors >= walls ? Tile.FLOOR : Tile.WALL;
				}	
			}
			tiles = tiles2;
		}
		setMapBuildSuccessful(true);
		return this;
	}
	
	public MapBuilder createRooms() {
		return randomize().mapFixer(8);
	}
	
	public int getWidth() {return width;}
	public int getHeight() {return height;}
	public boolean isMapBuildSuccessful() {return mapBuildSuccessful;}
	public void setMapBuildSuccessful(boolean mapBuildSuccessful) {
		this.mapBuildSuccessful = mapBuildSuccessful;
	}
}
