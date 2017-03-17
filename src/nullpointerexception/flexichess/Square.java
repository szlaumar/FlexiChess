package nullpointerexception.flexichess;

/**
 * Představuje jeden čtverec šachovnice.
 * 
 * @author Drabek Jan
 * @author Stastny Martin
 * @author Szlauer Martin
 */
public class Square {
    
    private final char  m_column;
    private final int   m_row;
    private ChessPiece  m_piece = null;
    
    /**
     * Vytvoří čtverec s danými souřadnicemi.
     * 
     * @param column    Column letter.
     * @param row       Row number.
     */
    public Square(char column, int row){
        m_column = column;
        m_row    = row;
    }
    
    /**
     * Vytvoří čtverec s souřadnicemi danými jako retezec.
     * Očekává zvalidovaný vstup.
     * 
     * @param str    Coordinates string like "a5", "c12" etc.
     */
    public Square(String str){
        m_column = str.charAt(0);
        
        str = str.substring(1);
        m_row = Integer.parseInt(str);
    }
    
    /**
     * Vrátí písmeno sloupce daného čtverce.
     * 
     * @return  Column letter.
     */
    public char column(){
        return m_column;
    }
    
    /**
     * Vrátí číslo řádku daného čtverce.
     * 
     * @return  Row number.
     */
    public int row(){
        return m_row;
    }
    
    /**
     * Vrátí figurku na tomto čtverci. 
     * 
     * Pokud je čtverec prázný, vyhodí výjimku IllegalStateException.
     * 
     * @return  ChessPiece/chess figure.
     */
    public ChessPiece piece(){
        if( this.isEmpty() )
            throw new IllegalStateException("Square is empty!");
        else
            return m_piece;
    }
    
    /**
     * Postaví figurku na tento čtverec. 
     * 
     * Figurce se tak zároveň nastaví tento čtverec jak ten, na kterém stojí. 
     * Pokud už na čtverci nějaká figurka stojí, vyhodí výjimku IllegalStateException.
     * 
     * @param piece  ChessPiece/chess figure.
     */
    public void putPiece(ChessPiece piece){
        if( m_piece != null)
            throw new IllegalStateException("Square isn't empty!");
        m_piece = piece;
        m_piece.setSquare(this);
    }
    
    /**
     * Pravda, je-li čtverec prázdný (bez figurky).
     * 
     * @return True if square hasn't assigned ChessPiece/chess figure.
     */
    public boolean isEmpty(){
        return null == m_piece;
    }
    
    /**
     * Odstraní ze čtverce figurku a vrátí ji jako výsledek volání, 
     * pokud na něm nějaká stojí. 
     * 
     * Figurka se tím ocitne mimo šachovnici. 
     * Pokud je čtverec prázný, vyhodí výjimku IllegalStateException.
     * 
     * @return 
     */
    public ChessPiece empty(){
        ChessPiece tmp_piece = piece();
        tmp_piece.setOffBoard();

        m_piece = null;

        return tmp_piece;
    }
    
}
