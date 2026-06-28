package com.suresh.smarthome.health.entity;

import com.suresh.smarthome.common.entity.BaseEntity;
import com.suresh.smarthome.health.enums.HealthStatus;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "health_metrics")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HealthMetric extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String label;

    @Column(nullable = false)
    private String value;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private HealthStatus status;

}