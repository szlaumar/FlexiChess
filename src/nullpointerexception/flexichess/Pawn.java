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
            list.add(new SimpleMove(this, canGoStraight()));
        if (canGoStraightBy2() != null)
            list.add(new SimpleMove(this, canGoStraightBy2()));
        if (canGoDiagonalLeft() != null)
            list.add(new SimpleMove(this, canGoDiagonalLeft()));
        if (canGoDiagonalRight() != null)
            list.add(new SimpleMove(this, canGoDiagonalRight()));

        return list;
    }

    /**
     * Checks if it is possible to go 1 square straight.
     *
     * @return  Square of the new position if possible to go there, null if not possible.
     */
    private Square canGoStraight() {
        Square newPosition = new Square(position().column, position().row + 1);
        if (board().isInsideBoard(newPosition) && board().isEmptyAt(position()))
            return newPosition;
        return null;
    }

    /**
     * Checks if it is possible to go 2 square straight.
     *
     * @return  Square of the new position if possible to go there, null if not possible.
     */
    private Square canGoStraightBy2() {
        Square newPosition = new Square(position().column, position().row + 2);
        if (canGoStraight() != null && moveCounter() == 0 && board().isInsideBoard(newPosition))
            return newPosition;
        return null;
    }

    /**
     * Checks if it is possible to go to the upper right square (capture enemy).
     *
     * @return  Square of the new position if possible to go there, null if not possible.
     */
    private Square canGoDiagonalLeft() {
        Square upperLeftPosition = new Square((char)(position().column - 1), position().row + 1);
        if (board().isInsideBoard(upperLeftPosition) && isEnemyPiece(upperLeftPosition))
            return upperLeftPosition;
        return null;
    }

    /**
     * Checks if it is possible to go to the upper right square (capture enemy).
     *
     * @return  Square of the new position if possible to go there, null if not possible.
     */
    private Square canGoDiagonalRight() {
        Square upperRightPosition = new Square((char)(position().column + 1), position().row + 1);
        if (board().isInsideBoard(upperRightPosition) && isEnemyPiece(upperRightPosition))
            return upperRightPosition;
        return null;
    }

    @Override
    public List<Square> threatens() {
        if (isOffBoard())
            return Collections.emptyList();

        List<Square> list = new ArrayList<>();
        if (canGoDiagonalLeft() != null)
            list.add(canGoDiagonalLeft());
        if (canGoDiagonalRight() != null)
            list.add(canGoDiagonalRight());

        return list;
    }

    @Override
    public <T> T accept(ChessPieceVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
}
