package com.Wechat.respBean;

/**
 * Author     :Administrator
 * Time       :15:44
 * Project    :CMSM
 * Package    :reqBean
 */
public class TextMessage extends BaseMessage {
    // 消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}

