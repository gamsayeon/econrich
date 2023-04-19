package com.example.econrich.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LocationDTO {
    private Long locationId;

    private String streetAddress;

    private String postalCode;

    private String city;

    private String stateProvince;

    private CountryDTO countryDTO;
}
