/**
 * @author Drabek Jan
 * @author Stastny Martin
 * @author Szlauer Martin
 */
package nullpointerexception.flexichess;

import java.util.Objects;

/**
 * Představuje jednoduchý tah na šachovnici.
 * 
 * Jednoduchý tah je přesunutí figurky na volné políčko
 * nebo vyhození figurky jinou figurkou. 
 * Nepatří sem rošády, braní mimochodem 
 * nebo výměna pěšáků na poslední řadě.
 * 
 */
public class SimpleMove implements Move{
    private ChessPiece  m_piece;
    private Square      m_from;
    private Square      m_to;

    /**
     * Konstruktor. 
     * 
     * Figurka piece se má přesunout na políčko to.
     * 
     * @param piece
     * @param to 
     */
    public SimpleMove(ChessPiece piece, Square to){
        m_piece = piece;
        m_from  = piece.position();
        m_to    = to;
    }

    /**
     * @return Startovní políčko odkud se figurka posunuje.
     */
    public Square from() {
        return m_from;
    }

    /**
     * @return Cílové políčko.
     */
    public Square to() {
        return m_to;
    }

    /**
     * 
     * @return Figurka, které se tah týká.
     */
    public ChessPiece piece() {
        return piece;
    }
    
    /**
     * Provede tah. 
     * 
     * Pokud je cílové políčko prázdné, figurka se tam jen posune. 
     * Pokud je na něm soupeřova figurka, tak je zajmuta.
     * 
     * @param board 
     */
    @Override
    public void executeOnBoard(ChessBoard board) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Vrátí tah zpátky.
     * 
     * @param board 
     */
    @Override
    public void revertOnBoard(ChessBoard board) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * @return True pokud se během tahu zajímá soupeřova figurka.
     */
    public boolean isCapturing(){
        return !m_piece.board().isEmptyAt(m_to.column, m_to.row);
    }
    
    /**
     * Textový popis jednoduchého tahu má tuto strukturu:
     * PIECE_LETTER SQUARE_FROM '-' 'x'? SQUARE_TO
     * 
     * Popis tahu pěšcem, který nezajímá žádnou figurku, 
     * vypadá tedy například jako Pc2-c3. 
     * Popis tahu koněm, který zajímá figurku, 
     * vypadá jako Sa1-xb3.
     * 
     * @return 
     */
    @Override
    public String notation(){
        return isCapturing()? String.format("%c%s-%s", m_piece.letter(), m_from, m_to) :
            String.format("%c%s-x%s", m_piece.letter(), m_from, m_to);
    }
    
    /**
     * Standardní implementace podle atributů from a to.
     * 
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.m_from);
        hash = 59 * hash + Objects.hashCode(this.m_to);
        return hash;
    }

    /**
     * Standardní implementace podle atributů from a to.
     * 
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SimpleMove other = (SimpleMove) obj;
        if (!Objects.equals(this.m_from, other.m_from)) {
            return false;
        }
        if (!Objects.equals(this.m_to, other.m_to)) {
            return false;
        }
        return true;
    }
    
    /**
     * Vrací totéž co notation().
     * 
     * @return 
     */
    @Override
    public String toString(){
        return notation();
    }
}
