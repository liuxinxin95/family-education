//package com.education.util;
//
///**
// * @author Carl
// * @ClassName DistanceUtil
// * @Description
// * @date 2019-10-02 07:42
// **/
//public class DistanceUtil {
//
//    public static void get(double radii, double lon, double lat){
//        //地球半径千米
//        double r = 6371;
//        double dis = radii;
//        double dlng =  2*Math.asin(Math.sin(dis/(2*r))/Math.cos(lat*Math.PI/180));
//        //角度转为弧度
//        dlng = dlng*180/Math.PI;
//        double dlat = dis/r;
//        dlat = dlat*180/Math.PI;
//        double minlat =lat-dlat;
//        double maxlat = lat+dlat;
//        double minlng = lon -dlng;
//        double maxlng = lon + dlng;
//    }
//}
