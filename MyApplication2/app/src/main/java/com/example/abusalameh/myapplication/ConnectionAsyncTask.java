package com.example.abusalameh.myapplication;

import android.app.Activity;
import android.os.AsyncTask;

import com.example.abusalameh.myapplication.http.HttpManager;

/*
Connection Async Task Class to do all background connections and avoid ANR
 */
public class ConnectionAsyncTask extends AsyncTask<String, String, String> {
    Activity activity;
    public ConnectionAsyncTask(Activity activity) {
        this.activity=activity;
    }

    @Override
    protected String doInBackground(String... params) {
        String content = HttpManager.getData(params[0]);
        return content;
    }
    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }
}
