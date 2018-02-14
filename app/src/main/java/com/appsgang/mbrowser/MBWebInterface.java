package com.appsgang.mbrowser;

import android.webkit.WebView;

/**
 * Created by manobbiswas on 2/6/18.
 */

public interface MBWebInterface {
    void onResourceLoaded(WebView view, String url);
}
