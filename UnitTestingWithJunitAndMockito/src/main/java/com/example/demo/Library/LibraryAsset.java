package com.example.demo.Library;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "library_asset")
public class LibraryAsset {

    @Id
    @Column(name = "asset_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "asset_code", unique = true, nullable = false)
    private String assetCode;

    @Column(name = "asset_title", nullable = false)
    private String assetTitle;

    @Column(name = "creator_name", nullable = false)
    private String creatorName;

    @Column(name = "publisher_name", nullable = false)
    private String publisherName;

    @Column(name = "asset_category", nullable = false)
    private String assetCategory;

    @Column(name = "asset_type", nullable = false)
    private String assetType;

    @Column(name = "edition_year", nullable = false)
    private short editionYear;

    @Column(name = "price_usd", nullable = false)
    private String priceUSD;
}
