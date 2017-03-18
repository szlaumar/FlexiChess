package nullpointerexception.flexichess;

public class Knight extends ChessPiece {

    public Knight(ChessBoard board, Color color) {
        super(board, color);
        m_letter = 'N';
    }

    public Knight(ChessBoard board, Color color, char column, int row) {
        super(board, color, column, row);
        m_letter = 'N';
    }

    @Override
    public char letter() {
        return m_letter;
    }
    
}
