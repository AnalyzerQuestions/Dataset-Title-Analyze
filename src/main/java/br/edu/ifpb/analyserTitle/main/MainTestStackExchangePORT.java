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


/**
 * 
 * <p>
 * <b> {@link MainTestSO} </b>
 * </p>
 *
 * <p>
 * Generate DataSet with questions of PORTUGUESE_LENGUAGE_BETA .
 * </p>
 * 
 * @author <a href="https://github.com/JoseRafael97">Rafael Feitosa</a>
 */
public class MainTestStackExchangePORT {
	
	public static void main(String[] args) {
		
		StackExchangeApi api = new StackExchangeApi("KJi1v7aNWJ8aziMts2QEmQ((");
		api.authorize("gkTDYoP(Ar3ZGk64jkudSg))");
		
		Map<String, String> dates = new HashMap<String, String>();
		
		
		dates.put("1483228800", "1484438400");
		dates.put("1484524800", "1485820800");//Janeiro 2017
		
		dates.put("1485907200", "1487116800");
		dates.put("1487203200", "1488240000");//fevereiro 2017
		
		dates.put("1488326400", "1489536000");
		dates.put("1489622400", "1490918400");//março 2017
		
		dates.put("1491004800", "1492214400");
		dates.put("1492300800", "1493510400");//abril 2017
		
		dates.put("1493596800", "1494806400");
		dates.put("1494892800", "1496188800");//maio 2017
		
		dates.put("1496275200", "1494806400");
		dates.put("1497571200", "1498780800");//junho 2017
				
		dates.put("1498867200", "1500076800");
		dates.put("1500163200", "1501459200");//julho 2017
		
		dates.put("1501545600", "1502755200");
		dates.put("1502841600", "1504137600");//agosto 2017
		
		dates.put("1501545600", "1504656000");//setembro 2017
						
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
		
		//para coletar perguntas respondidas você deve muda esse método para ---> generateAnswedQuestions e mudar o nome do file .csv 
		csvUtils.getQuestions(generateReults.generateNotAnsweredQuestions(itemsQuestions, 200));
		
		System.out.println("------------------------------------------------> writing ...");
		
		csvUtils.writeCSV("perguntas-nao-respondidas-STEX-PORT-LENG.csv");
		
		System.out.println("------------------------------------------------> ESCRITA CSV OK");


	}

}
