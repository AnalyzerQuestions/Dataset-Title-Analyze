package br.edu.ifpb.analyserTitle.main;

import br.edu.ifpb.analyserTitle.extractYh.MappedQuestionYa;
import br.edu.ifpb.analyserTitle.extractYh.data.CSVUtil;

public class MainTestYH {

	public static void main(String[] args) {
		
		CSVUtil csvUtil = new CSVUtil();
		
		MappedQuestionYa mappedQuestionYa = new MappedQuestionYa();
		
	
		
		System.out.println("------------CRIANDO DATASET PERGUNTAS COM RESPOSTAS ACEITAS----------");
		
		//passa quantidade de pergunta que você quer 
	
		csvUtil.getQuestions(mappedQuestionYa.questionsWithAcceptedAnswer(5));
		
		
		csvUtil.writeCSV("perguntas-com-repostas-aceitas-YH.csv");
		
		System.out.println("------------FINALIZADO----------");
		
		System.out.println("------------CRIANDO DATASET PERGUNTAS SEM RESPOSTAS----------");
		//passa quantidade de pergunta que você quer 
		csvUtil.getQuestions(mappedQuestionYa.questionsNotAnswered(5));
		csvUtil.writeCSV("perguntas-sem-respostas-YH.csv");
		
		System.out.println("------------FINALIZADO----------");
		

	}
}
