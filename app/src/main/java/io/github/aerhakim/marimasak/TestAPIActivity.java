package io.github.aerhakim.marimasak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

public class TestAPIActivity extends AppCompatActivity {

    SearchView edText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        setContentView(R.layout.activity_test_apiactivity);
        edText = findViewById(R.id.search_bar);
        edText.requestFocus();
    }
}