package com.example.sistemaapptest;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class IngredientAdapter extends BaseAdapter {

    Context context;
    String[] ingredients;
    String[] measures;
    LayoutInflater inflater;

    public IngredientAdapter (Context applicationContext, String[] ingredients, String[] measures)
    {
        this.context = applicationContext;
        this.ingredients=ingredients;
        this.measures = measures;
        inflater = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return ingredients.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.ingr,null);
        TextView ing = view.findViewById(R.id.ingredientName);
        TextView mes = view.findViewById(R.id.measurement);
        ing.setText(ingredients[i]);
        mes.setText(measures[i]);
        return view;
    }
}
