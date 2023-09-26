package com.api.productapi.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // เป็น Spring Data repository ใช้สำหรับจัดการและทำงานกับฐานข้อมูล
// การสืบทอดจาก JpaRepository<Product, Long> ทำให้ ProductRepository มีความสามารถในการดำเนินการที่เกี่่ยวข้องกับข้อมูลผู้ใช้ในฐานข้อมูล และความสามารถที่จะทำงานร่วมกับข้อมูลผู้ใช้ที่มี primary key ประเภท Long
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT s FROM Product s WHERE s.id = ?1") // คือการกำหนดคำสั่ง JPQL ที่จะค้นหาข้อมูลผู้ใช้จากฐานข้อมูล
    Optional<Product> findProductById(Long id); // Method นี้ใช้ค้นหาข้อมูลผู้ใช้จากฐานข้อมูลโดยใช้ ID เป็นเงื่อนไขการค้นหา มีพารามิเตอร์เดียวคือ ID และคืนผลลัพธ์ในรูปแบบของ Optional<Product>
}
