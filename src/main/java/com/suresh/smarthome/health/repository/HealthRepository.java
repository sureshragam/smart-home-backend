package com.suresh.smarthome.health.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suresh.smarthome.health.entity.HealthMetric;

@Repository
public interface HealthRepository extends JpaRepository<HealthMetric, Long> {

}