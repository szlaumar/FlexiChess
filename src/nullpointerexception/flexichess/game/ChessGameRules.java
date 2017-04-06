package nullpointerexception.flexichess.game;

public abstract class ChessGameRules {
	public final int boardColumns;
	public final int boardRows;
	public final Square whiteKingPosition;
	public final Square blackKingPosition;
	public final boolean canPawnDoubleStep;
	public final boolean shortCastlingAllowed;
	public final boolean longCastlingAllowed;
	public final int columnStepForShortCastling;
	public final int columnStepForLongCastling;
	
	protected ChessGameRules(
			int boardColumns, 
			int boardRows, 
			Square whiteKingPosition, 
			Square blackKingPosition,
			boolean canPawnDoubleStep, 
			boolean shortCastlingAllowed, 
			boolean longCastlingAllowed,
			int columnStepForShortCastling, 
			int columnStepForLongCastling) {
		
		this.boardColumns = boardColumns;
		this.boardRows = boardRows;
		this.whiteKingPosition = whiteKingPosition;
		this.blackKingPosition = blackKingPosition;
		this.canPawnDoubleStep = canPawnDoubleStep;
		this.shortCastlingAllowed = shortCastlingAllowed;
		this.longCastlingAllowed = longCastlingAllowed;
		this.columnStepForShortCastling = columnStepForShortCastling;
		this.columnStepForLongCastling = columnStepForLongCastling;
	}
	
	public abstract void setUpPieces(ChessBoard board);	
}
