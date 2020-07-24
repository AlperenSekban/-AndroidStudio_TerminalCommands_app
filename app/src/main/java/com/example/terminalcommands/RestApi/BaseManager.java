package com.example.terminalcommands.RestApi;

public class BaseManager {
    protected RestApi getRestApiClient(){
        RestApiClient restApiClient=new RestApiClient(BaseUrl.url);
        return restApiClient.getmRestApi();
    }
}
