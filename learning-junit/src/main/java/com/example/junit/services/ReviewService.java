package com.example.junit.services;

import com.example.junit.dtos.ReviewDto;

import java.util.List;

public interface ReviewService {
    ReviewDto createReview(int pokemonId, ReviewDto reviewDto);

    List<ReviewDto> getReviewsByPokemonId(int id);

    ReviewDto getReviewById(int reviewId, int pokemonId);

    ReviewDto updateReview(int pokemonId, int reviewId, ReviewDto reviewDto);

    void deleteReview(int pokemonId, int reviewId);
}
