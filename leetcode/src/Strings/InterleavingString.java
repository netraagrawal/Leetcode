package Strings;

public class InterleavingString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
	}
	public static boolean isInterleave(String s1, String s2, String s3) {
		if(s1.length()+s2.length()!=s3.length())
            return false;
        boolean[][] dp=new boolean[s1.length()+1][s2.length()+1];
        dp[0][0]=true;
        for(int i=1;i<=s1.length();i++){
            if(s1.charAt(i-1)==s3.charAt(i-1))
                dp[i][0]=dp[i-1][0];
        }
        for(int i=1;i<=s2.length();i++){
            if(s2.charAt(i-1)==s3.charAt(i-1))
                dp[0][i]=dp[0][i-1];
        }
        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                int ind=i+j-1;
                if(s3.charAt(ind)==s1.charAt(i-1))
                    dp[i][j]=dp[i-1][j];
                else if(s3.charAt(ind)==s2.charAt(j-1))
                    dp[i][j]=dp[i][j-1];
            }
        }
        return dp[s1.length()][s2.length()];
    }

}
