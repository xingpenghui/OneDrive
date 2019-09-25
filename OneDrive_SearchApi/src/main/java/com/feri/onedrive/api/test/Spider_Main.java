package com.feri.onedrive.api.test;

import com.feri.onedrive.api.spider.DaheNewsPage;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;

/**
 * @program: OneDrive
 * @description:
 * @author: Feri
 * @create: 2019-09-25 17:14
 */
public class Spider_Main {
    public static void main(String[] args) {
        new Spider(new DaheNewsPage()).addPipeline(new ConsolePipeline()).
                addUrl("https://news.dahe.cn/yl/").thread(10).run();
    }
}
