package com.google.android.gms.plus.sample.quickstart;

import android.os.AsyncTask;

import com.squareup.okhttp.Headers;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by fares on 7/3/15.
 */
public class HttpHelper {

    private static final String URL = "https://www.googleapis.com/books/v1/volumes?";
    private static OkHttpClient client;

    public static String getBooksUrl(String term, int typeSearch){
        String finalUrl = URL;
        if (typeSearch == MenuActivity.TITLE_SEARCH){
            finalUrl += "q=" + term;
        }
        if (typeSearch == MenuActivity.AUTHOR_SEARCH){
            finalUrl += "q=+inauthor:" + term;
        }
//        if (!"".equals(author)){
//            finalUrl += "q=" + author;
//            if (!"".equals(title)){
//                finalUrl += "+inauthor:" + author;
//            }
//        }
//        if (!"".equals(title)){
//            finalUrl += "q=+inauthor:" + author;
//        }

        return finalUrl;
    }

    public void getBooksFromUrl(String url){
        client = new OkHttpClient();
        try {
            new GetJsonTask().execute(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class GetJsonTask extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... params) {
            Request request = new Request.Builder()
                    .url(params[0])
                    .build();

            Response response = null;
            try {
                response = client.newCall(request).execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (!response.isSuccessful()) try {
                throw new IOException("Unexpected code " + response);
            } catch (IOException e) {
                e.printStackTrace();
            }

            Headers responseHeaders = response.headers();
            for (int i = 0; i < responseHeaders.size(); i++) {
                System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
            }

            try {
                System.out.println(response.body().string());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
