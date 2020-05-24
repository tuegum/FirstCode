package com.example.testforall.listView;


import android.app.ActionBar;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.testforall.R;

import java.util.ArrayList;
import java.util.List;


public class ListViewFragment extends Fragment {

    private List<Fruit> fruitList = new ArrayList<Fruit>();
    private ListView listView;

    /**
     * 隐藏导航栏
     */
    public  void hide(){

        ActionBar actionBar = this.getActivity().getActionBar();
        if (!(actionBar ==null)) {
            actionBar.hide();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_view, null, false);
        listView = view.findViewById(R.id.list_view);
        initFruits(); // 初始化水果数据
        FruitListAdapter adapter = new FruitListAdapter(getActivity(), R.layout.fruit_list_item, fruitList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                hide();
                Fruit fruit = fruitList.get(position);
                Toast.makeText(getActivity(), fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    private void initFruits() {
        for (int i = 0; i < 10; i++) {
            Fruit apple = new Fruit("Apple", R.drawable.apple);
            fruitList.add(apple);
            Fruit banana = new Fruit("Banana", R.drawable.banana);
            fruitList.add(banana);
            Fruit orange = new Fruit("Orange", R.drawable.orange);
            fruitList.add(orange);
            Fruit watermelon = new Fruit("Watermelon", R.drawable.watermelon);
            fruitList.add(watermelon);
            Fruit pear = new Fruit("Pear", R.drawable.pear);
            fruitList.add(pear);
            Fruit grape = new Fruit("Grape", R.drawable.grape);
            fruitList.add(grape);
            Fruit pineapple = new Fruit("Pineapple", R.drawable.pineapple);
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit("Strawberry", R.drawable.strawberry);
            fruitList.add(strawberry);
            Fruit cherry = new Fruit("Cherry", R.drawable.cherry);
            fruitList.add(cherry);
            Fruit mango = new Fruit("Mango", R.drawable.mango);
            fruitList.add(mango);
        }
    }
}
