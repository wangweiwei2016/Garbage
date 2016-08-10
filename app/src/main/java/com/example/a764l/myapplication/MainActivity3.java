package com.example.a764l.myapplication;

/**
 * Created by 764l on 2016/8/3.
 */

import android.app.Activity;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.ContactsContract;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


public class MainActivity3 extends Activity {
    //初始化变量,帧布局
    FrameLayout frame = null;
    //自定义一个用于定时更新UI界面的handler类对象
    Handler handler = new Handler()
    {
        int i = 0;
        @Override
        public void handleMessage(Message msg) {
            //判断信息是否为本应用发出的
            if(msg.what == 0x123)
            {
                i++;
                move(i % 8 );
            }
            super.handleMessage(msg);
        }
    };
    private String[] names = new String[]{"盖伦", "赵信", "嘉文"};
    private String[] says = new String[]{"我将带头冲锋!", "长枪依在！", "犯我德邦者，虽远必诛！"};
    private int[] imgIds = new int[]{R.mipmap.head_icon1, R.mipmap.head_icon2, R.mipmap.head_icon3};
    //头像

    //定义走路时切换图片的方法
    void move(int i)
    {
        Drawable a = getResources().getDrawable(R.drawable.s_1);
        Drawable b = getResources().getDrawable(R.drawable.s_2);
        Drawable c = getResources().getDrawable(R.drawable.s_3);
        Drawable d = getResources().getDrawable(R.drawable.s_4);
        Drawable e = getResources().getDrawable(R.drawable.s_5);
        Drawable f = getResources().getDrawable(R.drawable.s_6);
        Drawable g = getResources().getDrawable(R.drawable.s_7);
        Drawable h = getResources().getDrawable(R.drawable.s_8);
        //通过setForeground来设置前景图像
        switch(i)
        {
            case 0:
                frame.setForeground(a);
                break;
            case 1:
                frame.setForeground(b);
                break;
            case 2:
                frame.setForeground(c);
                break;
            case 3:
                frame.setForeground(d);
                break;
            case 4:
                frame.setForeground(e);
                break;
            case 5:
                frame.setForeground(f);
                break;
            case 6:
                frame.setForeground(g);
                break;
            case 7:
                frame.setForeground(h);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testadapter);
       //要显示的数据
//        String[] strs = {"aaa","bbb","ccc","ddd","eee"};
//        //创建ArrayAdapter
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,strs);
//        //获取ListView对象，通过调用setAdapter方法为ListView设置Adapter设置适配器
         ListView list_test = (ListView) findViewById(R.id.list_test);
//        list_test.setAdapter(adapter);

//        List<String> data=new ArrayList<String>();
//        data.add("第一条");
//        data.add("第二条");
//        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,data);
//       ListView list_test2= (ListView) findViewById(R.id.list_test2);
//        list_test.setAdapter(adapter2);

//        List<Map<String, Object>> listitem = new ArrayList<Map<String, Object>>();
//        for (int i = 0; i < names.length; i++) {
//            Map<String, Object> showitem = new HashMap<String, Object>();
//            showitem.put("head", imgIds[i]);
//            showitem.put("name", names[i]);
//            showitem.put("says", says[i]);
//            listitem.add(showitem);
//        }
//
//        //创建一个simpleAdapter
//        SimpleAdapter myAdapter = new SimpleAdapter(getApplicationContext(), listitem, R.layout.list_item,
//                new String[]{"head", "name", "says"}, new int[]{R.id.imgtou, R.id.name, R.id.says});
//        ListView listView = (ListView) findViewById(R.id.list_test);
//        listView.setAdapter(myAdapter);

        //读取联系人
        Cursor cursor = getContentResolver()
                .query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        SimpleCursorAdapter spcAdapter = new SimpleCursorAdapter(this,R.layout.list_item2,cursor,
                new String[]{ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER},
                new int[]{R.id.list_name,R.id.list_phone});
        list_test.setAdapter(spcAdapter);

//        TimePicker tpc= (TimePicker) findViewById(R.id.timepicker1);
//        tpc.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener(){
//
//            @Override
//            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
//                Toast.makeText(MainActivity3.this, "你选择的时间是："+i+"时"+i1+"分！", Toast.LENGTH_SHORT).show();
//            }
//        });
//        frame = (FrameLayout) findViewById(R.id.myframe);
//        //定义一个定时器对象,定时发送信息给handler
//        new Timer().schedule(new TimerTask() {
//
//            @Override
//            public void run() {
//                //发送一条空信息来通知系统改变前景图片
//                handler.sendEmptyMessage(0x123);
//            }
//        }, 0,170);
    }
}