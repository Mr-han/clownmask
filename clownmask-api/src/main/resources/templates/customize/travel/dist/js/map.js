;(function () {
// 百度地图API功能
var map = new BMap.Map('allmap');
var poi = new BMap.Point(116.331398,39.897445);
map.centerAndZoom(poi, 10);
map.enableScrollWheelZoom();

//创建检索信息窗口对象
var searchInfoWindow = null;
searchInfoWindow = new BMapLib.SearchInfoWindow(map, '具体内容', {
    title  : "百度大厦",      //标题
    width  : 290,             //宽度
    panel  : "panel",         //检索结果面板
    enableAutoPan : true,     //自动平移
    searchTypes   :[
        BMAPLIB_TAB_SEARCH,   //周边检索
        BMAPLIB_TAB_TO_HERE,  //到这里去
        BMAPLIB_TAB_FROM_HERE //从这里出发
    ]
});
var marker = new BMap.Marker(poi); //创建marker对象
marker.enableDragging(); //marker可拖拽
marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
marker.addEventListener("click", function(e){
    searchInfoWindow.open(marker);
})
searchInfoWindow.open(marker);
map.addOverlay(marker); //在地图中添加marker
});