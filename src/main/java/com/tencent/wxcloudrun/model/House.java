package com.tencent.wxcloudrun.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class House {
    private String title;
    private String subtitle;
    private String bgColor;

    public House(String title, String subtitle, String bgColor) {
        this.title = title;
        this.subtitle = subtitle;
        this.bgColor = bgColor;
    }

}