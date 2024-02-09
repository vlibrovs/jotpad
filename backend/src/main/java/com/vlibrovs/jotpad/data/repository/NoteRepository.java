package com.vlibrovs.jotpad.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.vlibrovs.jotpad.data.model.Note;

public interface NoteRepository extends CrudRepository<Note, Integer> {
    
}