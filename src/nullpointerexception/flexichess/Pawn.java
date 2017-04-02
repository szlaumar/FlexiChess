package nullpointerexception.flexichess;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pawn extends ChessPiece {

    public Pawn(ChessBoard board, Color color) {
        super(board, color);
    }

    public Pawn(ChessBoard board, Color color, char column, int row) {
        super(board, color, column, row);
    }

    @Override
    public char letter() {
        return 'P';
    }

    @Override
    public boolean canBeCaptured() {
        return true;
    }

    @Override
    public List<Move> validMoves() {
        if (isOffBoard())
            return Collections.emptyList();

        List<Move> list = new ArrayList<>();
        if (canGoStraight() != null)
            list.add(canGoStraight());
        if (canGoStraightBy2() != null)
            list.add(canGoStraightBy2());
        if (canGoDiagonalLeft() != null)
            list.add(canGoDiagonalLeft());
        if (canGoDiagonalRight() != null)
            list.add(canGoDiagonalRight());

        return list;
    }

    private Move canGoStraight() {
        Square newPosition = new Square(position().column, position().row + 1);
        if (board().isInsideBoard(newPosition) && board().isEmptyAt(position()))
            return new SimpleMove(this, newPosition);
        return null;
    }

    private Move canGoStraightBy2() {
        Square newPosition = new Square(position().column, position().row + 2);
        if (canGoStraight() != null && moveCounter() == 0 && board().isInsideBoard(newPosition))
            return new SimpleMove(this, newPosition);
        return null;
    }

    private Move canGoDiagonalLeft() {
        Square upperLeftPosition = new Square((char)(position().column - 1), position().row + 1);
        if (board().isInsideBoard(upperLeftPosition) && isEnemyPiece(upperLeftPosition))
            return new SimpleMove(this, upperLeftPosition);
        return null;
    }

    private Move canGoDiagonalRight() {
        Square upperRightPosition = new Square((char)(position().column + 1), position().row + 1);
        if (board().isInsideBoard(upperRightPosition) && isEnemyPiece(upperRightPosition))
            return new SimpleMove(this, upperRightPosition);
        return null;
    }

    @Override
    public List<Square> threatens() {
//        if (isOffBoard())
//            return Collections.emptyList();
//
//        List<Move> list = new ArrayList<>();
//        if (canGoDiagonalLeft() != null)
//            list.
    }

    @Override
    public <T> T accept(ChessPieceVisitor<T> visitor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
