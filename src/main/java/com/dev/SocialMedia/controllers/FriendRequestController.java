package com.dev.SocialMedia.controllers;

import com.dev.SocialMedia.models.FriendRequest;
import com.dev.SocialMedia.services.FriendRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/friendRequests")
public class FriendRequestController {

    @Autowired
    private FriendRequestService friendRequestService;

    public FriendRequestController(FriendRequestService friendRequestService) {
        this.friendRequestService = friendRequestService;
    }

    @GetMapping("/getAllFriendRequests")
    public ResponseEntity<List<FriendRequest>> getAllFriendRequests() {
        List<FriendRequest> friendRequests = friendRequestService.getAllFriendRequests();
        return new ResponseEntity<>(friendRequests, HttpStatus.OK);
    }

    @GetMapping("/getAllFriendRequests/{id}")
    public ResponseEntity<FriendRequest> getFriendRequestById(@PathVariable Long id) {
        FriendRequest friendRequest = friendRequestService.getFriendRequestById(id);
        return new ResponseEntity<>(friendRequest, HttpStatus.OK);
    }

    @PostMapping("/addFriendRequests")
    public ResponseEntity<FriendRequest> createFriendRequest(@RequestBody FriendRequest friendRequest) {
        FriendRequest createdFriendRequest = friendRequestService.createFriendRequest(friendRequest);
        return new ResponseEntity<>(createdFriendRequest, HttpStatus.CREATED);
    }

    @PutMapping("updateFriendRequests/{id}")
    public ResponseEntity<FriendRequest> updateFriendRequest(@PathVariable Long id, @RequestBody FriendRequest friendRequest) {
        FriendRequest updatedFriendRequest = friendRequestService.updateFriendRequest(id, friendRequest);
        return new ResponseEntity<>(updatedFriendRequest, HttpStatus.OK);
    }

    @DeleteMapping("deleteFriendRequests/{id}")
    public ResponseEntity<Void> deleteFriendRequest(@PathVariable Long id) {
        friendRequestService.deleteFriendRequest(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/received/{receiverId}")
    public ResponseEntity<List<FriendRequest>> getFriendRequestsByReceiverId(@PathVariable Long receiverId) {
        List<FriendRequest> friendRequests = friendRequestService.getFriendRequestsByReceiverId(receiverId);
        return new ResponseEntity<>(friendRequests, HttpStatus.OK);
    }
}