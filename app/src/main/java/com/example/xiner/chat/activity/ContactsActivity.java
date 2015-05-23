package com.example.xiner.chat.activity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.xiner.chat.R;
import com.example.xiner.chat.adapter.ContactsAdapter;

public class ContactsActivity extends ActionBarActivity {

    ListView contactList;
    ContactsAdapter adapter;
    ImageView chatListig,contactsig,shakeig;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        contactList =(ListView)findViewById(R.id.contacts_list_ac_lv);
        adapter = new ContactsAdapter(this);
        contactList.setAdapter(adapter);
        ClickListener clickListener = new ClickListener();
        chatListig =(ImageView)findViewById(R.id.threeac_ac_message_iv);
        chatListig.setOnClickListener(clickListener);
        contactsig=(ImageView)findViewById(R.id.threeac_ac_contacts_iv);
        contactsig.setOnClickListener(clickListener);
        shakeig=(ImageView)findViewById(R.id.threeac_ac_shake_iv);
        shakeig.setOnClickListener(clickListener);

    }

    class  ClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.threeac_ac_message_iv:
                    Intent intent = new Intent(ContactsActivity.this,ChatListActivity.class);
                    startActivity(intent);
                    break;
                case R.id.threeac_ac_contacts_iv:
//                    Intent intent2 = new Intent(ContactsActivity.this,ContactsActivity.class);
//                    startActivity(intent2);
                    break;
                case R.id.threeac_ac_shake_iv:
                    Intent intent1 = new Intent(ContactsActivity.this,ShakeActivity.class);
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
