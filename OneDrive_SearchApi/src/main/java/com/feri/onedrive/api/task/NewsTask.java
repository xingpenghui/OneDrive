package com.feri.onedrive.api.task;

import com.feri.onedrive.api.spider.DaheNewsPage;
import com.feri.onedrive.api.spider.EsPipeline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;

/**
 * @program: OneDrive
 * @description:
 * @author: Feri
 * @create: 2019-09-25 17:09
 */
@Component
public class NewsTask {

    @Autowired
    private EsPipeline esPipeline;
    @Scheduled(cron = "0 0/2 * * * ?")
    public void startNews(){
        //启动爬虫
        new Spider(new DaheNewsPage()).addPipeline(esPipeline).
                addUrl("https://news.dahe.cn/yl/").run();
    }
}
