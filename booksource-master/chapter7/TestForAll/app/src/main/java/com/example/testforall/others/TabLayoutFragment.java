package com.example.testforall.others;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.example.testforall.R;

import java.util.ArrayList;
import java.util.List;

public class TabLayoutFragment extends Fragment {


    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment> fragments;
    private String[] titles = {"标题1", "标题2", "标题3"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tablayout, null);
        initView(view);
        initData();
        initAdapter();
        return view;
    }

    private void initView(View view) {
        tabLayout = view.findViewById(R.id.table_layout);
        viewPager = view.findViewById(R.id.view_pager);

        //通过setupWithViewPager使得tabLayout和viewPager绑定在一块
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initData() {
        fragments = new ArrayList<>();
        fragments.add(new Component1Fragment());
        fragments.add(new Component2Fragment());
        fragments.add(new Component3Fragment());
    }

    private void initAdapter() {
        viewPager.setAdapter(new FragmentStatePagerAdapter(getActivity().getSupportFragmentManager()) {


            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }


            @Override
            public int getCount() {
                return fragments.size();
            }


            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }
        });
    }
}
