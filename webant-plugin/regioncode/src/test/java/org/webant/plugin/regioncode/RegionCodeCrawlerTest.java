package org.webant.plugin.regioncode;

import org.apache.http.client.fluent.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;

public class RegionCodeCrawlerTest {

    @Before
    public void init() {

    }

    @Test
    public void crawl() throws IOException {
        String url = "http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2016/43/12/431222.html";

        Response resp = org.apache.http.client.fluent.Request.Get(url)
                .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
                .addHeader("Accept-Encoding", "gzip, deflate")
                .addHeader("Accept-Language", "zh-CN,zh;q=0.9")
                .addHeader("Cache-Control", "max-age=0")
                .addHeader("Connection", "keep-alive")
                .addHeader("Cookie", "_trs_uv=jfflgmds_6_hjxo; AD_RS_COOKIE=20080919")
                .addHeader("Host", "www.stats.gov.cn")
                .addHeader("If-Modified-Since", "Fri, 05 May 2017 07:20:46 GMT")
                .addHeader("If-None-Match", "133f-54ec1ba6ad412-gzip")
                .addHeader("Referer", url)
                .addHeader("Upgrade-Insecure-Requests", "1")
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36")
                .execute();
        String result = resp.returnContent().asString(Charset.forName("UTF-8"));
        Document doc = Jsoup.parse(result, url);
//        String profileUrl = doc.select(".newArticleHead a").first().absUrl("href");
//        String avatarUrl = doc.select(".newArticleHead img").attr("src");
//        String userName = doc.select(".newArticleHead .touch-user-name-a").text();
        String title = doc.select(".content-text").text();
//        String imgUrl = doc.select(".content-text img").attr("src");
//        String likeNum = doc.select(".article_info .laugh-comment").attr("data-votes");
//        String commentNum = doc.select(".article_info .comments").text().split(" ")[0];
        System.out.println(title);

    }
}
