package br.edu.ifpb.analyserTitle.stackExchangeAPI;

import retrofit.http.GET;
import br.edu.ifpb.analyserTitle.stackExchangeAPI.entities.types.Question;
import br.edu.ifpb.analyserTitle.stackExchangeAPI.entities.types.Tag;
import br.edu.ifpb.analyserTitle.stackExchangeAPI.entities.types.User;

public interface StackExchangeSite {

    public static final String STACK_OVERFLOW = "pt.stackoverflow";

    @GET("/users")
    Response<User> getUsers();

    @GET("/me")
    Response<User> getUser();
    
    @GET("/questions")
    Response<Question> getQuestions();
    
    @GET("/search")
    Response<Question> search();
    
    @GET("/tags")
    Response<Tag> getTags();

}	
