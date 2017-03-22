# SwipeBack
SwipeBackLayout侧滑关闭页面

## 效果预览
![](https://github.com/bjchenxz/SwipeBack/raw/master/gif/1.gif)
## 使用方式
### build.gradle文件
```
compile 'com.cxz:swipebacklibrary:1.0.0'
```
### Activity继承SwipeBackActivity
```
public class MainActivity extends SwipeBackActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
		...
		SwipeBackLayout mSwipeBackLayout = getSwipeBackLayout();
	}
}
```
### 设置滑动关闭的方向
```
mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
```
### 添加滑动事件监听
```
mSwipeBackLayout.addSwipeListener(new SwipeBackLayout.SwipeListener() {
    @Override
    public void onScrollStateChange(int state, float scrollPercent) {
    }
    @Override
    public void onEdgeTouch(int edgeFlag) {
        vibrate(VIBRATE_DURATION);
    }
    @Override
    public void onScrollOverThreshold() {
        vibrate(VIBRATE_DURATION);
    }
});
```