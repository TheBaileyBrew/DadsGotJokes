package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.text.PrecomputedText;
import android.util.Log;
import android.util.Pair;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class EndpointsAsyncTask extends AsyncTask<Context, Void, String> {
    private final static String TAG = EndpointsAsyncTask.class.getSimpleName();

    private static MyApi myApiService = null;
    private Context context;

    @Override
    protected String doInBackground(Context... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        context = params[0];

        try {
            return myApiService.getJoke().execute().getJoke();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Intent openActivity = new Intent(context, JokeDisplayActivity.class);
        Log.e(TAG, "onPostExecute: joke is: " + result );
        String[] jokeStuffs = result.split("---");
        String jokeQ = jokeStuffs[0];
        Log.e(TAG, "onPostExecute: jokeQ: " + jokeQ );
        String jokeA = jokeStuffs[1];
        Log.e(TAG, "onPostExecute: jokeA: " + jokeA );
        openActivity.putExtra(ConstantTerror.JOKE_KEY, jokeQ);
        openActivity.putExtra(ConstantTerror.ANSWER_KEY, jokeA);
        context.startActivity(openActivity);

    }
}
