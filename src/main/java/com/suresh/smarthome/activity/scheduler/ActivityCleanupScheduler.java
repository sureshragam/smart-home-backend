package com.suresh.smarthome.activity.scheduler;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.suresh.smarthome.activity.repository.ActivityRepository;
import com.suresh.smarthome.common.util.DateTimeUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class ActivityCleanupScheduler {

    private final ActivityRepository activityRepository;
    
    @Value("${app.activity.retention-days}")
    private int retentionDays;
    
    @Transactional
    @Scheduled(cron = "0 0 2 * * ?")
    public void cleanupOldActivities() {

        LocalDateTime retentionDate = DateTimeUtil.now().minusDays(retentionDays);

        long deleted = activityRepository.deleteByActivityTimeBefore(retentionDate);

        log.info("Deleted {} old activity records.", deleted);
    }
}