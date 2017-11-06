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

public class MainTestSO2017 {

	public static void main(String[] args) {

		StackExchangeApi api = new StackExchangeApi("KJi1v7aNWJ8aziMts2QEmQ((");
		api.authorize("gkTDYoP(Ar3ZGk64jkudSg))");

		Map<String, String> dates = new HashMap<String, String>();

		dates.put("1483228800", "1483574400"); // 01 jan - 05 jan
		dates.put("1483660800", "1484006400"); // 06 jan - 10 jan
		dates.put("1484092800", "1484438400"); // 11 jan - 15 jan
		dates.put("1484092800", "1484438400"); // 16 jan - 20 jan
		dates.put("1484956800", "1485302400"); // 21 jan - 25 jan
		dates.put("1485388800", "1485820800"); // 26 jan - .. jan

		dates.put("1485907200", "1486252800"); // 01 fev - 05 fev
		dates.put("1486339200", "1486684800"); // 06 fev - 10 fev
		dates.put("1486771200", "1487116800"); // 11 fev - 15 fev
		dates.put("1487203200", "1487548800"); // 16 fev - 20 fev
		dates.put("1487635200", "1487980800"); // 21 fev - 25 fev
		dates.put("1488067200", "1488240000"); // 26 fev - .. fev

		dates.put("1488326400", "1488672000"); // 01 mar - 05 mar
		dates.put("1488758400", "1489104000"); // 06 mar - 10 mar
		dates.put("1489190400", "1489536000"); // 11 mar - 15 mar
		dates.put("1489622400", "1489968000"); // 16 mar - 20 mar
		dates.put("1490054400", "1490400000"); // 21 mar - 25 mar
		dates.put("1490486400", "1490918400"); // 26 mar - .. mar

		dates.put("1491004800", "1491350400"); // 01 abr - 05 abr
		dates.put("1491436800", "1491782400"); // 06 abr - 10 abr
		dates.put("1491868800", "1492214400"); // 11 abr - 15 abr
		dates.put("1492300800", "1492646400"); // 16 abr - 20 abr
		dates.put("1492732800", "1493078400"); // 21 abr - 25 abr
		dates.put("1493164800", "1493510400"); // 26 abr - .. abr

		dates.put("1493596800", "1493942400"); // 01 mai - 05 mai
		dates.put("1494028800", "1494374400"); // 06 mai - 10 mai
		dates.put("1494460800", "1494806400"); // 11 mai - 15 mai
		dates.put("1494892800", "1495238400"); // 16 mai - 20 mai
		dates.put("1495324800", "1495670400"); // 21 mai - 25 mai
		dates.put("1495756800", "1496188800"); // 26 mai - .. mai

		dates.put("1496275200", "1496620800"); // 01 jun - 05 jun
		dates.put("1496707200", "1497052800"); // 06 jun - 10 jun
		dates.put("1497139200", "1497484800"); // 11 jun - 15 jun
		dates.put("1497571200", "1497916800"); // 16 jun - 20 jun
		dates.put("1498003200", "1498348800"); // 21 jun - 25 jun
		dates.put("1498435200", "1498780800"); // 26 jun - .. jun

		dates.put("1498867200", "1499212800"); // 01 jul - 05 jul
		dates.put("1499299200", "1499644800"); // 06 jul - 10 jul
		dates.put("1499731200", "1500076800"); // 11 jul - 15 jul
		dates.put("1500163200", "1500508800"); // 16 jul - 20 jul
		dates.put("1500595200", "1500940800"); // 21 jul - 25 jul
		dates.put("1501027200", "1501459200"); // 26 jul - .. jul

		dates.put("1501545600", "1501891200"); // 01 ago - 05 ago
		dates.put("1501977600", "1502323200"); // 06 ago - 10 ago
		dates.put("1502409600", "1502755200"); // 11 ago - 15 ago
		dates.put("1502841600", "1503187200"); // 16 ago - 20 ago
		dates.put("1503273600", "1503619200"); // 21 ago - 25 ago
		dates.put("1503705600", "1504137600"); // 26 ago - .. ago

		dates.put("1504224000", "1504569600"); // 01 set - 05 set
		dates.put("1504656000", "1505001600"); // 06 set - 10 set
		dates.put("1505088000", "1505433600"); // 11 set - 15 set
		dates.put("1505520000", "1505865600"); // 16 set - 20 set
		dates.put("1505952000", "1506297600"); // 21 set - 25 set
		dates.put("1506384000", "1506729600"); // 26 set - .. set

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

		csvUtils.writeCSV("perguntas-2017-SO-PT.csv");

		System.out.println("------------------------------------------------> ESCRITA CSV OK");

		System.out.println("-----------------------------------------------------------------------------------------------------");

	}
}
