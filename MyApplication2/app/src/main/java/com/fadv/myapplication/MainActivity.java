package com.fadv.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fadv.myapplication.adapter.MyListAdapter;
import com.fadv.myapplication.dto.CountryDTO;
import com.fadv.myapplication.network.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private List<CountryDTO> countryList;
    private RecyclerView recyclerView;
    private MyListAdapter adapter;
    ProgressBar progressBar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countryList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        progressBar1 = (ProgressBar) findViewById(R.id.progressBar1);
        adapter = new MyListAdapter(countryList, getApplicationContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        if (!NetworkUtils.isNetworkAvailable(getApplicationContext())) {
            try {
                Toast.makeText(getApplicationContext(), "Please check your internet connection", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                return;
            }
            return;
        } else {
            progressBar1.setVisibility(View.VISIBLE);
            getCountries();
        }

    }

    private void getCountries() {
        Call<List<CountryDTO>> call = RetrofitClient.getInstance().getMyApi().getCountry();
        call.enqueue(new Callback<List<CountryDTO>>() {
            @Override
            public void onResponse(Call<List<CountryDTO>> call, Response<List<CountryDTO>> response) {
                List<CountryDTO> listcountry = response.body();
                countryList.addAll(listcountry);
                progressBar1.setVisibility(View.GONE);
                Log.e("ada", String.valueOf(countryList.size()));
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<CountryDTO>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("error", t.getMessage());
            }
        });
    }
}