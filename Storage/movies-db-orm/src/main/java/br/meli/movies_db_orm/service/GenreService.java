package br.meli.movies_db_orm.service;

import br.meli.movies_db_orm.exception.EntityNotFoundException;
import br.meli.movies_db_orm.model.Genre;
import br.meli.movies_db_orm.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GenreService implements IService<Genre, Long>{
    @Autowired
    private GenreRepository genreRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Genre findById(Long id) {
        return genreRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Invalid genre ID: " + id));
    }

    @Override
    @Transactional
    public Genre create(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    @Transactional
    public Genre updateById(Long id, Genre updatedGenre) {
        Genre genre = this.findById(id);

        genre.setCreatedAt(updatedGenre.getCreatedAt());
        genre.setUpdatedAt(updatedGenre.getUpdatedAt());
        genre.setActive(updatedGenre.getActive());
        genre.setName(updatedGenre.getName());
        genre.setRanking(updatedGenre.getRanking());

        return genreRepository.save(genre);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        genreRepository.deleteById(id);
    }
}
