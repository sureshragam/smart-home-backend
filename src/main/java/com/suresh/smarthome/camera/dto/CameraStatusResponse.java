package com.suresh.smarthome.camera.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CameraStatusResponse {

    private String status;
    private String camera;
    private boolean streamReady;
    private long frameCount;
}