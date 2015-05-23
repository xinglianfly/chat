package com.example.xiner.chat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.example.xiner.chat.R;

/**
 * Created by xiner on 5/23/15.
 */
public class ChatListAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    public ChatListAdapter(Context context){
        this.context = context;

    }
    @Override
    public int getCount() {
        return 20;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView =LayoutInflater.from(context).inflate(R.layout.list_chatview,parent,false);
        return convertView;
    }
}
