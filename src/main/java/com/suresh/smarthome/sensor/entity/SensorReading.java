package com.suresh.smarthome.sensor.entity;

import java.time.LocalDateTime;

import com.suresh.smarthome.common.entity.BaseEntity;
import com.suresh.smarthome.device.entity.Device;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @JoinColumn(name = "device_id", nullable = false)
    private Device device;

    @Column(nullable = false)
    private Double temperature;

    @Column(nullable = false)
    private Double humidity;

    @Column(nullable = false)
    private Integer battery;

    @Column(nullable = false)
    private Integer signalStrength;

    @Column(nullable = false)
    private LocalDateTime readingTime;

}