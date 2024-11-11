package com.hospital.hospitalmanagementsystem.dto;

public class ResultMessage {


    public static ResultMessage success(){
        return  new ResultMessage(200,"ok",null);
    }

    public static ResultMessage success(Object obj){
        return  new ResultMessage(200,"ok",obj);
    }

    public static ResultMessage success(String msg){
        return  new ResultMessage(200,msg,null);

    }
    public static ResultMessage success(String msg,Object obj){
        return  new ResultMessage(200,msg,obj);
    }

    public static ResultMessage error(){
        return  new ResultMessage(500,"error",null);
    }
    public static ResultMessage error(String msg){
        return  new ResultMessage(500,msg,null);
    }

    public static ResultMessage error(int code){
        String msg="error";
        if(code == 400){
            msg="Can't find anything";
        }
        return  new ResultMessage(code,msg,null);
    }


    public static ResultMessage error(int code,String msg){
        return  new ResultMessage(code,msg,null);
    }


    public ResultMessage(){}

    public ResultMessage(int statusCode, String msg, Object result) {
        this.statusCode=statusCode;
        this.msg=msg;
        this.obj=result;
    }




    private Object obj;
    private String msg;
    private Integer statusCode;

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String toString() {
        return "ResultMessage{" +
                "obj=" + obj +
                ", msg='" + msg + '\'' +
                ", statusCode=" + statusCode +
                '}';
    }



}
