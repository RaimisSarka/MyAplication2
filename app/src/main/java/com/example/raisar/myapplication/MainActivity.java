package com.example.raisar.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.raisar.myapplication.utils.EilutesObj;
import com.example.raisar.myapplication.utils.Utilitys;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String PREF_NAME = "MyPrefName";

    //Keys for SharedPreferences
    public static final String NAME_KEY = "NamePrefData";
    public static final String LASTNAME_KEY = "LastnamePrefData";


    public String mVardas;
    public String mPavarde;

    private TextView mVardasTextView;
    private TextView mPavardeTextView;

    private EditText mNameEditText;
    private EditText mLastNameEditText;

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

        mAdapter = new EilutesAdapteris(mEiluciuSarasas);
        mRecyclerView.setAdapter(mAdapter);

        sudarytiSarasas();

        SharedPreferences savedData = getSharedPreferences(PREF_NAME, 0);
        mVardas = savedData.getString(NAME_KEY, null);
        mPavarde = savedData.getString(LASTNAME_KEY, null);
        setNamesToViews(mVardas, mPavarde);

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

    public void setNamesToViews(String mName, String mLastname){
        //getNamesFromUtilsObj();
        mVardasTextView = (TextView) findViewById(R.id.textViewVardas);
        mPavardeTextView = (TextView) findViewById(R.id.textViewPavarde);

        mVardasTextView.setText(mName);
        mPavardeTextView.setText(mLastname);
    }

    //onClick from layout
    public void SetMyName(View view) {

        EditText getName = (EditText) findViewById(R.id.editTextName);
        EditText getLastName = (EditText) findViewById(R.id.editTextLastName);

        String name = getName.getText().toString();
        String lastName = getLastName.getText().toString();
        
        if (!name.equals("") && !lastName.equals("")){
            util.setName(name, lastName);
            mVardas = name;
            mPavarde = lastName;
        } else {
            if (mVardas.equals("") && mPavarde.equals("")) {
                util.setName(getResources().getString(R.string.mano_vardas), getResources().getString(R.string.mano_pavarde));
            }
        }

        setNamesToViews(mVardas, mPavarde);
    }

    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences saveData = getSharedPreferences(PREF_NAME, 0);
        SharedPreferences.Editor editor = saveData.edit();
        editor.putString(NAME_KEY, mVardas);
        editor.putString(LASTNAME_KEY, mPavarde);

        editor.commit();
    }
}
