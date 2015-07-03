package com.google.android.gms.plus.sample.quickstart;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class SearchActivity extends Activity implements View.OnClickListener {

    private EditText eSearchField;
    private Button bSearch;
    private int searchType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        eSearchField = (EditText) findViewById(R.id.search_edit_text);
        bSearch = (Button) findViewById(R.id.search_button);

        bSearch.setOnClickListener(this);
        // po czym mam szukać ? (autor/title)
        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            searchType = extras.getInt("typ");
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);
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
//        String searchText = eSearchField.getText().toString();
        String searchText = "Twain";
        HttpHelper httpHelper = new HttpHelper();
        String url = null;
        if (!"".equals(searchText)){
            if(searchType == MenuActivity.AUTHOR_SEARCH)
                url = HttpHelper.getBooksUrl(searchText, MenuActivity.AUTHOR_SEARCH);
            else if (searchType == MenuActivity.TITLE_SEARCH)
                url = HttpHelper.getBooksUrl(searchText, MenuActivity.TITLE_SEARCH);
        }
        httpHelper.getBooksFromUrl(url);
    }
}
