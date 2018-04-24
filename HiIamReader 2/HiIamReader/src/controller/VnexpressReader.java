/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Article;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import service.CrawlerThread;

/**
 *
 * @author xuanhung
 */
public class VnexpressReader implements Reader {

    private static ArrayList<Article> listArticle = new ArrayList<>();

    public static void main(String[] args) throws IOException, InterruptedException {
        long startTime = System.currentTimeMillis();
//        ArrayList<String> listUrl = new ArrayList<>();
//        listUrl.add("https://vnexpress.net/tin-tuc/phap-luat/phan-sao-nam-tu-nguyen-nop-500-ty-dong-3734802.html");
//        listUrl.add("https://vnexpress.net/tin-tuc/the-gioi/quan-su/tau-chien-mang-ten-lua-hanh-trinh-cua-my-ap-sat-syria-3734722.html");
//        listUrl.add("https://vnexpress.net/tin-tuc/the-gioi/syria-bao-dong-chien-dau-toan-quan-de-phong-bi-tan-cong-3734838.html");
//        listUrl.add("https://vnexpress.net/tin-tuc/thoi-su/pho-thu-tuong-chi-dao-thanh-tra-viec-quan-ly-dat-nong-nghiep-o-phu-quoc-3734664.html");
//        listUrl.add("https://vnexpress.net/tin-tuc/thoi-su/xa-hoi-den-an-nau-trong-vu-truong-karaoke-o-sai-gon-3734425.html");
//        listUrl.add("https://kinhdoanh.vnexpress.net/tin-tuc/doanh-nghiep/nha-dau-tu-vao-tien-ao-ifan-keu-bi-lua-15-000-ty-dong-3734520.html");
//        listUrl.add("https://vnexpress.net/tin-tuc/thoi-su/can-bo-xa-giai-trinh-viec-bi-nem-bom-xang-vi-nghi-tiep-tay-cat-tac-3734787.html");
//        listUrl.add("https://sohoa.vnexpress.net/tin-tuc/doi-song-so/video-nhieu-luot-xem-nhat-moi-thoi-dai-tren-youtube-bi-hack-3734836.html");
//        listUrl.add("https://vnexpress.net/tin-tuc/thoi-su/lanh-dao-tp-hcm-canh-bao-gia-dat-ao-3734687.html");
//        listUrl.add("https://vnexpress.net/tin-tuc/phap-luat/co-gai-dam-chet-ke-sam-so-o-sai-gon-chinh-thuc-duoc-tu-do-3734672.html");
//        listUrl.add("https://vnexpress.net/tin-tuc/the-gioi/quan-su/my-co-the-thanh-lap-lien-quan-tan-cong-syria-3734694.html");                
        
        VnexpressReader reader = new VnexpressReader();
        reader.getIndexArticles();
        
//        for (Article article : listArticle) {
//            reader.getArticleDetail(article.getUrl());
//        }
        
        
        ArrayList<CrawlerThread> listThread = new ArrayList<>();
        for (int i = 0; i < listArticle.size(); i++) {
            CrawlerThread crawler1 = new CrawlerThread(listArticle.get(i).getUrl());
            listThread.add(crawler1);
            crawler1.start();            
        }
        for (CrawlerThread crawlerThread : listThread) {
            crawlerThread.join();
        }
        
        long endTime = System.currentTimeMillis();
        System.err.println("Thời gian chạy: " + (endTime - startTime) + " mls.");
//        VnexpressReader reader = new VnexpressReader();
//        while (true) {
//            reader.getIndexArticles();
//            reader.printListArticle();
//            //-------------------
//
//            System.out.println("Nhập số thứ tự của tin cần xem: ");
//            Scanner scanner = new Scanner(System.in);
//            int newsIndex = scanner.nextInt();
//            scanner.nextLine();
//            int trueIndex = newsIndex - 1;
//            // Lấy ra phần tử theo index người dùng lựa chọn.
//            Article choosedArticle = listArticle.get(trueIndex);
//            System.out.println("Bạn vừa lựa chọn xem tin: ");
//            System.out.println(choosedArticle.getTitle());
//            System.out.println(choosedArticle.getUrl());
//            // Lấy thông tin chi tiết.
//            Article article = reader.getArticleDetail(choosedArticle.getUrl());
//            System.out.println(article.getContent());
//            System.out.println("Press anykey to continue or 'quit' to exit ...");            
//            String userChoice = scanner.nextLine();
//            if(userChoice.equalsIgnoreCase("quit")){
//                System.out.println("Bye bye.");
//                break;
//            }
//        }
    }

    public void printListArticle() {
        for (int i = 0; i < listArticle.size(); i++) {
            Article art = listArticle.get(i);
            System.out.println(i + 1 + ". " + art.getTitle());
        }
    }

    @Override
    public void getIndexArticles() {
        try {
            if (listArticle.size() == 0) {
                Document doc = Jsoup.connect("https://vnexpress.net/").get();
                Elements els = doc.select(".sidebar_home_1 .title_news a:first-child");
                for (int i = 0; i < els.size(); i++) {
                    Element el = els.get(i);
                    // Biến các phần tử html thành đối tượng article.
                    Article article = new Article();
                    article.setUrl(el.attr("href"));
                    article.setTitle(el.text());
                    article.setStatus(1);
                    listArticle.add(article);
                }
            }
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
        long startTime = System.currentTimeMillis();
        Article article = new Article();
        try {
            Document doc = Jsoup.connect(articleLink).get();
            Element element = 
                    doc.select(".content_detail.fck_detail.width_common").get(0);
            article.setTitle(doc.select("h1.title_news_detail").text());
            article.setContent(element.text());
        } catch (Exception e) {
        }        
        long endTime = System.currentTimeMillis();
        System.out.println("Lấy tin thành công sau: " + (endTime - startTime) + " milisecond.");
        return article;
    }

}
