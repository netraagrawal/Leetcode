package dp;

public class KnightProbability {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(knightProbability(3, 2, 0, 0));
	}
	
	/*public static double knightProbability(int N, int K, int sr, int sc) {
        double[][] dp = new double[N][N];
        int[] dr = new int[]{2, 2, 1, 1, -1, -1, -2, -2};
        int[] dc = new int[]{1, -1, 2, -2, 2, -2, 1, -1};

        dp[sr][sc] = 1;
        for (; K > 0; K--) {
            double[][] dp2 = new double[N][N];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                	if(dp[r][c]!=0){
                		for (int k = 0; k < 8; k++) {
                            int cr = r + dr[k];
                            int cc = c + dc[k];
                            if (0 <= cr && cr < N && 0 <= cc && cc < N) {
                                dp2[cr][cc] += dp[r][c] / 8.0;
                            }
                        }
                	}
                }
            }
            dp = dp2;
        }
        double ans = 0.0;
        for (double[] row: dp) {
            for (double x: row) ans += x;
        }
        return ans;
    }*/
	
	public static double knightProbability(int N, int K, int r, int c) {
        if(N==0 || K==0){
            return 0.0;
        }
        double[][] dp=new double[N][N];
        int[][] dir={{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{-1,2},{1,-2},{-1,-2}};
        dp[r][c]=1;
        for(int step=0;step<K;step++){
            double[][] copy=new double[N][N];
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(dp[i][j]!=0){
                        for(int[] d:dir){
                            int cr=d[0]+i;
                            int cc=d[1]+j;
                            if(cr>=0 && cc>=0 && cr<N && cc<N)
                                copy[cr][cc]+=(dp[i][j]/8.0);
                        }
                    }
                }
            }
            dp=copy;
        }
        double ans=0;
        for(int k=0;k<N;k++){
            for(int l=0;l<N;l++)
                ans+=dp[k][l];
        }
        return ans;
    }
	
	

}
