package es.codeurjc.board.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.codeurjc.board.model.Comment;
import es.codeurjc.board.model.Post;
import es.codeurjc.board.repository.CommentsRepository;
import es.codeurjc.board.repository.PostRepository;

@RestController
@RequestMapping("/comments")
public class CommentsController {

    private CommentsRepository commentsRepository;
    private PostRepository postRepository;

    public CommentsController(CommentsRepository repository, PostRepository postRepository) {
        this.commentsRepository = repository;
        this.postRepository = postRepository;
    }

    @PostMapping("/{postId}")
    public Comment addComment(@PathVariable long postId, @RequestBody Comment c) {
        Post p = postRepository.findById(postId).orElseThrow();
        Comment savedComment = commentsRepository.save(c);
        p.addComment(savedComment);
        postRepository.save(p);
        return savedComment;
    }

}