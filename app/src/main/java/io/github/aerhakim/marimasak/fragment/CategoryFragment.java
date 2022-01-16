package io.github.aerhakim.marimasak.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import io.github.aerhakim.marimasak.R;
import io.github.aerhakim.marimasak.activity.CategoryActivity;
import io.github.aerhakim.marimasak.activity.SearchActivity;


public class CategoryFragment extends Fragment implements View.OnClickListener  {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater
                .inflate( R.layout.fragment_category, container, false);

        return view;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        CardView seafood = (CardView) getActivity().findViewById(
                R.id.seafood);
        seafood.setOnClickListener((View.OnClickListener) this);

        CardView makanandaging = (CardView) getActivity().findViewById(
                R.id.makanandaging);
        makanandaging.setOnClickListener((View.OnClickListener) this);

        CardView makanandesert = (CardView) getActivity().findViewById(
                R.id.makanandesert);
        makanandesert.setOnClickListener((View.OnClickListener) this);

        CardView masakansayuran = (CardView) getActivity().findViewById(
                R.id.masakansayuran);
        masakansayuran.setOnClickListener((View.OnClickListener) this);

        CardView makananayam = (CardView) getActivity().findViewById(
                R.id.makananayam);
        makananayam.setOnClickListener((View.OnClickListener) this);

        CardView makanansarapan = (CardView) getActivity().findViewById(
                R.id.makanansarapan);
        makanansarapan.setOnClickListener((View.OnClickListener) this);

        CardView masakanhariraya = (CardView) getActivity().findViewById(
                R.id.masakanhariraya);
        masakanhariraya.setOnClickListener((View.OnClickListener) this);

        CardView makanantradisional = (CardView) getActivity().findViewById(
                R.id.makanantradisional);
        makanantradisional.setOnClickListener((View.OnClickListener) this);

        CardView makansiang = (CardView) getActivity().findViewById(
                R.id.makansiang);
        makansiang.setOnClickListener((View.OnClickListener) this);

        CardView makanMalam = (CardView) getActivity().findViewById(
                R.id.makanMalam);
        makanMalam.setOnClickListener((View.OnClickListener) this);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.seafood) {
            Intent mIntent = new Intent(getActivity(), CategoryActivity.class);
            mIntent.putExtra("key", "resep-seafood");
            mIntent.putExtra("name", "Resep Seafood");
            startActivity(mIntent);
        } else if (v.getId() == R.id.makanandaging) {
            Intent mIntent = new Intent(getActivity(), CategoryActivity.class);
            mIntent.putExtra("key", "resep-daging");
            mIntent.putExtra("name", "Resep Daging");
            startActivity(mIntent);
        } else if (v.getId() == R.id.makanandesert) {
            Intent mIntent = new Intent(getActivity(), CategoryActivity.class);
            mIntent.putExtra("key", "resep-dessert");
            mIntent.putExtra("name", "Dessert");
            startActivity(mIntent);
        } else if (v.getId() == R.id.masakansayuran) {
            Intent mIntent = new Intent(getActivity(), CategoryActivity.class);
            mIntent.putExtra("key", "resep-sayuran");
            mIntent.putExtra("name", "Resep Sayuran");
            startActivity(mIntent);
        } else if (v.getId() == R.id.makananayam) {
            Intent mIntent = new Intent(getActivity(), CategoryActivity.class);
            mIntent.putExtra("key", "resep-ayam");
            mIntent.putExtra("name", "Resep Ayam");
            startActivity(mIntent);
        } else if (v.getId() == R.id.makanansarapan) {
            Intent mIntent = new Intent(getActivity(), CategoryActivity.class);
            mIntent.putExtra("key", "sarapan");
            mIntent.putExtra("name", "Sarapan");
            startActivity(mIntent);
        } else if (v.getId() == R.id.masakanhariraya) {
            Intent mIntent = new Intent(getActivity(), CategoryActivity.class);
            mIntent.putExtra("key", "masakan-hari-raya");
            mIntent.putExtra("name", "Masakan Hari Raya");
            startActivity(mIntent);
        } else if (v.getId() == R.id.makanantradisional) {
            Intent mIntent = new Intent(getActivity(), CategoryActivity.class);
            mIntent.putExtra("key", "masakan-tradisional");
            mIntent.putExtra("name", "Masakan Tradisional");
            startActivity(mIntent);
        } else if (v.getId() == R.id.makansiang) {
            Intent mIntent = new Intent(getActivity(), CategoryActivity.class);
            mIntent.putExtra("key", "makan-siang");
            mIntent.putExtra("name", "Menu Makan Siang");
            startActivity(mIntent);
        } else if (v.getId() == R.id.makanMalam) {
            Intent mIntent = new Intent(getActivity(), CategoryActivity.class);
            mIntent.putExtra("key", "makan-malam");
            mIntent.putExtra("name", "Menu Makan Malam");
            startActivity(mIntent);
        }
    }
}