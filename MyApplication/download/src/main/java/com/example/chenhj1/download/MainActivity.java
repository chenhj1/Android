package com.example.chenhj1.download;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        String appDir = getApplicationContext().getFilesDir().getAbsolutePath();
        String sdDir = Environment.getExternalStorageDirectory().getAbsolutePath();
        String fileName = "testfile.png";
        String urlStr = "http://d.ifengimg.com/w132_h94_q75/y3.ifengimg.com/ifengimcp/pic/20160406/20367410ecbf89daffc7_size140_w685_h490.jpg";
        //downloadSplashAd(urlStr, "sdcard/360/"+fileName);

        File testFile = new File(sdDir + "/360/kdpush");
        /*try {
            FileOutputStream fos = new FileOutputStream(testFile);
            fos.write("没雾霾真是太好了_没雾霾真是太好了_没雾霾真是太好了".getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        try {

            FileInputStream fis = new FileInputStream(testFile);
            byte[] b = new byte[fis.available()];
            fis.read(b);
            fis.close();
//            Log.i("tag",new String(b));
            File resultFile = new File(sdDir + "/alipay/a");
            FileOutputStream fos = new FileOutputStream(resultFile);
            fos.write(b);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.i("tag", e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            Log.i("tag", e.getMessage());
        }

//        Log.i("tag", " " + testFile.exists());
    }

    private void downloadSplashAd(final String urlStr, final String path) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                URL url;
                try {
                    url = new URL(urlStr);
                    // 获取 httpUrl连接
                    HttpURLConnection httpUrlConnection = (HttpURLConnection) url
                            .openConnection();

                    // 设置连接时限
                    httpUrlConnection.setConnectTimeout(5 * 1000);
                    httpUrlConnection.setDoInput(true);
                    httpUrlConnection.setDoOutput(true);
                    httpUrlConnection.setUseCaches(false);
                    httpUrlConnection.setRequestMethod("GET");
                    httpUrlConnection.setRequestProperty("Charsert", "UTF-8");
                    httpUrlConnection.connect();

                    int mResponseCode = httpUrlConnection.getResponseCode();
                    if (mResponseCode == HttpURLConnection.HTTP_OK) {

                        // 设置输入流
                        InputStream fis = httpUrlConnection.getInputStream();
                        int bufferSize = 1024;
                        byte[] bufferArray = new byte[bufferSize];
                        int length;
                        File resultFile = new File(path);
                        FileOutputStream fos = new FileOutputStream(resultFile);
                        while ((length = fis.read(bufferArray)) != -1) {
                            fos.write(bufferArray, 0, length);
                            fos.flush();
                        }
                        fis.close();
                        fos.close();
                    }

                    httpUrlConnection.disconnect();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    Log.i("tag", e.getMessage());
                } catch (ProtocolException e) {
                    e.printStackTrace();
                    Log.i("tag", e.getMessage());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    Log.i("tag", e.getMessage());
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.i("tag", e.getMessage());
                }
            }
        }).start();
    }
}
