package com.example.testaws;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<NoteEntity, Long> {

    @Query("select n from NoteEntity n where n.content LIKE CONCAT('%',:searchText,'%') ")
    List<NoteEntity> searchText(@Param("searchText") String searchText);
}
