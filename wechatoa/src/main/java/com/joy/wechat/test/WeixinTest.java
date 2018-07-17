package com.joy.wechat.test;

import com.joy.wechat.po.AccessToken;
import com.joy.wechat.utils.WeixinUtil;
import net.sf.json.JSONObject;


public class WeixinTest {
    public static void main(String[] args) {
        try {
            AccessToken token = WeixinUtil.getAccessToken();
            System.out.println("票据" + token.getToken());
            System.out.println("有效时间" + token.getExpiresIn());

//			String path = "/Users/joybar/Documents/MyTest/wolfgirl.jpg";
//			String mediaId = WeixinUtil.upload(path, token.getToken(), "image");
//			// 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
//			System.out.println("mediaId=" + mediaId);

            // String result = WeixinUtil.translate("my name is laobi");
            // //String result = WeixinUtil.translateFull("");
            // System.out.println(result);

            // 创建菜单
            String memu =
                    JSONObject.fromObject(WeixinUtil.initMenu()).toString();
            int result = WeixinUtil.createMenu(token.getToken(), memu);
            if (result == 0) {
                System.out.println("创建菜单成功");
            } else {
                System.out.println("创建菜单失败，错误码：" + result);
            }

            // 查询菜单
//			JSONObject jsonObject = WeixinUtil.queryMenu(token.getToken());
//			System.out.println("jsonObject=" + jsonObject);

            // 删除菜单
//			int result = WeixinUtil.deleteMenu(token.getToken());
//			 if(result ==0){
//			 System.out.println("删除菜单成功");
//			 }else{
//			 System.out.println("删除菜单失败，错误码："+result);
//			 }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
