package com.example.testforall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.example.testforall.listView.ListViewFragment;
import com.example.testforall.others.TabLayoutFragment;
import com.example.testforall.recyclerView.RecyclerViewFragment;


public class RadioButtonActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup radioGroup;
    private FragmentManager fragmentManager;
    private ListViewFragment listViewFragment;
    private RecyclerViewFragment recyclerViewFragment;
    private TabLayoutFragment tabLayoutFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);

        radioGroup = findViewById(R.id.radio_group);
        radioGroup.setOnCheckedChangeListener(this);

        /**
         * 获取FragmentManager有两种方式
         * getFragmentManager()：对应SDK自带的原生Fragment(android.app.Fragment)
         * getSupportFragmentManager()：对应support包、androidx这种兼容包里的Fragment
         * 支持库版本的Fragment会比原生Fragment功能多些，bug更少。如果两个都可选的话，建议
         * 优先选择支持库版本的fragment
         *
         * fragment五部曲
         * 创建待添加的Fragment实例
         * 获取FragmentManager
         * 开启事务，通过beginTransaction()方法开启
         * 向容器中添加或替换Fragment
         * 提交事务，通过commit来完成。
         */

        fragmentManager = getSupportFragmentManager();

        listViewFragment = new ListViewFragment();
        recyclerViewFragment = new RecyclerViewFragment();
        tabLayoutFragment = new TabLayoutFragment();

        /**
         * 注意fragment的显示切换这里使用的是hide和show方式
         * hide和show方式不会销毁fragment，所以fragment的一些销毁相关的生命周期方法
         * 不会运行。而replace方式则会是销毁fragment，重建新的目标fragment。
         *
         * 这里是默认加载listViewFragment
         */
        fragmentManager.beginTransaction()
                .add(R.id.fragment_container, listViewFragment)
                .add(R.id.fragment_container, recyclerViewFragment)
                .add(R.id.fragment_container, tabLayoutFragment)
                .hide(recyclerViewFragment)
                .hide(tabLayoutFragment)
                .commit();
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rbt_list_view:
                fragmentManager.beginTransaction()
                        .hide(recyclerViewFragment)
                        .hide(tabLayoutFragment)
                        .show(listViewFragment)
                        .commit();
                break;
            case R.id.rbt_recycler_view:
                fragmentManager.beginTransaction()
                        .hide(listViewFragment)
                        .hide(tabLayoutFragment)
                        .show(recyclerViewFragment)
                        .commit();
                break;
            case R.id.rbt_others:
                fragmentManager.beginTransaction()
                        .hide(listViewFragment)
                        .hide(recyclerViewFragment)
                        .show(tabLayoutFragment)
                        .commit();
                break;
            default:
                break;
        }
    }
}