package nullpointerexception.flexichess;

import nullpointerexception.flexichess.classic.ClassicChessRules;
import nullpointerexception.flexichess.game.ChessBoard;
import nullpointerexception.flexichess.game.SimpleMove;
import nullpointerexception.flexichess.game.Square;

public class FlexiChess {
	public static void main(String[] args) {
		ChessBoard board = new ChessBoard(new ClassicChessRules());

		new SimpleMove(board.pieceAt('e', 2), new Square('e', 4)).executeOnBoard(board);
		System.out.println(board);
		new SimpleMove(board.pieceAt('e', 7), new Square('e', 5)).executeOnBoard(board);
		System.out.println(board);
		new SimpleMove(board.pieceAt('g', 1), new Square('f', 3)).executeOnBoard(board);
		System.out.println(board);
		new SimpleMove(board.pieceAt('d', 7), new Square('d', 6)).executeOnBoard(board);
		System.out.println(board);
		new SimpleMove(board.pieceAt('f', 1), new Square('c', 4)).executeOnBoard(board);
		System.out.println(board);
		new SimpleMove(board.pieceAt('f', 7), new Square('f', 5)).executeOnBoard(board);
		System.out.println(board);
		new SimpleMove(board.pieceAt('d', 2), new Square('d', 4)).executeOnBoard(board);
		System.out.println(board);
		new SimpleMove(board.pieceAt('g', 8), new Square('f', 6)).executeOnBoard(board);
		System.out.println(board);
		new SimpleMove(board.pieceAt('b', 1), new Square('c', 3)).executeOnBoard(board);
		System.out.println(board);
		new SimpleMove(board.pieceAt('e', 5), new Square('d', 4)).executeOnBoard(board);
		System.out.println(board);
		new SimpleMove(board.pieceAt('d', 1), new Square('d', 4)).executeOnBoard(board);
		System.out.println(board);
		new SimpleMove(board.pieceAt('c', 8), new Square('d', 7)).executeOnBoard(board);
		System.out.println(board);
		new SimpleMove(board.pieceAt('f', 3), new Square('g', 5)).executeOnBoard(board);
		System.out.println(board);
		new SimpleMove(board.pieceAt('b', 8), new Square('c', 6)).executeOnBoard(board);
		System.out.println(board);
		new SimpleMove(board.pieceAt('c', 4), new Square('f', 7)).executeOnBoard(board);
		System.out.println(board);
		new SimpleMove(board.pieceAt('e', 8), new Square('e', 7)).executeOnBoard(board);
		System.out.println(board);
		new SimpleMove(board.pieceAt('d', 4), new Square('f', 6)).executeOnBoard(board);
		System.out.println(board);
		new SimpleMove(board.pieceAt('e', 7), new Square('f', 6)).executeOnBoard(board);
		System.out.println(board);
		new SimpleMove(board.pieceAt('c', 3), new Square('d', 5)).executeOnBoard(board);
		System.out.println(board);
		new SimpleMove(board.pieceAt('f', 6), new Square('e', 5)).executeOnBoard(board);
		System.out.println(board);
		new SimpleMove(board.pieceAt('g', 5), new Square('f', 3)).executeOnBoard(board);
		System.out.println(board);
		new SimpleMove(board.pieceAt('e', 5), new Square('e', 4)).executeOnBoard(board);
		System.out.println(board);
		new SimpleMove(board.pieceAt('d', 5), new Square('c', 3)).executeOnBoard(board);
		System.out.println(board);
	}
}
