package com.example.testforall.recyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.testforall.R;
import com.example.testforall.listView.Fruit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecyclerViewFragment extends Fragment {

    private List<Fruit> fruitList = new ArrayList<Fruit>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler, null);
        initFruits();
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);

        //传入的是 StaggeredGridLayoutManager参数的话，可以展示瀑布流的形式
        StaggeredGridLayoutManager layoutManager = new
                StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        //如果传入的是LinearLayoutManager，表现则会像listView形式相同
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
//        recyclerView.setLayoutManager(linearLayoutManager);

        FruitRecyclerAdapter adapter = new FruitRecyclerAdapter(fruitList);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private void initFruits() {
        for (int i = 0; i < 10; i++) {
            Fruit apple = new Fruit(getRandomLengthName("Apple"), R.mipmap.apple_pic);
            fruitList.add(apple);
            Fruit banana = new Fruit(getRandomLengthName("Banana"), R.mipmap.banana_pic);
            fruitList.add(banana);
            Fruit orange = new Fruit(getRandomLengthName("Orange"), R.mipmap.orange_pic);
            fruitList.add(orange);
            Fruit watermelon = new Fruit(getRandomLengthName("Watermelon"), R.mipmap.watermelon_pic);
            fruitList.add(watermelon);
            Fruit pear = new Fruit(getRandomLengthName("Pear"), R.mipmap.pear_pic);
            fruitList.add(pear);
            Fruit grape = new Fruit(getRandomLengthName("Grape"), R.mipmap.grape_pic);
            fruitList.add(grape);
            Fruit pineapple = new Fruit(getRandomLengthName("Pineapple"), R.mipmap.pineapple_pic);
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit(getRandomLengthName("Strawberry"), R.mipmap.strawberry_pic);
            fruitList.add(strawberry);
            Fruit cherry = new Fruit(getRandomLengthName("Cherry"), R.mipmap.cherry_pic);
            fruitList.add(cherry);
            Fruit mango = new Fruit(getRandomLengthName("Mango"), R.mipmap.mango_pic);
            fruitList.add(mango);
        }
    }

    private String getRandomLengthName(String name) {
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(name);
        }
        return builder.toString();
    }
}
