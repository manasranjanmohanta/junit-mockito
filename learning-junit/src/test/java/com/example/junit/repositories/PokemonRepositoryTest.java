package com.example.junit.repositories;

import com.example.junit.entities.Pokemon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class PokemonRepositoryTest {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Test
    void PokemonRepository_SaveAll_ReturnSavedPokemon() {

        // Arrange
        Pokemon pokemon = Pokemon.builder()
                .name("Pikachu")
                .type("Electric").build();
        Pokemon pokemonWithEmptyName = Pokemon.builder().type("Water").build();
        Pokemon pokemonWithEmptyType = Pokemon.builder().name("Squirtle").build();
        Pokemon pokemonWithEmptyFields = new Pokemon();


        // Act
        Pokemon savedPokemon = pokemonRepository.save(pokemon);
        Pokemon savedPokemonWithEmptyName = pokemonRepository.save(pokemonWithEmptyName);
        Pokemon savedPokemonWithEmptyType = pokemonRepository.save(pokemonWithEmptyType);
        Pokemon savedPokemonWithEmptyFields = pokemonRepository.save(pokemonWithEmptyFields);


        // Assert
        Assertions.assertNotNull(savedPokemon);
        Assertions.assertNotNull(savedPokemonWithEmptyName);
        Assertions.assertNotEquals(0, savedPokemonWithEmptyName.getId());
        Assertions.assertNotNull(savedPokemonWithEmptyType);
        Assertions.assertNotEquals(0, savedPokemonWithEmptyType.getId());
        Assertions.assertNotNull(savedPokemonWithEmptyFields);
        Assertions.assertNotEquals(0, savedPokemonWithEmptyFields.getId());
    }
}
