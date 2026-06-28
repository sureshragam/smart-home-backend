package com.suresh.smarthome.sensor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suresh.smarthome.sensor.entity.SensorReading;

@Repository
public interface SensorRepository extends JpaRepository<SensorReading, Long> {

}