package com.covid19.demo.util;

import com.covid19.demo.json.model.CovidData;
import com.covid19.demo.json.model.CovidTotalCountData;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Component
public class ApiCallsUtil {
  
  @Value("${get_covid_total_count}")
  private String covidTotalCountUrl;
  
  @Value("${get_covid_state_data}")
  private String covidStateDataUrl;
  
  public List<CovidData> getCovidStateData() throws IOException {
    OkHttpClient client = new OkHttpClient().newBuilder()
        .build();
    Request request = new Request.Builder()
        .url(covidStateDataUrl)
        .method("GET", null)
        .build();
    Response response = client.newCall(request).execute();
    ObjectMapper mapper =
        new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    List<CovidData> covidStateDataList =
        mapper.readValue(response.body().byteStream(), ArrayList.class);
    return covidStateDataList;
  }
  
  public CovidTotalCountData getCovidTotalCountData() throws IOException {
    OkHttpClient client = new OkHttpClient().newBuilder()
        .build();
    Request request = new Request.Builder()
        .url(covidTotalCountUrl)
        .method("GET", null)
        .build();
    Response response = client.newCall(request).execute();
    ObjectMapper mapper =
        new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    CovidTotalCountData covidTotalCountData =
        mapper.readValue(response.body().byteStream(), CovidTotalCountData.class);
    return covidTotalCountData;
  }
  
}
