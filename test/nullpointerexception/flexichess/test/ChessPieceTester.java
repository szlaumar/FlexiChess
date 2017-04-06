package nullpointerexception.flexichess.test;

import static org.junit.Assert.*;

import nullpointerexception.flexichess.game.*;
import nullpointerexception.flexichess.test.chessPieceTest.BishopTestRules;
import nullpointerexception.flexichess.test.chessPieceTest.KnightTestRules;
import nullpointerexception.flexichess.test.chessPieceTest.QueenTestRules;
import nullpointerexception.flexichess.test.chessPieceTest.RookTestRules;
import org.junit.Test;

import java.util.List;

/**
 * Created by JD-mac on 06/04/2017.
 */
public class ChessPieceTester {
    private String expected;

    @Test
    public void bishopThreatensGameTest() {
        ChessBoard board = new TestChessBoard(new BishopTestRules());

//        System.out.println(board);
        showThreatensTravelPath(board, board.pieceAt('d', 3), false);

        expected =  "   ┌───┬───┬───┬───┬───┬───┬───┬───┐\n" +
                    " 8 │   │   │   │   │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 7 │   │   │   │-R │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 6 │-  │   │   │   │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 5 │   │-  │   │   │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 4 │   │   │-  │   │-  │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 3 │   │   │   │+B │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 2 │   │   │-  │+K │+P │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 1 │   │-  │   │   │   │   │   │   │\n" +
                    "   └───┴───┴───┴───┴───┴───┴───┴───┘\n" +
                    "     a   b   c   d   e   f   g   h \n" +
                    "W+:\n" +
                    "B-:";
        assertEquals(expected, board.toString());
    }

    @Test
    public void bishopValidMovesGameTest() {
        ChessBoard board = new TestChessBoard(new BishopTestRules());

//        System.out.println(board);
        showValidMovesTravelPath(board, board.pieceAt('d', 3), false);

        expected =  "   ┌───┬───┬───┬───┬───┬───┬───┬───┐\n" +
                    " 8 │   │   │   │   │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 7 │   │   │   │-R │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 6 │   │   │   │   │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 5 │   │   │   │   │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 4 │   │   │   │   │-P │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 3 │   │   │   │+B │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 2 │   │   │   │+K │+P │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 1 │   │   │   │   │   │   │   │   │\n" +
                    "   └───┴───┴───┴───┴───┴───┴───┴───┘\n" +
                    "     a   b   c   d   e   f   g   h \n" +
                    "W+:\n" +
                    "B-:";
        assertEquals(expected, board.toString());
    }

    @Test
    public void rookThreatensGameTest() {
        ChessBoard board = new TestChessBoard(new RookTestRules());

//        System.out.println(board);
        showThreatensTravelPath(board, board.pieceAt('d', 3), false);
        expected =  "   ┌───┬───┬───┬───┬───┬───┬───┬───┐\n" +
                    " 8 │   │   │   │   │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 7 │   │   │   │-  │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 6 │   │   │   │-  │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 5 │   │   │   │-  │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 4 │   │   │   │-  │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 3 │-  │-  │-  │+R │-  │-  │-  │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 2 │   │   │   │-  │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 1 │   │   │   │+K │   │   │   │   │\n" +
                    "   └───┴───┴───┴───┴───┴───┴───┴───┘\n" +
                    "     a   b   c   d   e   f   g   h \n" +
                    "W+:\n" +
                    "B-:";
        assertEquals(expected, board.toString());
    }

    @Test
    public void rookValidMovesGameTest() {
        ChessBoard board = new TestChessBoard(new RookTestRules());

//        System.out.println(board);
        showValidMovesTravelPath(board, board.pieceAt('d', 3), false);

        expected =  "   ┌───┬───┬───┬───┬───┬───┬───┬───┐\n" +
                    " 8 │   │   │   │   │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 7 │   │   │   │-  │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 6 │   │   │   │-  │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 5 │   │   │   │-  │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 4 │   │   │   │-  │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 3 │   │   │   │+R │   │   │-P │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 2 │   │   │   │-  │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 1 │   │   │   │+K │   │   │   │   │\n" +
                    "   └───┴───┴───┴───┴───┴───┴───┴───┘\n" +
                    "     a   b   c   d   e   f   g   h \n" +
                    "W+:\n" +
                    "B-:";
        assertEquals(expected, board.toString());
    }

    @Test
    public void queenThreatensGameTest() {
        ChessBoard board = new TestChessBoard(new QueenTestRules());

//        System.out.println(board);
        showThreatensTravelPath(board, board.pieceAt('d', 3), false);
        expected =  "   ┌───┬───┬───┬───┬───┬───┬───┬───┐\n" +
                    " 8 │   │   │   │   │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 7 │   │   │   │-  │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 6 │-  │   │   │-  │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 5 │   │-  │   │-  │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 4 │   │   │-  │-  │-  │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 3 │-  │-  │-  │+Q │-  │-  │+P │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 2 │   │   │-  │-  │+P │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 1 │   │-  │   │+K │   │   │   │   │\n" +
                    "   └───┴───┴───┴───┴───┴───┴───┴───┘\n" +
                    "     a   b   c   d   e   f   g   h \n" +
                    "W+:\n" +
                    "B-:";
        assertEquals(expected, board.toString());
    }

