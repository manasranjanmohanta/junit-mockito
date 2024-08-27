package com.example.demo.Library;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class LibraryAssetDTO {
    // @JsonProperty is to define a custom name for a Java object's field or property
    // when it is serialized to JSON or deserialized from JSON
    @JsonProperty("assertTitle")
    private String assetTitle;
    @JsonProperty private String creatorName;
    @JsonProperty private String publisherName;
    @JsonProperty private String assetCategory;
    @JsonProperty private String assetType;
    @JsonProperty private Short editionYear;
    @JsonProperty private String priceUSD;
}
