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
public class ContactsAdapter extends BaseAdapter {

    Context context;
    public ContactsAdapter(Context context){
        this.context = context;
    }
    @Override
    public int getCount() {
        return 20;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.list_contacts,viewGroup,false);
        return view;
    }
}
