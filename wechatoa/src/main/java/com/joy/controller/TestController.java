package com.joy.controller;

import com.joy.result.data.BaseResultInfo;
import com.joy.result.data.SuccessResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by joybar on 2018/4/10.
 */
@RestController
public class TestController {
    public static String TAG = "ConstellationController";

  //  http://localhost:8223/wechatoa/say
    @GetMapping(value = "/say")
    public BaseResultInfo say() {
        return new SuccessResult("hello");
    }
}
