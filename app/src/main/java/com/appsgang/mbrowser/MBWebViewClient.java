package com.appsgang.mbrowser;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.KeyEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by manobbiswas on 2/6/18.
 */

public class MBWebViewClient extends WebViewClient {

    private Context MBContext;
    private MBWebInterface mbWebInterface;

    public MBWebViewClient(Context MBContext,MBWebInterface mbWebInterface) {
        this.MBContext = MBContext;
        this.mbWebInterface = mbWebInterface;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        return super.shouldOverrideUrlLoading(view, request);
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
    }

    @Override
    public void onLoadResource(WebView view, String url) {

        super.onLoadResource(view, url);
        mbWebInterface.onResourceLoaded(view,url);
    }

    @Override
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {

        return super.shouldInterceptRequest(view, request);
    }

    @Override
    public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
        return super.shouldOverrideKeyEvent(view, event);
    }
}
