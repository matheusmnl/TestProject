package br.com.viacep.serverapi.model;

import javax.persistence.Embeddable;

@Embeddable
public class Region {

    private String productIdentifier;
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

    public static Region convert(RegionDTO regionDTO) {
        Region region = new Region();
        region.setProductIdentifier(
                regionDTO.getProductIdentifier()
        ); regionDTO.setTaxPercentage(regionDTO.getTaxPercentage());
        return region;
    }
}
