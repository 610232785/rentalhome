package com.platform.rentalhome.base;

import org.json.JSONObject;
import java.util.Map;

public class ResultBean extends JSONObject {

    public ResultBean() {
        put("code", 1);
    }

    public static String error() {
        return error(500, "未知异常，请联系管理员").toString();
    }

    public static String error(String msg) {
        return error(500, msg).toString();
    }

    public static String error(int code, String msg) {
        ResultBean r = new ResultBean();
        r.put("code", code);
        r.put("msg", msg);
        return r.toString();
    }

    public static String ok(int code, String msg) {
        ResultBean r = new ResultBean();
        r.put("code", code);
        r.put("msg", msg);
        return r.toString();
    }

    public static String ok(String msg) {
        ResultBean r = new ResultBean();
        r.put("msg", msg);
        return r.toString();
    }

    public static String ok(Object o) {
        ResultBean r = new ResultBean();
        r.put("data",o);
        return r.toString();
    }

    public static String ok() {
        return new ResultBean().toString();
    }

    public JSONObject put(String key, Object value) {
        if(null==value){
            value="";//JSON处理字符串会过滤null的参数
        }
        super.put(key, value);
        return this;
    }

    /**
     *
     * @param msg
     * @param o
     * @param num
     * @return
     */
    public static String ok(String msg,Object o,Integer num){
        ResultBean resultBean = new ResultBean();
        if (num != null){
            resultBean.put("num", num);
        }
        resultBean.put("msg", msg);
        resultBean.put("data", o);
        return resultBean.toString();
    }

}
