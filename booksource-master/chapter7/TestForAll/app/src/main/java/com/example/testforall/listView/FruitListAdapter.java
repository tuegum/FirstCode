package com.example.testforall.listView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testforall.R;

import java.util.List;

/**
 * 这里为了简便，继承的是ArrayAdapter(ArrayAdapter是BaseAdapter的一个子类)，
 * 有时为了实现更多的定制内容，会选择继承BaseAdapter
 */
public class FruitListAdapter extends ArrayAdapter<Fruit> {

    private int resourceId;

    public FruitListAdapter(Context context, int textViewResourceId,List<Fruit> objects) {

        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Fruit fruit = getItem(position); // 获取当前项的Fruit实例
        View view;
        ViewHolder viewHolder;

        /**
         * 注意这里的性能优化
         * 复用convertView
         * ViewHolder的引入，getTag()
         */
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.fruitImage = view.findViewById(R.id.fruit_image);
            viewHolder.fruitName = view.findViewById(R.id.fruit_name);
            view.setTag(viewHolder); // 将ViewHolder存储在View中
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag(); // 重新获取ViewHolder
        }
        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(fruit.getName());
        return view;
    }

    class ViewHolder {
        ImageView fruitImage;
        TextView fruitName;
    }

}
