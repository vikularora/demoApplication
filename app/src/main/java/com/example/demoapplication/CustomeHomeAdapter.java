package com.example.demoapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomeHomeAdapter extends RecyclerView.Adapter<CustomeHomeHolder> {
    Context mContext;
    LayoutInflater inflater;
    ArrayList arrayList;
    int blockHeight, blockWidth, blockMargin;
    private OnItemClickListener mListener;


    public CustomeHomeAdapter(Context mContext, OnItemClickListener onItemClickListener, ArrayList arrayList, int blockMargin) {

        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
        mListener = onItemClickListener;
        this.arrayList = arrayList;
        this.blockHeight = blockHeight;
        this.blockWidth = blockWidth;
        this.blockMargin = blockMargin;

    }

    @Override
    public CustomeHomeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View v = inflater.inflate(R.layout.custme_home_adapter_item, parent, false);
        final CustomeHomeHolder viewHolder = new CustomeHomeHolder(v, mListener, mContext, blockMargin);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final CustomeHomeHolder holder, final int position) {


        holder.grid_text.setText(String.valueOf(arrayList.get(position)));
        holder.linearLay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim = AnimationUtils.loadAnimation(mContext, R.anim.alpha);
                anim.reset();
                holder.linearLay1.clearAnimation();
                holder.linearLay1.startAnimation(anim);
                /*Thread splashTread = new Thread() {
                    @Override
                    public void run() {
                        try {
                            int waited = 0;
                            // Splash screen pause time
                            while (waited < 3500) {
                                sleep(100);
                                waited += 100;
                            }*/
                            arrayList.remove(position);
                            notifyDataSetChanged();
                            Toast.makeText(mContext, position + "", Toast.LENGTH_SHORT).show();
                      /*  } catch (Exception e) {
                        }
                    }
                };
                splashTread.start();*/

            }
        });


        // holder.relativeLayout.setBackgroundColor(Color.parseColor(commentTypeArrayList.get(position).color));
        // Span the item if active
        //  final ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


}