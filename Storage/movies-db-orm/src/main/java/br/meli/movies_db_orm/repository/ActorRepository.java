package br.meli.movies_db_orm.repository;

import br.meli.movies_db_orm.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
}
