package com.example.annis.apps;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.annis.apps.api.ApiService;
import com.example.annis.apps.api.JsonList;
import com.example.annis.apps.api.UtilsApi;
import com.example.annis.apps.modal.AdapterSungai;
import com.example.annis.apps.modal.DataSungai;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Sungai extends Fragment {
    View v;
    public ArrayList<DataSungai> data;
    private AdapterSungai adapter;
    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("Data Sungai");


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_sungai, container, false);
        recyclerView = (RecyclerView)rootView.findViewById(R.id.listdata);
        recyclerView.setHasFixedSize(true);
        AdapterSungai monitoringAdapter = new AdapterSungai(getContext(), data);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(monitoringAdapter);
        swipeRefreshLayout = (SwipeRefreshLayout)rootView.findViewById(R.id.swipe);
        loadJSON();
        return rootView;
    }

    private void loadJSON() {
        swipeRefreshLayout.setRefreshing(true);
        ApiService service = UtilsApi.getClient().create(ApiService.class);
        Call<JsonList> call = service.getData("http://simonir.com/api/get_datasungai.php");
        call.enqueue(new Callback<JsonList>() {
            @Override
            public void onResponse(Call<JsonList> call, Response<JsonList> response) {
                swipeRefreshLayout.setRefreshing(false);
                JsonList jsonResponse = response.body();
                data = new ArrayList<>(Arrays.asList(jsonResponse.getSungai()));
                adapter = new AdapterSungai(getActivity().getApplicationContext(), data);
                recyclerView.setAdapter(adapter);
                Toast.makeText(getContext(), "data berhasil", Toast.LENGTH_LONG).show();
                Log.d("data", data.get(0).getNamaSungai());
            }
            @Override
            public void onFailure(Call<JsonList> call, Throwable t) {
//                Log.d("Error", t.getMessage());
//                Toast.makeText(getContext(), "data eror", Toast.LENGTH_LONG).show();
            }

        });

    }
}
