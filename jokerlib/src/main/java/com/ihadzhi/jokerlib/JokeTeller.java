package com.ihadzhi.jokerlib;

import io.chucknorris.client.ChuckNorrisClient;
import io.chucknorris.client.Joke;

public class JokeTeller {

    public static String tellJoke() {

        // create the chuck norris client
        ChuckNorrisClient client = new ChuckNorrisClient();

        Joke joke = client.getRandomJoke();

        return joke.getValue();
    }
}
