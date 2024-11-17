package com.nathan.springsecurity.dto;

import java.util.List;

public record FeedDto(
        List<FeedItemDto> feedItens,
        int page,
        int pagesize,
        int getTotalPages,
        long totalElements
) {
}
