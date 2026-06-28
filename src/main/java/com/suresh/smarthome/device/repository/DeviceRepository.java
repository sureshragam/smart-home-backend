package com.suresh.smarthome.device.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suresh.smarthome.device.entity.Device;
import com.suresh.smarthome.device.enums.DeviceStatus;
import com.suresh.smarthome.device.enums.MotionStatus;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {

    long countByStatus(DeviceStatus status);

    long countByMotionStatus(MotionStatus motionStatus);
    Optional<Device> findByDeviceCode(String deviceCode);

}