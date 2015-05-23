package com.example.xiner.chat.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.xiner.chat.MainActivity;
import com.example.xiner.chat.R;
import com.example.xiner.chat.views.BitMapblur;
import com.example.xiner.chat.views.CircularImage;

public class PersonInfoActivity extends ActionBarActivity{

    ImageView mImage;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_info);
        mImage =(CircularImage)findViewById(R.id.personinfo_ac_head_ig);
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.mipmap.xiaoqingxin);
        mImage.setImageBitmap(bmp);
        relativeLayout =(RelativeLayout)findViewById(R.id.personinfo_ac_rela);
        blur(relativeLayout);

    }

    private void blur( final RelativeLayout mImage){
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.mipmap.xiaoqingxin);
        final Bitmap blurBmp = BitMapblur.fastblur(PersonInfoActivity.this, bmp, 12);
        mImage.post(new Runnable() {
            @Override
            public void run() {
                Drawable d = new BitmapDrawable(getResources(), blurBmp);
                mImage.setBackgroundDrawable(d);
            }
        });
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
