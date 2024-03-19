package com.dev.SocialMedia.repositories;

import com.dev.SocialMedia.models.AuthToken;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface AuthTokenRepository extends JpaRepository<AuthToken, Long> {
    AuthToken findByUserId(String userId);
    AuthToken findByToken(String token);

}

