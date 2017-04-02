package nullpointerexception.flexichess;

/**
 * Stará se o diagnostický výpis šachovnice do řetězce.
 * 
 * @author Drabek Jan
 * @author Stastny Martin
 * @author Szlauer Martin
 */
public class ChessBoardAsString {

    private ChessBoard m_chessBoard = null;

    /**
     * Vytvoří instanci objektu pro danou šachovnici.
     * 
     * @param chessBoard Chess board to handle.
     */
    public ChessBoardAsString(ChessBoard chessBoard){
        m_chessBoard = chessBoard;
    }

    /**
     * Vrátí řetězec s diagnostickým výpisem stavu šachovnice, viz úkol 02.
     * 
     * @return Text visualization of board.
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        appendTopBorder(sb);
        
        // For every line except last print content and separating row
        for (int row = m_chessBoard.rows(); row > 1 ; row--) {
            appendContentRow(sb, row);
            appendSeparatingBorder(sb);
        }

        appendContentRow(sb, 1);
        appendBottomBorder(sb);

        appendColumnsNotation(sb);
        appendCapturedPiecesInfo(sb);
        
        return sb.toString();
    }

    private void appendTopBorder( StringBuilder sb ){
        sb.append("   ┌");
        for (int i = 0; i < m_chessBoard.columns() - 1; i++)
            sb.append("───┬");
        sb.append("───┐\n");        
    }

    private void appendContentRow( StringBuilder sb, int row ){
        // print row notation
        sb.append(String.format("%2d │", row));

        // print each column
        for (int col = 0; col < m_chessBoard.columns(); col++)
            try{
                sb.append(m_chessBoard.pieceAt( (char)('a' + col), row).symbol()).append(" │");
            }
            catch(Exception e){
                sb.append("   │");
            }

        sb.append("\n");
    }    

    private void appendSeparatingBorder( StringBuilder sb ){
        sb.append("   ├");
        for (int col = 0; col < m_chessBoard.columns() - 1; col++)
            sb.append("───┼");
        sb.append("───┤\n");
    }
    
    private void appendBottomBorder( StringBuilder sb ){
        sb.append("   └");
        for (int i = 0; i < m_chessBoard.columns() - 1; i++)
            sb.append("───┴");
        sb.append("───┘\n");
    }

    private void appendColumnsNotation( StringBuilder sb ){
        sb.append("     ");
        for (int i = 0; i < m_chessBoard.columns() - 1; i++)
            sb.append((char)('a' + i)).append("   ");
        sb.append((char)('a' + m_chessBoard.columns() - 1)).append(" \n");        
    }

    private void appendCapturedPiecesInfo(StringBuilder sb) {
        appendCapturedPiecesList(sb, ChessPiece.Color.WHITE);
        sb.append("\n");
        appendCapturedPiecesList(sb, ChessPiece.Color.BLACK);
    }
    
    private void appendCapturedPiecesList(StringBuilder sb,
            ChessPiece.Color color) {
        if (color == ChessPiece.Color.WHITE)
            sb.append("W").append(color.getSign()).append(":");
        else
            sb.append("B").append(color.getSign()).append(":");
        
        m_chessBoard.capturedPieces(color).forEach((piece) -> {
            sb.append(" ").append(piece.letter());
        });
    }
}
