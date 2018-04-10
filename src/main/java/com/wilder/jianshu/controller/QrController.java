package com.wilder.jianshu.controller;

import com.wilder.jianshu.model.WebSocketSessionMap;
import com.wilder.jianshu.service.QrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @author:Wilder Gao
 * @time:2018/4/10
 * @Discription：
 */
@Controller
@RequestMapping("/qr")
public class QrController {
    @Autowired
    private QrService service;

    /**
     * 接收手机发送过来的标识和ip，返回到前端页面
     * @param sign
     * @param ip
     */
    @RequestMapping(value = "/send", method = RequestMethod.GET)
    @ResponseBody
    public String getMessage(@RequestParam("sign")String sign , @RequestParam("ip")String ip){
        try {
            System.out.println(sign+"\n"+ip);
            service.handleIp(sign, ip);
            System.out.println(WebSocketSessionMap.getInstance().get(sign));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "OK";
    }

}
