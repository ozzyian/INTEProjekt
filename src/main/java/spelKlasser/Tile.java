package spelKlasser;

public enum Tile {
	FLOOR('.'),
	WALL('#'),
	OUTOFBOUNDS('X');
	
	private char glyph;
	
	Tile(char glyph){
		this.glyph = glyph;
	}
	
	public char getGlyph() {return glyph;}

}
