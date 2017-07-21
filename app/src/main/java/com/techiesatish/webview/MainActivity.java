package com.techiesatish.webview;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    WebView webview;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressDialog = ProgressDialog.show(this, "Please Wait", "Loading...", true);
        webview = (WebView) findViewById(R.id.webview);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebChromeClient(new WebChromeClient());
        webview.setWebViewClient(new WebViewClient() {  //WebViewClient is an interface for responding to rendering events
            @Override
            public void onPageFinished(WebView view, String url) {
                if(progressDialog.isShowing() && progressDialog!=null)
                {
                    progressDialog.dismiss();
                }
            }
        });
        webview.loadUrl("http://www.techiesatish.com/");
    }
}