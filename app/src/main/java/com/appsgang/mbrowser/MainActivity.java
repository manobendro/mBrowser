package com.appsgang.mbrowser;

import android.net.UrlQuerySanitizer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity implements MBWebInterface{


    public static String TAG = "manob";
    UrlQuerySanitizer sanitizer = new UrlQuerySanitizer();
    private WebView my_web_view;
    private WebSettings my_web_setting;
    private ProgressBar webViewProgress;
    private MBWebViewClient mbWebViewClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        my_web_view = (WebView) findViewById(R.id.webview);
        my_web_setting = my_web_view.getSettings();

        webViewProgress = (ProgressBar) findViewById(R.id.webview_content_progress);
        mbWebViewClient = new MBWebViewClient(this,this);

        my_web_setting.setJavaScriptEnabled(true);
        my_web_setting.setAppCacheEnabled(true);
        my_web_setting.setDatabaseEnabled(true);
        my_web_setting.setAllowFileAccessFromFileURLs(true);
        my_web_setting.setAllowUniversalAccessFromFileURLs(true);
        my_web_setting.setJavaScriptCanOpenWindowsAutomatically(true);
        my_web_setting.setDomStorageEnabled(true);
        my_web_setting.setLoadWithOverviewMode(true);
        my_web_setting.setPluginState(WebSettings.PluginState.ON);
        my_web_setting.setLoadsImagesAutomatically(true);
        my_web_setting.setUseWideViewPort(true);


        //my_web_setting.setMediaPlaybackRequiresUserGesture(true);
        //webViewProgress.setProgress(34);
        my_web_view.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);

                if (newProgress == 100) {
                    webViewProgress.setVisibility(View.INVISIBLE);
                } else {

                    Log.d("manob", "Progress: " + newProgress);

                    webViewProgress.setVisibility(View.VISIBLE);
                    webViewProgress.setProgress(newProgress);
                }


            }
        });
        my_web_view.setWebViewClient(mbWebViewClient);

        my_web_view.loadUrl("https://www.google.com");
    }

    @Override
    public void onResourceLoaded(WebView view, String url) {
        Log.d(TAG,"url:"+url);
    }
}
