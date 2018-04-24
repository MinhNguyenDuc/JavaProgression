/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Article;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author xuanhung
 */
public class DantriReader implements Reader {

    @Override
    public void getIndexArticles() {
        try {
            Document doc = Jsoup.connect("http://dantri.com.vn/").get();
            System.out.println(doc.text());
        } catch (Exception e) {
            System.err.println("Không thể lấy được tin.");
        }
    }

    @Override
    public void getListCategories() {
        System.out.println("Lấy danh mục từ vnexpress.net");
    }

    @Override
    public void getArticlesByCategory(String categoryName) {
        System.out.println("Lấy danh sách tin theo chuyên mục " + categoryName);
    }

    @Override
    public Article getArticleDetail(String articleLink) {
        System.out.println("Lấy nội dung tin từ trang " + articleLink);
        return new Article();
    }
}
