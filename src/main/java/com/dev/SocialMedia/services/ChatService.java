package com.dev.SocialMedia.services;

import com.dev.SocialMedia.models.Chat;
import com.dev.SocialMedia.repositories.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {
    @Autowired
    private ChatRepository chatRepository;

    public ChatService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    public List<Chat> getAllChats() {
        return chatRepository.findAll();
    }


    public List<Chat> getChatsBetweenUsers(Long senderId, Long receiverId) {
        return chatRepository.findBySenderIdAndReceiverIdOrSenderIdAndReceiverIdOrderBySentAt(senderId, receiverId, receiverId, senderId);
    }


    public Chat sendChat(Chat chat) {
        return chatRepository.save(chat);
    }

    public List<Chat> getChatsForUser(Long userId) {
        return chatRepository.findByReceiverIdOrderBySentAt(userId);
    }
}
