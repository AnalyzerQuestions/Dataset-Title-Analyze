package br.edu.ifpb.analyserTitle.util;

import java.util.StringTokenizer;

/**
 * 
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
public class StringTokenizerUtils {

	/**
	 * Transforma uma String em tokens
	 * 
	 * @param str String a ser tokenizada
	 * @return array de tokens
	 */
	public static String[] parseToken(String str) {

		String[] result;
		int i = 0;

		StringTokenizer st = new StringTokenizer(str);

		result = new String[st.countTokens()];

		while (st.hasMoreTokens()) {
			result[i++] = st.nextToken();
		}
		return result;
	}
	
	public static String[] parseTokenWithoutPointer(String str){
		
		String [] result = str.split(".");
		
		return result;
	}
	
	public static String[] parseTokenWithoutComma(String str){
		
		String [] result = str.split(",");
		
		return result;
	}
	
}
