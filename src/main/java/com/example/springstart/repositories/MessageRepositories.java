package com.example.springstart.repositories;

import com.example.springstart.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepositories extends CrudRepository<Message, Long> {
    List<Message> findByTag(String tag); // var tag =  db.Messages.Where(n=> n.tag == tag).ToList();
}
