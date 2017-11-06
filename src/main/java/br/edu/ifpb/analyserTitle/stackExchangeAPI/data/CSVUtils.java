package br.edu.ifpb.analyserTitle.stackExchangeAPI.data;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import br.edu.ifpb.analyserTitle.stackExchangeAPI.entities.pojos.QuestionPojo;


/**
 * 
 * <p>
 * <b> Grava dataset com os resultados</b>
 * </p>
 *
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
public class CSVUtils {
	
    private static final String NEW_LINE_SEPARATOR = "\n";
    
    private List<QuestionPojo> questions;

	private CSVPrinter csvPrinter;
    
	/**
	 * Headers of dataset
	 */
    private static final Object [] FILE_HEADER = {
    	"ID PERGUNTA",
    	"ID RESPOSTA ACEITA",
    	"QUANTIDADE DE RESPOSTAS",
    	"FECHADA", 
    	"DATA FECHAMENTO", 
    	"DATA CRIAÇÃO", 
    	"QUANTIDADE DE VISUALIZAÇÕES",
    	"TITULO", 
    	"DESCRIÇAO", 
    	"FOI RESPONDIDA",
    	
    	"TEMPO (minutos) ENTRE PERGUNTA E 1ª RESPOSTA",
    	"PORCENTAGEM DE PALAVRAS EM CAIXA ALTA",
    	"TAMANHO DO TÍTULO", 
    	
    	"TÍTULO USA NORMA CULTA DA LÍNGUA",
    	"TÍTULO TOTALMENTE EM CAIXA ALTA",
		"TÍTULO CONTÉM 'AJUDA'",
		"TÍTULO CONTÉM 'URGENTE'",
		"TÍTULO CONTÉM 'SOCORRO'",
		"TÍTULO CONTÉM 'POR FAVOR'",
		"TÍTULO COERENTE COM A DESCRIÇÃO",
		"TÍTULO CONTÉM PALAVRA ENTRE PARENTESES",
		"TÍTULO CONTÉM PALAVRA ENTRE COLCHETES",
		"TÍTULO CONTÉM PALAVRA ENTRE CHAVES",
		"TÍTULO TERMINA COM INTERROGAÇÃO"
	};
    
    
    
    public void getQuestions(List<QuestionPojo> questions){
    	
    	this.questions = questions;
    }
    
    
    /**
     * Write in file with format csv
     * @param fileName
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public void writeCSV(String fileName){
    	
    	FileWriter fWriter = null;
    	
    	CSVFormat csvFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);
    	
    	try {
			fWriter = new FileWriter(fileName);
			csvPrinter = new CSVPrinter(fWriter, csvFormat);
			csvPrinter.printRecord(FILE_HEADER);
			System.out.println(questions.size());
			for (QuestionPojo q : questions) {
		    	List recordQuestions = new ArrayList();
				recordQuestions.add(String.valueOf(q.getColumnQuestion().getQuestionId()));
				recordQuestions.add(String.valueOf(q.getColumnQuestion().getAcceptedAnswerId()));
				recordQuestions.add(String.valueOf(q.getColumnQuestion().getAnswerCount()));
				recordQuestions.add(String.valueOf(q.getColumnQuestion().isCanClosed()));
				recordQuestions.add(String.valueOf(q.getColumnQuestion().getClosedDate()));
				recordQuestions.add(String.valueOf(q.getColumnQuestion().getCreationDate()));
				recordQuestions.add(String.valueOf(q.getColumnQuestion().getViewCount()));
				recordQuestions.add(String.valueOf(q.getColumnQuestion().getTitle()));
				recordQuestions.add(String.valueOf(q.getColumnQuestion().getBody()));
				recordQuestions.add(String.valueOf(q.getColumnQuestion().isAnswered()));
				
				recordQuestions.add(String.valueOf(q.getColumnDateBetwenQuestionAnswer() == -1 ? "Sem Resposta":q.getColumnDateBetwenQuestionAnswer()));
				recordQuestions.add(String.valueOf(q.getColumnPercentageUpperCase()));
				recordQuestions.add(String.valueOf(q.getColumnSizeTitle()));
				
				recordQuestions.add(String.valueOf(q.getColumnProperLinguage()));
				recordQuestions.add(String.valueOf(q.getColumnTotallyUpperCase()));
				recordQuestions.add(String.valueOf(q.getColumnContainsHelp()));
				recordQuestions.add(String.valueOf(q.getColumnContainsUrgent()));
				recordQuestions.add(String.valueOf(q.getColumnContainsSocorro()));
				recordQuestions.add(String.valueOf(q.getColumnContainsPlease()));
				recordQuestions.add(String.valueOf(q.getColumnCoherentBodyAndTitle()));
				recordQuestions.add(String.valueOf(q.getColumnWordIntoParenthesis()));
				recordQuestions.add(String.valueOf(q.getColumnWordIntoBracket()));
				recordQuestions.add(String.valueOf(q.getColumnWordIntoBrace()));
				recordQuestions.add(String.valueOf(q.getColumnEndsWithQuestionMark()));
				
				csvPrinter.printRecord(recordQuestions);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fWriter.flush();
				fWriter.close();
				csvPrinter.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
    }
}
