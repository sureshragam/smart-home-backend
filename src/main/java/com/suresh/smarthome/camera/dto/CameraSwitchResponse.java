package com.suresh.smarthome.camera.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CameraSwitchResponse {

    private boolean success;
    private String camera;
}