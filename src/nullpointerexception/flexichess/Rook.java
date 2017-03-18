package nullpointerexception.flexichess;

public class Rook extends ChessPiece {

    public Rook(ChessBoard board, Color color) {
        super(board, color);
        m_letter = 'R';
    }

    public Rook(ChessBoard board, Color color, char column, int row) {
        super(board, color, column, row);
        m_letter = 'R';
    }

    @Override
    public char letter() {
        return m_letter;
    }
    
}
