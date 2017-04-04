package nullpointerexception.flexichess;

import java.util.*;

/**
 * Představuje šachovnici.
 * 
 * @author Drabek Jan
 * @author Stastny Martin
 * @author Szlauer Martin
 */
public class ChessBoard {
    final private ChessPiece[][] m_board;
    final private Stack<ChessPiece> capturedPieces;
    final private HashSet<ChessPiece> allPieces;
    final private LinkedList<Move> playedMoves;
    
    /**
     * Vytvoří šachovnici o zadaném počtu sloupců a řádků.
     * 
     * @param column    Number of m_board columns.
     * @param row       Number of m_board rows.
     */
    public ChessBoard(int column, int row) {
        m_board = new ChessPiece[column][row];
        capturedPieces = new Stack<>();
        allPieces = new HashSet<>();
        playedMoves = new LinkedList<>();
    }

    public ChessBoard(int columns, int rows, Square whiteKingPos, Square blackKingPos) {
        this(columns, rows);
        new King(this, ChessPiece.Color.WHITE, whiteKingPos.column, whiteKingPos.row);
        new King(this, ChessPiece.Color.BLACK, blackKingPos.column, blackKingPos.row);
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

    public LinkedList<Move> getPlayedMoves() {
        return playedMoves;
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
    public ChessPiece pieceAt(char column, int row) {
        ChessPiece piece = m_board[column - 'a'][row - 1];
        
        if( piece == null )
            throw new IllegalStateException("No chess piece on given coordinates.");
        else
            return piece;
    }

    public ChessPiece pieceAt(Square square) {
        return pieceAt(square.column, square.row);
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

    public boolean isEmptyAt(Square square) {
        return isEmptyAt(square.column, square.row);
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
    public ChessPiece emptySquare(char column, int row) {
        if (isEmptyAt(column, row))
            throw new IllegalStateException("Square is empty.");
        
        ChessPiece chessPiece = m_board[column - 'a'][row - 1];
        chessPiece.setOffBoard();
        m_board[column - 'a'][row - 1] = null;
        
        return chessPiece;
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
        
        ChessPiece chessPiece = m_board[fromColumn - 'a'][fromRow - 1];
        putPiece(toColumn, toRow, chessPiece);
        chessPiece.incrementMoveCounter();
        m_board[fromColumn - 'a'][fromRow - 1] = null;
    }

    public void moveTo(Square from, Square to) {
        moveTo(from.column, from.row, to.column, to.row);
    }
    
    /**
     * Přesune figurku z políčka do zásobníku zajatých figurek a
     * vrátí danou figurku.
     * 
     * Pokud je políčko prázdné, vyhodí výjimku IllegalStateException.
     * Pokud figurka na zadanem policku nemuze byt vyhozena vyhodi vyjimku UnsupportedOperationException.
     * 
     * @param column
     * @param row
     * @return 
     */
    public ChessPiece capturePieceAt(char column, int row) {
        ChessPiece chessPiece = pieceAt(column, row);

        if (!chessPiece.canBeCaptured())
            throw new UnsupportedOperationException("Chess piece cannot be captured");

        emptySquare(column, row);
        capturedPieces.add(chessPiece);
        
        return chessPiece;
    }

    public ChessPiece capturePieceAt(Square square) {
        return capturePieceAt(square.column, square.row);
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

    public boolean isInsideBoard(char column, int row) {
        if (column - 'a' >= 0 && column - 'a' < m_board.length &&
                row > 0 && row <= m_board[0].length)
            return true;

        return false;
    }

    public boolean isInsideBoard(Square square) {
        return isInsideBoard(square.column, square.row);
    }

    /**
     * @param color
     * @return  Seznam všech figurek dané barvy na šachovnici.
     */
    public List<ChessPiece> onBoardPieces(ChessPiece.Color color) {
        List<ChessPiece> list = new ArrayList<>();

        for (ChessPiece[] column : m_board)
            for (ChessPiece piece : column)
                if (piece != null && piece.color() == color)
                    list.add(piece);

        return list;
    }

    /**
     * @return  Seznam všech figurek na šachovnici.
     */
    public List<ChessPiece> onBoardPieces() {
        List<ChessPiece> list = onBoardPieces(ChessPiece.Color.WHITE);
        list.addAll(onBoardPieces(ChessPiece.Color.BLACK));
        return list;
    }

    /**
     * Množina všech políček ohrožovaných firugurkami dané barvy.
     *
     * @param color
     * @return
     */
    public Set<Square> threatenedBy(ChessPiece.Color color) {
        Set<Square> set = new HashSet<>();

        for (ChessPiece piece : onBoardPieces(color))
            set.addAll(piece.threatens());

        return set;
    }

    public List<Move> validMovesFor(ChessPiece.Color color) {
        List<Move> list = new ArrayList<>();

        System.out.println("validMovesFor()");
        if (king(color).isInCheck()) {
            System.out.println("isInCheck");
            list.addAll(king(color).validMoves());
            return list;
        }

        for (ChessPiece piece : onBoardPieces(color))
            list.addAll(piece.validMoves());

        return list;
    }

    /**
     *  Král dané barvy
     *  Throws IllegalStateException if chess piece not found.
     *
     * @param color
     * @return  Král dané barvy
     */
    public King king(ChessPiece.Color color) {
        ChessPieceVisitor<King> visitor = new HandleChessPieceVisitor();

        allPieces.contains(new King(this, color));
        for (ChessPiece piece : allPieces) {
            if (piece.equals(new King(this, color)))
                return piece.accept(visitor);
        }

        throw new IllegalStateException(color.toString() + " King not found");
    }

}