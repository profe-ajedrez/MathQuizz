package org.studio.jacobopus.mathquizz;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MainActivity extends AppCompatActivity {

    WebView webView;
    SwipeRefreshLayout swipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipe = (SwipeRefreshLayout) findViewById(R.id.swipe);
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                WebAction();
            }
        });
        WebAction();
    }

    public void WebAction() {
        this.webView = (WebView) findViewById(R.id.webView);
        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.getSettings().setAppCacheEnabled(true);
        this.webView.setWebChromeClient(new WebChromeClient());
        this.webView.getSettings().setDomStorageEnabled(true);     //DomStorageEnabled = true;

         webView.loadUrl("file:///android_asset/mathquizz/index.html"); //"text/html", "UTF-8", null);

        //this.webView.loadUrl("file:///android_asset/index.html");
        swipe.setRefreshing(true);
        this.webView.setWebViewClient(new WebViewClient(){

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

                view.loadUrl("file:///android_asset/mathquizz/error.html");

            }

            public void onPageFinished(WebView view, String url) {
                // do your stuff here
                swipe.setRefreshing(false);
            }

        });
    }

    @Override
    public void onBackPressed(){

        if (webView.canGoBack()){
            webView.goBack();
        }else {
            finish();
        }
    }
}
