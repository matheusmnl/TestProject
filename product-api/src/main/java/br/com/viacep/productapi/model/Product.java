package br.com.viacep.productapi.model;

import br.com.viacep.productapi.dto.ProductDTO;
import jdk.jfr.Category;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private Float percentualImposto;
    private String descricao;
    private String productIdentifier;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getPercentualImposto() {
        return percentualImposto;
    }

    public void setPercentualImposto(Float percentualImposto) {
        this.percentualImposto = percentualImposto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getProductIdentifier() {
        return productIdentifier;
    }

    public void setProductIdentifier(String productIdentifier) {
        this.productIdentifier = productIdentifier;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public static Product convert(ProductDTO productDTO) {
        Product product = new Product();
        product.setNome(productDTO.getNome());
        product.setPercentualImposto(productDTO.getPercentualImposto());

    product.setDescricao(productDTO.getDesccricao());
        product.setProductIdentifier(
                productDTO.getProductIdentifier()
        );
        if(productDTO.getCategoryDTO() != null) {
            product.setCategory(
        Category.convert(productDTO.getCategoryDTO()));

        }
        return  product;
    }
}
