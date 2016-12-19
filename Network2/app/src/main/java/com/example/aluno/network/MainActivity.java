package com.example.aluno.network;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnGet = (Button) findViewById(R.id.btn_get);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                        URL url;
                        HttpURLConnection httpURLConnection;

                        try {
                            url = new URL("https://httpbin.org/get");
                            httpURLConnection= (HttpURLConnection) url.openConnection();
                            httpURLConnection.setRequestMethod("GET");
                            int responseCode = httpURLConnection.getResponseCode();
                            if (responseCode == HttpURLConnection.HTTP_OK){
                                String resposta = StreamUtil.readStream(httpURLConnection.getInputStream());
                                JSONObject jsonObject = new JSONObject(resposta);

                                setText(resposta);
                            }
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    public void setText(final String str)
    {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                final TextView txtView = (TextView) findViewById(R.id.tv_response);
                txtView.setText(str);
            }
        });


    }
}
