package com.example.demo.model;


import com.example.demo.constants.ColumnNames;
import com.example.demo.constants.TableNames;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = TableNames.CUSTOMER)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ColumnNames.ID)
    private Long id;

    @Column(name = ColumnNames.NAME, length = 255)
    private String name;

    @Column(name = ColumnNames.EMAIL, length = 255)
    private String email;

    @Column(name = ColumnNames.PHONE, length = 20)
    private String phone;

    @Column(name = ColumnNames.ADDRESS, length = 255)
    private String address;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}