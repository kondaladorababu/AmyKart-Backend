package com.example.AmyKart_Backend.product;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*") // Enable CORS
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        List<Product> products = productService.findAll();
        List<ProductResponse> productResponses = products.stream().map(ProductResponse::new).collect(Collectors.toList());
        return ResponseEntity.ok(productResponses);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addProduct(@RequestParam("title") String title,
                                             @RequestParam("price") double price,
                                             @RequestParam("description") String description,
                                             @RequestParam("category") String category,
                                             @RequestParam("image") MultipartFile image) throws IOException {
        if (image.isEmpty()) {
            return new ResponseEntity<>("Image not found", HttpStatus.BAD_REQUEST);
        }

        if (!image.getContentType().equals("image/jpeg")) {
            return new ResponseEntity<>("Only JPEG images are allowed", HttpStatus.BAD_REQUEST);
        }

        Product newProduct = new Product(title, price, description, category, image.getBytes(), null);
        productService.createProduct(newProduct);
        return ResponseEntity.ok("Product added successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Integer id) {
        Product product = productService.getProductById(id);
        if (product == null) {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(product);

    }

    @GetMapping("/image/{id}")
    public ResponseEntity<?> getProductImage(@PathVariable int id) {
        Optional<Product> product = Optional.ofNullable(productService.getProductById(id));
        if (product.isEmpty()) {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
        byte[] image = product.get().getImage();
        HttpHeaders headers = new HttpHeaders();
        headers.add("content-type", "image/jpeg");
        return new ResponseEntity<>(image, headers, HttpStatus.OK);
        
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer id) {
        Product product = productService.getProductById(id);
        if (product == null) {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        boolean updated = productService.updateProduct(id, product);
        if (updated) {
            return ResponseEntity.ok("Product updated successfully");
        } else {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
    }
}
