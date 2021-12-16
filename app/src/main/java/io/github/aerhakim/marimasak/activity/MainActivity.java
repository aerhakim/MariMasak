package io.github.aerhakim.marimasak.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import dev.shreyaspatil.MaterialDialog.MaterialDialog;
import dev.shreyaspatil.MaterialDialog.interfaces.DialogInterface;
import io.github.aerhakim.marimasak.R;
import io.github.aerhakim.marimasak.database.Resep;
import io.github.aerhakim.marimasak.fragment.CategoryFragment;
import io.github.aerhakim.marimasak.fragment.HomeFragment;
import io.github.aerhakim.marimasak.fragment.SaveFragment;
import io.github.aerhakim.marimasak.fragment.SettingFragment;

public class MainActivity extends AppCompatActivity {
    ChipNavigationBar chipNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chipNavigationBar = findViewById(R.id.navigation);
        chipNavigationBar.setItemSelected(R.id.home, true);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment = null;
                switch (i) {
                    case R.id.home:
                        fragment = new HomeFragment();
                        break;

                    case R.id.category:
                        fragment = new CategoryFragment();
                        break;

                    case R.id.favourite:
                        fragment = new SaveFragment();
                        break;
                    case R.id.setting:
                        fragment = new SettingFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            }
        });
    }

    @Override
    public void onBackPressed() {

        MaterialDialog mDialog = new MaterialDialog.Builder(this)
                .setTitle("Ingin Keluar?")
                .setMessage("Apakah Anda ingin keluar dari Mari Masak?")
                .setCancelable(false)
                .setPositiveButton("Keluar", R.drawable.ic_baseline_exit_to_app_24, new MaterialDialog.OnClickListener() {


                    @Override
                    public void onClick(dev.shreyaspatil.MaterialDialog.interfaces.DialogInterface dialogInterface, int which) {
                        MainActivity.super.onBackPressed();
                    }
                })
                .setNegativeButton("Batal", R.drawable.ic_baseline_close_24, new MaterialDialog.OnClickListener() {


                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        dialogInterface.dismiss();
                    }
                })
                .build();
        // Show Dialog
        mDialog.show();

    }
}