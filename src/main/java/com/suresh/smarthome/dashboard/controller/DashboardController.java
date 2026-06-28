package com.suresh.smarthome.dashboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suresh.smarthome.dashboard.dto.response.DashboardResponse;
import com.suresh.smarthome.dashboard.service.DashboardService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/dashboard")
@RequiredArgsConstructor
@Tag(
    name = "Dashboard",
    description = "APIs for retrieving the smart home dashboard summary."
)
public class DashboardController {

    private final DashboardService dashboardService;

    @Operation(
    	    summary = "Get dashboard summary",
    	    description = "Returns an overview of the smart home including device statistics, motion status, and system health."
    	)
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Dashboard summary retrieved successfully")
    })
    @GetMapping
    public DashboardResponse getDashboardSummary() {
        return dashboardService.getDashboardSummary();
    }

}