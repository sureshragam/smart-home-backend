package com.suresh.smarthome.activity.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suresh.smarthome.activity.dto.request.MotionRequest;
import com.suresh.smarthome.activity.dto.response.ActivityResponse;
import com.suresh.smarthome.activity.entity.Activity;
import com.suresh.smarthome.activity.enums.ActivityType;
import com.suresh.smarthome.activity.mapper.ActivityMapper;
import com.suresh.smarthome.activity.repository.ActivityRepository;
import com.suresh.smarthome.common.exception.ResourceNotFoundException;
import com.suresh.smarthome.common.util.DateTimeUtil;
import com.suresh.smarthome.device.enums.MotionStatus;
import com.suresh.smarthome.sensor.entity.Sensor;
import com.suresh.smarthome.sensor.repository.SensorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository activityRepository;
    private final SensorRepository sensorRepository;

    public List<ActivityResponse> getAllActivities() {
        return activityRepository.findAll(
                        Sort.by(Sort.Direction.DESC, "activityTime"))
                .stream()
                .map(ActivityMapper::toResponse)
                .toList();
    }

    @Transactional
    public void processMotionEvent(MotionRequest request) {

        Sensor sensor = sensorRepository.findBySensorCode(request.getSensorCode())
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Sensor with code '%s' not found.",
                                request.getSensorCode())));

        LocalDateTime now = DateTimeUtil.now();

        // Update sensor heartbeat
        sensor.setLastSeen(now);

        // Update parent device heartbeat
        sensor.getDevice().setLastSeen(now);

        ActivityType activityType = request.getMotionStatus() == MotionStatus.ACTIVE
                ? ActivityType.MOTION_DETECTED
                : ActivityType.MOTION_STOPPED;

        String title = request.getMotionStatus() == MotionStatus.ACTIVE
                ? "Motion Detected"
                : "Motion Stopped";

        String message = request.getMotionStatus() == MotionStatus.ACTIVE
                ? "Motion detected by " + sensor.getName()
                : "Motion stopped for " + sensor.getName();

        Activity activity = Activity.builder()
                .sensor(sensor)
                .type(activityType)
                .title(title)
                .message(message)
                .activityTime(now)
                .build();

        activityRepository.save(activity);
    }

}