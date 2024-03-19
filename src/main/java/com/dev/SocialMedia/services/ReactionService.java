package com.dev.SocialMedia.services;


import com.dev.SocialMedia.Repository.ReactionRepository;
import com.dev.SocialMedia.models.Reaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReactionService {

    @Autowired
    private ReactionRepository reactionRepository;

    public ReactionService(ReactionRepository reactionRepository) {
        this.reactionRepository = reactionRepository;
    }

    public List<Reaction> getAllReactions() {
        return reactionRepository.findAll();
    }

    public Reaction getReactionById(Long id) {
        return reactionRepository.findById(id).orElse(null);
    }

    public Reaction createReaction(Reaction reaction) {
        return reactionRepository.save(reaction);
    }

    public Reaction updateReaction(Long id, Reaction reaction) {
        Reaction existingReaction = reactionRepository.findById(id).orElse(null);
        if (existingReaction != null) {
            existingReaction.setUser(reaction.getUser());
            existingReaction.setPost(reaction.getPost());
            existingReaction.setType(reaction.getType());
            return reactionRepository.save(existingReaction);
        }
        return null;
    }

    public void deleteReaction(Long id) {
        reactionRepository.deleteById(id);
    }
}