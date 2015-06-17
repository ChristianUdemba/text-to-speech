package com.example.sairamkrishna.texttospeech;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;



public class MainActivity extends Activity {
    TextToSpeech t1;
    EditText ed1;
    Button b1;
    Toast m_toast;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = (EditText) findViewById(R.id.editText);
        b1 = (Button) findViewById(R.id.button);




        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);
                }
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = ed1.getText().toString();
                Toast.makeText(getApplicationContext(), toSpeak, Toast.LENGTH_SHORT).show();
                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
    }

    public void onPause() {
        if (t1 != null) {
            t1.stop();
            t1.shutdown();
        }
        super.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.langEnglish:
                t1.setLanguage(Locale.US);
                m_toast = Toast.makeText(MainActivity.this, "English", Toast.LENGTH_SHORT);
                m_toast.setGravity(Gravity.CENTER, 0, 0);
                m_toast.show();
                return true;
            case R.id.langGerman:
                t1.setLanguage(Locale.GERMAN);
                m_toast = Toast.makeText(MainActivity.this, "German", Toast.LENGTH_SHORT);
                m_toast.setGravity(Gravity.CENTER, 0, 0);
                m_toast.show();
                return true;
            case R.id.langFrench:
                t1.setLanguage(Locale.FRENCH);
                m_toast = Toast.makeText(MainActivity.this, "French", Toast.LENGTH_SHORT);
                m_toast.setGravity(Gravity.CENTER, 0, 0);
                m_toast.show();
                return true;
            case R.id.langItalian:
                t1.setLanguage(Locale.ITALIAN);
                m_toast = Toast.makeText(MainActivity.this, "Italian", Toast.LENGTH_SHORT);
                m_toast.setGravity(Gravity.CENTER, 0, 0);
                m_toast.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
