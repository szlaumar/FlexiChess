package nullpointerexception.flexichess;
/**
 * 
 * @author Drabek Jan
 * @author Stastny Martin
 */
public class FlexiChess {

    public static void main(String[] args) {
        // test data
        int rows = 26;
        int columns = 26;
        
        ChessBoard myBoard = new ChessBoard(columns, rows);
        System.out.print(myBoard.toString());
    }
    
}