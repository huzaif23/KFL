package com.huzaifa.project.football;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.squareup.picasso.Transformation;



public class img_circle implements Transformation {
    @Override
    public Bitmap transform(Bitmap bitmap) {
        int size = Math.min(bitmap.getWidth(),bitmap.getHeight());
        int x = (bitmap.getWidth() - size)/2;
        int y = (bitmap.getHeight() - size)/2;

        Bitmap sqbitmaps = Bitmap.createBitmap(bitmap,x,y,size,size);
        if (sqbitmaps != bitmap) {
            bitmap.recycle();
        }
        Bitmap bitmaps = Bitmap.createBitmap(size, size, bitmap.getConfig());
        Canvas canvas = new Canvas(bitmaps);
        Paint paint = new Paint();
        BitmapShader bitmapShader = new BitmapShader(sqbitmaps,BitmapShader.TileMode.CLAMP,BitmapShader.TileMode.CLAMP);
        paint.setShader(bitmapShader);
        paint.setAntiAlias(true);

        float a= size/2f;
        canvas.drawCircle(a,a,a,paint);
        sqbitmaps.recycle();
        return bitmaps;
    }

    @Override
    public String key() {
        return "circle";
    }
}
