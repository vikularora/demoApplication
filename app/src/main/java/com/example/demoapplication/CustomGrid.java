package com.example.demoapplication;

import android.content.Context;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomGrid extends BaseAdapter {
    int height;
    int numRow;
    int numOfCol;
    private Context mContext;

    public CustomGrid(Context c, int height, int numOfCol, int numRow) {
        mContext = c;
        this.height = height;
        this.numOfCol = numOfCol;
        this.numRow = numRow;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            grid = inflater.inflate(R.layout.home_grid_item, null);
            grid.setMinimumHeight(height / numRow);

            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            ImageView imageView = (ImageView) grid.findViewById(R.id.grid_image);
            textView.setLines(2);
            textView.setText(String.valueOf(position));

        } else {
            grid = (View) convertView;
        }

        return grid;
    }
}