package br.edu.ifpb.analyserTitle.analysers;

import br.edu.ifpb.analyserTitle.util.LanguageToolUtils;
import br.edu.ifpb.analyserTitle.util.StringTokenizerUtils;
import br.edu.ifpb.analyserTitle.util.StringUtil;
import br.edu.ifpb.analyserTitle.util.data.ReaderFile;
import br.edu.ifpb.analyserTitle.util.similarity.ScoreSimilarity;

/**
 * 
 * <p>
 * <b> {@link TitleAnalyzer} </b>
 * </p>
 *
 * <p>
 * Analyser to title of question.
 * </p>
 * 
 * @author <a href="https://github.com/JoseRafael97">Rafael Feitosa</a>
 */
public class TitleAnalyzer {
	
	private static final Float VALUE_SIMILARITY = 0.05f;
	
	public TitleAnalyzer() {

	}
	
	public Integer isTotallyUpperCase(String title){
		
		boolean result = title.equals(title.toUpperCase());
		
		if(result == true){
			return 1;
		}
		
		return 0;
	}
	
	public Integer isPartiallyUpperCase(String title){
		
		String str = StringUtil.removeConnective(title);
		str = StringUtil.removeCharacterSpecial(str);
		String[] strPart = StringTokenizerUtils.parseToken(str);
		
		int cont = 0;
		
		for(String s: strPart){
						
			if(s.equals(s.toUpperCase())){
				cont++;
			}
		}
		
		if(cont >= 2 && cont < strPart.length){
			return 1;
		}
		
		return 0;
	}

	public Integer isCoherentBodyAndTitle(String title, String description) {
		
		ScoreSimilarity scoreSimilarity = new ScoreSimilarity();

		Double similarity = scoreSimilarity.getSimilarity(title, description);
		
		if (similarity > VALUE_SIMILARITY) {
			return 1;
		}
		
		return 0;
	}

	public Integer containsHelp(String title){
						
		if(title.toLowerCase().contains("ajuda")){
			return 1;
		}
		
		return 0;
	}
	
	public Integer containsUrgent(String title){
						
		if(title.toLowerCase().contains("urgente")){
			return 1;
		}
		
		return 0;
	}
	
	public Integer containsSocorro(String title){
		
		if(title.toLowerCase().contains("socorro")){
			return 1;
		}
		
		return 0;
	}
	
	public Integer containsPlease(String title){
		
		if(title.toLowerCase().contains("por favor")){
			return 1;
		}
		
		return 0;
	}
	
	public Integer endsWithQuestionMark(String title){
		
		
		if(title.endsWith("?")) {
			return 1;
		}
		
		return 0;
	}
	
	/**
	 * <p>
	 * Analisa o uso da língua adequando no título
	 * </p>
	 * 
	 * Verifica se o título está gramaticamente e ortograficamente correto
	 * 
	 * @param description
	 *            titulo da pergunta a ser análisado
	 * @return 1/0
	 */
	public Integer analyzerUsingProperLanguage(String title) {
		
		String s0 = StringUtil.removerTagsHtml(title.toLowerCase());
		s0 = StringUtil.removeCharacterSpecial(s0);
		String s2 = StringUtil.trim(s0);

		if (!LanguageToolUtils.textIsValid(s2, 0)) {
			return 0;
		} 

		return 1;
	}
	
	public static Integer containsWordIntoParenthesis(String title) {
				
		String[] strPart = StringTokenizerUtils.parseToken(title);
		
		int openParenthesis = -1;
		int closeParenthesis = -1;
		
		for(int i=0; i<strPart.length; i++) {
			
			if(strPart[i].contains("(")) {
				openParenthesis = i;
			}
			else if(strPart[i].contains(")") && openParenthesis != -1) {
				closeParenthesis = i;
			}
			
			
			
			System.out.println(strPart[i]);
		}
				
		if((closeParenthesis != -1) && 
				(closeParenthesis - openParenthesis) != 1) {
			System.out.println("CONTEM PALAVRA ENTRE PARENTESES");
			return 1;
		}
		
		System.out.println("NÃO CONTEM PALAVRA ENTRE PARENTESES");
		return 0;
	}
	
	public Integer containsWordIntoBrace(String title) {
		
	}
	
	public Integer containsWordIntoBracket(String title) {
		
	}
	
	public static void main(String[] args) {
		
		containsWordIntoParenthesis("Your heart has ( been broken )");
	}
	
}
