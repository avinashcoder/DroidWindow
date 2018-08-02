package droidwindow.rainbow.com.droidwindow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class SocialSiteActivity extends AppCompatActivity {
    ImageButton facebook,twitter,gmail,googleplus,linkedin,instagram,youtube,pinterest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_site);
        facebook=(ImageButton)findViewById(R.id.facebook);
        twitter=(ImageButton)findViewById(R.id.twitter);
        gmail=(ImageButton)findViewById(R.id.gmail);
        googleplus=(ImageButton)findViewById(R.id.googleplus);
        linkedin=(ImageButton)findViewById(R.id.linkedin);
        instagram=(ImageButton)findViewById(R.id.instagram);
        youtube=(ImageButton)findViewById(R.id.youtube);
        pinterest=(ImageButton)findViewById(R.id.pinterest);

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SocialSiteActivity.this,AppBrowser.class);
                i.putExtra("url","https://www.facebook.com");
                startActivity(i);

            }
        });

        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SocialSiteActivity.this,AppBrowser.class);
                i.putExtra("url","https://www.twitter.com");
                startActivity(i);
            }
        });

        gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SocialSiteActivity.this,AppBrowser.class);
                i.putExtra("url","https://www.gmail.com");
                startActivity(i);
            }
        });

        pinterest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SocialSiteActivity.this,AppBrowser.class);
                i.putExtra("url","https://in.pinterest.com");
                startActivity(i);
            }
        });

        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SocialSiteActivity.this,AppBrowser.class);
                i.putExtra("url","https://www.youtube.com");
                startActivity(i);
            }
        });

        googleplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SocialSiteActivity.this,AppBrowser.class);
                i.putExtra("url","https://www.googleplus.com");
                startActivity(i);
            }
        });

        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SocialSiteActivity.this,AppBrowser.class);
                i.putExtra("url","https://www.instagram.com");
                startActivity(i);
            }
        });

        linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SocialSiteActivity.this,AppBrowser.class);
                i.putExtra("url","https://www.linkedin.com");
                startActivity(i);
            }
        });
    }
}
