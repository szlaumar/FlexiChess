package nullpointerexception.flexichess;

/**
 * Představuje šachovou figurku.
 * 
 * @author Drabek Jan
 * @author Stastny Martin
 * @author Szlauer Martin
 */
public abstract class ChessPiece {
    
    /**
     * Defines ChessPiece/chess figure color and assigned sign for printing.
     */
    public enum Color { 
        WHITE('+'), 
        BLACK('-');
        
        /**
         * Sign assigned to color for short printing.
         */
        public final char m_sign;

        private Color(char sign){
            m_sign = sign;
        }

        public char getSign() {
            return m_sign;
        }
    }

    /** 
     * Letter describes ChessPiece/chess figure kind by standard chess notation.
     * Different kinds has different behaviors.
     * <p>
     * 
     * CHESS FIGURE KINDS:  <br>
     *  P   pawn            <br>
     *  N   knight          <br>
     *  B   bishop          <br>
     *  R   rook            <br>
     *  Q   queen           <br>
     */
    private char  m_letter;
    private final Color m_color;
    private Square      m_square = null;
    private final ChessBoard  m_board;
 
    /**
     * Chráněný konstruktor, který vytvoří figurku pro danou šachovnici.
     * 
     * Figurka začíná mimo šachovnici, ovšem ne jako zajatá.
     * Pouze nestojí na žádném políčku.
     * 
     * @param board     Board which is the piece assigned to.
     * @param color     Color of figure. BLACK or WHITE.
     */
    protected ChessPiece(ChessBoard board, ChessPiece.Color color) {
        m_board = board;
        m_color = color;
        board.addNewChessPiece(this);
    }
    
    /**
     * Chráněný konstruktor, který vytvoří figurku na daném políčku
     * na dané šachovnici.
     * 
     * Throws IllegalStateException if there is already a ChessPiece
     * on that square.s
     * 
     * @param board     Board which is the piece assigned to.
     * @param color     Color of figure. BLACK or WHITE.
     * @param column
     * @param row 
     */
    protected ChessPiece(ChessBoard board, ChessPiece.Color color,
            char column, int row) {
        m_board = board;
        m_color = color;
        setPosition(column, row);
        board.addNewChessPiece(this);
        board.putPiece(column, row, this);
    }

    /**
     * Vrátí barvu figurky.
     * 
     * @return ChessPiece/chess figure color.
     */
    public ChessPiece.Color color(){
        return m_color;
    }
    
    /**
     * Vrátí písmenko figurky.
     * 
     * @return ChessPiece/chess figure letter.
     */
    public char letter(){
        return m_letter;
    }
    
    /**
     * Vrátí symbol pro figurku, například +A, -B a podobně, viz zadání úkolu.
     * 
     * @return ChessPiece/chess figure symbol.
     */
    public String symbol(){
        return "" + m_color.getSign() + m_letter;
    }

    /**
     * Vrátí čtverec, na kterém zrovna figurka stojí. 
     * 
     * Pokud je figurka mimo šachovnici, vyhodí IllegalStateException.
     * 
     * @return Square/board location.
     */
    public Square position(){
        if( this.isOffBoard() )
            throw new IllegalStateException("ChessPiece is off board!");
        else
            return m_square;
    }

    /**
     * Vrací šachovnici, se kterou je tato figurka spojena.
     * 
     * If the ChessPiece is not linked to any board, NullPointerException thrown.
     * 
     * @return 
     */
    public ChessBoard board() {
        if (m_board == null)
            throw new NullPointerException("ChessPiece not linked to any board.");
        
        return m_board;
    }

    /**
     * Nastaví figurce čtverec, na kterém má stát. 
     * 
     * Pokud je paramter null vyhodí výjimku NullPointerException
     * 
     * @param square Square where to put ChessPiece/chess figure.
     */
    public void setPosition(Square square ){
        if(square == null)
            throw new NullPointerException("Can't assign null position on board.");
        m_square = square;
    }
    
    /**
     * Nastaví figurce čtverec, na kterém má stát.
     * 
     * Pokud je paramter null vyhodí výjimku NullPointerException
     * 
     * @param column
     * @param row 
     */
    public void setPosition(char column, int row){
        setPosition(new Square(column, row));
    }

    /**
     * Po zavolání této metody nemá figurka žádný čtverec, na kterém stojí. 
     * 
     * Je tedy mimo šachovnici.
     */
    public void setOffBoard(){
        m_square = null;
    }
    
    /**
     * Vrátí True pokud nemá figurka přiřazen žádný čtverec na šachovnici.
     * 
     * @return True if ChessPiece/chess figure hasn't assigned Square/board location.
     */
    public boolean isOffBoard(){
        return null == m_square;
    }
    
    /**
     * Vrátí totéž, co metoda symbol().
     * 
     * @return Return output from symbol() method.
     */
    @Override
    public String toString() {
        return symbol();
    }
    
}
