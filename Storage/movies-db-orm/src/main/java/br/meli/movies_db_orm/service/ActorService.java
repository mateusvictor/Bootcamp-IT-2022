package br.meli.movies_db_orm.service;

import br.meli.movies_db_orm.exception.EntityNotFoundException;
import br.meli.movies_db_orm.model.Actor;
import br.meli.movies_db_orm.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService implements IService<Actor, Long>{
    @Autowired
    private ActorRepository actorRepository;

    @Override
    public List<Actor> findAll() {
        return actorRepository.findAll();
    }

    @Override
    public Actor findById(Long id) {
        return actorRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Invalid autor ID: " + id));
    }

    @Override
    public Actor create(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public Actor updateById(Long id, Actor updatedActor) {
        Actor actor = this.findById(id);
        actor.setCreatedAt(updatedActor.getCreatedAt());
        actor.setUpdatedAt(updatedActor.getUpdatedAt());
        actor.setRating(updatedActor.getRating());
        actor.setFirstName(updatedActor.getFirstName());
        actor.setLastName(updatedActor.getLastName());
        actor.setFavoriteMovieId(updatedActor.getFavoriteMovieId());

        return actorRepository.save(actor);
    }

    @Override
    public void deleteById(Long id) {
        actorRepository.deleteById(id);
    }
}
