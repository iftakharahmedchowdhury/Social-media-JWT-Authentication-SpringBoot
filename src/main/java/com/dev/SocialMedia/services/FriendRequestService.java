package com.dev.SocialMedia.services;

import com.dev.SocialMedia.models.FriendRequest;
import com.dev.SocialMedia.repositories.FriendRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendRequestService {

    @Autowired
    private FriendRequestRepository friendRequestRepository;

    public List<FriendRequest> getAllFriendRequests() {
        return friendRequestRepository.findAll();
    }

    public FriendRequest getFriendRequestById(Long id) {
        return friendRequestRepository.findById(id).orElse(null);
    }

    public FriendRequest createFriendRequest(FriendRequest friendRequest) {
        return friendRequestRepository.save(friendRequest);
    }

    public FriendRequest updateFriendRequest(Long id, FriendRequest friendRequest) {
        FriendRequest existingFriendRequest = friendRequestRepository.findById(id).orElse(null);
        if (existingFriendRequest != null) {
            existingFriendRequest.setSender(friendRequest.getSender());
            existingFriendRequest.setReceiver(friendRequest.getReceiver());
            existingFriendRequest.setStatus(friendRequest.getStatus());
            return friendRequestRepository.save(existingFriendRequest);
        }
        return null;
    }

    public void deleteFriendRequest(Long id) {
        friendRequestRepository.deleteById(id);
    }
}