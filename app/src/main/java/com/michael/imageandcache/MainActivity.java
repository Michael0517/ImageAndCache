package com.michael.imageandcache;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import com.michael.ImageUnit.ImageCache;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView iv = (ImageView) findViewById(R.id.iv);
        Bitmap bitmap = ImageCache.decodeSampleBitmapFromResource(getResources(),R.mipmap.default_bg,100,100);
        iv.setImageBitmap(bitmap);
    }





}
