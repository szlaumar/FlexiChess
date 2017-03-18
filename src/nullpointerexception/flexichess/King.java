package nullpointerexception.flexichess;

public class King extends ChessPiece {

    public King(ChessBoard board, Color color) {
        super(board, color);
        m_letter = 'K';
    }

    public King(ChessBoard board, Color color, char column, int row) {
        super(board, color, column, row);
        m_letter = 'K';
    }

    @Override
    public char letter() {
        return m_letter;
    }
    
}
