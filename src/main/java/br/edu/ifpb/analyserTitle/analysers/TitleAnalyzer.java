package br.edu.ifpb.analyserTitle.analysers;

import java.util.Stack;

import br.edu.ifpb.analyserTitle.util.CoGrooUtils;
import br.edu.ifpb.analyserTitle.util.LanguageToolUtils;
import br.edu.ifpb.analyserTitle.util.StringUtil;
import br.edu.ifpb.analyserTitle.util.similarity.ScoreSimilarity;
import br.edu.ifpb.analyserTitle.util.data.ReaderFile;
import br.edu.ifpb.analyserTitle.util.StringTokenizerUtils;

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
	
	private String javaClasses;
	private String javaClassesException;
	private static final Float VALUE_SIMILARITY = 0.05f;

	public TitleAnalyzer(){
		this.setClassesJava();
		this.setClassesJavaExceptions();
	}
	
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
	 * Analisa o uso da língua adequando na descrição
	 * </p>
	 * 
	 * Verifica se a descrição está gramaticamente e ortograficamente correta
	 * 
	 * @param description
	 *            descrição da pergunta a ser análisada
	 * @return 1/0
	 */
	public Integer isUsingProperLanguage(String title) {
		String s0 = StringUtil.removerTagsHtml(title.toLowerCase());
		s0 = this.removeAllCode(s0);
		s0 = StringUtil.removeCharacterSpecial(s0);
		String s2 = StringUtil.trim(s0);


		if (frenquencyOfCode(title, 2) == 0) {
			if (!LanguageToolUtils.textIsValid(s2, 0)) {
				return 0;
			} else {
				return 1;
			}
		}
		if (frenquencyOfCode(title, 2) > 10
				&& frenquencyOfCode(title, 2) < 60) {
			if (!LanguageToolUtils.textIsValid(s2, 80)) {
				return 0;
			} else {
				return 1;
			}
		} else if (frenquencyOfCode(title, 2) >= 5) {
			if (!LanguageToolUtils.textIsValid(s2, 12)) {
				return 0;
			} else {
				return 1;
			}
		} else if (frenquencyOfCode(title, 2) < 5) {
			if (!LanguageToolUtils.textIsValid(s2, 5)) {
				return 0;
			} else {
				return 1;
			}
		} else {
			if (!LanguageToolUtils.textIsValid(s2, 400)) {
				return 0;
			} else {
				return 1;
			}
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
	
	/**
	 * <p>
	 * Verifica a frequência de código em um texto
	 * </p>
	 * 
	 * @param description texto
	 * @return a frequẽncia do texto passado
	 */
	private int frenquencyOfCode(String description, Integer type) {

		int flag = 0;

		String[] tJavaClasses = StringTokenizerUtils.parseToken(javaClasses
				.toLowerCase());
		String[] strSplited = StringTokenizerUtils.parseToken(description
				.toLowerCase());

		if (type == 1) {
			for (int j = 0; j < strSplited.length; j++) {
				for (int i = 0; i < tJavaClasses.length; i++) {

					if (strSplited[j].equals(tJavaClasses[i])) {
						flag++;
					}
				}
			}
		} else {
			for (int j = 0; j < strSplited.length; j++) {
				for (int i = 0; i < tJavaClasses.length; i++) {

					if (strSplited[j].contains(tJavaClasses[i])) {
						flag++;
					}
				}
			}

		}
		return flag;
	}
	
	private String removeAllCode(String description) {
		String result = "";
		String tStr[] = StringTokenizerUtils.parseToken(description
				.toLowerCase());
		String[] tJavaClasses = StringTokenizerUtils.parseToken(javaClasses
				.toLowerCase());

		for (int i = 0; i < tStr.length; i++) {

			for (int j = 0; j < tJavaClasses.length; j++) {
				if (tStr[i].contains(tJavaClasses[j])) {
					tStr[i] = "";
				}
			}
		}

		for (String string : tStr) {
			result += string + " ";
		}

		return StringUtil.trim(result);
	}
	
	/**
	 * método auxiliar para carregar os nomes das classes do java. Deve ser
	 * executado antes para não ter que fazer conexão com a pagina toda vez.
	 */
	private void setClassesJava() {
		javaClasses = ReaderFile.readerTxt("classJava.txt").toLowerCase();
	}

	/**
	 * método auxiliar para carregar os nomes das classes exception do java. Deve ser
	 * executado antes para não ter que fazer conexão com a pagina toda vez.
	 */
	private void setClassesJavaExceptions(){
		javaClassesException = ReaderFile.readerTxt("classOnlyExceptionJava.txt");
	}

}
