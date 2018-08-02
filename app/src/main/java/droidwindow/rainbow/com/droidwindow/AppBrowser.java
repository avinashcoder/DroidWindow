package droidwindow.rainbow.com.droidwindow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class AppBrowser extends AppCompatActivity {
    WebView brow;
    Button forward,back,reload,clear;
    ProgressBar progressBar;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_browser);
        Intent i=getIntent();
        url=(i.getStringExtra("url"));

        brow=(WebView)findViewById(R.id.wv_brow);
        forward=(Button)findViewById(R.id.forward);
        back=(Button)findViewById(R.id.back);
        reload=(Button)findViewById(R.id.reload);
        clear=(Button)findViewById(R.id.clear);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);

        brow.setWebViewClient(new WebViewClient());
        brow.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                progressBar.setProgress(newProgress);

                if(newProgress==100) {
                    progressBar.setVisibility(View.GONE);
                }
                else{
                    progressBar.setVisibility(View.VISIBLE);
                }
            }
        });

        brow.getSettings().setJavaScriptEnabled(true);
        brow.setVerticalScrollBarEnabled(false);
        brow.setHorizontalScrollBarEnabled(false);
        brow.loadUrl(url);

        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(brow.canGoForward())
                    brow.goForward();

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(brow.canGoBack()) {
                    brow.goBack();
                }
                else{
                    Intent i=new Intent(AppBrowser.this,SocialSiteActivity.class);
                    startActivity(i);
                }

            }
        });

        reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                brow.reload();

            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                brow.clearHistory();
                Toast.makeText(getApplicationContext(),"History Cleared",Toast.LENGTH_LONG).show();

            }
        });

    }
}
