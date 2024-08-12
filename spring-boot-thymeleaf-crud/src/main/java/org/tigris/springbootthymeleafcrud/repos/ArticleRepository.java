package org.tigris.springbootthymeleafcrud.repos;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.tigris.springbootthymeleafcrud.model.Article;

import java.util.List;

@Transactional
public interface ArticleRepository extends JpaRepository<Article, Long> {

    List<Article> findByTitleContainingIgnoreCase(String keyWord);

    @Query(value = "UPDATE Article a SET a.published = :published WHERE a.id = :id")
    @Modifying
    void updatePublishedStatus(long id, boolean published);
}
