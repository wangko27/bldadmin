package com.cnarj.ttxs.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: liz
 * Date: 13-6-25
 * Time: P.M.3:07
 * 商品推荐区域常量类
 */
public class RecommendArea {
    public static  final  String INDEX_PAGE = "1";//首页
    public static  final  String MIAOSHA_INDEX_PAGE= "2";//首页秒杀区

    public static Map<String,String> map = new HashMap<String, String>();

    static {
        map.put(INDEX_PAGE,"首页");
        map.put(MIAOSHA_INDEX_PAGE,"首页秒杀区");
    }

}
