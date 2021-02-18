package com.fadv.myapplication.network;

import com.fadv.myapplication.dto.CountryDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Amit Rawat  on 18-02-2021.
 */
public interface Api {
    String BaseURL = "https://restcountries.eu/rest/v2/";

    @GET("all")
    Call<List<CountryDTO>> getCountry();
}
