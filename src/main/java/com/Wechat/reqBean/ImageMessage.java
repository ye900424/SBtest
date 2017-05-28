package com.Wechat.reqBean;

/**
 * Author     :Administrator
 * Time       :15:57
 * Project    :CMSM
 * Package    :reqBean
 */
public class ImageMessage extends ReqBaseMessage {
    // 图片链接
    private String PicUrl;

    // 素材ID
    private String MediaId;

    public String getPicUrl() {
        return PicUrl;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
}

