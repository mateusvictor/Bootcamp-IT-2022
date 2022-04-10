package br.meli.tutorials.repository;

import br.meli.tutorials.entity.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

}
