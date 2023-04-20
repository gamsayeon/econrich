package com.example.econrich.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CountryDTO {
    private String countryId;

    private String countryName;

    private RegionDTO regionDTO;

}
