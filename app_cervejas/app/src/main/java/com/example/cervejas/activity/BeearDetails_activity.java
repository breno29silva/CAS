package com.example.cervejas.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cervejas.R;
import com.example.cervejas.model.Beer;
import com.example.cervejas.utils.Images;

public class BeearDetails_activity extends AppCompatActivity {

    private TextView title;
    private TextView subTitle;
    private TextView description;
    private Beer beerSelected;
    private ImageView imageViewBeer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beear_details_activity);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        title = findViewById(R.id.textViewTitle);
        subTitle = findViewById(R.id.textViewSubTitle);
        description = findViewById(R.id.textViewDescription);
        imageViewBeer = findViewById(R.id.imageViewBeer);


        //Recuperando dados
        beerSelected = (Beer) getIntent().getSerializableExtra("selectBeer");

        //Carregando informacoes
        title.setText(beerSelected.getName());
        subTitle.setText(beerSelected.getTagline());
        description.setText(beerSelected.getDescription());
        Images.showImages(imageViewBeer, beerSelected.getImage_url());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }
        return true;
    }
}

