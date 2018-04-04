package org.webant.plugin.regioncode.processor;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.webant.plugin.regioncode.data.RegionEntity;
import org.webant.worker.processor.HtmlPageProcessor;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;

public class RegionProcessor extends HtmlPageProcessor<RegionEntity> {

    @Override
    public Collection<RegionEntity> list() {
        Elements trs = doc.select(".villagetr");
        if(!doc.select(".citytr").isEmpty()) trs = doc.select(".citytr");
        else if(!doc.select(".countytr").isEmpty()) trs = doc.select(".countytr");
        else if(!doc.select(".towntr").isEmpty()) trs = doc.select(".towntr");
        else if(!doc.select(".villagetr").isEmpty()) trs = doc.select(".villagetr");

        LinkedList<RegionEntity> regions = new LinkedList<>();
        for (Element tr : trs) {
            RegionEntity region = new RegionEntity();
            Elements tds = tr.select("td");
            if (tds.size() == 3) {
                region.setCode(tds.get(0).text());
                region.setCategory(tds.get(1).text());
                region.setName(tds.get(2).text());
            } else if (tds.size() == 2) {
                region.setCode(tds.get(0).text());
                region.setName(tds.get(1).text());
            }

            region.srcId = region.getCode();
            region.srcUrl = url().toExternalForm();
            region.source = "http://www.stats.gov.cn";
            region.crawlTime = new Date();

            regions.add(region);
        }
        return regions;
    }
}
