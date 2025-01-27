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

    public static Specification<Product> hasPriceLessThanEqualTo(double price) {
        return (root, query, createBuilder) -> {
            return createBuilder.lessThanOrEqualTo(root.get("price"), price);
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

    //hasRatingGreaterThan
    public static Specification<Product> hasRatingGreaterThan(double rating) {
        return (root, query, createBuilder) -> {
            return createBuilder.greaterThanOrEqualTo(root.get("rating"), rating);
        };
    }

    //size
    public static Specification<Product> hasSize(List<String> sizes) {
        return (root, query, criteriaBuilder) -> root.get("size").in(sizes);
    }

    //discount
    public static Specification<Product> hasDiscountGreaterThanEqualTo(double discount) {
        return (root, query, createBuilder) -> {
            return createBuilder.greaterThanOrEqualTo(root.get("discount"), discount);
        };
    }

    //color
    public static Specification<Product> hasColor(List<String> colors) {
        return (root, query, createBuilder) -> {
            return root.get("color").in(colors);
        };
    }

    //material
    public static Specification<Product> hasMaterial(List<String> materials) {
        return (root, query, createBuilder) -> {
            return root.get("material").in(materials);
        };
    }

    //fit
    public static Specification<Product> hasFit(List<String> fits) {
        return (root, query, createBuilder) -> {
            return root.get("fit").in(fits);
        };
    }

    //occasion
    public static Specification<Product> hasOccasion(List<String> occasions) {
        return (root, query, createBuilder) -> {
            return root.get("occasion").in(occasions);
        };
    }

    //neck
    public static Specification<Product> hasNeck(List<String> neck) {
        return (root, query, createBuilder) -> {
            return createBuilder.equal(root.get("neck"), neck);
        };
    }

    //author
    public static Specification<Product> hasAuthor(List<String> author) {
        return (root, query, createBuilder) -> {
            return createBuilder.equal(root.get("author"), author);
        };
    }

    //genere
    public static Specification<Product> hasGenre(List<String> genere) {
        return (root, query, createBuilder) -> {
            return createBuilder.equal(root.get("genere"), genere);
        };
    }

    //language
    public static Specification<Product> hasLanguage(List<String> language) {
        return (root, query, createBuilder) -> {
            return createBuilder.equal(root.get("language"), language);
        };
    }

    //type
    public static Specification<Product> hasType(List<String> type) {
        return (root, query, createBuilder) -> {
            return createBuilder.equal(root.get("type"), type);
        };
    }
}
