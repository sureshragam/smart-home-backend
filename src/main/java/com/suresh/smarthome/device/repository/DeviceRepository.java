package com.suresh.smarthome.device.repository;



import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suresh.smarthome.device.entity.Device;
import com.suresh.smarthome.device.enums.DeviceLocation;
import com.suresh.smarthome.device.enums.DeviceStatus;
import com.suresh.smarthome.device.enums.DeviceType;


@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {

    long countByStatus(DeviceStatus status);

    Optional<Device> findByDeviceCode(String deviceCode);
    
    long countByLastSeenAfter(LocalDateTime lastSeen);
    
    Optional<Device> findTopByTypeAndLocationOrderByIdDesc(
            DeviceType type,
            DeviceLocation location);


}