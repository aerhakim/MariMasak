package io.github.aerhakim.marimasak.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;
import java.util.List;


import dev.shreyaspatil.MaterialDialog.MaterialDialog;
import dev.shreyaspatil.MaterialDialog.interfaces.DialogInterface;
import io.github.aerhakim.marimasak.R;
import io.github.aerhakim.marimasak.activity.MainActivity;
import io.github.aerhakim.marimasak.adapter.CategoryAdapter;
import io.github.aerhakim.marimasak.adapter.RecipeAdapter;
import io.github.aerhakim.marimasak.database.AppDatabase;
import io.github.aerhakim.marimasak.database.Resep;
import io.github.aerhakim.marimasak.database.adapter.ResepAdapter;
import io.github.aerhakim.marimasak.models.Category;
import io.github.aerhakim.marimasak.models.GetCategory;
import io.github.aerhakim.marimasak.models.GetRecipe;
import io.github.aerhakim.marimasak.models.Recipe;
import io.github.aerhakim.marimasak.utils.api.Config;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SaveFragment extends Fragment {
    private RecyclerView recyclerView;
    private AppDatabase database;
    private ResepAdapter resepAdapter;
    private List<Resep> list = new ArrayList<>();
    private AlertDialog.Builder dialog;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater
                .inflate( R.layout.fragment_save, container, false);

        recyclerView = view.findViewById(R.id.rv_fav);
        database = AppDatabase.getInstance(getActivity().getApplicationContext());
        list.clear();
        list.addAll(database.resepDao().getAll());
        resepAdapter = new ResepAdapter(getActivity().getApplicationContext(), list);
        resepAdapter.setDialog(new ResepAdapter.Dialog() {
            @Override
            public void onClick(int position) {
                MaterialDialog mDialog = new MaterialDialog.Builder(getActivity())
                        .setTitle("Hapus Resep?")
                        .setMessage("Apakah anda ingin menghapus resep?")
                        .setCancelable(false)
                        .setPositiveButton("Hapus", R.drawable.ic_baseline_delete_24, new MaterialDialog.OnClickListener() {


                            @Override
                            public void onClick(dev.shreyaspatil.MaterialDialog.interfaces.DialogInterface dialogInterface, int which) {
                                Resep resep = list.get(position);
                                database.resepDao().delete(resep);
                                onStart();
                                dialogInterface.dismiss();
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
        });
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(resepAdapter);

        return view;
    }
    @Override
    public void onStart() {
        super.onStart();
        list.clear();
        list.addAll(database.resepDao().getAll());
        resepAdapter.notifyDataSetChanged();
    }
}