package com.example.sviter.repository;

import com.example.sviter.domain.MyMassage;
import com.example.sviter.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MessageRepository extends CrudRepository<MyMassage, Long> {

    Page<MyMassage> findAll(Pageable pageable);

    Page<MyMassage> findByTag(String tag, Pageable pageable);

    @Query(" from MyMassage m " +
            " where m.author = :author " +
            " group by m")
    Page<MyMassage> findByUser(Pageable pageable, @Param("author") User author);
}