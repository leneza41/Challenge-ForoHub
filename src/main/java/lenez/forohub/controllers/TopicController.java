package lenez.forohub.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lenez.forohub.domain.topic.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicService service;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid TopicRequest data, UriComponentsBuilder uriBuilder) {
        Topic topic = service.register(data);
        var uri = uriBuilder.path("topic/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(uri).body(topic);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TopicResponse> findById(@PathVariable Long id) {
        return service.findById(id);
    }
    @GetMapping
    public ResponseEntity<List<TopicResponse>> findAll() {
        return service.getTopics();
    }
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicResponse> update(@PathVariable Long id, @RequestBody @Valid TopicRequest data) {
        return service.update(id, data);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
