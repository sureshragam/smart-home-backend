package com.suresh.smarthome.sensor.entity;

import java.time.LocalDateTime;

import com.suresh.smarthome.common.entity.BaseEntity;
import com.suresh.smarthome.device.entity.Device;
import com.suresh.smarthome.sensor.enums.SensorStatus;
import com.suresh.smarthome.sensor.enums.SensorType;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "sensors")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sensor extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String sensorCode;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SensorType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SensorStatus status;

    @Column(nullable = false)
    private Integer pinNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_id", nullable = false)
    private Device device;

    private LocalDateTime lastSeen;
    
    private String manufacturer;

    private String model;

}