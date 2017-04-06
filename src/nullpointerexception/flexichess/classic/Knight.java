package nullpointerexception.flexichess.classic;

import nullpointerexception.flexichess.game.*;

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
    public List<Move> validMoves() {
        return Collections.emptyList();
    }

    @Override
    public List<Square> threatens() {
        return Collections.emptyList();
    }

    @Override
    public <T> T accept(ChessPieceVisitor<T> visitor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
