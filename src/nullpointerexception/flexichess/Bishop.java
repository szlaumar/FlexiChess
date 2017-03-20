package nullpointerexception.flexichess;

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
    
}
