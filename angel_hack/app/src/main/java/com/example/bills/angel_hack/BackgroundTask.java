package com.example.bills.angel_hack;

import android.os.AsyncTask;
import android.content.Context;
import android.util.Log;
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
        String reg_url="http://www.psychtree.co.uk/register.php";
        String method=params[0];
        if (method.equals("register")){

            String username=params[1];
            String password=params[2];
            String email=params[3];
            String location=params[4];

            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream os = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                String data = URLEncoder.encode("username", "UTF-8")+"="+ URLEncoder.encode(username, "UTF-8")+"&"+
                        URLEncoder.encode("password", "UTF-8")+"="+ URLEncoder.encode(password, "UTF-8")+"&"+
                        URLEncoder.encode("email", "UTF-8")+"="+ URLEncoder.encode(email, "UTF-8")+"&"+
                        URLEncoder.encode("location", "UTF-8")+"="+ URLEncoder.encode(location, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();

                os.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return data.toString();



            } catch (MalformedURLException e) {
                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();

            } catch(Exception e) {
                Log.d(e.toString(), "debug1");
                return (e.toString());
            }


        }

        return "Registration Failed!";
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
