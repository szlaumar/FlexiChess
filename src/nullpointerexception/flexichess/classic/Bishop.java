package nullpointerexception.flexichess.classic;

import com.sun.tools.javac.util.Pair;
import nullpointerexception.flexichess.game.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bishop extends ChessPiece {

    public Bishop(ChessBoard board, Color color) {
        super(board, color);
    }

    public Bishop(ChessBoard board, Color color, char column, int row) {
        super(board, color, column, row);
    }
    
    @Override
    public char letter() {
        return 'B';
    }

    @Override
    public boolean canBeCaptured() {
        return true;
    }

    @Override
    public List<Move> validMoves() {
        return Collections.emptyList();
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

    /**
     * Iterates through the squares int the given diagonal direction and returns a list of threatened squares.
     *
     * @param direction Diagonal direction to check squares.
     * @return          List of threatened squares in given direction.
     */
    private List<Square> checkMovesInDirection(Direction direction) {
        List<Square> list = new ArrayList<>();

        Square square = position();
        square = square.step(direction.colStep, direction.rowStep);

        while (board().isInsideBoard(square)) {
            if (board().isEmptyAt(square))
                list.add(square);
            else if (board().pieceAt(square).color() == color().opposite()) {
                list.add(square);
                break;
            }
            else
                break;

            square = square.step(direction.colStep, direction.rowStep);
        }

        return list;
    }

    private enum Direction {
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
