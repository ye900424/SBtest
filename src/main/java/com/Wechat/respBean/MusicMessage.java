package com.Wechat.respBean;

/**
 * Author     :Administrator
 * Time       :17:13
 * Project    :CMSM
 * Package    :respBean
 */
public class MusicMessage extends BaseMessage {
    // 音乐
    private Music Music;

    public Music getMusic() {
        return Music;
    }

    public void setMusic(Music music) {
        Music = music;
    }
}

