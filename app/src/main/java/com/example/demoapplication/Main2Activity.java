package com.example.demoapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity implements OnItemClickListener {
    GridLayout myGridLayout;
    LinearLayout gridContainer;
    RecyclerView recyclerView;
    int totalBlock;
    OnItemClickListener onItemClickListener;
    ArrayList arrayList;
    String height,width,margins,speed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        arrayList = new ArrayList();
        gridContainer = (LinearLayout) findViewById(R.id.gridContainer);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        onItemClickListener = this;
        height = getIntent().getStringExtra("height");
        width = getIntent().getStringExtra("width");
        margins = getIntent().getStringExtra("margin");
        speed = getIntent().getStringExtra("speed");
       /* CustomeHomeAdapter customeHomeAdapter = new CustomeHomeAdapter(Main2Activity.this, 100, onItemClickListener, totalBlock);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(Main2Activity.this, 0);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(customeHomeAdapter);*/
       view2();
    }

    void view2(){
        gridContainer.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                gridContainer.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                int screenWidth = gridContainer.getMeasuredWidth();
                int screenHeight = gridContainer.getMeasuredHeight();

                int blockHeight = Integer.parseInt(height);
                int blockWidth = Integer.parseInt(width);
                int margin = Integer.parseInt(margins);
                totalBlock = (screenWidth * screenHeight) / (((2 * margin) + blockHeight) * ((2 * margin) + blockWidth));
                Log.e("screenSize--", screenHeight + "     " + screenWidth + "     " + totalBlock);
                int span = screenWidth/blockWidth;
                for(int i=0;i<totalBlock;i++){
                    arrayList.add(i);
                }

                CustomeHomeAdapter customeHomeAdapter = new CustomeHomeAdapter(Main2Activity.this, onItemClickListener, arrayList,margin);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(Main2Activity.this, span);
                recyclerView.setLayoutManager(gridLayoutManager);
                recyclerView.setHasFixedSize(true);
                recyclerView.setAdapter(customeHomeAdapter);

            }
        });
    }
    void view(int width,int blockwidth) {



    }

    @Override
    public void onClick(View view, int position) {
        Log.e("sdasd", position + "    s");
    }
}
