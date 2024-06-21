package com.example.demo.model;

import com.example.demo.constants.ColumnNames;
import com.example.demo.constants.TableNames;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table(name = TableNames.USER)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ColumnNames.ID)
    private Long id;

    @Column(name = ColumnNames.USERNAME, length = 255)
    private String username;

    @Column(name = ColumnNames.PASSWORD)
    private String password;

    @Column(name = ColumnNames.EMAIL)
    private String email;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}