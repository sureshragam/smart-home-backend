package com.suresh.smarthome.common.util;

import java.lang.management.ManagementFactory;
import java.time.Duration;

public final class UptimeUtil {

    private UptimeUtil() {
    }

    public static String getApplicationUptime() {

        long uptimeMillis = ManagementFactory.getRuntimeMXBean().getUptime();

        Duration duration = Duration.ofMillis(uptimeMillis);

        long days = duration.toDays();
        long hours = duration.toHoursPart();
        long minutes = duration.toMinutesPart();

        if (days > 0) {
            return String.format("%dd %dh %dm", days, hours, minutes);
        }

        return String.format("%dh %dm", hours, minutes);
    }
}