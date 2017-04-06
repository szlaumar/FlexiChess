package nullpointerexception.flexichess.classic;

import nullpointerexception.flexichess.game.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Knight extends ChessPiece {

    public Knight(ChessBoard board, Color color) {
        super(board, color);
    }

    public Knight(ChessBoard board, Color color, char column, int row) {
        super(board, color, column, row);
    }

    @Override
    public char letter() {
        return 'S';
    }

    @Override
    public boolean canBeCaptured() {
        return true;
    }

    @Override
    public List<Square> threatens() {
        if (isOffBoard())
            throw new IllegalStateException("Piece is off board.");

        List<Square> list = new ArrayList<>();
        list.addAll(checkMovesInDirection(Direction.UP_LEFT));
        list.addAll(checkMovesInDirection(Direction.UP_RIGHT));
        list.addAll(checkMovesInDirection(Direction.DOWN_LEFT));
        list.addAll(checkMovesInDirection(Direction.DOWN_RIGHT));

        return list;
    }

    private List<Square> checkMovesInDirection(Direction direction) {
        List<Square> list = new ArrayList<>();

        Square square = position();
        square = square.step(2 * direction.colStep, direction.rowStep);
        if (board().isInsideBoard(square)
                && (board().isEmptyAt(square) || board().pieceAt(square).color() == color().opposite()))
            list.add(square);

        square = position();
        square = square.step(direction.colStep, 2 * direction.rowStep);
        if (board().isInsideBoard(square)
                && (board().isEmptyAt(square) || board().pieceAt(square).color() == color().opposite()))
            list.add(square);

        return list;
    }

    public enum Direction {
        UP_LEFT   (-1, 1),
        UP_RIGHT  ( 1, 1),
        DOWN_LEFT (-1,-1),
        DOWN_RIGHT( 1,-1);

        /**
         * Sign assigned to color for short printing.
         */
        public final int colStep;
        public final int rowStep;

        Direction(int colStep, int rowStep){
            this.colStep = colStep;
            this.rowStep = rowStep;
        }

    }

    @Override
    public <T> T accept(ChessPieceVisitor<T> visitor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
