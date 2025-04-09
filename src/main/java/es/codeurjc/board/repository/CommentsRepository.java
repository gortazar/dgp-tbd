package es.codeurjc.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.board.model.Comment;

public interface CommentsRepository extends JpaRepository<Comment, Long>{

}
