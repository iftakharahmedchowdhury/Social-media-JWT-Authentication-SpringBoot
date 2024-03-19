package com.dev.SocialMedia.repositories;

import com.dev.SocialMedia.models.FriendRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRequestRepository extends JpaRepository<FriendRequest, Long> {
    // You can add custom queries here if needed
}