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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/activities")
@RequiredArgsConstructor
@Tag(
    name = "Activities",
    description = "APIs for retrieving activity history and processing motion events."
)
public class ActivityController {

    private final ActivityService activityService;

    @Operation(summary = "Get all activities")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Activities retrieved successfully")
    })
    @GetMapping
    public List<ActivityResponse> getAllActivities() {
        return activityService.getAllActivities();
    }

    @Operation(summary = "Process a motion event")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Motion event processed successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid request"),
        @ApiResponse(responseCode = "404", description = "Device not found")
    })
    @PostMapping("/motion")
    public void processMotionEvent(
            @Valid @RequestBody MotionRequest request) {

        activityService.processMotionEvent(request);
    }

}