    @Test
    public void queenValidMovesGameTest() {
        ChessBoard board = new TestChessBoard(new QueenTestRules());

//        System.out.println(board);
        showValidMovesTravelPath(board, board.pieceAt('d', 3), false);

        expected =  "   ┌───┬───┬───┬───┬───┬───┬───┬───┐\n" +
                " 8 │   │   │   │   │   │   │   │   │\n" +
                "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                " 7 │   │   │   │-  │   │   │   │   │\n" +
                "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                " 6 │   │   │   │-  │   │   │   │   │\n" +
                "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                " 5 │   │   │   │-  │   │   │   │   │\n" +
                "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                " 4 │   │   │   │-  │-P │   │   │   │\n" +
                "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                " 3 │   │   │   │+Q │   │   │+P │   │\n" +
                "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                " 2 │   │   │   │-  │+P │   │   │   │\n" +
                "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                " 1 │   │   │   │+K │   │   │   │   │\n" +
                "   └───┴───┴───┴───┴───┴───┴───┴───┘\n" +
                "     a   b   c   d   e   f   g   h \n" +
                "W+:\n" +
                "B-:";
        assertEquals(expected, board.toString());
    }

    @Test
    public void knightThreatensGameTest() {
        ChessBoard board = new TestChessBoard(new KnightTestRules());

//        System.out.println(board);
        showThreatensTravelPath(board, board.pieceAt('b', 3), false);
        expected =  "   ┌───┬───┬───┬───┬───┬───┬───┬───┐\n" +
                    " 8 │   │   │   │   │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 7 │   │   │   │   │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 6 │   │   │   │   │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 5 │-  │   │-  │   │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 4 │   │   │   │-  │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 3 │   │+S │   │   │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 2 │   │   │   │-  │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 1 │-  │   │+P │   │   │   │   │   │\n" +
                    "   └───┴───┴───┴───┴───┴───┴───┴───┘\n" +
                    "     a   b   c   d   e   f   g   h \n" +
                    "W+:\n" +
                    "B-:";
        assertEquals(expected, board.toString());
    }

    @Test
    public void knightValidMovesGameTest() {
        ChessBoard board = new TestChessBoard(new KnightTestRules());

//        System.out.println(board);
        showValidMovesTravelPath(board, board.pieceAt('b', 3), false);

        expected =  "   ┌───┬───┬───┬───┬───┬───┬───┬───┐\n" +
                " 8 │   │   │   │   │   │   │   │   │\n" +
                "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                " 7 │   │   │   │   │   │   │   │   │\n" +
                "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                " 6 │   │   │   │   │   │   │   │   │\n" +
                "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                " 5 │-  │   │-  │   │   │   │   │   │\n" +
                "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                " 4 │   │   │   │-  │   │   │   │   │\n" +
                "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                " 3 │   │+S │   │   │   │   │   │   │\n" +
                "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                " 2 │   │   │   │-  │   │   │   │   │\n" +
                "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                " 1 │-  │   │+P │   │   │   │   │   │\n" +
                "   └───┴───┴───┴───┴───┴───┴───┴───┘\n" +
                "     a   b   c   d   e   f   g   h \n" +
                "W+:\n" +
                "B-:";
        assertEquals(expected, board.toString());
    }



    // testing helper methods
    private void showThreatensTravelPath (ChessBoard board, ChessPiece piece, boolean print) {
        for (Square s : piece.threatens())
            new MoveIndicator(board, ChessPiece.Color.BLACK, s.column, s.row);

        if (print)
            System.out.println(board);
    }
    private void showValidMovesTravelPath(ChessBoard board, ChessPiece piece, boolean print) {
        for (Move m : piece.validMoves())
            new MoveIndicator(board, ChessPiece.Color.BLACK, ((SimpleMove)m).to().column, ((SimpleMove)m).to().row);

        if (print)
            System.out.println(board);
    }

    private class MoveIndicator extends ChessPiece {
        protected MoveIndicator(ChessBoard board, Color color, char column, int row) {
            super(board, color, column, row);
        }

        @Override
        public char letter() {
            return ' ';
        }

        @Override
        public boolean canBeCaptured() {
            return false;
        }

        @Override
        public List<Move> validMoves() {
            return null;
        }

        @Override
        public List<Square> threatens() {
            return null;
        }

        @Override
        public <T> T accept(ChessPieceVisitor<T> visitor) {
            return null;
        }
    }
}
