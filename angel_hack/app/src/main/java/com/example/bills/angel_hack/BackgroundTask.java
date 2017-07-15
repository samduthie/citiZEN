package com.example.bills.angel_hack;

import android.os.AsyncTask;
import android.content.Context;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Sam on 15/07/2017.
 */

public class BackgroundTask extends AsyncTask<String, Void, String> {

    Context ctx;
    BackgroundTask(Context ctx){
        this.ctx = ctx;

    }
    protected String doInBackground(String... params) {
        String reg_url="http://62.190.88.242/project/register.php";
        String method=params[0];
        if (method.equals("register")){

            String username=params[1];
            String password=params[1];
            String email=params[1];
            String location=params[1];

            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("Post");
                httpURLConnection.setDoOutput(true);
                OutputStream os = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                String data = URLEncoder.encode("username", "UTF-8")+"s"+ URLEncoder.encode(username, "UTF-8")+"&"+
                        URLEncoder.encode("password", "UTF-8")+"s"+ URLEncoder.encode(password, "UTF-8")+"&"+
                        URLEncoder.encode("email", "UTF-8")+"s"+ URLEncoder.encode(email, "UTF-8")+"&"+
                        URLEncoder.encode("location", "UTF-8")+"s"+ URLEncoder.encode(location, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return "Registration Success";



            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
