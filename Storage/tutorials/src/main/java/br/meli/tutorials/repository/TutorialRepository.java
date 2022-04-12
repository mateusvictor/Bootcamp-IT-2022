package br.meli.tutorials.repository;

import br.meli.tutorials.entity.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
    List<Tutorial> findByTitle(String title);
    List<Tutorial> findByPublished(Boolean published);
}
