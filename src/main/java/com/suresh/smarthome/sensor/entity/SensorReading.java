package com.suresh.smarthome.sensor.entity;

import java.time.LocalDateTime;

import com.suresh.smarthome.common.entity.BaseEntity;
import com.suresh.smarthome.sensor.enums.ReadingType;
import com.suresh.smarthome.sensor.enums.UnitType;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "sensor_readings")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SensorReading extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sensor_id", nullable = false)
    private Sensor sensor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReadingType readingType;

    @Column(nullable = false)
    private Double value;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UnitType unit;

    @Column(nullable = false)
    private LocalDateTime readingTime;

}