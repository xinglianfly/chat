package com.example.xiner.chat.activity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.xiner.chat.R;

public class RegisterActivity extends AppCompatActivity {

    Toolbar toolbar;
    Button registerBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        init();
    }

    private void init(){
        ClickListener clickListener = new ClickListener();
        registerBt =(Button)findViewById(R.id.register_ac_register_bt);
        registerBt.setOnClickListener(clickListener);
    }

    class ClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.register_ac_register_bt:
                    Intent intent = new Intent();
                    intent.setClass(RegisterActivity.this,ChatListActivity.class);
                    startActivity(intent);
                    break;
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
