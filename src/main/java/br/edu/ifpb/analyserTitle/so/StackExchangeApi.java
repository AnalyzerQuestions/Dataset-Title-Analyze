
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

import java.lang.reflect.Type;
import java.util.Date;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * 
 * <p>
 * <b>{@link StackExchangeApi} </b>
 * </p>
 *
 * <p>
 * 
 * </p>
 * 
 * @author <a href="https://github.com/JoseRafael97">Rafael Feitosa</a>
 */
public class StackExchangeApi {

	 public static final String ENDPOINT = "https://api.stackexchange.com/2.2";

	    private final RestAdapter.Builder builder;

	    public StackExchangeApi() {

	        Gson gson = new GsonBuilder()
	                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
	                .registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
	                    public Date deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
	                        return new Date(json.getAsLong() * 1000);
	                    }
	                }).create();
	            this.builder = new RestAdapter.Builder()
	                .setEndpoint(ENDPOINT)
	                .setErrorHandler(new StackExchangeErrorHandler())
	                //.setLogLevel(RestAdapter.LogLevel.FULL) //log da requisição
	                .setConverter(new GsonConverter(gson));

	    }

	    public StackExchangeSite getSiteService(final String site) {
	        return builder
	            .setRequestInterceptor(new RequestInterceptor() {
	                public void intercept(RequestFacade request) {
	                    request.addQueryParam("site", site);
	                    request.addQueryParam("sort", "creation");
	                    request.addQueryParam("tagged", "java");
	                    request.addQueryParam("key", "ADD KEY");
	                    request.addQueryParam("access_token", "ADD");
	                    request.addQueryParam("filter", "c*65v.ppToRvQ1LyNaG30spXwQLmiAxD*(");
	                }
	            })
	            .build()
	            .create(StackExchangeSite.class);
	    }
}
