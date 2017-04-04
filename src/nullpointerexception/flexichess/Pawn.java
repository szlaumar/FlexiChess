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
    public List<Square> threatens() {
        if (isOffBoard())
            return Collections.emptyList();

        List<Square> list = new ArrayList<>();
        if (goDiagonalLeft() != null)
            list.add(goDiagonalLeft());
        if (goDiagonalRight() != null)
            list.add(goDiagonalRight());

        return list;
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
        if (goDiagonalLeftValid() != null )
            list.add(new SimpleMove(this, goDiagonalLeftValid()));
        if (goDiagonalRightValid() != null)
            list.add(new SimpleMove(this, goDiagonalRightValid()));

        return list;
    }

    /**
     * Checks if it is possible to go 1 square straight.
     *
     * @return  Square of the new position if possible to go there, null if not possible.
     */
    private Square canGoStraight() {
        int direction = - 1;

        if (color() == Color.WHITE)
            direction = 1;

        Square newPosition = new Square(position().column, position().row + direction);
        if (board().isInsideBoard(newPosition) && board().isEmptyAt(newPosition) && board().isEmptyAt(newPosition))
                return newPosition;

        return null;
    }

    /**
     * Checks if it is possible to go 2 square straight.
     *
     * @return  Square of the new position if possible to go there, null if not possible.
     */
    private Square canGoStraightBy2() {
        int direction = - 2;

        if (color() == Color.WHITE)
            direction = 2;

        Square newPosition = new Square(position().column, position().row + direction);
        if (canGoStraight() != null && moveCounter() == 0 && board().isInsideBoard(newPosition))
            return newPosition;
        return null;
    }

    /**
     * Checks if it is possible to go to the upper right square (capture enemy).
     *
     * @return  Square of the new position if possible to go there, null if not possible.
     */
    private Square goDiagonalLeft() {
        int direction = - 1;

        if (color() == Color.WHITE)
            direction = 1;

        Square upperLeftPosition = new Square((char)(position().column - 1), position().row + direction);
        if (board().isInsideBoard(upperLeftPosition))
            return upperLeftPosition;
        return null;
    }

    private Square goDiagonalLeftValid() {
        Square square = goDiagonalLeft();
        if (square != null && !board().isEmptyAt(square) && board().pieceAt(square).color().opposite() == color()
                && board().pieceAt(square).letter() != 'K')
            return square;
        else
            return null;
    }

    /**
     * Checks if it is possible to go to the upper right square (capture enemy).
     *
     * @return  Square of the new position if possible to go there, null if not possible.
     */
    private Square goDiagonalRight() {
        int direction = - 1;

        if (color() == Color.WHITE) {
            direction = 1;
        }

        char newCol = (char)(position().column + 1);
        int newRow = position().row + direction;
        if (board().isInsideBoard(newCol, newRow - 1))
            return new Square(newCol, newRow);

        return null;
    }

    private Square goDiagonalRightValid() {
        Square square = goDiagonalRight();
        if (square != null && !board().isEmptyAt(square) && board().pieceAt(square).color().opposite() == color()
                && board().pieceAt(square).letter() != 'K')
            return square;
        else
            return null;
    }

    @Override
    public <T> T accept(ChessPieceVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
}
