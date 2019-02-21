package com.example.verzeichnisdemo;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

   private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createFile(getFilesDir(), "A");
        File dirAudio = getDir("audio",MODE_PRIVATE);
        createFile(dirAudio, "B");
        File dirVideo = getDir("video",MODE_PRIVATE);
        createFile(dirVideo, "C");
        try {
            File tmpFile = File.createTempFile("Temp",".tmp",getCacheDir());
            Log.d(TAG, "onCreate: tempVerz: " + getCacheDir().getAbsolutePath());
        } catch (IOException e) {
            Log.e(TAG, "", e);
        }
    }

    private void createFile(File filesDir, String name) {
        File file = new File(filesDir, name);
        // FileOutputStream -> Streams = byte orientiert -> Format = Byteformat -> für alles was nicht Text ist!
        try(FileOutputStream fos = new FileOutputStream(file)){
            Log.d(TAG, "createFile: " + file.getAbsolutePath());
            fos.write("Hallo".getBytes());

        } catch (FileNotFoundException e) {
            Log.e(TAG, "", e);
        } catch (IOException e) {
            Log.e(TAG, "", e);
        }
    }
}
