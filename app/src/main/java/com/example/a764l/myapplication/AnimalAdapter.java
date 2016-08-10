package com.example.a764l.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * Created by 764l on 2016/8/5.
 */
public class AnimalAdapter extends BaseAdapter{

    private LinkedList<Animal> mData;
    private Context mContext;

    public AnimalAdapter(LinkedList<Animal> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }
    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_list_animal,parent,false);
            holder = new ViewHolder();
            holder.img_icon = (ImageView) convertView.findViewById(R.id.imgicon);
            holder.txt_aName = (TextView) convertView.findViewById(R.id.txt_aName);
            holder.txt_aSpeak = (TextView) convertView.findViewById(R.id.txt_aSpeak);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

//        ImageView img_icon = (ImageView) convertView.findViewById(R.id.imgicon);
//        TextView txt_aName = (TextView) convertView.findViewById(R.id.txt_aName);
//        TextView txt_aSpeak = (TextView) convertView.findViewById(R.id.txt_aSpeak);
//        img_icon.setBackgroundResource(mData.get(position).getaIcon());
//        txt_aName.setText(mData.get(position).getaName());
//        txt_aSpeak.setText(mData.get(position).getaSpeak());
        holder.img_icon.setBackgroundResource(mData.get(position).getaIcon());
        holder.txt_aName.setText(mData.get(position).getaName());
        holder.txt_aSpeak.setText(mData.get(position).getaSpeak());
        return convertView;
    }

    static class ViewHolder{
        ImageView img_icon;
        TextView txt_aName;
        TextView txt_aSpeak;
    }
}

