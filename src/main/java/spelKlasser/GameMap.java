package spelKlasser;

public class GameMap{
	
	private Tile[][] tiles;
	private int width, height;
	
	public int getWidth() {return width;}
	public int getHeight() {return height;}
	
	public GameMap(Tile[][] tiles) {
		this.tiles = tiles;
		this.width = tiles.length;
		this.height = tiles[0].length;
	}
	
	public Tile tile(int x, int y) {
		if (x < 0 || x >= width || y < 0 || y >= height) {
			return Tile.OUTOFBOUNDS;
		} else {
			return tiles[x][y];
		}
	}
	
	public char glyph(int x, int y) {
		return tile(x,y).getGlyph();
	}

}
