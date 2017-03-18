package nullpointerexception.flexichess;

public class Bishop extends ChessPiece {

    public Bishop(ChessBoard board, Color color) {
        super(board, color);
        m_letter = 'B';
    }

    public Bishop(ChessBoard board, Color color, char column, int row) {
        super(board, color, column, row);
        m_letter = 'B';
    }
    
    @Override
    public char letter() {
        return m_letter;
    }
    
}
