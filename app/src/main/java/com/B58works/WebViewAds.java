package com.B58works;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Bharath.R(58) on 28-12-2017.
 */

public class WebViewAds extends WebView
{
    Context c;

    public WebViewAds(final Context c) {
        super(c);
        this.c = c;
        this.init();
    }

    public WebViewAds(final Context c, final AttributeSet set) {
        super(c, set);
        this.c = c;
        this.init();
    }

    public WebViewAds(final Context c, final AttributeSet set, final int n) {
        super(c, set, n);
        this.c = c;
        this.init();
    }

    @SuppressLint({ "NewApi" })
    public void init() {
        while (true) {
            try {
                if (Build.VERSION.SDK_INT >= 11) {
                    this.setBackgroundColor(0);
                    this.setLayerType(1, null);
                }
                this.setWebViewClient(new nbi(this));
                try {
                    if (B58.isOnline(this.getContext())) {
                        this.getSettings().setJavaScriptEnabled(true);
                        this.loadUrl("http://tempohari.com/wp-content/uploads/ads1.html");
                    }
                    else {
                        this.loadUrl("file:///android_asset/B58.html");
                    }
                }
                catch (Exception ex) {
                    this.loadUrl("file:///android_asset/B58.html");
                }
            }
            catch (Exception ex2) {
                continue;
            }
            break;
        }
    }

    class nbi extends WebViewClient
    {
        final WebViewAds w;

        nbi(final WebViewAds w) {
            this.w = w;
        }

        public void onReceivedError(final WebView webView, final int n, final String s, final String s2) {
            super.onReceivedError(webView, n, s, s2);
            this.w.loadUrl("file:///android_asset/B58.html");
        }
    }
}

