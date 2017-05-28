package com.Wechat.respBean;

/**
 * Author     :Administrator
 * Time       :15:57
 * Project    :CMSM
 * Package    :reqBean
 */
public class ImageMessage extends BaseMessage {
    private Image Image;

    public Image getImage() {
        return Image;
    }

    public void setImage(Image Image) {

        this.Image = Image;
    }
}

