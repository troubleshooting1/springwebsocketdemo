package com.anji.springwebsocketdemo.model;

/**
 * Description:
 * author: chenqiang
 * date: 2018/6/8 9:33
 */
public class ResponseMessage {

    public ResponseMessage(String message) {
        this.message = message;
    }

    /**
     * 响应消息
     */
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
