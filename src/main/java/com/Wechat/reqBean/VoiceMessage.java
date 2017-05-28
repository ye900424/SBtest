package com.Wechat.reqBean;

/**
 * Author     :Administrator
 * Time       :17:11
 * Project    :CMSM
 * Package    :reqBean
 */
public class VoiceMessage extends ReqBaseMessage {
    // 媒体ID
    private String MediaId;
    // 语音格式
    private String Format;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }
}


