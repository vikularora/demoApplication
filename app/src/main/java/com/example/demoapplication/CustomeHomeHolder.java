package com.example.demoapplication;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class CustomeHomeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView grid_text;
    //  RelativeLayout relativeLayout;
    ImageView grid_image;
    LinearLayout linearLay1;

    private OnItemClickListener mListener;


    public CustomeHomeHolder(View itemView, OnItemClickListener mListener, Context context,int blockMargin) {
        super(itemView);

        // relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relativeLayout);
        grid_image = (ImageView) itemView.findViewById(R.id.grid_image);
        grid_text = (TextView) itemView.findViewById(R.id.grid_text);
        linearLay1 = (LinearLayout) itemView.findViewById(R.id.linearLay1);
        linearLay1.removeAllViews();
        LinearLayout ll = new LinearLayout(context);
        ll.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(blockMargin, blockMargin, blockMargin, blockMargin);
        ll.addView(grid_image);
        ll.addView(grid_text);
        ll.setBackgroundColor(Color.RED);
        linearLay1.addView(ll,layoutParams);
        this.mListener = mListener;
        itemView.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        mListener.onClick(v, getAdapterPosition());
    }
}