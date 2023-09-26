//package com.api.productapi.product;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class CorsConfig {
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedOrigins("*") // กำหนดโดเมนที่อนุญาต (ในที่นี้อนุญาตทุกโดเมน)
//                        .allowedMethods("GET", "POST", "PUT", "DELETE") // กำหนด HTTP methods ที่อนุญาต
//                        .allowCredentials(true) // อนุญาตการส่งข้อมูลสำหรับแบบต่างๆ (เช่น คุกกี้)
//                        .maxAge(3600); // ตั้งค่าอายุของการอนุญาตเป็นวินาที
//            }
//        };
//    }
//}
//
