package com.dev.SocialMedia.repositories;

import com.dev.SocialMedia.models.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {
    List<Chat> findBySenderIdAndReceiverIdOrSenderIdAndReceiverIdOrderBySentAt(Long senderId1, Long receiverId1, Long senderId2, Long receiverId2);


    List<Chat> findByReceiverIdOrderBySentAt(Long receiverId);
}
