package br.edu.ifpb.analyserTitle.stackExchangeAPI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.edu.ifpb.analyserTitle.stackExchangeAPI.entities.types.Question;


public class StackExchangeApiTest {

	public static void main(String[] args) {

		StackExchangeApi api = new StackExchangeApi("KJi1v7aNWJ8aziMts2QEmQ((");
		api.authorize("gkTDYoP(Ar3ZGk64jkudSg))");
		
		Map<String, String> dates = new HashMap<String, String>();
		
		dates.put("1388534400", "1391212800");
		dates.put("1391212800", "1393632000");
		dates.put("1393632000", "1396310400");
		dates.put("1396310400", "1398902400");
		dates.put("1398902400", "1401580800");
		dates.put("1401580800", "1404172800");
		dates.put("1404172800", "1406851200");
		dates.put("1406851200", "1409529600");
		dates.put("1409529600", "1412121600");
		dates.put("1412121600", "1414800000");
		dates.put("1414886400", "1416009600");
		dates.put("1416096000", "1417305600");
		dates.put("1417392000", "1418601600");
		dates.put("1417824000", "1419984000");//2014-12-31 <- parou aqui
		dates.put("1420070400", "1421280000");
		dates.put("1421366400", "1422662400");
		dates.put("1422748800", "1423958400");
		dates.put("1424044800", "1425081600");
		dates.put("1425168000", "1426377600");
		dates.put("1426464000", "1427760000");
		dates.put("1427846400", "1429056000");
		dates.put("1429142400", "1430352000");
		dates.put("1430438400", "1431648000");
		dates.put("1431734400", "1433030400");
		dates.put("1433116800", "1434326400");
		dates.put("1434412800", "1435622400");
		dates.put("1435708800", "1436918400");
		dates.put("1437004800", "1438300800");
		dates.put("1438387200", "1439596800");
		dates.put("1439683200", "1440979200");
		dates.put("1441065600", "1442275200");
		dates.put("1442361600", "1443571200");
		dates.put("1443657600", "1444867200");
		dates.put("1444953600", "1446249600");
		dates.put("1446336000", "1447545600");
		dates.put("1447632000", "1448841600");
		dates.put("1448928000", "1450137600");
		dates.put("1450224000", "1451520000");
		dates.put("1451606400", "1452816000");
		dates.put("1452902400", "1454198400");
		dates.put("1454284800", "1455408000");
		dates.put("1455494400", "1456704000");
		dates.put("1456790400", "1458000000");
		dates.put("1458086400", "1459382400");
		dates.put("1459468800", "1460678400");
		dates.put("1460764800", "1461974400");
		dates.put("1462060800", "1463270400");//2016-05-01 <- comecou
		dates.put("1463356800", "1464652800");
		dates.put("1464739200", "1465948800");
		dates.put("1466035200", "1467244800");
		dates.put("1467331200", "1468540800");
		dates.put("1468627200", "1469923200");
		dates.put("1470009600", "1471219200");
		dates.put("1471305600", "1472601600");
		dates.put("1472688000", "1473897600");
		dates.put("1473897600", "1475193600");
		dates.put("1475280000", "1476403200"); //2016-10-14 <- parou aqui
		
		dates.put("1476489600", "1477872000");
		dates.put("1477958400", "1479168000");
		dates.put("1479254400", "1480464000");
		dates.put("1480550400", "1481760000");
		dates.put("1481846400", "1483142400");
		dates.put("1483228800", "1484352000");
		dates.put("1484438400", "1485302400"); //2017-01-25 <- parou aqui
	
		
		
		StackExchangeSite siteService = api.getSiteService(StackExchangeSite.STACK_OVERFLOW);
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

		System.out.println("------------------------------------------------> 200 OK");
		System.out.println("------------------------------------------------> "+itemsQuestions.size()+" COUNT LIST");
		System.out.println("------------------------------------------------> Analyzing ...");

//		GenerateReults generateReults = new GenerateReults();
//		CSVUtils csvUtils = new CSVUtils();
//		csvUtils.getQuestions(generateReults.generate(itemsQuestions));
//		
		System.out.println("------------------------------------------------> writing ...");
		
//		csvUtils.writeCSV("perguntas-nao-respondidas.csv");
		
		System.out.println("------------------------------------------------> ESCRITA CSV OK");


	}
}
