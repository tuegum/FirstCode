package com.example.testforfragment.TestForFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.testforfragment.R;

public class LeftFragment extends Fragment {

    //用inflater方法将刚刚定义的left_fragment布局动态的加载进来
    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.left_fragment,container,false);
        return view;
    }
}
