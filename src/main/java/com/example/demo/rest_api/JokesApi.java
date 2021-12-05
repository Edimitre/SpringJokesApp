package com.example.demo.rest_api;



import com.example.demo.dao.TwoLineJokeDao;
import com.example.demo.model.OneLineJoke;
import com.example.demo.model.TwoLineJoke;
import com.example.demo.service.JokeService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class JokesApi {

    public static final String TWO_LINE_PROGRAMER_JOKE_URL = "https://v2.jokeapi.dev/joke/Programming?type=twopart&amount=10";

    public static final String TWO_LINE_DARK_JOKE_URL = "https://v2.jokeapi.dev/joke/Dark?type=twopart&amount=10";

    public static final String TWO_LINE_MISCELLANOUS_JOKE_URL = "https://v2.jokeapi.dev/joke/Miscellaneous?type=twopart&amount=10";

    public static final String ONE_LINE_RANDOM_JOKE = "https://v2.jokeapi.dev/joke/Any?type=single&amount=10";

    public static HttpURLConnection connection;

    @Autowired
    public static TwoLineJokeDao twoLineJokeDao;

    public List<TwoLineJoke> getTwoLineProgramerJokes() throws IOException {

        List<TwoLineJoke> programmersJokeList = new ArrayList<>();

        int status = 0;
        URL url = new URL(TWO_LINE_PROGRAMER_JOKE_URL);

        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        status = connection.getResponseCode();

        connection.setConnectTimeout(5000);

        connection.connect();

        if (status == 200){

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            StringBuffer stringBuffer = new StringBuffer();
            String output;
            while((output = bufferedReader.readLine()) != null ){
                stringBuffer.append(output);
            }
            bufferedReader.close();


            JSONObject myResponse = new JSONObject(stringBuffer.toString());

            JSONArray jokesArray = myResponse.getJSONArray("jokes");

            for(int i = 0; i < jokesArray.length(); i++) {

                JSONObject objects = jokesArray.getJSONObject(i);

                TwoLineJoke twoLineJoke = new TwoLineJoke();
                twoLineJoke.setCategory(objects.getString("category"));
                twoLineJoke.setSetupLine(objects.getString("setup"));
                twoLineJoke.setPunchLine(objects.getString("delivery"));

                programmersJokeList.add(twoLineJoke);



            }

        }
        return programmersJokeList;

    }

    public List<TwoLineJoke> getTwoLineDarkJokes() throws IOException {

        List<TwoLineJoke> darkJokeList = new ArrayList<>();

        int status = 0;
        URL url = new URL(TWO_LINE_DARK_JOKE_URL);

        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        status = connection.getResponseCode();

        connection.setConnectTimeout(5000);

        connection.connect();

        if (status == 200){

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            StringBuffer stringBuffer = new StringBuffer();
            String output;
            while((output = bufferedReader.readLine()) != null ){
                stringBuffer.append(output);
            }
            bufferedReader.close();


            JSONObject myResponse = new JSONObject(stringBuffer.toString());

            JSONArray jokesArray = myResponse.getJSONArray("jokes");

            for(int i = 0; i < jokesArray.length(); i++) {

                JSONObject objects = jokesArray.getJSONObject(i);

                TwoLineJoke twoLineJoke = new TwoLineJoke();
                twoLineJoke.setCategory(objects.getString("category"));
                twoLineJoke.setSetupLine(objects.getString("setup"));
                twoLineJoke.setPunchLine(objects.getString("delivery"));

                darkJokeList.add(twoLineJoke);



            }

        }
        return darkJokeList;


    }

    public List<TwoLineJoke> getTwoLineMiscellanousJokes() throws IOException {

        List<TwoLineJoke> miscJokeList = new ArrayList<>();

        int status = 0;
        URL url = new URL(TWO_LINE_MISCELLANOUS_JOKE_URL);

        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        status = connection.getResponseCode();

        connection.setConnectTimeout(5000);

        connection.connect();

        if (status == 200){

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            StringBuffer stringBuffer = new StringBuffer();
            String output;
            while((output = bufferedReader.readLine()) != null ){
                stringBuffer.append(output);
            }
            bufferedReader.close();


            JSONObject myResponse = new JSONObject(stringBuffer.toString());

            JSONArray jokesArray = myResponse.getJSONArray("jokes");

            for(int i = 0; i < jokesArray.length(); i++) {

                JSONObject objects = jokesArray.getJSONObject(i);

                TwoLineJoke twoLineJoke = new TwoLineJoke();
                twoLineJoke.setCategory(objects.getString("category"));
                twoLineJoke.setSetupLine(objects.getString("setup"));
                twoLineJoke.setPunchLine(objects.getString("delivery"));

                miscJokeList.add(twoLineJoke);



            }

        }
        return miscJokeList;


    }

    public List<OneLineJoke> getOneLineJokes() throws IOException {

        List<OneLineJoke> oneLineJokes = new ArrayList<>();

        int status = 0;
        URL url = new URL(ONE_LINE_RANDOM_JOKE);

        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        status = connection.getResponseCode();

        connection.setConnectTimeout(5000);

        connection.connect();

        if (status == 200){

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            StringBuffer stringBuffer = new StringBuffer();
            String output;
            while((output = bufferedReader.readLine()) != null ){
                stringBuffer.append(output);
            }
            bufferedReader.close();


            JSONObject myResponse = new JSONObject(stringBuffer.toString());

            JSONArray jokesArray = myResponse.getJSONArray("jokes");

            for(int i = 0; i < jokesArray.length(); i++) {

                JSONObject objects = jokesArray.getJSONObject(i);

                OneLineJoke oneLineJoke = new OneLineJoke();
                oneLineJoke.setJoke(objects.getString("joke"));

                oneLineJokes.add(oneLineJoke);
            }

        }
        return oneLineJokes;


    }
}
