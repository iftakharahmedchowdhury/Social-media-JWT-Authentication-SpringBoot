package com.dev.SocialMedia.services;

import com.dev.SocialMedia.repositories.AuthTokenRepository;
import com.dev.SocialMedia.models.AuthToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthTokenService {
    @Autowired
    private AuthTokenRepository authTokenRepository;

    public AuthTokenService(AuthTokenRepository authTokenRepository) {
        this.authTokenRepository = authTokenRepository;
    }

    public void saveAuthToken(AuthToken authToken) {
        authTokenRepository.save(authToken);
    }

    public AuthToken findAuthTokenByUserId(String userId) {
        return authTokenRepository.findByUserId(userId);
    }

    public void updateAuthToken(AuthToken authToken) {
        authTokenRepository.save(authToken);
    }

    public AuthToken findByToken(String token) {
        return authTokenRepository.findByToken(token);
    }

    public boolean isTokenValid(AuthToken authToken) {
        // Check if the token is not expired
        return authToken.getExpirationTime() == null;
    }


}
