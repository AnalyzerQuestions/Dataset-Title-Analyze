package br.edu.ifpb.analyserTitle.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.edu.ifpb.analyserTitle.GenerateReults;
import br.edu.ifpb.analyserTitle.stackExchangeAPI.Response;
import br.edu.ifpb.analyserTitle.stackExchangeAPI.StackExchangeApi;
import br.edu.ifpb.analyserTitle.stackExchangeAPI.StackExchangeSite;
import br.edu.ifpb.analyserTitle.stackExchangeAPI.data.CSVUtils;
import br.edu.ifpb.analyserTitle.stackExchangeAPI.entities.types.Question;

public class MainTestStackExchangePORT {
	
	public static void main(String[] args) {
		
		StackExchangeApi api = new StackExchangeApi("KJi1v7aNWJ8aziMts2QEmQ((");
		api.authorize("gkTDYoP(Ar3ZGk64jkudSg))");
		
		Map<String, String> dates = new HashMap<String, String>();
		
		
		dates.put("1494892800", "1501545600");

		StackExchangeSite siteService = api.getSiteService(StackExchangeSite.PORTUGUESE_LENGUAGE_BETA);
		Response<Question> response = null;
		List<Question> itemsQuestions = new ArrayList<Question>();
		
		if(siteService != null){
			for (String key : dates.keySet()) {
				api.dateBetwen(key, dates.get(key));
				response = siteService.getQuestions();

				for (Question question : response.getItems()) {
					itemsQuestions.add(question);
				}
			}
		}
		System.out.println("-----------------------------------------------> 200 OK");
		System.out.println("------------------------------------------------> "+itemsQuestions.size()+" COUNT LIST");
		System.out.println("------------------------------------------------> Analyzing ...");

		GenerateReults generateReults = new GenerateReults();
		CSVUtils csvUtils = new CSVUtils();
		csvUtils.getQuestions(generateReults.generate(itemsQuestions));
		
		System.out.println("------------------------------------------------> writing ...");
		
		csvUtils.writeCSV("perguntas-nao-respondidas-STEX-PORT-LENG.csv");
		
		System.out.println("------------------------------------------------> ESCRITA CSV OK");


	}

}
