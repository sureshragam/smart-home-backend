package com.suresh.smarthome.activity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suresh.smarthome.activity.entity.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

}