package br.meli.elasticdemo.repository;

import br.meli.elasticdemo.domain.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends ElasticsearchRepository<Article, String> {
}
