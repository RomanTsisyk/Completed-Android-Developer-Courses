package com.example.mortezasaadat.colorapp;

import android.graphics.Bitmap;
import android.graphics.Color;

/**
 * Created by mortezasaadat on 5/14/17.
 */

public class Colorful {



    private Bitmap bitmap;
    private float redColorValue;
    private float greenColorValue;
    private float blueColorValue;



    public Colorful(Bitmap newBitmap, float redValue, float greenValue, float blueValue) {


       // this.bitmap = bitmap;
        bitmap = newBitmap;
        setRedColorValue(redValue);
        setGreenColorValue(greenValue);
        setBlueColorValue(blueValue);


    }


    public void setRedColorValue(float redValue) {

        if (redValue >= 0 && redValue <= 1) {

            redColorValue = redValue;

        }

    }

    public void setGreenColorValue(float greenValue) {


        if (greenValue >= 0 && greenValue <= 1) {

            greenColorValue = greenValue;

        }
    }



    public  void setBlueColorValue(float blueValue) {


        if (blueValue >= 0 && blueValue <= 1) {

            blueColorValue = blueValue;

        }

    }



    public float getRedColorValue() {

        return redColorValue;
    }

    public float getGreenColorValue() {

        return greenColorValue;
    }

    public float getBlueColorValue() {

        return blueColorValue;

    }



    public Bitmap returnTheColorizedBitmap() {


        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();

        Bitmap.Config bitmapConfig = bitmap.getConfig();

        Bitmap localBitmap = Bitmap.createBitmap(bitmapWidth, bitmapHeight, bitmapConfig);


        for (int row = 0; row < bitmapWidth; row++) {


            for (int column = 0; column < bitmapHeight; column++) {


                int pixelColor = bitmap.getPixel(row, column);


                pixelColor = Color.argb(Color.alpha(pixelColor),
                        (int)redColorValue * Color.red(pixelColor),
                        (int) greenColorValue * Color.green(pixelColor),
                        (int)blueColorValue * Color.blue(pixelColor));
                localBitmap.setPixel(row, column, pixelColor);

            }


        }


        return localBitmap;



    }



}
