package Strings;

public class StringCompression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] input={'a','a','b','b','c','b','b','b','b','c','c'};
		System.out.println(compress(input));
		for(char ch:input){
			System.out.print(ch+" ");
		}

	}
	public static int compress(char[] chars) {
        int anchor = 0, write = 0;
        for (int read = 0; read < chars.length; read++) {
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    for (char c: ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        return write;
    }

}
