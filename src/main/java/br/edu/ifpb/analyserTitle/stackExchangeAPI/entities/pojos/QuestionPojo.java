package br.edu.ifpb.analyserTitle.stackExchangeAPI.entities.pojos;

import br.edu.ifpb.analyserTitle.stackExchangeAPI.entities.types.Question;

/**
 * 
 * <p>
 * <b> POJO Dataset </b>
 * </p>
 *
 * <pre>
 * &#64;see <a href="http://www.linkreferencia.com">Link de Referencia</a>
 * </pre>
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
public class QuestionPojo {

	private Question columnQuestion;

	private Long columnDateBetwenQuestionAnswer;

	private int columnLink;
	private int combLink;
	private int columnSizeTitle;
	private int columnPercentageUpperCase;
	
	private int columnTotallyUpperCase;
	private int columnContainsHelp;
	private int columnContainsUrgent;
	private int columnContainsSocorro;
	private int columnContainsPlease;
	private int columnProperLinguage;
	private int columnCoherentBodyAndTitle;
	private int columnEndsWithQuestionMark;
	private int columnWordIntoParenthesis;
	private int columnWordIntoBrace;
	private int columnWordIntoBracket;

	public QuestionPojo() {
	}

	public int getColumnLink() {
		return columnLink;
	}

	public void setColumnLink(int columnLink) {
		this.columnLink = columnLink;
	}

	public int getCombLink() {
		return combLink;
	}

	public void setCombLink(int combLink) {
		this.combLink = combLink;
	}

	public Question getColumnQuestion() {
		return columnQuestion;
	}

	public void setColumnQuestion(Question columnQuestion) {
		this.columnQuestion = columnQuestion;
	}

	public Long getColumnDateBetwenQuestionAnswer() {
		return columnDateBetwenQuestionAnswer;
	}

	public void setColumnDateBetwenQuestionAnswer(Long columnDateBetwenQuestionAnswer) {
		this.columnDateBetwenQuestionAnswer = columnDateBetwenQuestionAnswer;
	}

	public int getColumnTotallyUpperCase() {
		return columnTotallyUpperCase;
	}

	public void setColumnTotallyUpperCase(int columnTotallyUpperCase) {
		this.columnTotallyUpperCase = columnTotallyUpperCase;
	}

	public int getColumnPercentageUpperCase() {
		return columnPercentageUpperCase;
	}

	public void setColumnPercentageUpperCase(int columnPercentageUpperCase) {
		this.columnPercentageUpperCase = columnPercentageUpperCase;
	}

	public int getColumnContainsHelp() {
		return columnContainsHelp;
	}

	public void setColumnContainsHelp(int columnContainsHelp) {
		this.columnContainsHelp = columnContainsHelp;
	}

	public int getColumnContainsUrgent() {
		return columnContainsUrgent;
	}

	public void setColumnContainsUrgent(int columnContainsUrgent) {
		this.columnContainsUrgent = columnContainsUrgent;
	}

	public int getColumnContainsSocorro() {
		return columnContainsSocorro;
	}

	public void setColumnContainsSocorro(int columnContainsSocorro) {
		this.columnContainsSocorro = columnContainsSocorro;
	}

	public int getColumnSizeTitle() {
		return columnSizeTitle;
	}

	public void setColumnSizeTitle(int columnSizeTitle) {
		this.columnSizeTitle = columnSizeTitle;
	}

	public int getColumnContainsPlease() {
		return columnContainsPlease;
	}

	public void setColumnContainsPlease(int columnContainsPlease) {
		this.columnContainsPlease = columnContainsPlease;
	}

	public int getColumnProperLinguage() {
		return columnProperLinguage;
	}

	public void setColumnProperLinguage(int columnProperLinguage) {
		this.columnProperLinguage = columnProperLinguage;
	}

	public int getColumnCoherentBodyAndTitle() {
		return columnCoherentBodyAndTitle;
	}

	public void setColumnCoherentBodyAndTitle(int columnCoherentBodyAndTitle) {
		this.columnCoherentBodyAndTitle = columnCoherentBodyAndTitle;
	}

	public int getColumnEndsWithQuestionMark() {
		return columnEndsWithQuestionMark;
	}

	public void setColumnEndsWithQuestionMark(int columnEndsWithQuestionMark) {
		this.columnEndsWithQuestionMark = columnEndsWithQuestionMark;
	}

	public int getColumnWordIntoParenthesis() {
		return columnWordIntoParenthesis;
	}

	public void setColumnWordIntoParenthesis(int columnWordIntoParenthesis) {
		this.columnWordIntoParenthesis = columnWordIntoParenthesis;
	}

	public int getColumnWordIntoBrace() {
		return columnWordIntoBrace;
	}

	public void setColumnWordIntoBrace(int columnWordIntoBrace) {
		this.columnWordIntoBrace = columnWordIntoBrace;
	}

	public int getColumnWordIntoBracket() {
		return columnWordIntoBracket;
	}

	public void setColumnWordIntoBracket(int columnWordIntoBracket) {
		this.columnWordIntoBracket = columnWordIntoBracket;
	}
	
	

}
