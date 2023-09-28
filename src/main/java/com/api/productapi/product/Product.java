  package com.api.productapi.product;

import jakarta.persistence.*;

import java.util.Arrays;

@Entity
@Table
public class Product {
    @Id
    @SequenceGenerator(
            name="product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
//    สร้าง field เก็บข้อมูลข้อมูล
    private Long id;
    @Lob
    private byte[] advt;
    @Lob
    private byte[] image;
    private String name;
    private String description;

    private int price;

//    Construtor
    public Product(Long id, byte[] image, String name, String description , int price){
        this.id = id;
        this.advt = advt;
        this.image = image;
        this.name = name;
        this.description = description;
        this.price = price;
    }
    public Product(byte[] image, String name, String description, int price){
        this.advt = advt;
        this.image = image;
        this.name = name;
        this.description = description;
        this.price = price;
    }
    public Product(){}

//    getter and setter methods มีสำหรับทุก Fields เพื่ออนุญาติให้เข้าถึงและแก้ไขข้อมูล
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public byte[] getImage(){
        return image;
    }
    public void setImage(byte[] image){
        this.image = image;
    }
    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public int getPrice(){
        return price;
    }
    public void setPrice(int price){
        this.price = price;
    }

//    toString() method แสดงข้อมูลของ obj เป็น String
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", advt=" + Arrays.toString(advt) +'\'' +
                ", image=" + Arrays.toString(image) +'\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}

