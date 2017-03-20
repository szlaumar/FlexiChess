import static org.junit.Assert.assertEquals;

import org.junit.Test;

import nullpointerexception.flexichess.builders.Demichess;
import nullpointerexception.flexichess.builders.Microchess;
import nullpointerexception.flexichess.builders.Regularchess;
import nullpointerexception.flexichess.builders.Silverman4x4;
import nullpointerexception.flexichess.builders.Silverman4x5;

public class BuildersTester {
	
	@Test
	public void testBuilder() {
		String expected =    
				"   ┌───┬───┬───┐\n" +
				" 4 │-R │-Q │-K │\n" +
				"   ├───┼───┼───┤\n" +
				" 3 │-P │-P │-P │\n" +
				"   ├───┼───┼───┤\n" +
				" 2 │+P │+P │+P │\n" +
				"   ├───┼───┼───┤\n" +
				" 1 │+R │+Q │+K │\n" +
				"   └───┴───┴───┘\n" +
				"     a   b   c \n" +
				"W+:\n" +
				"B-:";
		assertEquals(expected, new TestGameBuilder().board().toString());
	}
	
	@Test
	public void demichess() {
		String expected =
				"   ┌───┬───┬───┬───┐\n" +
				" 8 │-K │-B │-S │-R │\n" +
				"   ├───┼───┼───┼───┤\n" +
				" 7 │-P │-P │-P │-P │\n" +
				"   ├───┼───┼───┼───┤\n" +
				" 6 │   │   │   │   │\n" +
				"   ├───┼───┼───┼───┤\n" +
				" 5 │   │   │   │   │\n" +
				"   ├───┼───┼───┼───┤\n" +
				" 4 │   │   │   │   │\n" +
				"   ├───┼───┼───┼───┤\n" +
				" 3 │   │   │   │   │\n" +
				"   ├───┼───┼───┼───┤\n" +
				" 2 │+P │+P │+P │+P │\n" +
				"   ├───┼───┼───┼───┤\n" +
				" 1 │+K │+B │+S │+R │\n" +
				"   └───┴───┴───┴───┘\n" +
				"     a   b   c   d \n" +
				"W+:\n" +
				"B-:";
		assertEquals(expected, new Demichess().board().toString());
	}
	
	@Test
	public void microchess() {
		String expected =
				"   ┌───┬───┬───┬───┐\n" +
				" 5 │-K │-S │-B │-R │\n" +
				"   ├───┼───┼───┼───┤\n" +
				" 4 │-P │   │   │   │\n" +
				"   ├───┼───┼───┼───┤\n" +
				" 3 │   │   │   │   │\n" +
				"   ├───┼───┼───┼───┤\n" +
				" 2 │   │   │   │+P │\n" +
				"   ├───┼───┼───┼───┤\n" +
				" 1 │+R │+B │+S │+K │\n" +
				"   └───┴───┴───┴───┘\n" +
				"     a   b   c   d \n" +
				"W+:\n" +
				"B-:";
		assertEquals(expected, new Microchess().board().toString());
	}
	
	@Test
	public void regularchess() {
		String expected =
				"   ┌───┬───┬───┬───┬───┬───┬───┬───┐\n" + 
				" 8 │-R │-S │-B │-Q │-K │-B │-S │-R │\n" +
				"   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
				" 7 │-P │-P │-P │-P │-P │-P │-P │-P │\n" +
				"   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
				" 6 │   │   │   │   │   │   │   │   │\n" +
				"   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
				" 5 │   │   │   │   │   │   │   │   │\n" +
				"   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
				" 4 │   │   │   │   │   │   │   │   │\n" +
				"   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
				" 3 │   │   │   │   │   │   │   │   │\n" +
				"   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
				" 2 │+P │+P │+P │+P │+P │+P │+P │+P │\n" +
				"   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
				" 1 │+R │+S │+B │+Q │+K │+B │+S │+R │\n" +
				"   └───┴───┴───┴───┴───┴───┴───┴───┘\n" +
				"     a   b   c   d   e   f   g   h \n" +
				"W+:\n" +
				"B-:";
		assertEquals(expected, new Regularchess().board().toString());
	}
	
	@Test
	public void silverman4x4() {
		String expected =
				"   ┌───┬───┬───┬───┐\n" +
				" 4 │-R │-Q │-K │-R │\n" +
				"   ├───┼───┼───┼───┤\n" +
				" 3 │-P │-P │-P │-P │\n" +
				"   ├───┼───┼───┼───┤\n" +
				" 2 │+P │+P │+P │+P │\n" +
				"   ├───┼───┼───┼───┤\n" +
				" 1 │+R │+Q │+K │+R │\n" +
				"   └───┴───┴───┴───┘\n" +
				"     a   b   c   d \n" +
				"W+:\n" +
				"B-:";
		assertEquals(expected, new Silverman4x4().board().toString());
	}
	
	@Test
	public void silverman4x5() {
		String expected =
				"   ┌───┬───┬───┬───┐\n" +
				" 5 │-R │-Q │-K │-R │\n" +
				"   ├───┼───┼───┼───┤\n" +
				" 4 │-P │-P │-P │-P │\n" +
				"   ├───┼───┼───┼───┤\n" +
				" 3 │   │   │   │   │\n" +
				"   ├───┼───┼───┼───┤\n" +
				" 2 │+P │+P │+P │+P │\n" +
				"   ├───┼───┼───┼───┤\n" +
				" 1 │+R │+Q │+K │+R │\n" +
				"   └───┴───┴───┴───┘\n" +
				"     a   b   c   d \n" +
				"W+:\n" +
				"B-:";
		assertEquals(expected, new Silverman4x5().board().toString());
	}
}