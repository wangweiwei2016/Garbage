package com.example.a764l.myapplication;

/**
 * Created by 764l on 2016/8/3.
 */

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Calendar;

public class MainActivity2 extends Activity implements CompoundButton.OnCheckedChangeListener,View.OnClickListener,Chronometer.OnChronometerTickListener,DatePicker.OnDateChangedListener{

    private Button btn_add;
    private EditText edit_one;
    private ToggleButton tglbtn1;
    private Switch switch1;
    private Chronometer chronometer;
    private Button btn_start,btn_stop,btn_base,btn_format;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_chronometers);
         initView();
        DatePicker dp_test = (DatePicker) findViewById(R.id.datepicker1);
        Calendar calendar = Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        int monthOfYear=calendar.get(Calendar.MONTH);
        int dayOfMonth=calendar.get(Calendar.DAY_OF_MONTH);
        dp_test.init(year,monthOfYear,dayOfMonth,this);
//        tglbtn1 = (ToggleButton) findViewById(R.id.tglbtn1);
//        switch1 = (Switch) findViewById(R.id.switch1);
//        tglbtn1.setOnCheckedChangeListener(this);
//        switch1.setOnCheckedChangeListener(this);
//        btn_add = (Button) findViewById(R.id.btn_add);
//        edit_one = (EditText) findViewById(R.id.edit_one);
//        btn_add.setOnClickListener(new View.OnClickListener() {
//            @TargetApi(Build.VERSION_CODES.CUPCAKE)
//            @Override
//            public void onClick(View v) {
//                SpannableString spanStr = new SpannableString("imge");
//                Drawable drawable = MainActivity2.this.getResources().getDrawable(R.drawable.f045);
//                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
//                ImageSpan span = new ImageSpan(drawable,ImageSpan.ALIGN_BASELINE);
//                spanStr.setSpan(span,0,4,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//                int cursor = edit_one.getSelectionStart();
//                edit_one.getText().insert(cursor, spanStr);
//            }
//        });


//        TextView t1 = (TextView)findViewById(R.id.txtFour);

