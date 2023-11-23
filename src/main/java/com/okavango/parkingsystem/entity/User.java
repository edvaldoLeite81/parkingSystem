package com.okavango.parkingsystem.entity;

import com.okavango.parkingsystem.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String userName;

    @Column(nullable = false, length = 200)
    private String password;

    private LocalDateTime creationDate;

    private LocalDateTime modificationDate;

    private String createdBy;

    private String modifiedBy;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 25)
    private Role role = Role.ROLE_CLIENT;

    //construtor personalizado
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
