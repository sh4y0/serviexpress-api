package com.servi.serviexpress_api.user.infrastructure.adapters.output.persistence.entity;

import com.servi.serviexpress_api.customer.infrastructure.adapters.output.persistence.entity.CustomerEntity;
import com.servi.serviexpress_api.employee.infrastructure.adapters.output.persistence.entity.EmployeeEntity;
import com.servi.serviexpress_api.user.domain.model.Role;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class UserEntity implements UserDetails{

    @Id
    //@UuidGenerator(style = UuidGenerator.Style.TIME)
    @Column(length = 50, updatable = false, nullable = false)
    private String id;

    @Column(unique = true, nullable = false)
    private String userName;

    @Column()
    private String name;

    @Column()
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    private String profileImageUrl;
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(columnDefinition = "boolean default false")
    private boolean completeProfile;

    private double latitude;
    private double longitude;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "employee_id", unique = true)
    private EmployeeEntity employee;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "customer_id", unique = true)
    private CustomerEntity customer;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @SuppressWarnings("unused")
    public String getUserName() {
        return userName;
    }

    @SuppressWarnings("unused")
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
