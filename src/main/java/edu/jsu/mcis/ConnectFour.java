package edu.jsu.mcis;

public class ConnectFour {
    public enum Location {EMPTY, RED, BLACK};
    private Location[][] board;
    private int currentTurn;
    
    public ConnectFour() {
        board = new Location[7][6];
        currentTurn = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                board[i][j] = Location.EMPTY;
            }
        }
    }
    
    public Location getTopOfColumn(int column) {
        for(int i = board[column].length-1; i >= 0; i--){
            if(board[column][i] != Location.EMPTY){
                return board[column][i];
            }
        }
        return Location.EMPTY;
    }
    
    public int getHeightOfColumn(int column) {      
        int height = 0;
        for(int i = 0; i < board[column].length; i++){
            if(board[column][i] != Location.EMPTY){
                height++;
            }
        }
        return height;
    }
    
    public void dropToken(int column) {
        try{
            switch(currentTurn%2){
                case 0:
                    board[column][getHeightOfColumn(column)] = Location.RED;
                    break;
                case 1:
                    board[column][getHeightOfColumn(column)] = Location.BLACK;
                    break;                
            }
            currentTurn++;  
        }catch(ArrayIndexOutOfBoundsException ex){
            throw new ColumnFullException("The column selected, [" + column + "], was full.");
        }
    }
}