package com.Wechat; /**
 * Author     :Administrator
 * Time       :17:33
 * Project    :CMSM
 * Package    :PACKAGE_NAME
 */





import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.Wechat.respBean.*;


public class CoreService {
    /**
     * 处理微信发来的请求
     *
     * @param request
     * @return
     */
    public static String processRequest(HttpServletRequest request) {
        String respMessage = null;
        try {
            // 默认返回的文本消息内容
            String respContent = "请求处理异常，请稍候尝试！";

            // xml请求解析
            Map<String, String> requestMap = MessageUtil.parseXml(request);

            // 发送方帐号（open_id）
            String fromUserName = requestMap.get("FromUserName");
            // 公众帐号
            String toUserName = requestMap.get("ToUserName");
            // 消息类型
            String msgType = requestMap.get("MsgType");
            // 消息内容
            String content = requestMap.get("Content");
            // 素材ID
            String mediaId = requestMap.get("MediaId");
            //
            Long msgId = requestMap.get("MsgId") == null ? null : Long.parseLong(requestMap.get("MsgId"));

            // 回复文本消息
            TextMessage textMessage = new TextMessage();
            textMessage.setToUserName(fromUserName);
            textMessage.setFromUserName(toUserName);
            textMessage.setCreateTime(new Date().getTime());
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
            textMessage.setFuncFlag(0);

            // 回复图片消息
            ImageMessage imageMessage = new ImageMessage();
            imageMessage.setToUserName(fromUserName);
            imageMessage.setFromUserName(toUserName);
            imageMessage.setCreateTime(new Date().getTime());
//            imageMessage.setMsgId(msgId);
            imageMessage.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_IMAGE);
            imageMessage.setFuncFlag(0);

            // 文本消息
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
                List<String> tmpList = new ArrayList<String>();
                tmpList.add("1");
                tmpList.add("2");
                tmpList.add("3");
                tmpList.add("4");
//                respContent = "您发送的是文本消息！";
                if ("?".equals(content) || "？".equals(content)) {
                    StringBuffer buffer = new StringBuffer();
                    buffer.append("1、查看老曹帅照").append("\n");
                    buffer.append("2、查看老曹动图").append("\n");
                    buffer.append("3、查看老曹裸照").append("\n");
                    buffer.append("4、查看老曹睡照").append("\n\n");
                    buffer.append("回复“?”显示此帮助菜单");
                    respContent = buffer.toString();
                } else if (tmpList.contains(content)) {
                    respContent = "哈哈~~你个逗比，让你发你就发啊，我让你现在去吃/:shit呢，去啊！";
//                    respContent = "image";

                } else if ("666".equals(content)) {
                    respContent = "image";
                } else {
                    respContent = "回复“?”显示此帮助菜单";
                }
            }
            // 图片消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
                respContent = "image";
            }
            // 地理位置消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
                respContent = "您发送的是地理位置消息！";
            }
            // 链接消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
                respContent = "您发送的是链接消息！";
            }
            // 音频消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
                respContent = "您发送的是音频消息~"+requestMap.get("Recognition");
            }
            // 事件推送
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
                // 事件类型
                String eventType = requestMap.get("Event");
                // 订阅
                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
                    StringBuffer buffer = new StringBuffer();
                    buffer.append("接下来的日子里隔壁老曹将会带你装逼，带你飞！").append("\n\n");
                    buffer.append("回复“?”显示此帮助菜单");
                    respContent = buffer.toString();
                }
                // 取消订阅
                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
                    // TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
                }
                // 自定义菜单点击事件
                else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
                    // TODO 自定义菜单权没有开放，暂不处理该类消息
                }
            }

            if (!"image".equals(respContent)) {
                textMessage.setContent(respContent);
                respMessage = MessageUtil.textMessageToXml(textMessage);
                System.out.println(respMessage);
            } else if ("image".equals(respContent)) {
                System.out.println("这里需要返回图片");
                Image image = new Image();
                image.setMediaId(mediaId);
                imageMessage.setImage(image);
                respMessage = MessageUtil.textMessageToXml(imageMessage);
                System.out.println(respMessage);
                System.out.println();


//                String str = "<xml>\n" +
//                        "  <ToUserName><![CDATA[ocz5zszWwVpk0zAd9uNSs4Hghu7c]]></ToUserName>\n" +
//                        "  <FromUserName><![CDATA[gh_9417525e75f6]]></FromUserName>\n" +
//                        "  <CreateTime><![CDATA[1438656522644]]></CreateTime>\n" +
//                        "  <MsgType><![CDATA[image]]></MsgType>\n" +
//                        "  <MsgId><![CDATA[0]]></MsgId>\n" +
//                        "  <FuncFlag><![CDATA[0]]></FuncFlag>\n" +
//                        "  <Image>\n" +
//                        "  <MediaId><![CDATA[laocao]]></MediaId>\n" +
//                        "  </Image>\n" +
//                        "</xml>";
//                String str = "<xml>\n" +
//                        "  <ToUserName><![CDATA[ocz5zszWwVpk0zAd9uNSs4Hghu7c]]></ToUserName>\n" +
//                        "  <FromUserName><![CDATA[gh_9417525e75f6]]></FromUserName>\n" +
//                        "  <CreateTime><![CDATA[1438739193601]]></CreateTime>\n" +
//                        "  <MsgType><![CDATA[image]]></MsgType>\n" +
//                        "  <MsgId><![CDATA[6179337777325456007]]></MsgId>\n" +
//                        "  <FuncFlag><![CDATA[0]]></FuncFlag>\n" +
//                        "  <image>\n" +
//                        "    <MediaId><![CDATA[SOIdKqMQJBFDJNJPbVcyTEwc8wYSmrfg0-k0-5pTS3SopZITKrPhJY7dUeraosW7]]></MediaId>\n" +
//                        "  </image>\n" +
//                        "</xml>";
//                respMessage = str.replace("laocao", "Rq9i6es42GfwWhbWOWu3_o1blAq0PHDQpIs7QDHUn8bOyFRexpppKhWR21RL7WUA");
//                System.out.println(respMessage);
//                System.out.println();
//
//
//
//                WeiXin.TextMessage respMsg = new WeiXin.TextMessage();
//                respMsg.setContent(requestMap.get("Content")+System.currentTimeMillis());
//                respMsg.setCreateTime(System.currentTimeMillis());
//                respMsg.setFromUserName(requestMap.get("ToUserName"));
//                respMsg.setToUserName(requestMap.get("FromUserName"));
//                respMsg.setMsgType(requestMap.get("MsgType"));
//                if(requestMap.get("MsgType")!=null && requestMap.get("MsgType").equals("image")){
//                    //如果是图片消息
//                    Image image = new Image();
//                    image.setMediaId(requestMap.get("MediaId"));
//                    respMsg.setImage(image);
//                }
//
//                //将文本消息转换为xml文本
//                respMessage = XmlUtil.toXml(respMsg);
//                System.out.println(respMessage);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return respMessage;
    }
}

