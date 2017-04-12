package com.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caoyang on 2017/4/10.
 */
@Component
@ConfigurationProperties(prefix = "config")
public class ConfigTest {

    private String address;
    private String tel;

    private List<String> configs = new ArrayList<String>();

    public List<String> getConfigs() {
        return this.configs;
    }

    public void setConfigs(List<String> my) {
        this.configs = my;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
