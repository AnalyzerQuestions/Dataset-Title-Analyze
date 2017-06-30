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

import retrofit.ErrorHandler;
import retrofit.RetrofitError;

/**
 * 
 * <p>
 * <b> {@link StackExchangeApi} </b>
 * </p>
 *
 * <p>
 * Handler para Erros na requisição ao StackExchange.
 * </p>
 * 
 * @author <a href="https://github.com/JoseRafael97">Rafael Feitosa</a>
 */
public class StackExchangeErrorHandler implements ErrorHandler {

    public Throwable handleError(RetrofitError error) {
        return error;
    }

}
