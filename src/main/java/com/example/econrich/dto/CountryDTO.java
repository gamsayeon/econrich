package com.example.econrich.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CountryDTO {
    private String countryId;

    private String countryName;

    private RegionDTO regionDTO;

}
