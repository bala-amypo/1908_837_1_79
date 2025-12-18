package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(
    name = "vehicles",
    uniqueConstraints = @UniqueConstraint(columnNames = "vehicleNumber")
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @NotBlank
    @Size(min = 2, max = 50)
    @Column(nullable = false, unique = true)
    private String vehicleNumber;

    @NotNull
    @Positive
    private Double capacityKg;

    @NotNull
    @Positive
    private Double fuelEfficiency;
}
