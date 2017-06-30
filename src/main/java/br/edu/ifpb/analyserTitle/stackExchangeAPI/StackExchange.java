package br.edu.ifpb.analyserTitle.stackExchangeAPI;

import br.edu.ifpb.analyserTitle.stackExchangeAPI.entities.types.Filter;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

public interface StackExchange {


    @POST("/filters/create")
    Response<Filter> createFilter(@Query("unsafe") boolean unsafe);


    @GET("/filters/{filters}")
    Response<Filter> getFilters(@Path("filters") String filters);


    @GET("/errors")
    Response<Error> getErrors();

}
