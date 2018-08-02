package droidwindow.rainbow.com.droidwindow;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Browser extends AppCompatActivity {
    WebView brow;
    EditText url_text;
    Button go,forward,back,reload,clear;
    ProgressBar progressBar;
    String url="https://www.google.com";
    String CurrentUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);

        brow=(WebView)findViewById(R.id.wv_brow);
        url_text=(EditText)findViewById(R.id.et_url);
        go=(Button)findViewById(R.id.btn_go);
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
        CurrentUrl=brow.getUrl();
        url_text.setText(CurrentUrl);

        final InputMethodManager imm=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromInputMethod(url_text.getWindowToken(),0);

        url_text.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if(i== EditorInfo.IME_NULL)
                    go.performClick();
                return false;
            }
        });

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                url=url_text.getText().toString();
                if(!url.contains("www"))
                    url="www."+url;
                if(!(url.startsWith("http://")||url.startsWith("https://")))
                    url="http://"+url;

                brow.loadUrl(url);
                CurrentUrl=brow.getUrl();
                url_text.setText(CurrentUrl);
                imm.hideSoftInputFromInputMethod(url_text.getWindowToken(),0);
            }
        });

        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(brow.canGoForward())
                    brow.goForward();
                CurrentUrl=brow.getUrl();
                url_text.setText(CurrentUrl);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(brow.canGoBack())
                    brow.goBack();
                CurrentUrl=brow.getUrl();
                url_text.setText(CurrentUrl);
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
