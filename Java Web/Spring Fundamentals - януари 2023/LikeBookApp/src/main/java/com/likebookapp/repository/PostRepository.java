package com.likebookapp.repository;

import com.likebookapp.model.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
    Set<PostEntity> findAllByCreator_Id(Long id);

    @Query("select p from PostEntity p where p.creator.id != ?1")
    Set<PostEntity> findAllByCreator_IdIsNot(Long id);
}