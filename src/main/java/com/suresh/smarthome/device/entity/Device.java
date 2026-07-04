package com.suresh.smarthome.device.entity;

import java.time.LocalDateTime;

import com.suresh.smarthome.device.enums.DeviceLocation;
import com.suresh.smarthome.device.enums.DeviceStatus;
import com.suresh.smarthome.device.enums.DeviceType;
import com.suresh.smarthome.common.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "devices")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Device extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false, unique = true)
    private String deviceCode;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DeviceType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DeviceStatus status;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DeviceLocation location;

    private String ipAddress;

    private Integer wifiStrength;

    private String firmwareVersion;

    private LocalDateTime lastSeen;

}