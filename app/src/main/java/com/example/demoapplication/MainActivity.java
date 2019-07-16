package com.example.demoapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity /*implements MyView.OnToggledListener */{

    MyView[] myViews;

    GridLayout myGridLayout;
    EditText blockHeight,blockWidth,blockMargin,animationSpeed;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myGridLayout = (GridLayout)findViewById(R.id.mygrid);
        blockHeight = (EditText)findViewById(R.id.blockHeight);
        blockWidth = (EditText)findViewById(R.id.blockWidth);
        blockMargin = (EditText)findViewById(R.id.blockMargin);
        animationSpeed = (EditText)findViewById(R.id.animationSpeed);
        submit = (Button)findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(blockHeight.getText().toString())){
                    Toast.makeText(MainActivity.this, "Enter Height", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(blockWidth.getText().toString())){
                    Toast.makeText(MainActivity.this, "Enter Width", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(blockMargin.getText().toString())){
                    Toast.makeText(MainActivity.this, "Enter Margin", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(animationSpeed.getText().toString())){
                    Toast.makeText(MainActivity.this, "Enter animation Speed", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                    intent.putExtra("height",blockHeight.getText().toString());
                    intent.putExtra("width",blockWidth.getText().toString());
                    intent.putExtra("margin",blockMargin.getText().toString());
                    intent.putExtra("speed",animationSpeed.getText().toString());
                    startActivity(intent);
                }
            }
        });

      /*  int numOfCol = myGridLayout.getColumnCount();
        int numOfRow = myGridLayout.getRowCount();

        myViews = new MyView[numOfCol*numOfRow];
        for(int yPos=0; yPos<numOfRow; yPos++){
            for(int xPos=0; xPos<numOfCol; xPos++){
                MyView tView = new MyView(this, xPos, yPos);
                tView.setOnToggledListener(this);
                myViews[yPos*numOfCol + xPos] = tView;
                myGridLayout.addView(tView);
            }
        }

        myGridLayout.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener(){

                    @Override
                    public void onGlobalLayout() {

                        final int MARGIN = 10;

                        int pWidth = myGridLayout.getWidth();
                        int pHeight = myGridLayout.getHeight();
                        int numOfCol = myGridLayout.getColumnCount();
                        int numOfRow = myGridLayout.getRowCount();
                        int w = pWidth/numOfCol;
                        int h = pHeight/numOfRow;

                        for(int yPos=0; yPos<numOfRow; yPos++){
                            for(int xPos=0; xPos<numOfCol; xPos++){
                                GridLayout.LayoutParams params =
                                        (GridLayout.LayoutParams)myViews[yPos*numOfCol + xPos].getLayoutParams();
                                params.width = w - 2*MARGIN;
                                params.height = h - 2*MARGIN;
                                params.setMargins(MARGIN, MARGIN, MARGIN, MARGIN);
                                myViews[yPos*numOfCol + xPos].setLayoutParams(params);
                            }
                        }

                    }});*/
    }

   /* @Override
    public void OnToggled(MyView v, boolean touchOn) {

        //get the id string
        String idString = v.getIdX() + ":" + v.getIdY();

        Toast.makeText(MainActivity.this,
                "Toogled:\n" +
                        idString + "\n" +
                        touchOn, Toast.LENGTH_SHORT).show();
    }
*/
}