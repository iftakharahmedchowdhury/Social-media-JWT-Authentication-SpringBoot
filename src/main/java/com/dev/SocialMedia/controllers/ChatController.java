package com.dev.SocialMedia.controllers;

import com.dev.SocialMedia.models.Chat;
import com.dev.SocialMedia.services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chats")
public class ChatController {

    @Autowired
    private ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/getAllChats")
    public ResponseEntity<List<Chat>> getAllChats() {
        List<Chat> chats = chatService.getAllChats();
        return new ResponseEntity<>(chats, HttpStatus.OK);
    }

    @GetMapping("/getChats/{senderId}/{receiverId}")
    public ResponseEntity<List<Chat>> getChatsBetweenUsers(@PathVariable Long senderId, @PathVariable Long receiverId) {
        List<Chat> chats = chatService.getChatsBetweenUsers(senderId, receiverId);
        return new ResponseEntity<>(chats, HttpStatus.OK);
    }

    @PostMapping("/sendChat")
    public ResponseEntity<Chat> sendChat(@RequestBody Chat chat) {
        Chat sentChat = chatService.sendChat(chat);
        return new ResponseEntity<>(sentChat, HttpStatus.CREATED);
    }

    @GetMapping("/getChatsForUser/{userId}")
    public ResponseEntity<List<Chat>> getChatsForUser(@PathVariable Long userId) {
        List<Chat> chats = chatService.getChatsForUser(userId);
        return new ResponseEntity<>(chats, HttpStatus.OK);
    }
}
