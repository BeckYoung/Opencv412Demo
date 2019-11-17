package com.example.opencvdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import org.opencv.android.OpenCVLoader;
import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (OpenCVLoader.initDebug()) {
            Log.d(TAG, "Internal OpenCV library not found. Using OpenCV Manager for initialization");
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.meinv);
            Mat src = new Mat();
            Mat dst = new Mat();
            Utils.bitmapToMat(bitmap, src);
            Imgproc.cvtColor(src, dst, Imgproc.COLOR_BGR2GRAY);
            Utils.matToBitmap(dst, bitmap);
            ImageView imageView2 = findViewById(R.id.imageView2);
            imageView2.setImageBitmap(bitmap);
            src.release();
            dst.release();
        }
    }
}
