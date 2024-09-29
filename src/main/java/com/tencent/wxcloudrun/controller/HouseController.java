package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.model.House;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class HouseController {

    @GetMapping("/api/houses")
    public List<House> getHouses(@RequestParam("page") int page) {
        // 每页显示 6 个房源
        int pageSize = 6;
        String[] images = {
                "https://7072-prod-9gplmuz278725aad-1305749485.tcb.qcloud.la/image.webp?sign=08890e392ebe2420c68092f62bb7afc9&t=1727583248",
                "https://7072-prod-9gplmuz278725aad-1305749485.tcb.qcloud.la/image2.webp?sign=55accd9961e43754947512c899d0b510&t=1727583228",
                "https://7072-prod-9gplmuz278725aad-1305749485.tcb.qcloud.la/image3.webp?sign=129d253963b33bd464f9df4bed568674&t=1727583201",
                "https://7072-prod-9gplmuz278725aad-1305749485.tcb.qcloud.la/image4.webp?sign=0d8d49440c4db21b639f349418907b79&t=1727583080"
        };

        List<House> houses = new ArrayList<>();
        Random random = new Random();

        // 生成房源数据，每页 6 个，模拟分页
        for (int i = 0; i < pageSize; i++) {
            String title = "房源标题 第" + ((page - 1) * pageSize + i + 1) + "期";
            String subtitle = "位置：城市" + (char) ('A' + i) + ", 价格：" + (3000 + random.nextInt(1000)) + "元/月";
            String imageUrl = images[random.nextInt(images.length)]; // 随机选择图片

            houses.add(new House(title, subtitle, imageUrl));
        }

        return houses;
    }
}