package com.suresh.smarthome.camera.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CameraCaptureResponse {

    private boolean success;
    private String fileName;
    private String path;
    private long size;
    private String message;
}