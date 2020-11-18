package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.igalata.bubblepicker.BubblePickerListener;
import com.igalata.bubblepicker.adapter.BubblePickerAdapter;
import com.igalata.bubblepicker.model.BubbleGradient;
import com.igalata.bubblepicker.model.PickerItem;
import com.igalata.bubblepicker.rendering.BubblePicker;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    BubblePicker picker;

    /*
    String [] matchTraits = {
            "Gaming",
            "Coding",
            "Hiking",
            "Memes",
            "Food",
    };


    int[] colors= {
            Color.parseColor("#1A237E"),
            Color.parseColor("#6200EA"),
            Color.parseColor("#004D40"),
            Color.parseColor("#880E4F"),
            Color.parseColor("#B71C1C"),

    };
    */



    /*
    Resources res = getResources();
    Drawable myImage = ResourcesCompat.getDrawable(res, R.drawable.invisible, null);
    //int image = R.drawable.invisible;
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final String[] titles = getResources().getStringArray(R.array.matchTraits);
        final TypedArray colors = getResources().obtainTypedArray(R.array.colors);
        final TypedArray images = getResources().obtainTypedArray(R.array.images);
        picker =findViewById(R.id.picker);
        picker.setAdapter(new BubblePickerAdapter() {
            @Override
            public int getTotalCount() {
                return titles.length;
            }

            @NotNull
            @Override
            public PickerItem getItem(int position) {
                PickerItem item = new PickerItem();
                item.setTitle(titles[position]);
                item.setGradient(new BubbleGradient(colors.getColor((position * 2) % 8, 0),
                        colors.getColor((position * 2) % 8 + 1, 0), BubbleGradient.VERTICAL));
                //item.setTypeface(mediumTypeface);
                item.setTextColor(ContextCompat.getColor(HomeActivity.this, android.R.color.white));
                item.setBackgroundImage(ContextCompat.getDrawable(HomeActivity.this, images.getResourceId(position, 0)));
                return item;
            }
        });

        picker.setListener(new BubblePickerListener() {
            @Override
            public void onBubbleSelected(@NotNull PickerItem item) {

            }

            @Override
            public void onBubbleDeselected(@NotNull PickerItem item) {

            }
        });


        /*
        ArrayList<PickerItem> listItems = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            PickerItem item = new PickerItem(titles[i],myImage,false,colors[i]);
            listItems.add(item);
        }

        picker.setItems(listItems);
        picker.setListener(new BubblePickerListener() {
            @Override
            public void onBubbleSelected(@NotNull PickerItem pickerItem) {
                Toast.makeText(getApplicationContext(), "" + pickerItem.getTitle()
                        + " selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onBubbleDeselected(@NotNull PickerItem pickerItem) {
                Toast.makeText(getApplicationContext(), "" + pickerItem.getTitle()
                        + " Deselected", Toast.LENGTH_SHORT).show();

            }
        });
        */

    }
    @Override
    protected void onResume() {
        super.onResume();
        picker.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        picker.onPause();
    }
}