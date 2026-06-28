package com.suresh.smarthome.activity.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.suresh.smarthome.activity.dto.request.MotionRequest;
import com.suresh.smarthome.activity.dto.response.ActivityResponse;
import com.suresh.smarthome.activity.entity.Activity;
import com.suresh.smarthome.activity.enums.ActivityType;
import com.suresh.smarthome.activity.mapper.ActivityMapper;
import com.suresh.smarthome.activity.repository.ActivityRepository;
import com.suresh.smarthome.common.exception.ResourceNotFoundException;
import com.suresh.smarthome.common.util.DateTimeUtil;
import com.suresh.smarthome.device.entity.Device;
import com.suresh.smarthome.device.enums.MotionStatus;
import com.suresh.smarthome.device.repository.DeviceRepository;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository activityRepository;
    private final DeviceRepository deviceRepository;

    public List<ActivityResponse> getAllActivities() {

    	return activityRepository.findAll(Sort.by(Sort.Direction.DESC, "activityTime"))
    	        .stream()
    	        .map(ActivityMapper::toResponse)
    	        .toList();
    }
    
    @Transactional
    public void processMotionEvent(MotionRequest request) {

        Device device = deviceRepository.findByDeviceCode(request.getDeviceCode())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                String.format("Device with code '%s' not found.",
                                        request.getDeviceCode())));

        LocalDateTime now = DateTimeUtil.now();

        device.setMotionStatus(request.getMotionStatus());
        device.setLastSeen(now);

        Activity activity = Activity.builder()
                .deviceName(device.getName())
                .type(request.getMotionStatus() == MotionStatus.ACTIVE
                        ? ActivityType.MOTION_DETECTED
                        : ActivityType.MOTION_STOPPED)
                .title(request.getMotionStatus() == MotionStatus.ACTIVE
                        ? "Motion Detected"
                        : "Motion Stopped")
                .message(request.getMotionStatus() == MotionStatus.ACTIVE
                        ? "Motion detected by " + device.getName()
                        : "Motion stopped for " + device.getName())
                .activityTime(now)
                .build();

        activityRepository.save(activity);
    }

}