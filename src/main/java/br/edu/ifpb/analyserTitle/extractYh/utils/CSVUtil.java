package br.edu.ifpb.analyserTitle.extractYh.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import br.edu.ifpb.analyserTitle.entities.Question;

public class CSVUtil {

	 private static final String NEW_LINE_SEPARATOR = "\n";
	    
	    private List<Question> questions;

		private CSVPrinter csvPrinter;
	    
		/**
		 * Headers of dataset
		 */
	    private static final Object [] FILE_HEADER = {
		    "TITLE", 
	    	"DESCRIÇAO", 
	    	"TAGS",
	    	"QUANTIDADE DE RESPOSTAS",
	    	"DATA CRIAÇÃO", 
	    	"DATA PRIMEIRA RESP.",
	    	"FOI RESPONDIDA",
	    	
	    	"TEMPO (Horas) ENTRE PERGUNTA E 1ª RESPOSTA",
	    	
			"TÍTULO TOTALMENTE EM CAIXA ALTA",
			"TÍTULO PARCIALMENTE EM CAIXA ALTA",
			"TÍTULO QUE RESUMA O PROBLEMA",
			"TÍTULO CURTO (Até 3 palavras)", 
			"TÍTULO TAMANHO MÉDIO (de 4 a 8 palavras)",
			"TÍTULO COERENTE COM A DESCRIÇÃO",
			"TÍTULO OBJETIVO", 
			"TÍTULO CLARO",
			"TÍTULO ESCRITO USANDO A NORMA CULTA DA LÍNGUA",
		
		};
	    
	    
	    public void getQuestions(List<Question> questions){
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
				
				for (Question q : questions) {
					
			    	List recordQuestions = new ArrayList();
					recordQuestions.add(String.valueOf(q.getTitle()));
					recordQuestions.add(String.valueOf(q.getBody()));
					recordQuestions.add(String.valueOf(q.getTags()));
					recordQuestions.add(String.valueOf(q.getAnswersNumber()));
					recordQuestions.add(String.valueOf(q.getCreateDate()));
					recordQuestions.add(String.valueOf(q.getFirstAnswer()));
					recordQuestions.add(String.valueOf(q.isAcceptedAnswers()));
					recordQuestions.add(String.valueOf(q.getTimeInHourForFisrtAnswer()));


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
