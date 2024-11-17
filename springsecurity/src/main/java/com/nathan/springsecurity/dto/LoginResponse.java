package com.nathan.springsecurity.dto;

public record LoginResponse(String accessToken, Long expiresIn) {
}
