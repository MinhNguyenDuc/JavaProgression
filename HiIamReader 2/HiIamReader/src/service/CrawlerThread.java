/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Article;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author xuanhung
 */
public class CrawlerThread extends Thread {

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public CrawlerThread(String url) {
        this.url = url;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        Article article = new Article();
        try {
            Document doc = Jsoup.connect(this.url).get();
            Element element = 
                    doc.select(".content_detail.fck_detail.width_common").get(0);
            article.setTitle(doc.select("h1.title_news_detail").text());
            article.setContent(element.text());
        } catch (Exception e) {
        }        
        long endTime = System.currentTimeMillis();
        System.out.println("Lấy tin thành công sau: " + (endTime - startTime) + " milisecond.");
    }

}
