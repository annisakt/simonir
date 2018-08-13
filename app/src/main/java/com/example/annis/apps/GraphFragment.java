package com.example.annis.apps;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.example.annis.apps.modal.AdapterMonitoring;
import com.example.annis.apps.modal.DataMonitoring;
import java.util.ArrayList;

public class GraphFragment extends Fragment implements ViewTreeObserver.OnGlobalLayoutListener {

    SwipeRefreshLayout swipeRefreshLayout;
    WebView webView;
    WebSettings webSettings;
    Typeface mTfLight;
    public ArrayList<DataMonitoring> data;
    private AdapterMonitoring adapter;
   String URL = "http://google.com";

    public GraphFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_graph, container, false);
        webView = (WebView) rootView.findViewById(R.id.web_view);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(URL);
        webView.setHorizontalScrollBarEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.setInitialScale(120);
        webView.getSettings().setLoadWithOverviewMode(false);
        webView.getSettings().setUseWideViewPort(true);
        return rootView;
    }

    @Override
    public void onGlobalLayout() {
        webView.layout(50, 50, 1024 - 50, 600 - 50);
    }
}