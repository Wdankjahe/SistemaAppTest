package com.example.sistemaapptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MealDetailActivity extends AppCompatActivity {
    ListView listView;
    TextView mealName, mealCategory, mealOrigin, mealInstruction, mealTags, mealSource, mealYoutube;
    ImageView mealThumbnail;
    Button backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_detail);
        APIList apis = RetrofitClient.getRetrofitClient().create(APIList.class);
        Intent intent = getIntent();
        Call<MealsDetailed> call = apis.getMealByID(Integer.parseInt(intent.getStringExtra("MealId")));
        mealName = findViewById(R.id.mealNameD);
        mealCategory= findViewById(R.id.mealCat);
        mealOrigin= findViewById(R.id.mealOrigin);
        mealInstruction= findViewById(R.id.mealInstruction);
        mealTags= findViewById(R.id.mealTags);
        mealSource= findViewById(R.id.sourceLink);
        mealYoutube= findViewById(R.id.youtubeLink);
        mealThumbnail = findViewById(R.id.imageDtail);
        listView = findViewById(R.id.inmeasure);
        backButton = findViewById(R.id.button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Log.e("MyLog", "Test");
        call.enqueue(new Callback<MealsDetailed>() {
            @Override
            public void onResponse(Call<MealsDetailed> call, Response<MealsDetailed> response) {

                if(response.isSuccessful()) {
                    MealsDetailed data = response.body();
                    MealDetail meal = data.getMealId().get(0);
                    List<Map<String,String>> listThings = new ArrayList<>();


                    String[] ingredients = {
                            meal.getStrIngredient1(),
                            meal.getStrIngredient2(),
                            meal.getStrIngredient3(),
                            meal.getStrIngredient4(),
                            meal.getStrIngredient5(),
                            meal.getStrIngredient6(),
                            meal.getStrIngredient7(),
                            meal.getStrIngredient8(),
                            meal.getStrIngredient9(),
                            meal.getStrIngredient10(),
                            meal.getStrIngredient11(),
                            meal.getStrIngredient12(),
                            meal.getStrIngredient13(),
                            meal.getStrIngredient14(),
                            meal.getStrIngredient15(),
                            meal.getStrIngredient16(),
                            meal.getStrIngredient17(),
                            meal.getStrIngredient18(),
                            meal.getStrIngredient19(),
                            meal.getStrIngredient20()
                    };

                    String[] measures = {
                            meal.getStrMeasure1(),
                            meal.getStrMeasure2(),
                            meal.getStrMeasure3(),
                            meal.getStrMeasure4(),
                            meal.getStrMeasure5(),
                            meal.getStrMeasure6(),
                            meal.getStrMeasure7(),
                            meal.getStrMeasure8(),
                            meal.getStrMeasure9(),
                            meal.getStrMeasure10(),
                            meal.getStrMeasure11(),
                            meal.getStrMeasure12(),
                            meal.getStrMeasure13(),
                            meal.getStrMeasure14(),
                            meal.getStrMeasure15(),
                            meal.getStrMeasure16(),
                            meal.getStrMeasure17(),
                            meal.getStrMeasure18(),
                            meal.getStrMeasure19(),
                            meal.getStrMeasure20()
                    };

                    for (int i=0;i<ingredients.length;i++)
                    {
                        Map<String, String> listing = new HashMap<>();
                        listing.put("Ingredients",ingredients[i]);
                        listing.put("Measurement",measures[i]);
                        listThings.add(listing);
                    }

                    listView.setAdapter(
                            new SimpleAdapter(getApplicationContext(),listThings,R.layout.ingr,
                                    new String[] {"Ingredients", "Measurement"},
                                    new int[] {R.id.ingredientName, R.id.measurement}
                                    )
                    );

                    //listView.setAdapter(new IngredientAdapter(getApplicationContext(),ingredients,measures));
                    //viewing.loadUrl(meal.getMealYoutube());
                    mealName.setText(meal.getMealName());
                    mealCategory.setText(meal.getMealCategory());
                    mealInstruction.setText(meal.getMealInstructions());
                    mealOrigin.setText(meal.getMealArea());
                    mealTags.setText(meal.getMealTags());
                    mealYoutube.setText(
                            Html.fromHtml(
                                    "<a href=" + "\""+ meal.getMealYoutube()  + "\"" + ">Youtube Video</a> "));
                    mealYoutube.setMovementMethod(LinkMovementMethod.getInstance());
                    mealSource.setText(
                            Html.fromHtml(
                                    "<a href=" + "\""+ meal.getMealSource()  + "\"" + ">Source Link</a> "));
                    mealSource.setMovementMethod(LinkMovementMethod.getInstance());

                    new DownloadImageFromInternet(mealThumbnail).execute(meal.getMealThumbnail());

                }

            }

            @Override
            public void onFailure(Call<MealsDetailed> call, Throwable t) {
                Log.e("MyLog", t.getCause().getMessage());
                Toast.makeText(getApplicationContext(),"Something wrong. Please try again later.",Toast.LENGTH_SHORT).show();
            }
        });



    }
}