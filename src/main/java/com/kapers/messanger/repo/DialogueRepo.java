package com.kapers.messanger.repo;

import com.kapers.messanger.model.Dialogue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DialogueRepo extends CrudRepository<Dialogue, Long> {



}
