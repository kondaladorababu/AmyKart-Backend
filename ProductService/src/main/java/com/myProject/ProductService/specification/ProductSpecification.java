package com.myProject.ProductService.specification;

import com.myProject.ProductService.model.Product;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class ProductSpecification {

    public static Specification<Product> hasCategory(String category) {
        return (root, query, createBuilder) -> {
            return createBuilder.equal(root.get("category"), category);
        };
    }

    public static Specification<Product> hasPriceLessThan(double price) {
        return (root, query, createBuilder) -> {
            return createBuilder.lessThan(root.get("price"), price);
        };
    }

    public static Specification<Product> hasPriceGreaterThan(double price) {
        return (root, query, createBuilder) -> {
            return createBuilder.greaterThan(root.get("price"), price);
        };
    }

    public static Specification<Product> hasPriceBetween(double minPrice, double maxPrice) {
        return (root, query, createBuilder) -> {
            return createBuilder.between(root.get("price"), minPrice, maxPrice);
        };
    }

    //hasBrand
    public static Specification<Product> hasBrand(List<String> brands) {
        return (root, query, createBuilder) -> {
            return root.get("brand").in(brands);
        };
    }

    //hasRating
    public static Specification<Product> hasRating(double rating) {
        return (root, query, createBuilder) -> {
            return createBuilder.equal(root.get("rating"), rating);
        };
    }

    //hasRatingGreaterThan
    public static Specification<Product> hasRatingGreaterThan(double rating) {
        return (root, query, createBuilder) -> {
            return createBuilder.greaterThan(root.get("rating"), rating);
        };
    }

    //hasRatingLessThan
    public static Specification<Product> hasRatingLessThan(double rating) {
        return (root, query, createBuilder) -> {
            return createBuilder.lessThan(root.get("rating"), rating);
        };
    }

    //size
    public static Specification<Product> hasSize(String size) {
        return (root, query, createBuilder) -> {
            return createBuilder.equal(root.get("size"), size);
        };
    }

    //discount
    public static Specification<Product> hasDiscount(double discount) {
        return (root, query, createBuilder) -> {
            return createBuilder.equal(root.get("discount"), discount);
        };
    }

    //color
    public static Specification<Product> hasColor(String color) {
        return (root, query, createBuilder) -> {
            return createBuilder.equal(root.get("color"), color);
        };
    }

    //material
    public static Specification<Product> hasMaterial(String material) {
        return (root, query, createBuilder) -> {
            return createBuilder.equal(root.get("material"), material);
        };
    }

    //fit
    public static Specification<Product> hasFit(String fit) {
        return (root, query, createBuilder) -> {
            return createBuilder.equal(root.get("fit"), fit);
        };
    }

    //occasion
    public static Specification<Product> hasOccasion(String occasion) {
        return (root, query, createBuilder) -> {
            return createBuilder.equal(root.get("occasion"), occasion);
        };
    }

    //neck
    public static Specification<Product> hasNeck(String neck) {
        return (root, query, createBuilder) -> {
            return createBuilder.equal(root.get("neck"), neck);
        };
    }

    //author
    public static Specification<Product> hasAuthor(String author) {
        return (root, query, createBuilder) -> {
            return createBuilder.equal(root.get("author"), author);
        };
    }

    //genere
    public static Specification<Product> hasGenere(String genere) {
        return (root, query, createBuilder) -> {
            return createBuilder.equal(root.get("genere"), genere);
        };
    }

    //language
    public static Specification<Product> hasLanguage(String language) {
        return (root, query, createBuilder) -> {
            return createBuilder.equal(root.get("language"), language);
        };
    }

    //type
    public static Specification<Product> hasType(String type) {
        return (root, query, createBuilder) -> {
            return createBuilder.equal(root.get("type"), type);
        };
    }


}
