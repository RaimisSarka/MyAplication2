package com.example.raisar.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.raisar.myapplication.utils.EilutesObj;
import com.example.raisar.myapplication.utils.Utilitys;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public String mVardas;
    public String mPavarde;
	

    private TextView mVardasTextView;
    private TextView mPavardeTextView;

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;

    private List<EilutesObj> mEiluciuSarasas = new ArrayList<>();

    private Button mSetName;
    Utilitys util = new Utilitys();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recView);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //TODO (1) Sukurti adapteri
        mAdapter = new EilutesAdapteris(mEiluciuSarasas);
        mRecyclerView.setAdapter(mAdapter);

        sudarytiSarasas();

        setNamesToViews();
        Button bSecActivity = (Button) findViewById(R.id.buttonNextActivity);
        bSecActivity.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent startSecondActivityIntent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(startSecondActivityIntent);
            }
        });
    }

    public void sudarytiSarasas(){
        EilutesObj obj = new EilutesObj("Vienas", "Du", "Trys");
        mEiluciuSarasas.add(obj);

        obj = new EilutesObj("Eins", "Zwei", "Drei");
        mEiluciuSarasas.add(obj);

        obj = new EilutesObj("One", "Two", "Three");
        mEiluciuSarasas.add(obj);

        mAdapter.notifyDataSetChanged();
    }

    public void getNamesFromUtilsObj(){
        mVardas = util.getName(util.VARDAS);
        mPavarde = util.getName(util.PAVARDE);
    }

    public void setNamesToViews(){
        getNamesFromUtilsObj();
        mVardasTextView = (TextView) findViewById(R.id.textViewVardas);
        mPavardeTextView = (TextView) findViewById(R.id.textViewPavarde);

        mVardasTextView.setText(mVardas);
        mPavardeTextView.setText(mPavarde);
    }

    public void SetMyName(View view) {
        util.setName(getResources().getString(R.string.mano_vardas), getResources().getString(R.string.mano_pavarde));
        setNamesToViews();
    }
}
