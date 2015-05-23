package com.example.xiner.chat.activity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.GroundOverlayOptions;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.TextOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.example.xiner.chat.MainActivity;
import com.example.xiner.chat.R;

import java.util.ArrayList;

public class MapActivity extends ActionBarActivity {

    MapView mMapView;
    private Marker mMarkerA;
    private Marker mMarkerB;
    private Marker mMarkerC;
    private Marker mMarkerD;
    private BitmapDescriptor bitmapDescriptor;
//    private BitmapDescriptor bdGround;

    BaiduMap baiduMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SDKInitializer.initialize(getApplicationContext());

        setContentView(R.layout.activity_map);
        bitmapDescriptor = BitmapDescriptorFactory.fromResource(R.mipmap.icon_gcoding);
//        bdGround = BitmapDescriptorFactory
//                .fromResource(R.mipmap.ground_overlay);

        mMapView = (MapView) findViewById(R.id.bmapView);
        baiduMap = mMapView.getMap();
        MapStatusUpdate mapStatusUpdate = MapStatusUpdateFactory.zoomTo(14.0f);
        baiduMap.setMapStatus(mapStatusUpdate);
        initOverlay();

    }

    private void initOverlay(){
        LatLng llA = new LatLng(39.963175, 116.400244);
        LatLng llB = new LatLng(39.942821, 116.369199);
        LatLng llC = new LatLng(39.939723, 116.425541);
        LatLng llD = new LatLng(39.906965, 116.401394);
        OverlayOptions ooA = new MarkerOptions().position(llA).icon(bitmapDescriptor)
                .zIndex(9).draggable(true);
        mMarkerA = (Marker) (baiduMap.addOverlay(ooA));
        OverlayOptions ooB = new MarkerOptions().position(llB).icon(bitmapDescriptor)
                .zIndex(5);
        mMarkerB = (Marker) (baiduMap.addOverlay(ooB));
        OverlayOptions ooC = new MarkerOptions().position(llC).icon(bitmapDescriptor)
                .zIndex(7);
        mMarkerC = (Marker) (baiduMap.addOverlay(ooC));
        ArrayList<BitmapDescriptor> giflist = new ArrayList<BitmapDescriptor>();
        giflist.add(bitmapDescriptor);
        giflist.add(bitmapDescriptor);
        giflist.add(bitmapDescriptor);
        OverlayOptions textOption = new TextOptions()
                .bgColor(0xAAFFFF00)
                .fontSize(24)
                .fontColor(0xFFFF00FF)
                .text("百度地图SDK")
                .position(llA);
//在地图上添加该文字对象并显示
        baiduMap.addOverlay(textOption);

        baiduMap.setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if (marker==mMarkerA){
                    Toast.makeText(MapActivity.this,"A is click",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    intent.setClass(MapActivity.this,PersonInfoActivity.class);
                    startActivity(intent);
                }else if (marker==mMarkerB){
                    Toast.makeText(MapActivity.this,"B is click",Toast.LENGTH_SHORT).show();

                }
                return false;
            }
        });

        baiduMap.setOnMarkerDragListener(new BaiduMap.OnMarkerDragListener() {
            public void onMarkerDrag(Marker marker) {
            }

            public void onMarkerDragEnd(Marker marker) {
                Toast.makeText(
                        MapActivity.this,
                        "拖拽结束，新位置：" + marker.getPosition().latitude + ", "
                                + marker.getPosition().longitude,
                        Toast.LENGTH_LONG).show();
            }

            public void onMarkerDragStart(Marker marker) {
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

    @Override
    protected void onPause() {
        // MapView的生命周期与Activity同步，当activity挂起时需调用MapView.onPause()
        mMapView.onPause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        // MapView的生命周期与Activity同步，当activity恢复时需调用MapView.onResume()
        mMapView.onResume();
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        // MapView的生命周期与Activity同步，当activity销毁时需调用MapView.destroy()
        mMapView.onDestroy();
        super.onDestroy();
        // 回收 bitmap 资源
        bitmapDescriptor.recycle();

    }

}
