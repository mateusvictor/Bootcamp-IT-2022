package br.meli.elasticdemo.service;

import br.meli.elasticdemo.domain.Article;
import br.meli.elasticdemo.repository.ArticleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.elasticsearch.core.query.Query.findAll;

@AllArgsConstructor
@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public Article createArticle(Article article){
        return articleRepository.save(article);
    }

    public Article findArticleById(String id) {
        return articleRepository.findById(id).orElse(new Article());
    }

    public List<Article> findAllArticles(){
        Iterable<Article> articleIterable = articleRepository.findAll();
        List<Article> articleList = new ArrayList<>();
        articleIterable.forEach(articleList::add);

        return articleList;
    }

    public void deleteAllArticles(){
        articleRepository.deleteAll();
    }
}
