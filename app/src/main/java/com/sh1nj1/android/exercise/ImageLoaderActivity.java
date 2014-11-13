package com.sh1nj1.android.exercise;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by soonoh on 11/13/14.
 */
public class ImageLoaderActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageloader);

        Bitmap icon = BitmapFactory.decodeResource(getResources(),
                R.drawable.ic_launcher);

        String path = "/sdcard/test.png";
        try {
            writeBitmap(icon, path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageView imageView1 = (ImageView) findViewById(R.id.image1);
        ImageView imageView2 = (ImageView) findViewById(R.id.image2);

        Uri uri = Uri.fromFile(new File(path));

        System.out.println("uri="+uri);

        Glide.with(this).load(uri).into(imageView1);
        Picasso.with(this).load(uri).into(imageView2);
    }

    public void writeBitmap(Bitmap bitmap, String path) throws IOException {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(path);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
        } finally {
            if (out != null) out.close();
        }
    }
}
