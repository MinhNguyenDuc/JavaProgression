/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Article;

/**
 *
 * @author xuanhung
 */
public interface Reader {
    public void getIndexArticles();
    public void getListCategories();
    public void getArticlesByCategory(String categoryName);
    public Article getArticleDetail(String articleLink);
}
