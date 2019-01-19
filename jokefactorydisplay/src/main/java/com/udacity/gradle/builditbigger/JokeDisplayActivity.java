package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class JokeDisplayActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = JokeDisplayActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);
        TextView jokeTextView = findViewById(R.id.display_joke);
        ConstraintLayout mainDisplay = findViewById(R.id.main_screen_display_activity);
        mainDisplay.setOnClickListener(this);
        final TextView jokeAnswerView = findViewById(R.id.display_answer);
        final ImageView jokeImageView = findViewById(R.id.joke_dog_image);

        //Get joke intent
        Intent intent = getIntent();
        String jokeTold = intent.getStringExtra("this is a joke");
        Log.e(TAG, "onCreate: joke: " + jokeTold);
        final String answerTold = intent.getStringExtra("this is an answer");
        Log.e(TAG, "onCreate: answer: " + answerTold );

        if (jokeTold != null) {
            jokeTextView.setText(jokeTold);
            final Handler handler = new Handler();
            Runnable delayAnswer = new Runnable() {
                @Override
                public void run() {
                    jokeAnswerView.setText(answerTold);
                    jokeImageView.setImageDrawable(getDrawable(R.drawable.laughing_dog_joke_face));
                }
            };
            handler.postDelayed(delayAnswer, 5000);

        } else {
            jokeTextView.setText("Jokes on you... Let's try that again");
        }


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.main_screen_display_activity) {
            finish();
        }
    }
}
