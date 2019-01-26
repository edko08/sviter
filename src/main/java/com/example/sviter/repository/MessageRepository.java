package com.example.sviter.repository;

import com.example.sviter.domain.MyMassage;
import com.example.sviter.domain.User;
import com.example.sviter.domain.dto.MessageDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MessageRepository extends CrudRepository<MyMassage, Long> {

    @Query(value = "select new com.example.sviter.domain.dto.MessageDto( " +
            "   m, " +
            "   count(ml), " +
            "   case when sum(case when ml = :user then 1 else 0 end) <> 0 then true else false end " +
            ") " +
            "from MyMassage m left join m.likes ml " +
            "group by m")
    Page<MessageDto> findAll(Pageable pageable, @Param("user") User user);

    @Query("select new com.example.sviter.domain.dto.MessageDto(" +
            "   m, " +
            "   count(ml), " +
            "   case when sum(case when ml = :user then 1 else 0 end)  <> 0 then true else false end" +
            ") " +
            "from MyMassage m left join m.likes ml " +
            "where m.tag = :tag " +
            "group by m")
    Page<MessageDto> findByTag(@Param("tag") String tag, Pageable pageable, @Param("user") User user);

    @Query("select new com.example.sviter.domain.dto.MessageDto(" +
            "   m, " +
            "   count(ml), " +
            "   case when sum(case when ml = :user then 1 else 0 end)  <> 0 then true else false end" +
            ") " +
            "from MyMassage m left join m.likes ml " +
            "where m.author = :author " +
            "group by m")
    Page<MessageDto> findByUser(Pageable pageable, @Param("author") User author, @Param("user") User user);
}