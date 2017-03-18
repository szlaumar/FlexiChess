package nullpointerexception.flexichess;

public class Pawn extends ChessPiece {

    public Pawn(ChessBoard board, Color color) {
        super(board, color);
        m_letter = 'p';
    }

    public Pawn(ChessBoard board, Color color, char column, int row) {
        super(board, color, column, row);
        m_letter = 'p';
    }

    @Override
    public char letter() {
        return m_letter;
    }
    
}
