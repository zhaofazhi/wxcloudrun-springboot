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
                "https://ninja-1258454995.cos.ap-beijing.myqcloud.com/image.webp",
                "https://ninja-1258454995.cos.ap-beijing.myqcloud.com/image2.webp",
                "https://ninja-1258454995.cos.ap-beijing.myqcloud.com/image3.webp",
                "https://ninja-1258454995.cos.ap-beijing.myqcloud.com/image4.webp"
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