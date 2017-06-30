package br.edu.ifpb.analyserTitle.util.data;

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
    	"QUANTIDADE COMENTÁRIO", 
    	"DATA CRIAÇÃO", 
    	"ÚLTIMA DATA DE EDIÇÃO", 
    	"PONTOS", 
    	"QUANTIDADE DE VISUALIZAÇÕES",
    	"TITLE", 
    	"DESCRIÇAO", 
    	"DESCRICAO HTML",
    	"TAGS",
    	"FOI RESPONDIDA",
    	"QUANTIDADADE DE VOTOS (down)",
    	"FOI VOTADA (down)",
    	"QUANTIDADE DE VOTOS (up)", 
    	"QUANTIDADE DE VOTOS DELETADOS",
    	"FOI VOTADA (up)",
    	
    	"TEMPO (minutos) ENTRE PERGUNTA E 1º COMENTARIO",
    	"TEMPO (minutos) ENTRE PERGUNTA E 1ª RESPOSTA",
    	"TEMPO (minutos) ENTRE 1º COMENTARIO E 1ª RESPOSTA",
    	
		"OBJETIVIDADE",
		"PERGUNTA UNICA (OBJETIVIDADE)",
		"DESCRICAO CURTA (OBJETIVIDADE)",
		
		"CLAREZA", 
		"COERENCIA ENTRE TITULO E DESCRICAO (CLAREZA)",
		"EVIDENCIAR PROBLEMA (CLAREZA)",
		
		
		"DESCRICAO BEM ESCRITA", 
		"MOSTRAR EXEMPLO (DESC BEM ESCRITA)",
		"INCLUIR LINKS REL A PERGUNTA (DESC BEM ESCRITA)",
		"COMBINAR LINKS COM CONTEUDO (DESC BEM ESCRITA)",
		"EVITAR PERGUNTAS COM APENAS CODIGO/MUITO CODIGO (DESC BEM ESCRITA)",
		
		"SER EDUCADO", 
		"EVITAR CRIAR PERGUNTAS DUPLICADAS (SER EDUCADO)", 
		"EVITAR CRIAR PERGUNTAS DE TRABALHOS (SER EDUCADO)",
		"INCLUIR AGRADECIMENTO (SER EDUCADO)",
		"USO DA LINGUA CULTA (SER EDUCADO)",
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
				recordQuestions.add(String.valueOf(q.getColumnQuestion().getCommentCount()));
				recordQuestions.add(String.valueOf(q.getColumnQuestion().getCreationDate()));
				recordQuestions.add(String.valueOf(q.getColumnQuestion().getLastEditDate()));
				recordQuestions.add(String.valueOf(q.getColumnQuestion().getScore()));
				recordQuestions.add(String.valueOf(q.getColumnQuestion().getViewCount()));
				recordQuestions.add(String.valueOf(q.getColumnQuestion().getTitle()));
				recordQuestions.add(String.valueOf(q.getColumnQuestion().getBodyMarkdown()));
				recordQuestions.add(String.valueOf(q.getColumnQuestion().getBody()));
				recordQuestions.add(String.valueOf(q.getColumnQuestion().getTags()));
				recordQuestions.add(String.valueOf(q.getColumnQuestion().isAnswered()));
				recordQuestions.add(String.valueOf(q.getColumnQuestion().getDownVoteCount()));
				recordQuestions.add(String.valueOf(q.getColumnQuestion().isDownVoted()));
				recordQuestions.add(String.valueOf(q.getColumnQuestion().getUpVoteCount()));
				recordQuestions.add(String.valueOf(q.getColumnQuestion().getDeleteVoteCount()));
				recordQuestions.add(String.valueOf(q.getColumnQuestion().isUpVoted()));
				
				recordQuestions.add(String.valueOf(q.getColumnDateBetwenQuestionComment() == -1 ? "Sem comentário":q.getColumnDateBetwenQuestionComment()));
				recordQuestions.add(String.valueOf(q.getColumnDateBetwenQuestionAnswer() == -1 ? "Sem Resposta":q.getColumnDateBetwenQuestionAnswer()));
				recordQuestions.add(String.valueOf(q.getColumnDateBetwenCommentAnswer() == -1 ? "Sem resposta/comentario":q.getColumnDateBetwenCommentAnswer()));
				

				recordQuestions.add(String.valueOf(q.getColumnObjetividade()));
				recordQuestions.add(String.valueOf(q.getColumnQuestionUnique()));
				recordQuestions.add(String.valueOf(q.getColumnDescricaoCurta()));
				
				
				recordQuestions.add(String.valueOf(q.getColumnClareza()));
				recordQuestions.add(String.valueOf(q.getColumnCoerenciaTeD()));
				recordQuestions.add(String.valueOf(q.getColumnEvidentProbleam()));

				
				recordQuestions.add(String.valueOf(q.getColumnPergBemDefinida()));
				recordQuestions.add(String.valueOf(q.getColumnExemplo()));
				recordQuestions.add(String.valueOf(q.getColummLink()));
				recordQuestions.add(String.valueOf(q.getCombLink()));
				recordQuestions.add(String.valueOf(q.getColumnMuchCode()));
				
				
				recordQuestions.add(String.valueOf(q.getColumnEducacao()));
				recordQuestions.add(String.valueOf(q.getColumnEvPerguntaDuplicada()));
				recordQuestions.add(String.valueOf(q.getColumnEvPergSobreTrabAcademicos()));
				recordQuestions.add(String.valueOf(q.getColumnAgradecimento()));
				recordQuestions.add(String.valueOf(q.getColumnUsoNormaCultaLingua()));

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
