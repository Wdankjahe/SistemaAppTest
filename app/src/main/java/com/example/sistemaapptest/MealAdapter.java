package com.example.sistemaapptest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.InputStream;
import java.util.ArrayList;


public class MealAdapter extends ArrayAdapter<Meal> {


    public MealAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Meal> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View mealItemView = convertView;
        if (mealItemView == null)
        {
            mealItemView = LayoutInflater.from(getContext()).inflate(R.layout.meal_list_item, parent, false);
        }
        Meal meal = getItem(position);
        TextView mealName = mealItemView.findViewById(R.id.mealName);
        ImageView mealImage = mealItemView.findViewById(R.id.mealImage);
        mealName.setText(meal.getMealName());
        new DownloadImageFromInternet(mealImage).execute(meal.getMealImgURL());

        return mealItemView;
    }

    private class DownloadImageFromInternet extends AsyncTask<String, Void, Bitmap> {
        ImageView imageView;
        public DownloadImageFromInternet(ImageView imageView) {
            this.imageView=imageView;

        }
        protected Bitmap doInBackground(String... urls) {
            String imageURL=urls[0];
            Bitmap bimage=null;
            try {
                InputStream in=new java.net.URL(imageURL).openStream();
                bimage= BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error Message", e.getMessage());
                e.printStackTrace();
            }
            return bimage;
        }
        protected void onPostExecute(Bitmap result) {
            imageView.setImageBitmap(result);
        }
    }


}
