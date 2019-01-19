package com.example.sviter.repository;

import com.example.sviter.domain.MyMassage;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface MessageRepository extends CrudRepository<MyMassage, Long> {
    List<MyMassage> findByTag(String tag);

}
