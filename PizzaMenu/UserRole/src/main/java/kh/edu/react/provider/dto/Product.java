package kh.edu.react.provider.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    private String productName;

    private String productDescription;

    private int productPrice;

    private String productCategory;

    private int productStock;

    private String productImageUrl;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Product(String productName, String productDescription, int productPrice, String productCategory, int productStock, String productImageUrl) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
        this.productStock = productStock;
        this.productImageUrl = productImageUrl;
    }
}
