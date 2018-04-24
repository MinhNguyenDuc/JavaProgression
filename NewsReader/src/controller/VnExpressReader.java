/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author nguye
 */
public class VnExpressReader {
    
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("http://en.wikipedia.org/").get();
        System.out.println(doc.title());
        Elements newsHeadlines = doc.select("#mp-itn b a");
        for (Element headline : newsHeadlines) {
          System.out.println(headline.attr("title"));
        }
    }
    
    public void getIndexArticle(){
        System.out.println("Lấy danh sách tin trang chủ");
    }
    
    public void getListCategories(){
        System.out.println("Lấy danh sách danh mục");
    }
    
    public void getArticleByCategory(String categoryName){
        System.out.println("Lấy tin theo danh mục " + categoryName);
    }
    
    public void getArticleDetail(String articleLink){
        System.out.println("Lấy link chi tiết từ trang " + articleLink);
    }
}
