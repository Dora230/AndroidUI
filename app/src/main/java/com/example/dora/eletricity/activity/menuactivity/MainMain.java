package com.example.dora.eletricity.activity.menuactivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.dora.eletricity.R;
import com.example.dora.eletricity.framgment.FxFragment;
import com.example.dora.eletricity.framgment.SzFragment;
import com.example.dora.eletricity.framgment.TxlFragment;
import com.example.dora.eletricity.framgment.WxFragment;

/**
 * Created by Dora on 2021/4/20.
 */

public class MainMain extends AppCompatActivity implements View.OnClickListener {

    private DrawerLayout mDrawableLayout;

    private LinearLayout llTabWx, llTabTxl, llTabFx, llTabSz;
    private ImageView imgWx, imgTxl, imgFx, imgSz;
    private WxFragment tabwx;
    private TxlFragment tabtxl;
    private FxFragment tabfx;
    private SzFragment tabsz;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //标题栏
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        //滑动菜单
        mDrawableLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
//        //优化滑动菜单使用NaviView必须要引入依赖闭包
//        //滑动菜单优化
        NavigationView navView = (NavigationView) findViewById(R.id.nav_view);
//
//
//        //底部栏切换实现
        initView();
        llTabWx.setOnClickListener(this);
        llTabTxl.setOnClickListener(this);
        llTabFx.setOnClickListener(this);
        llTabSz.setOnClickListener(this);


//        FragmentManager fm=getFragmentManager();
//        FragmentTransaction transaction = fm.beginTransaction();
//        transaction.add(R.id.content,tabwx);
//        transaction.commit();

//        //图标跳出隐藏菜单
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.person);
        }
//        //菜单页  ，默认选中call，点击时收起菜单页
        //navView.setCheckedItem(R.id.nav_call);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Intent intent = new Intent();

                switch (item.getItemId()) {
                    case R.id.nav_call:

                        intent.setClass(getApplicationContext(), Call_Activity.class);

                        break;
                    case R.id.nav_friends:


                        break;
                    case R.id.nav_location:


                        break;

                }
                // this.startActivity(intent);

                mDrawableLayout.closeDrawers();
                return true;
            }

        });

    }

    //    //标题栏图标实现方法
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    //    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            //HomeAsUp按钮的id永远都是android.R.id.home
            case android.R.id.home:
                mDrawableLayout.openDrawer(GravityCompat.START);
                //DrawableLayout中的openDrawer方法将滑动菜单显示出来
                break;
            case R.id.backup:
                Toast.makeText(this, "You Clicked Backup", Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                Toast.makeText(this, "You Clicked delete", Toast.LENGTH_SHORT).show();
                break;
            case R.id.settings:
                Toast.makeText(this, "You Clicked Settings", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    void initView() {

        llTabWx = (LinearLayout) this.findViewById(R.id.llwx);
        llTabTxl = (LinearLayout) this.findViewById(R.id.lltxl);
        llTabFx = (LinearLayout) this.findViewById(R.id.llfx);
        llTabSz = (LinearLayout) this.findViewById(R.id.llsz);

        imgWx = (ImageView) this.findViewById(R.id.imgwx);
        imgTxl = (ImageView) this.findViewById(R.id.imgtxl);
        imgFx = (ImageView) this.findViewById(R.id.imgfx);
        imgSz = (ImageView) this.findViewById(R.id.imgsz);

    }

    public void onClick(View v) {

        FragmentManager fm=getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

        imgWx.setImageResource(R.mipmap.tack1);
        imgTxl.setImageResource(R.mipmap.tack2);
        imgFx.setImageResource(R.mipmap.tack3);
        imgSz.setImageResource(R.mipmap.tack4);


        switch (v.getId()){
            case R.id.llwx:

                tabwx= new WxFragment();
                transaction.replace(R.id.content,tabwx);
                imgWx.setImageResource(R.mipmap.tack1_1);


                break;
            case R.id.lltxl:

                tabtxl= new TxlFragment();
                transaction.replace(R.id.content,tabtxl);
                imgTxl.setImageResource(R.mipmap.tack2_2);

                break;
            case R.id.llfx:

                tabfx= new FxFragment();
                transaction.replace(R.id.content,tabfx);
                imgFx.setImageResource(R.mipmap.tack3_1);

                break;
            case R.id.llsz:

                tabsz= new SzFragment();
                transaction.replace(R.id.content,tabsz);
                imgSz.setImageResource(R.mipmap.tack4_1);

                break;
        }

        transaction.commit();

    }
}



