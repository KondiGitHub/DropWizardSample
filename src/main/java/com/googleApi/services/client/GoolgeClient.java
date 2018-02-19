package com.googleApi.services.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.googleApi.model.dto.google_news.GoogleResponse;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import java.io.IOException;

public class GoolgeClient {

    private String endPoint;
    private String apiKey;
    private Client httpClient;
    private  ObjectMapper mapper;
    public GoolgeClient(String endPoint, String apiKey, Client httpClient) {
        this.endPoint = endPoint;
        this.apiKey = apiKey;
        this.httpClient = ClientBuilder.newClient();
        this.mapper = new ObjectMapper();
    }

    public GoogleResponse getGoogleNews() throws IOException {

        Response response = httpClient
                .target(endPoint)
                .queryParam("sources","google-news")
                .queryParam("apiKey",apiKey)
                .request()
                .get();
//JSON from file to Object
        GoogleResponse googleResponse = mapper.readValue(response.readEntity(String.class), GoogleResponse.class);

       return googleResponse;
    }

    public GoogleResponse getGoogleSearchResults(String searchStr) throws IOException {

        Response response = httpClient
                .target(endPoint)
                .queryParam("q",searchStr)
                .queryParam("apiKey",apiKey)
                .request()
                .get();
        GoogleResponse googleResponse = mapper.readValue(response.readEntity(String.class), GoogleResponse.class);

        return googleResponse;
    }
}
