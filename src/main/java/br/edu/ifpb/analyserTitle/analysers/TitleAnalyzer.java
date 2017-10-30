package br.edu.ifpb.analyserTitle.analysers;

import java.util.Stack;

import br.edu.ifpb.analyserTitle.util.LanguageToolUtils;
import br.edu.ifpb.analyserTitle.util.StringUtil;
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
	
	public Integer isTotallyUpperCase(String title){
		
		boolean result = title.equals(title.toUpperCase());
		
		if(result){
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
						
		return containsWord(title,"ajuda");
	}
	
	public Integer containsUrgent(String title){
						
		return containsWord(title,"urgente");
	}
	
	public Integer containsSocorro(String title){
		
		return containsWord(title,"socorro");
	}
	
	public Integer containsPlease(String title){
		
		return containsWord(title, "por favor");
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
	public Integer isUsingProperLanguage(String title) {
		
		String s0 = StringUtil.removerTagsHtml(title.toLowerCase());
		s0 = StringUtil.removeCharacterSpecial(s0);
		String s2 = StringUtil.trim(s0);

		if (!LanguageToolUtils.textIsValid(s2, 0)) {
			return 0;
		} 
		else {
			return 1;
		}
		
	}
	
	public Integer containsWordIntoParenthesis(String title) {
		
		return this.containsSymbol(title, '(', ')');
	}
	
	public Integer containsWordIntoBrace(String title) {
		
		return this.containsSymbol(title, '{', '}');
	}
	
	public Integer containsWordIntoBracket(String title) {
		
		return this.containsSymbol(title, '[', ']');
	}
	
	private Integer containsSymbol(String title, char symbolOpen, char symbolClose) {
		
		Stack<Character> pilha = new Stack<Character>();

		char[] charPart = title.toCharArray();
	
		boolean existsString = false;
		
		for(char c: charPart) {
			
			if(c == symbolOpen) {
				pilha.push(c);
			}
			
			else if(Character.isLetterOrDigit(c) && 
					existsString == false && !pilha.empty()) {
				existsString = true;
			}
			
			else if(c == symbolClose && !pilha.empty()) {
								
				pilha.pop();
				
				if(existsString && pilha.empty()) { 

					return 1; //Contem palavra entre simbolos
				}
			}
		}

		return 0; //Não contem palavra entre simbolos
	}
	
	private Integer containsWord(String title, String word) {
		
		if(title.toLowerCase().contains(word)){
			return 1;
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		System.out.println(new TitleAnalyzer().isUsingProperLanguage("Testando o método"));
	}
	
}
