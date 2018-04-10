package com.wilder.jianshu.model;

/**
 * @author:Wilder Gao
 * @time:2018/4/10
 * @Discription：
 */
public enum TypeEnum {
    /**
     * 标识符
     */
    SIGN(0),
    /**
     * 网址
     */
    WEB_SIGN(1);

    private int state;

    TypeEnum(int state){
        this.state = state;
    }

    public int getState(){
        return state;
    }
}
