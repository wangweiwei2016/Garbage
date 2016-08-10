package com.example.a764l.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by 764l on 2016/8/5.
 */
public class MainActivity4 extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private List<Animal> mData = null;
    private Context mContext;
    private AnimalAdapter mAdapter = null;
    private ListView list_animal;

    private List<Person> mData2 = null;
    private Context mContext2;
    private ContactListAdapter mAdapter2 = null;
    private ListView list_animal2;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_animal_view);//R.layout.testadpter  出错

        mContext = MainActivity4.this;
        mContext2 = MainActivity4.this;

        list_animal = (ListView) findViewById(R.id.list_animal);

        //动态加载顶部View和底部View
        final LayoutInflater inflater = LayoutInflater.from(this);
        View headView = inflater.inflate(R.layout.view_header, null, false);
        View footView = inflater.inflate(R.layout.view_footer, null, false);

        mData = new LinkedList<Animal>();
        mData.add(new Animal("狗说", "你是狗么?", R.mipmap.ic_icon_dog));
        mData.add(new Animal("牛说", "你是牛么?", R.mipmap.ic_icon_cow));
        mData.add(new Animal("鸭说", "你是鸭么?", R.mipmap.ic_icon_duck));
        mData.add(new Animal("鱼说", "你是鱼么?", R.mipmap.ic_icon_fish));
        mData.add(new Animal("马说", "你是马么?", R.mipmap.ic_icon_horse));

        mData.add(new Animal("狗说", "你是狗么?", R.mipmap.ic_icon_dog));
        mData.add(new Animal("牛说", "你是牛么?", R.mipmap.ic_icon_cow));
        mData.add(new Animal("鸭说", "你是鸭么?", R.mipmap.ic_icon_duck));
        mData.add(new Animal("鱼说", "你是鱼么?", R.mipmap.ic_icon_fish));
        mData.add(new Animal("马说", "你是马么?", R.mipmap.ic_icon_horse));

        mData.add(new Animal("狗说", "你是狗么?", R.mipmap.ic_icon_dog));
        mData.add(new Animal("牛说", "你是牛么?", R.mipmap.ic_icon_cow));
        mData.add(new Animal("鸭说", "你是鸭么?", R.mipmap.ic_icon_duck));
        mData.add(new Animal("鱼说", "你是鱼么?", R.mipmap.ic_icon_fish));
        mData.add(new Animal("马说", "你是马么?", R.mipmap.ic_icon_horse));

        mData2 = new LinkedList<Person>();
        mData2.add(new Person("miss", "123456"));
        mData2.add(new Person("misaya", "102312414"));
        mData2.add(new Person("clearlove", "987632"));
        mData2.add(new Person("pdd", "215434"));

        mData2.add(new Person("miss", "123456"));
        mData2.add(new Person("misaya", "102312414"));
        mData2.add(new Person("clearlove", "987632"));
        mData2.add(new Person("pdd", "215434"));

        mData2.add(new Person("miss", "123456"));
        mData2.add(new Person("misaya", "102312414"));
        mData2.add(new Person("clearlove", "987632"));
        mData2.add(new Person("pdd", "215434"));

        mData2.add(new Person("miss", "123456"));
        mData2.add(new Person("misaya", "102312414"));
        mData2.add(new Person("clearlove", "987632"));
        mData2.add(new Person("pdd", "215434"));

        mData2.add(new Person("miss", "123456"));
        mData2.add(new Person("misaya", "102312414"));
        mData2.add(new Person("clearlove", "987632"));
        mData2.add(new Person("pdd", "215434"));


        mAdapter = new AnimalAdapter((LinkedList<Animal>) mData, mContext);
        mAdapter2 = new ContactListAdapter((List<Person>) mData2, mContext2);

        //添加表头和表尾需要写在setAdapter方法调用之前！！！
        list_animal.addHeaderView(headView);
        list_animal.addFooterView(footView);

        list_animal.setAdapter(mAdapter2);
        list_animal.setOnItemClickListener(this);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Toast.makeText(mContext, "你点击了第" + position + "项", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "MainActivity4 Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.a764l.myapplication/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "MainActivity4 Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.a764l.myapplication/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
