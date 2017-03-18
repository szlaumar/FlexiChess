package nullpointerexception.flexichess;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Představuje šachovnici.
 * 
 * @author Drabek Jan
 * @author Stastny Martin
 * @author Szlauer Martin
 */
public class ChessBoard {
    private ChessPiece[][] m_board;
    private Stack<ChessPiece> capturedPieces;
    private HashSet<ChessPiece> allPieces;
    
    /**
     * Vytvoří šachovnici o zadaném počtu sloupců a řádků.
     * 
     * @param column    Number of m_board columns.
     * @param row       Number of m_board rows.
     */
    public ChessBoard(int column, int row){
        m_board = new ChessPiece[column][row];
        capturedPieces = new Stack<>();
        allPieces = new HashSet<>();
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
        ChessPiece piece = m_board[column - 'a'][row - 1];
        
        if( piece == null )
            throw new IllegalStateException("No chess piece on given coordinates.");
        else
            return piece;
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
    public void putPiece(char column, int row, ChessPiece piece) {
        if (!isEmptyAt(column, row))
            throw new IllegalStateException("Can't move chess piece.");
        
        piece.setPosition(column, row);
        m_board[column - 'a'][row - 1] = piece;
    }

    @Override
    public String toString() {
        ChessBoardAsString boardAsString = new ChessBoardAsString(this);

        return boardAsString.toString();
    }

    /**
     * Pravda, je-li čtverec prázdný.
     * 
     * Vznikne přejmenováním metody isSquareEmpty
     * 
     * @param column
     * @param row
     * @return 
     */
    // TODO
    public boolean isEmptyAt(char column, int row) {
        return m_board[column - 'a'][row - 1] == null;
    }
    
    /**
     * Vyprázndí daný čtverec a postaví figurku mimo šachovnici.
     * 
     * Je-li čtverec už prázdný, vyhodí výjimku IllegalStateException.
     * 
     * @param column
     * @param row
     * @return 
     */
    // TODO: ma ji dat jako vyhozenou? stejne jako capturePieceAt()?
    public ChessPiece emptySquare(char column, int row) {
        return capturePieceAt(column, row);
    }
    
    /**
     * Přesune figurku z políčka from na políčko to.
     * 
     * Pokud je políčko "from" prázdné, nebo na políčku "to" stojí figurka,
     * vyhodí výjimku IllegalStateException.
     * 
     * @param fromColumn
     * @param fromRow
     * @param toColumn
     * @param toRow 
     */
    public void moveTo(char fromColumn, int fromRow, char toColumn, int toRow) {
        if (isEmptyAt(fromColumn, fromRow) || !isEmptyAt(toColumn, toRow))
            throw new IllegalStateException("Can't move chess piece.");
        
        ChessPiece chessPiece = m_board[fromColumn][fromRow];
        putPiece(toColumn, toRow, chessPiece);
        m_board[fromColumn - 'a'][fromRow - 1] = null;
    }
    
    /**
     * Přesune figurku z políčka do zásobníku zajatých figurek a
     * vrátí danou figurku.
     * 
     * Pokud je políčko prázdné, vyhodí výjimku IllegalStateException.
     * 
     * @param column
     * @param row
     * @return 
     */
    public ChessPiece capturePieceAt(char column, int row) {
        if (isEmptyAt(column, row))
            throw new IllegalStateException("Square is empty.");
        
        ChessPiece chessPiece = m_board[column - 'a'][row - 1];
        chessPiece.setOffBoard();
        capturedPieces.add(chessPiece);
        
        return chessPiece;
    }
    
    /**
     * Přesune figurku z vrcholu zásobníku zajatých figurek na dané políčko.
     * 
     * Pokud je políčko už obsazené, vyhodí výjimku IllegalStateException,
     * pokud je zásobník prázdný, vyhodí EmptyStackException.
     * 
     * @param column
     * @param row 
     */
    public void returnLastCapturedTo(char column, int row) {
        if (!isEmptyAt(column, row))
            throw new IllegalStateException("Square is not empty.");
        
        ChessPiece chessPiece = capturedPieces.pop();
        putPiece(column, row, chessPiece);
    }
    
    /**
     * Vrátí seznam zajatých figurek.
     * 
     * @return List of captured pieces.
     */
    public List<ChessPiece> capturedPieces() {
        List<ChessPiece> list = new LinkedList<>();
        
        capturedPieces.forEach((piece) -> {
            list.add(piece);
        });
        return list;
    }
    
    /**
     * Vrátí seznam zajatých figurek dané barvy.
     * 
     * @param color
     * @return List of captured pieces of given color.
     */
    public List<ChessPiece> capturedPieces(ChessPiece.Color color) {
        List<ChessPiece> list = new LinkedList<>();
        
        capturedPieces.forEach((piece) -> {
            if (piece.color() == color)
                list.add(piece);
        });
        return list;
    }
    
    /**
     * Add newly created ChessPuece to the pool of all pieces assigned to this
     * board.
     * 
     * @param piece 
     */
    public void addNewChessPiece(ChessPiece piece) {
        allPieces.add(piece);
    }
}