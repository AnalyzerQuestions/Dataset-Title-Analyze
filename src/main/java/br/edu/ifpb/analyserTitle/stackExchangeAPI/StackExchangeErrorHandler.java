package br.edu.ifpb.analyserTitle.stackExchangeAPI;

import retrofit.ErrorHandler;
import retrofit.RetrofitError;

public class StackExchangeErrorHandler implements ErrorHandler {

    public Throwable handleError(RetrofitError error) {
        return error;
    }

}
