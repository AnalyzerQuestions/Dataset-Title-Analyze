/**
 * 
  <p>
 * <b> Analyser Title </b>
 * </p>
 *
 * <p>
 * todos os direitos reservados
 * </p>
 * 
 * @author <a href="https://github.com/JoseRafael97">Rafael Feitosa</a>
 */
package br.edu.ifpb.analyserTitle.so;

import retrofit.http.GET;

/**
 * 
 * <p>
 * <b> {@link StackExchangeSite} </b>
 * </p>
 *
 * <p>
 * Interface que contém end-point para acesso a perguntas nos sites do StackExchange.
 * </p>
 * 
 * @author <a href="https://github.com/JoseRafael97">Rafael Feitosa</a>
 */
public interface StackExchangeSite {

	public static final String STACK_OVERFLOW = "pt.stackoverflow";
	    
	    @GET("/questions")
	    Response<QuestionPojo> getQuestions();
}
