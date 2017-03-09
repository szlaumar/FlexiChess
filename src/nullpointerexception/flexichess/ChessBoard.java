package nullpointerexception.flexichess;

/**
 * Představuje šachovnici.
 * 
 * @author Drabek Jan
 * @author Stastny Martin
 * @author Szlauer Martin
 */
public class ChessBoard {
    private Square[][] m_board;
    
    /**
     * Vytvoří šachovnici o zadaném počtu sloupců a řádků.
     * 
     * @param column    Number of m_board columns.
     * @param row       Number of m_board rows.
     */
    public ChessBoard(int column, int row){

        // Initialization of array
        m_board = new Square[column][row];

        for (int i = 0; i < column; i++)
            for (int j = 0; j < row; j++)
                m_board[i][j] = new Square((char)('a' + i), j);
    }

    /**
     * Vrátí počet sloupců šachovnice.
     * 
     * @return Number of columns.
     */    
    public int columns(){
        return m_board.length;
    }
    
    /**
     * Vrátí počet řádků šachovnice.
     * 
     * @return Number of rows.
     */
    public int rows(){
        return m_board[0].length;
    }
    
    /**
     * Vrátí figurku na zadané souřadnici. 
     * 
     * Pokud je čtverec prázdný, vyhodí výjimku IllegalStateException.
     * 
     * @param column    Column letter.
     * @param row       Row number.
     * @return          ChessPiece/chess figure.
     */
    public ChessPiece pieceAt(char column, int row){
        return m_board[column - 'a'][row - 1].piece();
    }

    /**
     * Postaví figurku na zadanou souřadnici. 
     * 
     * Pokud je čtverec už plný, vyhodí výjimku IllegalStateException.
     * 
     * @param column    Column letter.
     * @param row       Row number.
     * @param piece     ChessPiece/chess figure.
     */
    public void putPiece(char column, int row, ChessPiece piece){
        m_board[column - 'a'][row - 1].putPiece(piece);
    }

    @Override
    public String toString() {
        ChessBoardAsString boardAsString = new ChessBoardAsString(this);

        return boardAsString.toString();
    }

}