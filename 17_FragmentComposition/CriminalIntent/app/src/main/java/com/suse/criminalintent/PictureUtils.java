package com.suse.criminalintent;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;

/**
 * @author liujing
 * @version 1.0
 * @date 2020/12/27 10:43
 */
public class PictureUtils {
    public static Bitmap getScaledBitmap(String path,int destWidth,int destHeight){
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path,options);
        float srcWidth = options.outWidth;
        float srcHeight = options.outHeight;
        int inSampleSize = 1;
        if (srcHeight > destHeight || srcWidth > destWidth){
            float heightScale = srcHeight / destHeight;
            float widthScale = srcWidth / destWidth;
            inSampleSize = Math.round(heightScale > widthScale ? heightScale : widthScale);
        }
        options = new BitmapFactory.Options();
        options.inSampleSize = inSampleSize;
        return BitmapFactory.decodeFile(path,options);
    }

    public static Bitmap getScaledBitmap(String path, Activity activity){
        Point size = new Point();
        activity.getWindowManager().getDefaultDisplay().getSize(size);
        return getScaledBitmap(path,size.x,size.y);
    }
}
