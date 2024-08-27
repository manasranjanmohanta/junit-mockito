package com.example.demo.Library;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryAssetService {

    @Autowired
    private LibraryAssetRepository assetRepository;

    public LibraryAsset findByCode(@NonNull String assetCode) {
        return this.assetRepository.findByAssetCode(assetCode);
    }

    public List<LibraryAsset> findByCreator(@NonNull String assetCreator) {
        return this.assetRepository.findByCreatorName(assetCreator);
    }

    public List<LibraryAsset> findByTitle(@NonNull String assetTitle) {
        return this.assetRepository.findByAssetTitle(assetTitle);
    }

    public List<LibraryAsset> findByCategory(@NonNull String assetCategory) {
        return this.assetRepository.findByAssetCategory(assetCategory);
    }

    public List<LibraryAsset> findByType(@NonNull String assetType) {
        return this.assetRepository.findByAssetType(assetType);
    }

    public List<LibraryAsset> findByPublisher(@NonNull String assetPublisher) {
        return this.assetRepository.findByPublisherName(assetPublisher);
    }

    @Transactional
    public void addAsset(@NonNull LibraryAsset assetToAdd) {
        this.assetRepository.save(assetToAdd);
    }

    public List<LibraryAsset> getAllAssets() {
        return this.assetRepository.findAll();
    }

    @Transactional
    public void removeAsset(@NonNull String assetCode) {
        LibraryAsset queriedAsset = this.findByCode(assetCode);
        this.assetRepository.delete(queriedAsset);
    }

    @Transactional
    public void removeAsset(@NonNull LibraryAsset assetToRemove) {
        this.assetRepository.delete(assetToRemove);
    }

    @Transactional
    public LibraryAsset updateAssetAttributes(@NonNull String assetCode, @NonNull LibraryAssetDTO libraryAssetDTO) {
        LibraryAsset updAsset = this.assetRepository.findByAssetCode(assetCode);

        if (libraryAssetDTO.getEditionYear() != null && libraryAssetDTO.getEditionYear() > (short) 0) {
            updAsset.setEditionYear(libraryAssetDTO.getEditionYear());
        }

        if (libraryAssetDTO.getCreatorName() != null && !libraryAssetDTO.getCreatorName().isEmpty()) {
            updAsset.setCreatorName(libraryAssetDTO.getCreatorName());
        }

        if (libraryAssetDTO.getPublisherName() != null && !libraryAssetDTO.getPublisherName().isEmpty()) {
            updAsset.setPublisherName(libraryAssetDTO.getPublisherName());
        }

        if (libraryAssetDTO.getAssetCategory() != null && !libraryAssetDTO.getAssetCategory().isEmpty()) {
            updAsset.setAssetCategory(libraryAssetDTO.getAssetCategory());
        }

        if (libraryAssetDTO.getAssetType() != null && !libraryAssetDTO.getAssetType().isEmpty()) {
            updAsset.setAssetType(libraryAssetDTO.getAssetType());
        }

        if (libraryAssetDTO.getAssetTitle() != null && !libraryAssetDTO.getAssetTitle().isEmpty()) {
            updAsset.setAssetTitle(libraryAssetDTO.getAssetTitle());
        }

        if (libraryAssetDTO.getPriceUSD() != null && !libraryAssetDTO.getPriceUSD().isEmpty()) {
            updAsset.setPriceUSD(libraryAssetDTO.getPriceUSD());
        }

        return this.assetRepository.save(updAsset);
    }
}
