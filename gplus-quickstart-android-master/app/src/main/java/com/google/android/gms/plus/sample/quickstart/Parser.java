package com.google.android.gms.plus.sample.quickstart;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

/**
 * Created by fares on 7/3/15.
 */
public class Parser {

    public List<Book> parseJsonBooks(String jsonBooks){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Book[].class, new DeserializerJsonBook());
        Gson gson = gsonBuilder.create();

        Book[] newsArray = gson.fromJson(jsonBooks, Book[].class);
        return Arrays.asList(newsArray);
    }

    private class DeserializerJsonBook implements JsonDeserializer<Book[]> {
        @Override
        public Book[] deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            Book[] newsArray;
            if (json.isJsonObject()) {
                return new Book[] {(Book)context.deserialize(json, Book.class)};
            } else if (json.isJsonArray()) {
                final JsonArray asJsonArray = json.getAsJsonArray();
                newsArray = new Book[asJsonArray.size()];
                for (int i = 0; i < newsArray.length; i++) {
                    newsArray[i] = context.deserialize(asJsonArray.get(i).getAsJsonObject(), Book.class);
                }
                return newsArray;
            }
            return null;
        }
    }

    private class DeserializerJsonBook implements JsonDeserializer<Book> {
        @Override
        public Book[] deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            Book[] newsArray;
            if (json.isJsonObject()) {
                return new Book[] {(Book)context.deserialize(json, Book.class)};
            } else if (json.isJsonArray()) {
                final JsonArray asJsonArray = json.getAsJsonArray();
                newsArray = new Book[asJsonArray.size()];
                for (int i = 0; i < newsArray.length; i++) {
                    newsArray[i] = context.deserialize(asJsonArray.get(i).getAsJsonObject(), Book.class);
                }
                return newsArray;
            }
            return null;
        }
    }

}
