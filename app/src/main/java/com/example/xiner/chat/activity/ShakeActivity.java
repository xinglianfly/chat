package com.example.xiner.chat.activity;

import android.app.Service;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Vibrator;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.xiner.chat.R;
import com.example.xiner.chat.utiles.ShakeListenerUtils;

import java.util.Map;

public class ShakeActivity extends ActionBarActivity implements SensorEventListener{

    SensorManager mSensorManager;
    ImageView chatListig,contactsig,shakeig;

    //    ShakeListenerUtils utils;
    Vibrator vibrator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shake);
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
                    Intent intent2 = new Intent(ShakeActivity.this,ChatListActivity.class);
                    startActivity(intent2);
                    break;
                case R.id.threeac_ac_contacts_iv:
                    Intent intent = new Intent(ShakeActivity.this,ContactsActivity.class);
                    startActivity(intent);
                    break;
                case R.id.threeac_ac_shake_iv:
//                    Intent intent1 = new Intent(ShakeActivity.this,ShakeActivity.class);
//                    startActivity(intent1);
                    break;
                default:
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        vibrator = (Vibrator) getSystemService(Service.VIBRATOR_SERVICE);

        mSensorManager.registerListener(this,mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
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

    @Override
    public void onSensorChanged(SensorEvent event) {
        int sensorType = event.sensor.getType();
        float [] values = event.values;

        if (sensorType == Sensor.TYPE_ACCELEROMETER){
            if ((Math.abs(values[0]) > 17 || Math.abs(values[1])>17 || Math.abs(values[2]) > 17)){

                vibrator.vibrate(500);
                Toast.makeText(this,"摇一摇",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(this, MapActivity.class);
                startActivity(intent);
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
