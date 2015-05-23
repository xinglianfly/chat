package com.example.xiner.chat.utiles;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

import com.example.xiner.chat.activity.MapActivity;

/**
 * Created by xiner on 5/18/15.
 */
public class ShakeListenerUtils implements SensorEventListener {

    Activity mContext;
    public ShakeListenerUtils(Activity mContext){
        this.mContext = mContext;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        int sensorType = event.sensor.getType();
        float [] values = event.values;

        if (sensorType == Sensor.TYPE_ACCELEROMETER){
            if ((Math.abs(values[0]) > 17 || Math.abs(values[1])>17 || Math.abs(values[2]) > 17)){

                Intent intent = new Intent(mContext, MapActivity.class);
                mContext.startActivity(intent);
                mContext.finish();
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //当传感器精度改变时回调该方法，Do nothing
    }


}
