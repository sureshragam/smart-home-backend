package com.suresh.smarthome.activity.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suresh.smarthome.activity.dto.request.MotionRequest;
import com.suresh.smarthome.activity.dto.response.ActivityResponse;
import com.suresh.smarthome.activity.service.ActivityService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/activities")
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityService activityService;

    @GetMapping
    public List<ActivityResponse> getAllActivities() {
        return activityService.getAllActivities();
    }

    @PostMapping("/motion")
    public void processMotionEvent(
            @Valid @RequestBody MotionRequest request) {

        activityService.processMotionEvent(request);
    }

}