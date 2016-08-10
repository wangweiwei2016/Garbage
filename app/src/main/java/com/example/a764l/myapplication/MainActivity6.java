package com.example.a764l.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * 作者：www on 2016/8/8 13:30
 * 邮箱：2030730029@qq.com
 */
public class MainActivity6 extends AppCompatActivity

    {
        private ArrayList<Group> gData = null;
        private ArrayList<ArrayList<Item>> iData = null;
        private ArrayList<Item> lData = null;
        private Context mContext;
        private ExpandableListView exlist_lol;
        private MyBaseExpandableListAdapter myAdapter = null;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main4);
            mContext = MainActivity6.this;
            exlist_lol = (ExpandableListView) findViewById(R.id.exlist_lol);


            //数据准备
            gData = new ArrayList<Group>();
            iData = new ArrayList<ArrayList<Item>>();
            gData.add(new Group("AD"));
            gData.add(new Group("AP"));
            gData.add(new Group("TANK"));

            lData = new ArrayList<Item>();

            //AD组
            lData.add(new Item(R.mipmap.iv_lol_icon3,"剑圣"));
            lData.add(new Item(R.mipmap.iv_lol_icon4,"德莱文"));
            lData.add(new Item(R.mipmap.iv_lol_icon13,"男枪"));
            lData.add(new Item(R.mipmap.iv_lol_icon14,"韦鲁斯"));
            iData.add(lData);
            //AP组
            lData = new ArrayList<Item>();
            lData.add(new Item(R.mipmap.iv_lol_icon1, "提莫"));
            lData.add(new Item(R.mipmap.iv_lol_icon7, "安妮"));
            lData.add(new Item(R.mipmap.iv_lol_icon8, "天使"));
            lData.add(new Item(R.mipmap.iv_lol_icon9, "泽拉斯"));
            lData.add(new Item(R.mipmap.iv_lol_icon11, "狐狸"));
            iData.add(lData);
            //TANK组
            lData = new ArrayList<Item>();
            lData.add(new Item(R.mipmap.iv_lol_icon2, "诺手"));
            lData.add(new Item(R.mipmap.iv_lol_icon5, "德邦"));
            lData.add(new Item(R.mipmap.iv_lol_icon6, "奥拉夫"));
            lData.add(new Item(R.mipmap.iv_lol_icon10, "龙女"));
            lData.add(new Item(R.mipmap.iv_lol_icon12, "狗熊"));
            iData.add(lData);

            myAdapter = new MyBaseExpandableListAdapter(gData,iData,mContext);
            exlist_lol.setAdapter(myAdapter);

            //为列表设置点击事件
            exlist_lol.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                @Override
                public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                    //Toast.makeText(mContext, "你点击了：" + iData.get(groupPosition).get(childPosition).getiName(), Toast.LENGTH_SHORT).show();
                    midToast("你点击了：" + iData.get(groupPosition).get(childPosition).getiName(), Toast.LENGTH_SHORT, iData.get(groupPosition).get(childPosition).getiId());
                    return true;
                }
            });


        }
//        void midToast(String str, int showTime)
//        {
//            Toast toast = Toast.makeText(mContext, str, showTime);
//            toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL , 0, 0);  //设置显示位置
//            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
//            v.setTextColor(Color.YELLOW);     //设置字体颜色
//            toast.show();
//        }

        private void midToast(String str, int showTime,int id)
        {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.view_toast_custom,
                    (ViewGroup) findViewById(R.id.lly_toast));
            ImageView img_logo = (ImageView) view.findViewById(R.id.img_logo);
            TextView tv_msg = (TextView) view.findViewById(R.id.tv_msg);
            img_logo.setBackgroundResource(id);
            tv_msg.setText(str);
            Toast toast = new Toast(mContext);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.setDuration(showTime);
            toast.setView(view);
            toast.show();
        }
//    private AutoCompleteTextView atv_content;
//    private MultiAutoCompleteTextView matv_content;
//
//    private static final String[] data = new String[]{
//            "小猪猪", "小狗狗", "小鸡鸡", "小猫猫", "小咪咪"
//    };
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main3);
//        atv_content = (AutoCompleteTextView) findViewById(R.id.atv_content);
//        matv_content = (MultiAutoCompleteTextView) findViewById(R.id.matv_content);
//
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity6.
//                this, android.R.layout.simple_dropdown_item_1line, data);
//        atv_content.setAdapter(adapter);
//
//        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_dropdown_item_1line, data);
//        matv_content.setAdapter(adapter);
//        matv_content.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
//    }
}

