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

/**
 *
 * <p>
 * <b> {@link MainTestSO} </b>
 * </p>
 *
 * <p>
 * Generate DataSet with questions of Stack Overflow in portuguese.
 * </p>
 *
 * @author <a href="https://github.com/JoseRafael97">Rafael Feitosa</a>
 */
public class MainTestSO2016 {

	public static void main(String[] args) {

		StackExchangeApi api = new StackExchangeApi("KJi1v7aNWJ8aziMts2QEmQ((");
		api.authorize("gkTDYoP(Ar3ZGk64jkudSg))");

		Map<String, String> dates = new HashMap<String, String>();

		dates.put("1451606400", "1451952000"); // 01 jan - 05 jan
		dates.put("1452038400", "1452384000"); // 06 jan - 10 jan
		dates.put("1452470400", "1452816000"); // 11 jan - 15 jan
		dates.put("1452902400", "1453248000"); // 16 jan - 20 jan
		dates.put("1453334400", "1453680000"); // 21 jan - 25 jan
		dates.put("1453766400", "1454198400"); // 26 jan - .. jan
		dates.put("1454284800", "1454630400"); // 01 fev - 05 fev
		dates.put("1454716800", "1455062400"); // 06 fev - 10 fev
		dates.put("1455148800", "1455494400"); // 11 fev - 15 fev
		dates.put("1455580800", "1455926400"); // 16 fev - 20 fev
		dates.put("1456012800", "1456358400"); // 21 fev - 25 fev
		dates.put("1456444800", "1456704000"); // 26 fev - .. fev
		dates.put("1456790400", "1457136000"); // 01 mar - 05 mar
		dates.put("1457222400", "1457568000"); // 06 mar - 10 mar
		dates.put("1457654400", "1458000000"); // 11 mar - 15 mar
		dates.put("1458086400", "1458432000"); // 16 mar - 20 mar
		dates.put("1458518400", "1458864000"); // 21 mar - 25 mar
		dates.put("1458950400", "1459382400"); // 26 mar - .. mar
		dates.put("1459468800", "1459814400"); // 01 abr - 05 abr
		dates.put("1459900800", "1460246400"); // 06 abr - 10 abr
		dates.put("1460332800", "1460678400"); // 11 abr - 15 abr
		dates.put("1460764800", "1461110400"); // 16 abr - 20 abr
		dates.put("1461196800", "1461542400"); // 21 abr - 25 abr
		dates.put("1461628800", "1461974400"); // 26 abr - .. abr
		dates.put("1462060800", "1462406400"); // 01 mai - 05 mai
		dates.put("1462492800", "1462838400"); // 06 mai - 10 mai
		dates.put("1462924800", "1463270400"); // 11 mai - 15 mai
		dates.put("1463356800", "1463702400"); // 16 mai - 20 mai
		dates.put("1463788800", "1464134400"); // 21 mai - 25 mai
		dates.put("1464220800", "1464652800"); // 26 mai - .. mai
		dates.put("1464739200", "1465084800"); // 01 jun - 05 jun
		dates.put("1465171200", "1465516800"); // 06 jun - 10 jun
		dates.put("1465603200", "1465948800"); // 11 jun - 15 jun
		dates.put("1466035200", "1466380800"); // 16 jun - 20 jun
		dates.put("1466467200", "1466812800"); // 21 jun - 25 jun
		dates.put("1466899200", "1467244800"); // 26 jun - .. jun
		dates.put("1467331200", "1467676800"); // 01 jul - 05 jul
		dates.put("1467763200", "1468108800"); // 06 jul - 10 jul
		dates.put("1468195200", "1468540800"); // 11 jul - 15 jul
		dates.put("1468627200", "1468972800"); // 16 jul - 20 jul
		dates.put("1469059200", "1469404800"); // 21 jul - 25 jul
		dates.put("1469491200", "1469923200"); // 26 jul - .. jul
		dates.put("1470009600", "1470355200"); // 01 ago - 05 ago
		dates.put("1470441600", "1470787200"); // 06 ago - 10 ago
		dates.put("1470873600", "1471219200"); // 11 ago - 15 ago
		dates.put("1471305600", "1471651200"); // 16 ago - 20 ago
		dates.put("1471737600", "1472083200"); // 21 ago - 25 ago
		dates.put("1472169600", "1472601600"); // 26 ago - .. ago
		dates.put("1472688000", "1473033600"); // 01 set - 05 set
		dates.put("1473120000", "1473465600"); // 06 set - 10 set
		dates.put("1473552000", "1473897600"); // 11 set - 15 set
		dates.put("1473984000", "1474329600"); // 16 set - 20 set
		dates.put("1474416000", "1474761600"); // 21 set - 25 set
		dates.put("1474848000", "1475193600"); // 26 set - .. set
		dates.put("1475280000", "1475625600"); // 01 out - 05 out
		dates.put("1475712000", "1476057600"); // 06 out - 10 out
		dates.put("1476144000", "1476489600"); // 11 out - 15 out
		dates.put("1476576000", "1476921600"); // 16 out - 20 out
		dates.put("1477008000", "1477353600"); // 21 out - 25 out
		dates.put("1477440000", "1477872000"); // 26 out - .. out
		dates.put("1477958400", "1478304000"); // 01 nov - 05 nov
		dates.put("1478390400", "1478736000"); // 06 nov - 10 nov
		dates.put("1478822400", "1479168000"); // 11 nov - 15 nov
		dates.put("1479254400", "1479600000"); // 16 nov - 20 nov
		dates.put("1479686400", "1480032000"); // 21 nov - 25 nov
		dates.put("1480118400", "1480464000"); // 26 nov - .. nov
		dates.put("1480550400", "1480896000"); // 01 dez - 05 dez
		dates.put("1480982400", "1481328000"); // 06 dez - 10 dez
		dates.put("1481414400", "1481760000"); // 11 dez - 15 dez
		dates.put("1481846400", "1482192000"); // 16 dez - 20 dez
		dates.put("1482278400", "1482624000"); // 21 dez - 25 dez
		dates.put("1482710400", "1483142400"); // 26 dez - .. dez

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

		csvUtils.getQuestions(generateReults.generateQuestions(itemsQuestions, 5000));

		System.out.println("------------------------------------------------> writing ...");

		csvUtils.writeCSV("perguntas-2016-SO-PT.csv");

		System.out.println("------------------------------------------------> ESCRITA CSV OK");

		System.out.println("-----------------------------------------------------------------------------------------------------");

	}
}
