package br.edu.ifpb.analyserTitle.stackExchangeAPI;

import com.google.gson.*;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

import java.lang.reflect.Type;
import java.util.Date;

public class StackExchangeApi {

    public static final double VERSION = 2.2;
    public static final String ENDPOINT = "https://api.stackexchange.com/" + VERSION;

    private final String key;
    private final RestAdapter.Builder builder;
    private String accessToken;
    
    private String de;
    private String ate;

    public StackExchangeApi(String key) {
        this.key = key;

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

    public void authorize(String accessToken) {
        this.accessToken = accessToken;
    }
    
    public void dateBetwen(String de, String ate){
    	this.de = de;
    	this.ate = ate;
    	System.out.println(de +" : "+ate);
    }

    public StackExchange getService() {
        return builder.build().create(StackExchange.class);
    }

    /**
     * Obter perguntas para dataset, inclui filtros para perguntas do dataset
     * 
     * @param site
     * @return
     */
    public StackExchangeSite getSiteService(final String site) {
        return builder
            .setRequestInterceptor(new RequestInterceptor() {
                public void intercept(RequestFacade request) {
                    request.addQueryParam("site", site);
                    request.addQueryParam("pagesize", "100");
                    request.addQueryParam("fromdate", de);
                    request.addQueryParam("todate", ate);
                    request.addQueryParam("sort", "creation");
                    request.addQueryParam("order", "desc");
                    request.addQueryParam("tagged", "java");
                    request.addQueryParam("key", key);
                    request.addQueryParam("access_token", accessToken);
                    request.addQueryParam("filter", "c*65v.ppToRvQ1LyNaG30spXwQLmiAxD*("); //  filter questions
                }
            })
            .build()
            .create(StackExchangeSite.class);
    }
    
    /**
     * Obter perguntas para dataset, inclui filtros para Tags
     * 
     * @param site
     * @return
     */
    public StackExchangeSite getSiteService(final String site, String nameParam, String value) {
        return builder
            .setRequestInterceptor(new RequestInterceptor() {
                public void intercept(RequestFacade request) {
                    request.addQueryParam("site", site);
                    request.addQueryParam(nameParam, value);
                    request.addQueryParam("key", key);
                    request.addQueryParam("access_token", accessToken);
                }
            })
            .build()
            .create(StackExchangeSite.class);
    }
    
    public StackExchangeSite getSiteService(final String site, String tagged) {
        return builder
            .setRequestInterceptor(new RequestInterceptor() {
                public void intercept(RequestFacade request) {
                    request.addQueryParam("site", site);
                    request.addQueryParam("sort", "creation");
                    request.addQueryParam("order", "desc");
                    request.addQueryParam("tagged", tagged);
                    request.addQueryParam("key", key);
                    request.addQueryParam("access_token", accessToken);
                    request.addQueryParam("filter", "c*65v.ppToRvQ1LyNaG30spXwQLmiAxD*("); //  filter questions
                }
            })
            .build()
            .create(StackExchangeSite.class);
    }
}
