package com.example.learningtemplate;

import java.util.Arrays;
import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class EfficientAdapter extends BaseAdapter {
	
    private LayoutInflater mInflater;
    private List<String> mDataList;
    private static final int HIGHLIGHT_COLOR = 0x999be6ff;
    private ColorGenerator mColorGenerator = ColorGenerator.MATERIAL;
    private TextDrawable.IBuilder mDrawableBuilder;
   public static int mPosition=-1,mLastPosition=-1;
    private Context mContext;
    
    public EfficientAdapter(Context context,List<String>mDataList) {
        mContext=context;
    	mInflater = LayoutInflater.from(context);
        this.mDataList=mDataList;
        mDrawableBuilder=TextDrawable.builder().round();
        mPosition=-1;
        
    }

    public int getCount() {
        return mDataList.size();
    }
    
    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            holder.image = (ImageView) convertView.findViewById(R.id.image);
            holder.title = (TextView) convertView.findViewById(R.id.title);
          
            holder.view=convertView;
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        
        holder.title.setText(mDataList.get(position));
        //holder.info.setText(mDataList.get(position).getInfo());
        try{
        	TextDrawable drawable = mDrawableBuilder.build(String.valueOf(mDataList.get(position).charAt(0)).toUpperCase(), mColorGenerator.getColor(mDataList.get(position)));
        	holder.image.setImageDrawable(drawable);
        	holder.view.setBackgroundColor(Color.TRANSPARENT);
        }catch(Exception e)
        {
        	
        }
    
        return convertView;
    }
    
    class ViewHolder {
        TextView title;
       
        ImageView image;
        View view;
        
    }	
    

    
}
    
	
