
/**
 * 
 * <p>
 * <b> Teste.java </b>
 * </p>
 *
 * <p>
 * Entidade ...
 * </p>
 * 
 * @author <a href="https://github.com/JoseRafael97">Rafael Feitosa</a>
 */
package br.edu.ifpb.analyserTitle.extractYh;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;


/**
 * 
 * <p>
 * <b> Teste.java </b>
 * </p>
 *
 * <p>
 * Entidade ...
 * </p>
 * 
 * @author <a href="https://github.com/JoseRafael97">Rafael Feitosa</a>
 */
public class Teste {

	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException {


	
		try (WebClient webClient = new WebClient(BrowserVersion.CHROME)) {
		    webClient.waitForBackgroundJavaScript(10000);
		    webClient.getOptions().setThrowExceptionOnScriptError(false);
		    final HtmlPage page = webClient.getPage("https://br.answers.yahoo.com/");
		    List<String> list = page.getByXPath("//a[@class='Fz-14 Fw-b Clr-b Wow-bw title']");
		    
		    System.out.println(list.size());


		    System.out.println(page.asText());
		}
	}

}
