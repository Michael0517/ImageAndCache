package com.michael.ImageUnit;


import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class ImageCache {

    public static Bitmap decodeSampleBitmapFromResource(Resources res,int resId,int reqWidth,int reqHeight){
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        //加载图片获取图片的width height
        BitmapFactory.decodeResource(res,resId,options);
        options.inSampleSize = calculateInSampleSize(options,reqWidth,reqHeight);
        //重新加载图片
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res,resId,options);
    }


    public static int calculateInSampleSize(BitmapFactory.Options options,int reqWidth, int reqHeight){
        //200*200  -->100*100  inSample = 2     必须是2的整数倍
        final int width  = options.outWidth;
        final int height = options.outHeight;
        int inSample     = 1;
        if((height > reqHeight) || (width > reqWidth)){
           final int halfWidth  = width/2;
           final int halfHeight = height/2;
            while ((halfWidth/inSample >= reqWidth) && (halfHeight/inSample >= reqHeight)){
                inSample *= 2;
            }
        }
        return  inSample;
    }
}
