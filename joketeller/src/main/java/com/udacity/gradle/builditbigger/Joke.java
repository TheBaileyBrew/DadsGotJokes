package com.udacity.gradle.builditbigger;

public class Joke {
    private final int jokeId;
    private final String jokeQuestion;
    private final String jokeAnswer;

    public Joke(int jokeId, String jokeQuestion, String jokeAnswer) {
        this.jokeId = jokeId;
        this.jokeQuestion = jokeQuestion;
        this.jokeAnswer = jokeAnswer;
    }

    public int getJokeId() {
        return jokeId;
    }

    public String getJokeQuestion() {
        return jokeQuestion;
    }

    public String getJokeAnswer() {
        return jokeAnswer;
    }
}
