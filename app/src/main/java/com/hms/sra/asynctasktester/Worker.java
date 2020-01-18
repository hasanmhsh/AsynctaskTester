package com.hms.sra.asynctasktester;

import android.os.AsyncTask;
import android.widget.EditText;

/**
 * Created by h on 2/19/2018.
 */

public class Worker extends AsyncTask<String,Integer,Integer> {
    EditText poster;
    EditText postPoster;
    EditText prePoster;
    static int increment = 0;
    static int preincrement = 0;
    public Worker(EditText result,EditText onPostExecuteResult,EditText prePosterET) {
        poster = result;
        postPoster = onPostExecuteResult;
        prePoster = prePosterET;
    }

    @Override
    protected Integer doInBackground(String... strings) {

        Integer i = (Integer) increment+1;
        poster.post(new Runnable() {
            @Override
            public void run() {
                increment++;
                poster.setText(String.valueOf(increment));
            }
        });
        try{Thread.sleep(3000);}catch(Exception e){}
        return i;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        preincrement++;
        prePoster.setText(String.valueOf(preincrement));
    }

    @Override
    protected void onPostExecute(Integer aInt) {

        super.onPostExecute(aInt);
        postPoster.setText(String.valueOf(aInt));
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onCancelled(Integer aInt) {
        super.onCancelled(aInt);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }
}
