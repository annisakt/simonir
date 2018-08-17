package com.example.annis.apps;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
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
import com.example.annis.apps.modal.AdapterMonitoring;
import com.example.annis.apps.modal.DataMonitoring;

import java.util.ArrayList;
import java.util.Arrays;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by annis on 04/05/2018.
 */

public class Monitoring extends Fragment {
    View v;
    public ArrayList<DataMonitoring> data;
    private AdapterMonitoring adapter;
    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getActivity().setTitle("Monitoring");

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_monitoring, container, false);
        recyclerView = (RecyclerView)rootView.findViewById(R.id.listmonitoring);
        recyclerView.setHasFixedSize(true);
        AdapterMonitoring monitoringAdapter = new AdapterMonitoring(getContext(), data);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(monitoringAdapter);
        swipeRefreshLayout =(SwipeRefreshLayout)rootView.findViewById(R.id.swipe);
        loadJSON();
        final int speedScroll = 10000;
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            int count = 0;
            @Override
            public void run() {
            loadJSON();
            handler.postDelayed(this, speedScroll);
            }
        };

        handler.postDelayed(runnable,speedScroll);
        return rootView;
    }

    private void loadJSON() {
        swipeRefreshLayout.setRefreshing(true);
        ApiService service = UtilsApi.getClient().create(ApiService.class);
        Call<JsonList> call = service.getRekap("http://simonir.com/api/get_datarekap.php");
        call.enqueue(new Callback<JsonList>() {
            @Override
            public void onResponse(Call<JsonList> call, Response<JsonList> response) {
                swipeRefreshLayout.setRefreshing(false);
                JsonList jsonResponse = response.body();
                data = new ArrayList<>(Arrays.asList(jsonResponse.getMonitoring()));
                adapter = new AdapterMonitoring(getContext(), data);
                recyclerView.setAdapter(adapter);
                Toast.makeText(getContext(), "data berhasil", Toast.LENGTH_LONG).show();
                Log.d("data", data.get(0).getKetinggian());
            }
            @Override
            public void onFailure(Call<JsonList> call, Throwable t) {
                Log.d("Error", t.getMessage());
//                Toast.makeText(getContext(), "data eror", Toast.LENGTH_LONG).show();
            }

        });

    }
}
