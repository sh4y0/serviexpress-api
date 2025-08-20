package com.servi.serviexpress_api.category.domain.model;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    private Long id;
    private String name;
    private String iconUrl;
    private boolean isActive;
    private LocalDateTime createdAt;
}
