package com.Wechat;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;

/**
 * Author     :Administrator
 * Time       :16:35
 * Project    :CMSM
 * Package    :weixin
 */
@RestController
public class CheckToken{

    @RequestMapping("/checkToken")
    public void fun(HttpServletRequest req,HttpServletResponse resp){
        System.out.println("进入验证方法");
        Map map =  req.getParameterMap();
        System.out.println(map.size());
        // 微信加密签名
        String signature = req.getParameter("signature");
        // 时间戳
        String timestamp = req.getParameter("timestamp");
        // 随机数
        String nonce = req.getParameter("nonce");
        // 随机字符串
        String echostr = req.getParameter("echostr");
        System.out.println("########echostr="+echostr);

        PrintWriter out = null;
        try {
            out = resp.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        if (this.validate(signature, timestamp, nonce)) {
            out.print(echostr);
        }
        System.out.println("参数：signature=" + signature);
        System.out.println("参数：timestamp=" + timestamp);
        System.out.println("参数：nonce=" + nonce);
        System.out.println("参数：echostr=" + echostr);
        out.close();
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        System.out.println("进入验证方法");


        // 微信加密签名
        String signature = req.getParameter("signature");
        // 时间戳
        String timestamp = req.getParameter("timestamp");
        // 随机数
        String nonce = req.getParameter("nonce");
        // 随机字符串
        String echostr = req.getParameter("echostr");

        PrintWriter out = resp.getWriter();
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        if (this.validate(signature, timestamp, nonce)) {
            out.print(echostr);
        }
        System.out.println("参数：signature=" + signature);
        System.out.println("参数：timestamp=" + timestamp);
        System.out.println("参数：nonce=" + nonce);
        System.out.println("参数：echostr=" + echostr);
        out.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // 将请求、响应的编码均设置为UTF-8（防止中文乱码）
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // 调用核心业务类接收消息、处理消息
        String respMessage = CoreService.processRequest(request);

        // 响应消息
        PrintWriter out = response.getWriter();

//        out.print("http://a.hiphotos.baidu.com/image/pic/item/6a63f6246b600c33d73c1f101f4c510fd8f9a1a5.jpg");
        out.print(respMessage);
        out.close();

    }


    //***************************************************华丽分隔线*****************************************************


    /**
     * 校验请求的签名是否合法
     * <p/>
     * 加密/校验流程：
     * 1. 将token、timestamp、nonce三个参数进行字典序排序
     * 2. 将三个参数字符串拼接成一个字符串进行sha1加密
     * 3. 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
     *
     * @param signature
     * @param timestamp
     * @param nonce
     * @return
     */
    public boolean validate(String signature, String timestamp, String nonce) {
        //1. 将token、timestamp、nonce三个参数进行字典序排序
        String token = getToken();
        String[] arrTmp = {token, timestamp, nonce};
        Arrays.sort(arrTmp);
        StringBuffer sb = new StringBuffer();
        //2.将三个参数字符串拼接成一个字符串进行sha1加密
        for (int i = 0; i < arrTmp.length; i++) {
            sb.append(arrTmp[i]);
        }
        String expectedSignature = encrypt(sb.toString());
        System.out.println("expectedSignature=" + expectedSignature);
        //3. 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
        if (expectedSignature.equals(signature)) {
            return true;
        }
        return false;
    }

    private String getToken() {
        return "111111";
    }

    /**
     * 将字节数组转换成16进制字符串
     *
     * @param b
     * @return
     */
    private static String byte2hex(byte[] b) {
        StringBuilder sbDes = new StringBuilder();
        String tmp = null;
        for (int i = 0; i < b.length; i++) {
            tmp = (Integer.toHexString(b[i] & 0xFF));
            if (tmp.length() == 1) {
                sbDes.append("0");
            }
            sbDes.append(tmp);
        }
        return sbDes.toString();
    }

    private String encrypt(String strSrc) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        String strDes = null;
        byte[] bt = strSrc.getBytes();
        digest.update(bt);
        strDes = byte2hex(digest.digest());
        return strDes;
    }


}
