package com.google.android.gms.plus.sample.quickstart;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MenuActivity extends Activity implements View.OnClickListener{

    public static final int AUTHOR_SEARCH = 0;
    public static final int TITLE_SEARCH  = 1;

    private Button bSearchAuthors;
    private Button bSearchTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        bSearchAuthors = (Button) findViewById(R.id.authors_button);
        bSearchTitle= (Button) findViewById(R.id.titles_button);

        bSearchAuthors.setOnClickListener(this);
        bSearchTitle.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.authors_button)
            startSearchActivity(AUTHOR_SEARCH);
        if (id == R.id.titles_button)
            startSearchActivity(TITLE_SEARCH);
    }

    private void startSearchActivity(int type){
        Intent intent = new Intent(this, SearchActivity.class);
        Bundle b = new Bundle();
        b.putInt("typ", type); //Your id
        intent.putExtras(b); //Put your id to your next Intent
        startActivity(intent);
        finish();
    }
}
