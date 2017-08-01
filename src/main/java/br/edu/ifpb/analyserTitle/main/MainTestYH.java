package br.edu.ifpb.analyserTitle.main;

import br.edu.ifpb.analyserTitle.extractYh.MappedQuestionYa;
import br.edu.ifpb.analyserTitle.extractYh.utils.CSVUtil;

public class MainTestYH {

	public static void main(String[] args) {
		
		CSVUtil csvUtil = new CSVUtil();
		
		MappedQuestionYa mappedQuestionYa = new MappedQuestionYa();
		
		System.out.println("------------CRIANDO DATASET PERGUNTAS COM RESPOSTAS ACEITAS----------");
		csvUtil.getQuestions(mappedQuestionYa.questionsWithAcceptedAnswer(200));
		csvUtil.writeCSV("perguntas-com-repostas-aceitas.csv");
		
		System.out.println("------------FINALIZADO----------");
		
		System.out.println("------------CRIANDO DATASET PERGUNTAS SEM RESPOSTAS----------");
		csvUtil.getQuestions(mappedQuestionYa.questionsNotAnswered(200));
		csvUtil.writeCSV("perguntas-sem-respostas.csv");
		
		System.out.println("------------FINALIZADO----------");

	}
}
