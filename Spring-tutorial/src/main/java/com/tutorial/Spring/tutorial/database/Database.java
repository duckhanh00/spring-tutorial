// package com.tutorial.Spring.tutorial.database;

// import com.tutorial.Spring.tutorial.models.Product;
// import com.tutorial.Spring.tutorial.repositories.ProductRepository;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;


// @Configuration
// public class Database {
//     private static final Logger logger = LoggerFactory.getLogger(Database.class);
    
//     @Bean
//     CommandLineRunner initDatabase(ProductRepository productRepository) {
//         return new CommandLineRunner() {
//             @Override
//             public void run(String... args) throws Exception {
//                 Product productA = new Product("macbook", 2020, 1234.3, "");
//                 System.out.println(productA);
//                 Product productB = new Product("macbook air", 2020, 1234.3, "");
//                 System.out.println(productB);
//                 productRepository.save(productA);
//                 logger.info("insert data: "+productRepository.save(productA));
//                 logger.info("insert data: "+productRepository.save(productB));
//             }
//         };
//     }
// }
