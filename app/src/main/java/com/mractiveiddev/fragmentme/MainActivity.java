package com.mractiveiddev.fragmentme;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ListFrag.ItemSelected {

    TextView tvDescription;
    String [] description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDescription = findViewById(R.id.tvDescription);

        description = getResources().getStringArray(R.array.descriptions);

        //tampilan layar phone menjadi portrat
        if (findViewById(R.id.layout_portrait) != null)
        {
            FragmentManager manager = this.getSupportFragmentManager();

            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.detileFrag))
                    .show(manager.findFragmentById(R.id.listFrag))
                    .commit();
        }
        //tampilan layar phone menjadi landscap
        if (findViewById(R.id.layout_land)!= null)
        {
            FragmentManager manager = this.getSupportFragmentManager();

            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.detileFrag))
                    .show(manager.findFragmentById(R.id.listFrag))
                    .commit();
        }

    }

    @Override
    public void onItemSelected(int index) {
        tvDescription.setText(description [index]);

        //tampilan layar phone menjadi portrat untuk dapat di klik
        if (findViewById(R.id.layout_portrait) != null)
        {
            FragmentManager manager = this.getSupportFragmentManager();

            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.detileFrag))
                    .hide(manager.findFragmentById(R.id.listFrag))
                    .addToBackStack(null)
                    .commit();
        }
    }
}