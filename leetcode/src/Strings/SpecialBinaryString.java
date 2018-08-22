package Strings;
import java.util.*;
public class SpecialBinaryString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(makeLargestSpecial("0011011100"));
	}
	
	public static String makeLargestSpecial(String S) {
        int count = 0, i = 0;
        List<String> res = new ArrayList<String>();
        for (int j = 0; j < S.length(); ++j) {
          if (S.charAt(j) == '1') count++;
          else count--;
          if (count == 0) {
            res.add('1' + makeLargestSpecial(S.substring(i + 1, j)) + '0');
            i = j + 1;
          }
        }
        Collections.sort(res, Collections.reverseOrder());
        return String.join("", res);
    }

}
