package com.wilder.jianshu.model;

/**
 * @author:Wilder Gao
 * @time:2018/4/10
 * @Discription：
 */
public class Message {
    /**
     * 返回类型，0为标识符，1为网址
     */
    private int type;
    /**
     * 返回内容
     */
    private String text;

    public Message(int type, String text){
        this.type = type;
        this.text = text;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Message{" +
                "type=" + type +
                ", text='" + text + '\'' +
                '}';
    }
}
