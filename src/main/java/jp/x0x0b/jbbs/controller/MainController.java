package jp.x0x0b.jbbs.controller;

import jp.x0x0b.jbbs.model.Post;
import jp.x0x0b.jbbs.repository.PostRepository;
import jp.x0x0b.jbbs.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/post")
public class MainController {
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public MainController(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @PostMapping(path = "/add")
    public @ResponseBody
    String addNewPost(@RequestBody Post post) {
        userRepository.save(post.getUser());
        postRepository.save(post);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Post> getAllPosts() {
        return postRepository.findAll();
    }
}
