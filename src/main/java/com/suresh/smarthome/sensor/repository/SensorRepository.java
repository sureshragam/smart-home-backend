package com.suresh.smarthome.sensor.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suresh.smarthome.device.entity.Device;
import com.suresh.smarthome.sensor.entity.Sensor;
import com.suresh.smarthome.sensor.enums.SensorStatus;
import com.suresh.smarthome.sensor.enums.SensorType;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {

    Optional<Sensor> findBySensorCode(String sensorCode);

    boolean existsBySensorCode(String sensorCode);

    List<Sensor> findByDevice(Device device);

    List<Sensor> findByType(SensorType type);

    List<Sensor> findByStatus(SensorStatus status);

    long countByType(SensorType type);

    long countByTypeAndStatus(SensorType type, SensorStatus status);

    Optional<Sensor> findTopByDeviceAndTypeOrderByIdDesc(
            Device device,
            SensorType type);

}