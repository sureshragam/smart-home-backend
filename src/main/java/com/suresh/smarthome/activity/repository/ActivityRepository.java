package com.suresh.smarthome.activity.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suresh.smarthome.activity.entity.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
	
	long deleteByActivityTimeBefore(LocalDateTime activityTime);

}