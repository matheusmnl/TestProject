package br.com.viacep.serverapi.dto;

import br.com.viacep.serverapi.model.Region;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RegionDTO {

    @NotBlank
    private String productIdentifier;
    @NotNull
    private Float taxPercentage;

    public String getProductIdentifier() {
        return productIdentifier;
    }

    public void setProductIdentifier(String productIdentifier) {
        this.productIdentifier = productIdentifier;
    }

    public Float getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(Float taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    public static RegionDTO convert(Region region) {
        RegionDTO regionDTO = new RegionDTO();
        regionDTO.setProductIdentifier(
                region.getProductIdentifier()
        );
        regionDTO.setTaxPercentage(region.getTaxPercentage());
        return  regionDTO;
    }
}
