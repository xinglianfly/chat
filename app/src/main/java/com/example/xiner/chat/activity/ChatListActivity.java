package com.example.xiner.chat.activity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.xiner.chat.R;
import com.example.xiner.chat.adapter.ChatListAdapter;

public class ChatListActivity extends ActionBarActivity {
    ImageView chatListig,contactsig,shakeig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_list);
        ListView chatlist =(ListView)findViewById(R.id.chatlist_ac_chatlist_lv);
        ChatListAdapter chatListAdapter = new ChatListAdapter(this);
        chatlist.setAdapter(chatListAdapter);
        ClickListener clickListener = new ClickListener();
        listClickListener listener = new listClickListener();
        chatlist.setOnItemClickListener(listener);
        chatListig =(ImageView)findViewById(R.id.threeac_ac_message_iv);
        chatListig.setOnClickListener(clickListener);
        contactsig=(ImageView)findViewById(R.id.threeac_ac_contacts_iv);
        contactsig.setOnClickListener(clickListener);
        shakeig=(ImageView)findViewById(R.id.threeac_ac_shake_iv);
        shakeig.setOnClickListener(clickListener);

    }

    class listClickListener implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Intent intent = new Intent(ChatListActivity.this,ChatActivity.class);
            startActivity(intent);
        }
    }

    class  ClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.threeac_ac_message_iv:

                    break;
                case R.id.threeac_ac_contacts_iv:
                    Intent intent = new Intent(ChatListActivity.this,ContactsActivity.class);
                    startActivity(intent);
                    break;
                case R.id.threeac_ac_shake_iv:
                    Intent intent1 = new Intent(ChatListActivity.this,ShakeActivity.class);
                    startActivity(intent1);
                    break;
                default:
            }
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }
}
