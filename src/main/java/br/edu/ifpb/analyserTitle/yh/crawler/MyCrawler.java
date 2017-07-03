
/**
 * 
 * <p>
 * <b> MyCrawler.java </b>
 * </p>
 *
 * <p>
 * Entidade ...
 * </p>
 * 
 * @author <a href="https://github.com/JoseRafael97">Rafael Feitosa</a>
 */
package br.edu.ifpb.analyserTitle.yh.crawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import br.edu.ifpb.analyserTitle.entities.Question;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

/**
 * 
 * <p>
 * <b> MyCrawler.java </b>
 * </p>
 *
 * <p>
 * Entidade ...
 * </p>
 * 
 * @author <a href="https://github.com/JoseRafael97">Rafael Feitosa</a>
 */
public class MyCrawler extends WebCrawler {

	private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|gif|jpg" + "|png|mp3|mp3|zip|gz))$");

	@Override
	public boolean shouldVisit(Page referringPage, WebURL url) {
		String href = url.getURL().toLowerCase();
		return !FILTERS.matcher(href).matches() && href.startsWith("http://www.ics.uci.edu/");
	}

	@Override
	public void visit(Page page) {

		List<Question> questionsYahoo = new ArrayList<Question>();
		
		if (page.getParseData() instanceof HtmlParseData) {
			HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
			String text = htmlParseData.getText();
			String html = htmlParseData.getHtml();

			Document doc = Jsoup.parse(html);
			Elements links2 = doc.getElementsByClass("Clr-b").select("[href]");

			for (int i = 0; i < links2.size(); i++) {
				try {
					final String QUESTIONURL = "https://br.answers.yahoo.com" + links2.get(i).attr("href");

					if (QUESTIONURL.contains("question") && QUESTIONURL.contains("qid")) {
						System.out.println(QUESTIONURL);

						doc = Jsoup.connect("https://br.answers.yahoo.com" + links2.get(i).attr("href")).get();

						String title = doc.getElementsByClass("Fz-24 Fw-300 Mb-10").text();
						String description = doc.getElementsByClass("ya-q-text").text();
						String numberAnswers = doc.getElementsByClass("Mend-10 Fz-13 Fw-n D-ib").text();
						
						if (numberAnswers.trim().length()>0) {
							numberAnswers = numberAnswers.substring(0, 4).trim();
						}

						questionsYahoo.add(new Question(title, description, QUESTIONURL, numberAnswers));
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

			System.out.println(questionsYahoo);
			System.out.println("Text length: " + text.length());
			System.out.println("Html length: " + html.length());
			System.out.println("Number of outgoing links: " + questionsYahoo.size());
		}

	}

}
