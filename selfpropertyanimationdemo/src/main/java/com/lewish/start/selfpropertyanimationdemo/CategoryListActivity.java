package com.lewish.start.selfpropertyanimationdemo;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.lewish.start.selfpropertyanimationdemo.movepoint.PointActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CategoryListActivity extends ListActivity
{
    private List<String> mData = new ArrayList<String>(Arrays.asList(
            "ObjectAnimator的方式创建动画", "组合动画的实现",
            "ValueAnimator的方式创建动画", "Layout Animator","Evaluator Demo"));
    private ListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mData);
        getListView().setAdapter(mAdapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id)
    {

        Intent intent = null;
        switch (position)
        {
            case 0:
                intent = new Intent(this, ObjectAnimActivity.class);
                break;
            case 1:
                intent = new Intent(this, AnimatorSetActivity.class);
                break;
            case 2:
                intent = new Intent(this, ValueAnimatorActivity.class);
                break;
            case 3:
                intent = new Intent(this, LayoutAnimActivity.class);
                break;
            case 4:
                intent = new Intent(this, PointActivity.class);
                break;
//            case 5:
//                intent = new Intent(this, ValueAnimatorActivity.class);
//                break;
        }
        startActivity(intent);
    }
}

