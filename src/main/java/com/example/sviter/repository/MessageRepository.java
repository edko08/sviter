package com.example.sviter.repository;

import com.example.sviter.domain.MyMassage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<MyMassage, Long> {

    Page<MyMassage> findAll(Pageable pageable);

    Page<MyMassage> findByTag(String tag, Pageable pageable);

}