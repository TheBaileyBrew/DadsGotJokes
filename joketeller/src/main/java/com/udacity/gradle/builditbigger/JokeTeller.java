package com.udacity.gradle.builditbigger;

import java.util.ArrayList;
import java.util.Random;

public class JokeTeller {

    private ArrayList<Joke> jokesOfTheDadVariety = new ArrayList<>();

    static Random randomJoke = new Random();


    public Joke tellJoke() {
        jokesOfTheDadVariety.add(new Joke(1, "Wanna hear a joke about paper?",
                "Nevermind, it's tearable..."));
        jokesOfTheDadVariety.add(new Joke(2, "How many apples grow on a tree?",
                "All of them..."));
        jokesOfTheDadVariety.add(new Joke(3, "Did you hear about the cheese factory that exploded in France?",
                "There was nothing left but de Brie..."));
        jokesOfTheDadVariety.add(new Joke(4, "Why don't skeletons ever go trick or treating?",
                "Because they have no body to go with..."));
        jokesOfTheDadVariety.add(new Joke(5, "Why did the scarecrow win an award?",
                "Because he was outstanding in his field..."));
        jokesOfTheDadVariety.add(new Joke(6, "What did the buffalo say to his son when he left for college?",
                "Bison..."));
        jokesOfTheDadVariety.add(new Joke(7, "Why can't you hear a pterodactyl going to the bathroom?",
                "Because the pee is silent..."));
        jokesOfTheDadVariety.add(new Joke(8, "Have you heard about the movie 'Constipation'?",
                "It hasn't come out yet..."));
        jokesOfTheDadVariety.add(new Joke(9, "How many tickles does it take to make an octopus laugh?",
                "Ten tickles..."));
        jokesOfTheDadVariety.add(new Joke(10,"What do you call a fish with an eye missing?",
                "A f-shhh..."));
        jokesOfTheDadVariety.add(new Joke(11, "Why did the coffee file a police report?",
                "Because he got mugged..."));


        return jokesOfTheDadVariety.get(randomJoke.nextInt(jokesOfTheDadVariety.size()));
    }
}
