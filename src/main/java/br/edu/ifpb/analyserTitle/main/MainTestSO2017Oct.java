package br.edu.ifpb.analyserTitle.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.edu.ifpb.analyserTitle.GenerateResults;
import br.edu.ifpb.analyserTitle.stackExchangeAPI.Response;
import br.edu.ifpb.analyserTitle.stackExchangeAPI.StackExchangeApi;
import br.edu.ifpb.analyserTitle.stackExchangeAPI.StackExchangeSite;
import br.edu.ifpb.analyserTitle.stackExchangeAPI.data.CSVUtils;
import br.edu.ifpb.analyserTitle.stackExchangeAPI.entities.types.Question;

public class MainTestSO2017Oct {

	public static void main(String[] args) {

		StackExchangeApi api = new StackExchangeApi("KJi1v7aNWJ8aziMts2QEmQ((");
		api.authorize("gkTDYoP(Ar3ZGk64jkudSg))");

		Map<String, String> dates = new HashMap<String, String>();

		dates.put("1506816000", "1507161600"); // 01 out - 05 out
		dates.put("1507248000", "1507593600"); // 06 out - 10 out
		dates.put("1507680000", "1508025600"); // 11 out - 15 out
		dates.put("1508112000", "1508457600"); // 16 out - 20 out
		dates.put("1508544000", "1508889600"); // 21 out - 25 out
		dates.put("1508976000", "1509408000"); // 26 out - .. out

		StackExchangeSite siteService = api.getSiteService(StackExchangeSite.STACK_OVERFLOW);
		Response<Question> response = null;
		List<Question> itemsQuestions = new ArrayList<Question>();

		if (siteService != null) {
			for (String key : dates.keySet()) {
				api.dateBetwen(key, dates.get(key));
				response = siteService.getQuestions();

				for (Question question : response.getItems()) {
					itemsQuestions.add(question);
				}
			}
		}

		System.out
				.println("------------------------------------------------> " + itemsQuestions.size() + " COUNT LIST");
		System.out.println("------------------------------------------------> Analyzing ...");

		GenerateResults generateReults = new GenerateResults();
		CSVUtils csvUtils = new CSVUtils();

		csvUtils.getQuestions(generateReults.generateQuestions(itemsQuestions, itemsQuestions.size()));

		System.out.println("------------------------------------------------> writing ...");

		csvUtils.writeCSV("perguntas-2017-OUTUBRO-SO-PT.csv");

		System.out.println("------------------------------------------------> ESCRITA CSV OK");

		System.out.println("-----------------------------------------------------------------------------------------------------");

	}
}
