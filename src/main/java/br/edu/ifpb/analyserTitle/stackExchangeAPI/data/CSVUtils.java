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
    	"TÍTULO PARCIALMENTE EM CAIXA ALTA --------------------> PORCENTAGEM DE PALAVRAS EM CAIXA ALTA",
    	"TÍTULO CURTO (Até 3 palavras) --------------------> TAMANHO DO TÍTULO", 
    	"TÍTULO TAMANHO MÉDIO (de 4 a 8 palavras) --------------------> TAMANHO DO TÍTULO",
    	
    	"TÍTULO TOTALMENTE EM CAIXA ALTA",
		"TÍTULO CONTEM 'AJUDA', 'URGENTE', SOCORRO --------------------> SEPARAR AS 3",
	};
    
    /*
     * "TÍTULO TOTALMENTE EM CAIXA ALTA",
		"TÍTULO PARCIALMENTE EM CAIXA ALTA",
		"TÍTULO QUE RESUMA O PROBLEMA",
		"TÍTULO CURTO (Até 3 palavras)", 
		"TÍTULO TAMANHO MÉDIO (de 4 a 8 palavras)",
		"TÍTULO COERENTE COM A DESCRIÇÃO",
		"TÍTULO OBJETIVO", 
		"TÍTULO CLARO",
		"TÍTULO ESCRITO USANDO A NORMA CULTA DA LÍNGUA"
	    "ÚLTIMA DATA DE EDIÇÃO", 
	    "PONTOS", 
	    "DESCRICAO HTML",
	    "TAGS",
	    "QUANTIDADADE DE VOTOS (down)",
	    "TEMPO (minutos) ENTRE PERGUNTA E 1º COMENTARIO",
	    "TEMPO (minutos) ENTRE 1º COMENTARIO E 1ª RESPOSTA",
	    "FOI VOTADA (down)",
	    "QUANTIDADE DE VOTOS (up)", 
	    "QUANTIDADE COMENTÁRIO", 
	    "QUANTIDADE DE VOTOS DELETADOS",
	    "FOI VOTADA (up)",
     */
    
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
				//recordQuestions.add(String.valueOf(q.getColumnQuestion().getCommentCount()));
				recordQuestions.add(String.valueOf(q.getColumnQuestion().getCreationDate()));
				//recordQuestions.add(String.valueOf(q.getColumnQuestion().getLastEditDate()));
				//recordQuestions.add(String.valueOf(q.getColumnQuestion().getScore()));
				recordQuestions.add(String.valueOf(q.getColumnQuestion().getViewCount()));
				recordQuestions.add(String.valueOf(q.getColumnQuestion().getTitle()));
				//recordQuestions.add(String.valueOf(q.getColumnQuestion().getBodyMarkdown()));
				recordQuestions.add(String.valueOf(q.getColumnQuestion().getBody()));
				//recordQuestions.add(String.valueOf(q.getColumnQuestion().getTags()));
				recordQuestions.add(String.valueOf(q.getColumnQuestion().isAnswered()));
				//recordQuestions.add(String.valueOf(q.getColumnQuestion().getDownVoteCount()));
				//recordQuestions.add(String.valueOf(q.getColumnQuestion().isDownVoted()));
				//recordQuestions.add(String.valueOf(q.getColumnQuestion().getUpVoteCount()));
				//recordQuestions.add(String.valueOf(q.getColumnQuestion().getDeleteVoteCount()));
				//recordQuestions.add(String.valueOf(q.getColumnQuestion().isUpVoted()));
				
				//recordQuestions.add(String.valueOf(q.getColumnDateBetwenQuestionComment() == -1 ? "Sem comentário":q.getColumnDateBetwenQuestionComment()));
				recordQuestions.add(String.valueOf(q.getColumnDateBetwenQuestionAnswer() == -1 ? "Sem Resposta":q.getColumnDateBetwenQuestionAnswer()));
				//recordQuestions.add(String.valueOf(q.getColumnDateBetwenCommentAnswer() == -1 ? "Sem resposta/comentario":q.getColumnDateBetwenCommentAnswer()));
				

				/*recordQuestions.add(String.valueOf(q.getColumnObjetividade()));
				recordQuestions.add(String.valueOf(q.getColumnQuestionUnique()));
				recordQuestions.add(String.valueOf(q.getColumnDescricaoCurta()));
				
				
				recordQuestions.add(String.valueOf(q.getColumnClareza()));
				recordQuestions.add(String.valueOf(q.getColumnCoerenciaTeD()));
				recordQuestions.add(String.valueOf(q.getColumnEvidentProbleam()));

				
				recordQuestions.add(String.valueOf(q.getColumnPergBemDefinida()));
				recordQuestions.add(String.valueOf(q.getColumnExemplo()));
				recordQuestions.add(String.valueOf(q.getColummLink()));
				recordQuestions.add(String.valueOf(q.getCombLink()));*/
				
				recordQuestions.add(String.valueOf(q.getColumnParciallyUpperCase()));
				recordQuestions.add(String.valueOf(q.getColumnSmallSizeTitle()));
				recordQuestions.add(String.valueOf(q.getColumnMediumSizeTitle()));
				
				recordQuestions.add(String.valueOf(q.getColumnTotallyUpperCase()));
				recordQuestions.add(String.valueOf(q.getColumnContainsHelpOrUrgent()));
				
				/*recordQuestions.add(String.valueOf(q.getColumnMuchCode()));
				
				
				recordQuestions.add(String.valueOf(q.getColumnEducacao()));
				recordQuestions.add(String.valueOf(q.getColumnEvPerguntaDuplicada()));
				recordQuestions.add(String.valueOf(q.getColumnEvPergSobreTrabAcademicos()));
				recordQuestions.add(String.valueOf(q.getColumnAgradecimento()));
				recordQuestions.add(String.valueOf(q.getColumnUsoNormaCultaLingua()));*/
				
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
