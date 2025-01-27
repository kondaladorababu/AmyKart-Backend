package com.myProject.ProductService.service;

import com.myProject.ProductService.dto.ProductRequestDTO;
import com.myProject.ProductService.dto.ProductResponseDTO;
import com.myProject.ProductService.model.Product;
import com.myProject.ProductService.repository.ProductRepository;
import com.myProject.ProductService.specification.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public String addProduct(ProductRequestDTO productRequest) {
        if (productRequest.getTitle() == null || productRequest.getPrice() == null ||
                productRequest.getDescription() == null || productRequest.getImage() == null ||
                productRequest.getCategory() == null) {
            return "Title, Price, Description, Image and Category are mandatory fields";
        }

        Product product = new Product();
        Product newProduct = createProductFromRequest(product, productRequest);
        productRepository.save(newProduct);
        return "Product added successfully";
    }

    @Override
    public String updateProduct(int productId, ProductRequestDTO productRequest) {
        Product product = productRepository.findById(productId).orElse(null);

        if (product != null) {
            if (productRequest.getTitle() == null || productRequest.getPrice() == null ||
                    productRequest.getDescription() == null || productRequest.getImage() == null ||
                    productRequest.getCategory() == null) {
                return "Title, Price, Description, Image and Category are mandatory fields";
            }

            Product updatedProduct = createProductFromRequest(product, productRequest);
            productRepository.save(updatedProduct);
            return "Product updated successfully";
        }
        return "Product not found";
    }

    @Override
    public List<ProductResponseDTO> getProductsByCategory(String category) {
        List<Product> products = productRepository.findByCategory(category);
        return createProductResponseDTO(products);
    }

    @Override
    public List<ProductResponseDTO> getProductsByFilters(
            String category, Double minPrice, Double maxPrice, List<String> brands, List<String> sizes,
            List<String> colors, List<String> materials, List<String> fits, List<String> occasions,
            List<String> necks, List<String> authors, List<String> genres, List<String> languages,
            List<String> types, Double minRating, Double minDiscount)
    {
        Specification<Product> spec = Specification.where(ProductSpecification.hasCategory(category))
                .and(minPrice != null && maxPrice == null ? ProductSpecification.hasPriceLessThanEqualTo(minPrice) : null)
                .and(minPrice != null && maxPrice != null ? ProductSpecification.hasPriceBetween(minPrice, maxPrice) : null)
                .and(brands != null && !brands.isEmpty() ? ProductSpecification.hasBrand(brands) : null)
                .and(sizes != null && !sizes.isEmpty() ? ProductSpecification.hasSize(sizes) : null)
                .and(colors != null && !colors.isEmpty() ? ProductSpecification.hasColor(colors) : null)
                .and(materials != null && !materials.isEmpty() ? ProductSpecification.hasMaterial(materials) : null)
                .and(fits != null && !fits.isEmpty() ? ProductSpecification.hasFit(fits) : null)
                .and(occasions != null && !occasions.isEmpty() ? ProductSpecification.hasOccasion(occasions) : null)
                .and(necks != null && !necks.isEmpty() ? ProductSpecification.hasNeck(necks) : null)
                .and(authors != null && !authors.isEmpty() ? ProductSpecification.hasAuthor(authors) : null)
                .and(genres != null && !genres.isEmpty() ? ProductSpecification.hasGenre(genres) : null)
                .and(languages != null && !languages.isEmpty() ? ProductSpecification.hasLanguage(languages) : null)
                .and(types != null && !types.isEmpty() ? ProductSpecification.hasType(types) : null)
                .and(minRating != null ? ProductSpecification.hasRatingGreaterThan(minRating) : null)
                .and(minDiscount != null ? ProductSpecification.hasDiscountGreaterThanEqualTo(minDiscount) : null);

        List<Product> products = productRepository.findAll(spec);
        return createProductResponseDTO(products);
    }

    @Override
    public String deleteProduct(int productId) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product != null) {
            productRepository.delete(product);
            return "Product deleted successfully";
        }
        return "Product not found";
    }


    //Helper Functions
    public Product createProductFromRequest(Product product, ProductRequestDTO productRequest) {
        product.setTitle(productRequest.getTitle());
        product.setPrice(productRequest.getPrice());
        product.setDescription(productRequest.getDescription());
        product.setImage(productRequest.getImage());
        product.setCategory(productRequest.getCategory());

        product.setRating(productRequest.getRating() != null ? productRequest.getRating() : null);
        product.setBrand(productRequest.getBrand() != null ? productRequest.getBrand() : null);
        product.setSize(productRequest.getSize() != null ? productRequest.getSize() : null);
        product.setColor(productRequest.getColor() != null ? productRequest.getColor() : null);
        product.setMaterial(productRequest.getMaterial() != null ? productRequest.getMaterial() : null);
        product.setFit(productRequest.getFit() != null ? productRequest.getFit() : null);
        product.setOccasion(productRequest.getOccasion() != null ? productRequest.getOccasion() : null);
        product.setNeck(productRequest.getNeck() != null ? productRequest.getNeck() : null);
        product.setAuthor(productRequest.getAuthor() != null ? productRequest.getAuthor() : null);
        product.setGenre(productRequest.getGenre() != null ? productRequest.getGenre() : null);
        product.setLanguage(productRequest.getLanguage() != null ? productRequest.getLanguage() : null);
        product.setType(productRequest.getType() != null ? productRequest.getType() : null);
        product.setDiscount(productRequest.getDiscount() != null ? productRequest.getDiscount() : null);

        return product;
    }

    public List<ProductResponseDTO> createProductResponseDTO(List<Product> products) {
        return products.stream().map(product -> {
            ProductResponseDTO responseDTO = new ProductResponseDTO();

            responseDTO.setId(product.getId());
            responseDTO.setTitle(product.getTitle());
            responseDTO.setPrice(product.getPrice());
            responseDTO.setDescription(product.getDescription());
            responseDTO.setImage(product.getImage());
            responseDTO.setCategory(product.getCategory());

            responseDTO.setRating(product.getRating());
            responseDTO.setBrand(product.getBrand());
            responseDTO.setSize(product.getSize());
            responseDTO.setColor(product.getColor());
            responseDTO.setMaterial(product.getMaterial());
            responseDTO.setFit(product.getFit());
            responseDTO.setOccasion(product.getOccasion());
            responseDTO.setNeck(product.getNeck());
            responseDTO.setAuthor(product.getAuthor());
            responseDTO.setGenre(product.getGenre());
            responseDTO.setLanguage(product.getLanguage());
            responseDTO.setType(product.getType());
            responseDTO.setDiscount(product.getDiscount());

            return responseDTO;
        }).collect(Collectors.toList());
    }
}
