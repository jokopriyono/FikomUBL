package id.ac.budiluhur.fikom.fikomubl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

public class DetailBrochureActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private WebView webView;
    private ImageView imgJudul, imgTestimoni;
    private String KEY = "konten";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_brochure);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        webView = (WebView)findViewById(R.id.webview);
        imgJudul = (ImageView)findViewById(R.id.img_judul);
        imgTestimoni = (ImageView)findViewById(R.id.img_testimoni);

        String cek = getIntent().getStringExtra(KEY);
        switch (cek){
            case "1":
                imgTestimoni.setVisibility(View.VISIBLE);
                imgTestimoni.setImageResource(R.drawable.testimoni);
                break;
            case "2":
                imgJudul.setVisibility(View.VISIBLE);
                webView.loadData("<html><body>"+getString(R.string.brochure_broadcast)+"</body></html>","text/html","utf-8");
                imgJudul.setImageResource(R.drawable.v_judul_broadcast);
                break;
            case "3":
                imgJudul.setVisibility(View.VISIBLE);
                webView.loadData("<html><body>"+getString(R.string.brochure_public)+"</body></html>","text/html","utf-8");
                imgJudul.setImageResource(R.drawable.v_judul_public);
                break;
            case "4":
                imgJudul.setVisibility(View.VISIBLE);
                webView.loadData("<html><body>"+getString(R.string.brochure_visual)+"</body></html>","text/html","utf-8");
                imgJudul.setImageResource(R.drawable.v_judul_visual);
                break;
            case "5":
                imgJudul.setVisibility(View.VISIBLE);
                webView.loadData("<html><body>"+getString(R.string.brochure_digital)+"</body></html>","text/html","utf-8");
                imgJudul.setImageResource(R.drawable.v_judul_digital);
                break;
            case "6":
                imgJudul.setVisibility(View.VISIBLE);
                webView.loadData("<html><body>"+getString(R.string.brochure_newmedia)+"</body></html>","text/html","utf-8");
                imgJudul.setImageResource(R.drawable.v_judul_newmedia);
                break;
        }
    }
}
