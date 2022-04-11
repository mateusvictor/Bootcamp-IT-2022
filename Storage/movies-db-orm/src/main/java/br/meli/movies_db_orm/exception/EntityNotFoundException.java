package br.meli.movies_db_orm.exception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message){
        super(message);
    }
}
