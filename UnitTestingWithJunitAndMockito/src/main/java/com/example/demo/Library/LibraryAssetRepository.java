package com.example.demo.Library;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibraryAssetRepository extends JpaRepository<LibraryAsset, Long> {
    LibraryAsset findByAssetCode(String assetCode);
    List<LibraryAsset> findByAssetTitle(String assetTitle);
    List<LibraryAsset> findByCreatorName(String assetCreator);
    List<LibraryAsset> findByPublisherName(String publisherName);
    List<LibraryAsset> findByAssetCategory(String assetCategory);
    List<LibraryAsset> findByAssetType(String assetCategory);
}
