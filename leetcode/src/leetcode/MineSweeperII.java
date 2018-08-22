package leetcode;

public class MineSweeperII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] ch={{'E','E','M','E','E'},{'E','E','E','E','E'},{'E','E','E','E','E'},{'E','E','E','E','E'}};
		int[] c={1,0};
		System.out.println(updateBoard(ch, c));
	}
	
	public static char[][] updateBoard(char[][] board, int[] click) {
        if(board.length==0 || board[0].length==0 )
            return board;
        int r=click[0];
        int c=click[1];
        if(r<0 || c<0 || r>board.length-1 || c>board[0].length-1)
            return board;
        int[][] dir={{1,1},{1,-1},{-1,1},{-1,-1},{0,1},{1,0},{-1,0},{0,-1}};
        if(board[r][c]=='M')
            board[r][c]='X';
        else{
            helper(board,r,c,dir);
        }
        return board;
    }
    
    public static void helper(char[][] board,int r,int c,int[][] dir){
        if(Character.isDigit(board[r][c]) || board[r][c]=='M' || board[r][c]=='B')
        	return;
        int mines=calculate(board,r,c,dir);
        if(mines>0){
            board[r][c]=(char)(mines+'0');
        }
        else{
            board[r][c]='B';
            for(int[] d:dir){
                int nr=r+d[0];
                int nc=c+d[1];
                if(nr>=0 && nc>=0 && nr<board.length && nc<board[0].length){
                    helper(board,nr,nc,dir);
                }
            }
        }
    }
    
    public static int calculate(char[][] board,int r,int c,int[][] dir){
        int total=0;
        for(int[] d:dir){
            int nr=r+d[0];
            int nc=c+d[1];
            if(nr>=0 && nc>=0 && nr<board.length && nc<board[0].length){
                if(board[nr][nc]=='M')
                    total++;
            }
        }
        return total;
    }

}