//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < 20; i++) {
//            sb.append("好友" + i + "，");
//        }
//
//        String likeUsers = sb.substring(0, sb.lastIndexOf("，")).toString();
//        t1.setMovementMethod(LinkMovementMethod.getInstance());
//        t1.setText(addClickPart(likeUsers), TextView.BufferType.SPANNABLE);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()){
            case R.id.tglbtn1:
                if(compoundButton.isChecked()) Toast.makeText(this,"打开声音",Toast.LENGTH_SHORT).show();
                else Toast.makeText(this,"打开声音",Toast.LENGTH_SHORT).show();
                break;
            case R.id.switch1:
                if(compoundButton.isChecked()) Toast.makeText(this,"开关:ON",Toast.LENGTH_SHORT).show();
                else Toast.makeText(this,"开关:OFF",Toast.LENGTH_SHORT).show();
                break;

        }
    }

    //定义一个点击每个部分文字的处理方法
    private SpannableStringBuilder addClickPart(String str) {
        //赞的图标，这里没有素材，就找个笑脸代替下~
        ImageSpan imgspan = new ImageSpan(MainActivity2.this, R.drawable.ic_widget_face);
        SpannableString spanStr = new SpannableString("p.");
        spanStr.setSpan(imgspan, 0, 1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);

        //创建一个SpannableStringBuilder对象，连接多个字符串
        SpannableStringBuilder ssb = new SpannableStringBuilder(spanStr);
        ssb.append(str);
        String[] likeUsers = str.split("，");
        if (likeUsers.length > 0) {
            for (int i = 0; i < likeUsers.length; i++) {
                final String name = likeUsers[i];
                final int start = str.indexOf(name) + spanStr.length();
                ssb.setSpan(new ClickableSpan() {
                    @Override
                    public void onClick(View widget) {
                        //点击事件
                        Toast.makeText(MainActivity2.this, name,
                                Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void updateDrawState(TextPaint ds) {
                        super.updateDrawState(ds);
                        //删除下划线，设置字体颜色为蓝色
                        ds.setColor(Color.BLUE);
                        ds.setUnderlineText(false);
                    }
                },start,start + name.length(),0);
            }
        }
        return ssb.append("等" + likeUsers.length + "个人觉得很赞");

//        String s1 = "<font color='blue'><b>百度一下，你就知道~：</b></font><br>";
//        s1 += "<a href = 'http://www.baidu.com'>百度</a>";
//        t1.setText(Html.fromHtml(s1));
//        t1.setMovementMethod(LinkMovementMethod.getInstance());

//        String s2 = "图片：<img src = 'icon'/><br>";
//        t1.setText(Html.fromHtml(s2, new Html.ImageGetter() {
//            @Override
//            public Drawable getDrawable(String source) {
//                Drawable draw = null;
//                try {
//                    Field field = R.drawable.class.getField(source);
//                    int resourceId = Integer.parseInt(field.get(null).toString());
//                    draw = getResources().getDrawable(resourceId);
//                    draw.setBounds(0, 0, draw.getIntrinsicWidth(), draw.getIntrinsicHeight());
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                return draw;
//            }
//        }, null));

//        SpannableString span = new SpannableString("红色打电话斜体删除线绿色下划线图片:.");
//        //1.设置背景色,setSpan时需要指定的flag,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE(前后都不包括)
//        span.setSpan(new ForegroundColorSpan(Color.RED), 0, 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        //2.用超链接标记文本
//        span.setSpan(new URLSpan("tel:4155551212"), 2, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        //3.用样式标记文本（斜体）
//        span.setSpan(new StyleSpan(Typeface.BOLD_ITALIC), 5, 7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        //4.用删除线标记文本
//        span.setSpan(new StrikethroughSpan(), 7, 10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        //5.用下划线标记文本
//        span.setSpan(new UnderlineSpan(), 10, 16, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        //6.用颜色标记
//        span.setSpan(new ForegroundColorSpan(Color.GREEN), 10, 13,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        //7.//获取Drawable资源
//        Drawable d = getResources().getDrawable(R.drawable.icon);
//        d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
//        //8.创建ImageSpan,然后用ImageSpan来替换文本
//        ImageSpan imgspan = new ImageSpan(d, ImageSpan.ALIGN_BASELINE);
//        span.setSpan(imgspan, 18, 19, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
//        t1.setText(span);

//        FrameLayout frame = (FrameLayout) findViewById(R.id.mylayout);
//        final MeziView mezi = new MeziView(MainActivity2.this);
//        //为我们的萌妹子添加触摸事件监听器
//        mezi.setOnTouchListener(new OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent event) {
//                //设置妹子显示的位置
//                mezi.bitmapX = event.getX() - 150;
//                mezi.bitmapY = event.getY() - 150;
//                //调用重绘方法
//                mezi.invalidate();
//                return true;
//            }
//        });
//        frame.addView(mezi);
    }
    public void initView(){
        chronometer = (Chronometer) findViewById(R.id.chronometer1);
        btn_start = (Button) findViewById(R.id.btnStart);
        btn_stop = (Button) findViewById(R.id.btnStop);
        btn_base = (Button) findViewById(R.id.btnReset);
        btn_format = (Button) findViewById(R.id.btn_format);

        chronometer.setOnChronometerTickListener(this);
        btn_start.setOnClickListener(this);
        btn_stop.setOnClickListener(this);
        btn_base.setOnClickListener(this);
        btn_format.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnStart:
                chronometer.start();// 开始计时
                break;
            case R.id.btnStop:
                chronometer.stop();// 停止计时
                break;
            case R.id.btnReset:
                chronometer.setBase(SystemClock.elapsedRealtime());// 复位
                break;
            case R.id.btn_format:
                chronometer.setFormat("Time：%s");// 更改时间显示格式
                break;
        }
    }
    @Override
    public void onChronometerTick(Chronometer chronometer) {
        String time = chronometer.getText().toString();
        if(time.equals("00:00")){
            Toast.makeText(MainActivity2.this,"时间到了~",Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
        Toast.makeText(MainActivity2.this,"您选择的日期是："+i+"年"+(i1+1)+"月"+i2+"日!",Toast.LENGTH_SHORT).show();
    }
}
