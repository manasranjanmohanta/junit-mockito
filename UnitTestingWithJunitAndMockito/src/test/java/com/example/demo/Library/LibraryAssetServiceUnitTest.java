package com.example.demo.Library;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@ExtendWith(MockitoExtension.class)
public class LibraryAssetServiceUnitTest {

    private final LibraryAsset bookThingsFallApart =
            LibraryAsset.builder().assetTitle("Things Fall Apart").assetCode("0385474547")
                    .editionYear((short) 1958).creatorName("Chinua Achebe").publisherName("William Heinemann")
                    .priceUSD("17.95").assetCategory(EntityCharacteristics.BOOK_FICTION)
                    .assetType(EntityCharacteristics.BOOK_PAPERBACK).build();

    private final LibraryAsset mediaTAJazz =
            LibraryAsset.builder().assetTitle("Trans Atlantic Jazz").assetCode("0385474548")
                    .editionYear((short) 2001).creatorName("Jazperience").publisherName("L. Asle Roe")
                    .priceUSD("9.95").assetCategory(EntityCharacteristics.MEDIA_AUDIO)
                    .assetType(EntityCharacteristics.MEDIA_AUDIO).build();

    private final List<LibraryAsset> baseAssets = Arrays.asList(this.bookThingsFallApart, this.mediaTAJazz);

    @Mock
    private LibraryAssetRepository mockRepository;

    @InjectMocks
    private LibraryAssetService libraryAssetService;

    @Test
    void whenAssetAdded_thenControlFlowAsExpected() {
        LibraryAsset assetToAdd = this.baseAssets.get(new Random().nextInt(this.baseAssets.size()));
        Mockito.when(this.mockRepository.save(Mockito.any(LibraryAsset.class)))
                .thenReturn(assetToAdd);

        this.libraryAssetService.addAsset(assetToAdd);

        Mockito.verify(this.mockRepository,  Mockito.times(1))
                .save(Mockito.any(LibraryAsset.class));

    }

    @Test
    void whenAssetAdded_thenRepositorySaveIsCalled() {
        // Arrange
        LibraryAsset assetToAdd = this.bookThingsFallApart; // Use a specific asset from the baseAssets list
        Mockito.when(this.mockRepository.save(Mockito.any(LibraryAsset.class)))
                .thenReturn(assetToAdd);

        // Act
        this.libraryAssetService.addAsset(assetToAdd);

        // Assert
        Mockito.verify(this.mockRepository, Mockito.times(1))
                .save(Mockito.any(LibraryAsset.class));
    }


    @Test
    void whenAssetDeleted_thenControlFlowAsExpected() {
        // Arrange
        Mockito.doNothing().when(this.mockRepository).delete(Mockito.any(LibraryAsset.class));

        // Act
        this.libraryAssetService.removeAsset(this.baseAssets.get(new Random().nextInt(this.baseAssets.size())));

        // Assert
        Mockito.verify(this.mockRepository, Mockito.times(1))
                .delete(Mockito.any(LibraryAsset.class));
    }

    @Test
    void whenAssetDeletedByCode_thenControlFlowAsExpected() {
        // Arrange
        Mockito.when(this.mockRepository.findByAssetCode(Mockito.any(String.class)))
                .thenReturn(this.baseAssets.get(new Random().nextInt(this.baseAssets.size())));

        // Act
        Mockito.doNothing().when(this.mockRepository).delete(Mockito.any(LibraryAsset.class));

        // Assert
        Mockito.verify(this.mockRepository, Mockito.times(1))
                .delete(Mockito.any(LibraryAsset.class));
    }

    @Test
    void whenAssetUpdated_thenControlFlowAsExpected() {
        // Arrange
        LibraryAsset assetToQuery = this.baseAssets.get(new Random().nextInt(this.baseAssets.size()));
        Mockito.when(this.mockRepository.findByAssetCode(Mockito.any(String.class)))
                .thenReturn(assetToQuery);
        Mockito.when(this.mockRepository.save(Mockito.any(LibraryAsset.class)))
                .thenReturn(assetToQuery);

        // Act
        this.libraryAssetService.updateAssetAttributes("Lorem-Ipsum", new LibraryAssetDTO());

        // Assert
        Mockito.verify(this.mockRepository, Mockito.times(1))
                .save(Mockito.any(LibraryAsset.class));

    }


}
