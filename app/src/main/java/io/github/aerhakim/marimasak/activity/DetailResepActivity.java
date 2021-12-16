package io.github.aerhakim.marimasak.activity;

import androidx.appcompat.app.AppCompatActivity;


import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.squareup.picasso.Picasso;

import java.security.PublicKey;
import java.util.Arrays;
import java.util.List;

import io.github.aerhakim.marimasak.R;
import io.github.aerhakim.marimasak.adapter.RecipeAdapter;
import io.github.aerhakim.marimasak.database.AppDatabase;
import io.github.aerhakim.marimasak.models.Category;
import io.github.aerhakim.marimasak.models.ResultsResponse;
import io.github.aerhakim.marimasak.utils.api.Config;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DetailResepActivity extends AppCompatActivity {
    String kunci;
    LinearLayout llVisitWeb;
    NestedScrollView main;
    TextView detailJudul, detailWaktu, detailKesulitan, detailPorsi, detailDeskripsi, detailAuthor, bahan, step, itemName;
    ImageView detailGambar, detailItem, iv_save;
    ShimmerFrameLayout shimmerFrameLayout;
    EditText edtitle, edthumb, edkunci, edtimes, edportion, eddificulty;
    private AppDatabase database;
    private int uid = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_resep);
        shimmerFrameLayout = findViewById(R.id.shimmerLayout);
        main = findViewById(R.id.main);
        detailJudul = findViewById(R.id.tv_judul);
        detailWaktu = findViewById(R.id.tv_waktu);
        detailKesulitan = findViewById(R.id.tv_kesulitan);
        detailPorsi = findViewById(R.id.tv_porsi);
        detailDeskripsi = findViewById(R.id.tv_deskripsi);
        detailGambar = findViewById(R.id.iv_detail);
        detailItem = findViewById(R.id.thumb_item);
        itemName = findViewById(R.id.name_item);
        edtimes = findViewById(R.id.times);
        edthumb = findViewById(R.id.thumb);
        edkunci = findViewById(R.id.kunci);
        edportion = findViewById(R.id.portion);
        eddificulty = findViewById(R.id.dificulty);
        edtitle = findViewById(R.id.title);
        iv_save = findViewById(R.id.iv_save);
        detailAuthor = findViewById(R.id.tv_author);
        llVisitWeb = findViewById(R.id.btn_visit_web);
        bahan = findViewById(R.id.tv_bahan);
        step = findViewById(R.id.tv_step);
        edtitle.setText(getIntent().getStringExtra("title"));
        edtimes.setText(getIntent().getStringExtra("times"));
        edthumb.setText(getIntent().getStringExtra("thumb"));
        kunci = getIntent().getStringExtra("kunci");
        edkunci.setText(getIntent().getStringExtra("kunci"));
        edportion.setText(getIntent().getStringExtra("portion"));
        eddificulty.setText(getIntent().getStringExtra("dificulty"));
        LoadData();

        database = AppDatabase.getInstance(getApplicationContext());
        iv_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database.resepDao().insertAll(edtitle.getText().toString(), edthumb.getText().toString(), edtimes.getText().toString(),
                        edportion.getText().toString(), edkunci.getText().toString(), eddificulty.getText().toString());
                Toast.makeText(DetailResepActivity.this, "Berhasil Menyimpan Resep!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void LoadData() {
        Call<ResultsResponse> call = Config.getInstance().getApi().results(kunci);
        call.enqueue(new Callback<ResultsResponse>() {
            @Override
            public void onResponse(Call<ResultsResponse> call, Response<ResultsResponse> response) {
                shimmerFrameLayout.startShimmer();
                detailJudul.setText(response.body().getResults().getTitle());
                detailWaktu.setText(response.body().getResults().getTimes());
                detailKesulitan.setText(response.body().getResults().getDificulty());
                detailPorsi.setText(response.body().getResults().getServings());
                detailDeskripsi.setText(response.body().getResults().getDesc());
                detailDeskripsi.setText(response.body().getResults().getDesc());
                detailAuthor.setText(response.body().getResults().getAuthor().getUser());
                Glide.with(DetailResepActivity.this)
                        .load(response.body().getResults().getThumb())
                        .apply(new RequestOptions().override(400, 400))
                        .into(detailGambar);

                //Intent Baca Resep di browser
                llVisitWeb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String url = ("https://www.masakapahariini.com/resep/" + kunci);
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);
                    }
                });
                shimmerFrameLayout.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<ResultsResponse> call, Throwable t) {
                Log.d("Hasil", t.getMessage());
            }

        });
    }

}