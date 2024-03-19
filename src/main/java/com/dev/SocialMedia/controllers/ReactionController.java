package com.dev.SocialMedia.controllers;


import com.dev.SocialMedia.services.ReactionService;
import com.dev.SocialMedia.models.Reaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reactions")
public class ReactionController {

    @Autowired
    private ReactionService reactionService;

    public ReactionController(ReactionService reactionService) {
        this.reactionService = reactionService;
    }

    @GetMapping("/getAllReaction")
    public ResponseEntity<List<Reaction>> getAllReactions() {
        List<Reaction> reactions = reactionService.getAllReactions();
        return new ResponseEntity<>(reactions, HttpStatus.OK);
    }

    @GetMapping("/getAllReaction/{id}")
    public ResponseEntity<Reaction> getReactionById(@PathVariable Long id) {
        Reaction reaction = reactionService.getReactionById(id);
        return new ResponseEntity<>(reaction, HttpStatus.OK);
    }

    @PostMapping("/addReaction")
    public ResponseEntity<Reaction> createReaction(@RequestBody Reaction reaction) {
        Reaction createdReaction = reactionService.createReaction(reaction);
        return new ResponseEntity<>(createdReaction, HttpStatus.CREATED);
    }

    @PutMapping("updateReaction/{id}")
    public ResponseEntity<Reaction> updateReaction(@PathVariable Long id, @RequestBody Reaction reaction) {
        Reaction updatedReaction = reactionService.updateReaction(id, reaction);
        return new ResponseEntity<>(updatedReaction, HttpStatus.OK);
    }

    @DeleteMapping("deleteReaction/{id}")
    public ResponseEntity<Void> deleteReaction(@PathVariable Long id) {
        reactionService.deleteReaction(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}