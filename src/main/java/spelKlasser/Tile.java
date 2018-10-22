package spelKlasser;

import java.awt.Color;

public enum Tile {
	FLOOR('.', Color.black),
	WALL('#', Color.black),
	OUTOFBOUNDS('X', Color.RED);
	
	private char glyph;
	private Color color;
	
	Tile(char glyph, Color color){
		this.glyph = '.';
		this.color = Color.black;
	}
	
	Tile(){
		this.glyph = '.';
		this.color = Color.black;
		}
	
	public char getGlyph() {return glyph;}
	public Color getColor() {return color;}

}
