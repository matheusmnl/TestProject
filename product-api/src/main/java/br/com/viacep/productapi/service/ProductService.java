package br.com.viacep.productapi.service;

import br.com.viacep.productapi.dto.ProductDTO;
import br.com.viacep.productapi.model.Product;
import br.com.viacep.productapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> getAll() {
        List<Product> products =
        productRepository.findAll();
        return products
                .stream()
                .map(ProductDTO::convert)
                .collect(Collectors.toList());

    }
    public List<ProductDTO> getProductByCategoryId(
            Long categoryId
    ){
        List<Product> products =
                productRepository
                        .getProductByCategory(categoryId);
        return products
                .stream()
                .map(Product::convert)
                .collect(Collectors.toList());
    }
    public Product findByProductIdentifier(
            String productIdentifier
    ){
        Product product = productRepository
                .findByProductIdentifier(productIdentifier);
        if(product != null) {
            return ProductDTO.convert(product);
        }
        return null;
    }
    public ProductDTO save(ProductDTO productDTO) {
        Product product =
                productRepository.save(Product.convert(productDTO));
        return ProductDTO.convert(product);
    }

}
