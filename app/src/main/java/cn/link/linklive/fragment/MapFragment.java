package cn.link.linklive.fragment;

import android.view.View;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;

import cn.link.linklive.R;


public class MapFragment extends BaseFragment implements View.OnClickListener{
    private MapView mapView=null;
    private BaiduMap mBaiduMap=null;
    public MapFragment() {

    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_map;
    }

    @Override
    protected void initView() {
        mapView=bind(R.id.mapView);
        mBaiduMap = mapView.getMap();
        //地图上比例尺
        mapView.showScaleControl(false);
        // 隐藏缩放控件
        mapView.showZoomControls(false);
        // 去掉百度地图Logo
        mapView.removeViewAt(1);
        MapStatusUpdate msu = MapStatusUpdateFactory.zoomTo(15.0f);//缩放等级
        mBaiduMap.setMapStatus(msu);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {

    }
}
