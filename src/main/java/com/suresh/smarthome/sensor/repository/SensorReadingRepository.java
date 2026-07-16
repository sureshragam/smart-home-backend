package com.suresh.smarthome.sensor.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suresh.smarthome.sensor.entity.SensorReading;
import com.suresh.smarthome.sensor.enums.ReadingType;

@Repository
public interface SensorReadingRepository extends JpaRepository<SensorReading, Long> {

    Optional<SensorReading> findTopByReadingTypeOrderByReadingTimeDesc(
            ReadingType readingType);

}