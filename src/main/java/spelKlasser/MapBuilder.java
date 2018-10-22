package spelKlasser;

public class MapBuilder {
	private Tile[][] tiles;
	private int width, height;
	
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
				tiles[x][y] = Math.random() < 0.5 ? Tile.FLOOR : Tile.WALL;
			}
		}
		return this;
	}
	
	private MapBuilder mapFixer(int times) {
		Tile[][] tiles2 = new Tile[width][height];
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				int floors = 0;
				int walls = 0;
				
				for (int i = -1; i < 2; i++) {
					for (int j = -1; j < 2; i++) {
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
			tiles = tiles2;
		}
		return this;
	}
	
	public MapBuilder createRooms() {
		return randomize().mapFixer(10);
	}
}
