package com.example.final_exam_module4.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity(name= "khach_hang")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE khach_hang SET deleted_at = Now() WHERE id=?")
@Where(clause = "deleted_at is null")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id")
    private long id;

    @Pattern(regexp = "^[A-Za-z0-9À-ỹáàảãạăắằẳẵặâấầẩẫậéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵ ]+$", message = "Tên chỉ được chứa chữ cái, số, khoảng trắng và các ký tự tiếng Việt hợp lệ, không có ký tự đặc biệt.")
    @Size(min = 1, max = 255, message = "Tên phải từ 2 đến 50 ký tự.")
    @NotEmpty(message = "Tên không được để trống.")
    @Column(name = "customer_Name")
    private String customerName;

    @Pattern(regexp = "^[0-9]{9,20}$", message = "Số điện thoại phải chứa từ 9 đến 20 chữ số.")
    @NotNull(message = "Số điện thoại không được để trống.")
    @Column(name = "phone")
    private String phone;

    @NotNull(message = "Địa chỉ email không được để trống")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "Email không hợp lệ")
    @Column(name = "email")
    private String email;

    @Column(name = "deleted_at")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime deletedAt;
}
