package br.meli.elasticdemo.controller;

import br.meli.elasticdemo.domain.Article;
import br.meli.elasticdemo.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/blog")
public class ArticleController {
    private final ArticleService articleService;

    @PostMapping
    public ResponseEntity<Article> createArticle(@RequestBody Article article, UriComponentsBuilder uriBuilder){
        Article articleCreated = articleService.createArticle(article);
        URI uri = uriBuilder
                .path("/{id}")
                .buildAndExpand(articleCreated.getId())
                .toUri();
        return ResponseEntity.created(uri).body(articleCreated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticle(@PathVariable String id){
        return ResponseEntity.ok(articleService.findArticleById(id));
    }

    @GetMapping()
    public ResponseEntity<List<Article>> getArticles(){
        return ResponseEntity.ok(articleService.findAllArticles());
    }

    @DeleteMapping()
    public ResponseEntity<List<?>> deleteArticles(){
        return ResponseEntity.noContent().build();
    }
}
