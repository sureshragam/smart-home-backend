package com.suresh.smarthome.camera.client;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import com.suresh.smarthome.camera.dto.CameraCaptureResponse;

@Component
public class TabletCameraClient {

    private final RestClient restClient = RestClient.create();

    private static final int PORT = 8081;

    public String switchCamera(String ipAddress) {

        return restClient.post()
                .uri("http://" + ipAddress + ":" + PORT + "/camera/switch")
                .retrieve()
                .body(String.class);
    }

    public CameraCaptureResponse capture(String ipAddress) {

        return restClient.post()
                .uri("http://" + ipAddress + ":" + PORT + "/camera/capture")
                .retrieve()
                .body(CameraCaptureResponse.class);
    }

    public ByteArrayResource getSnapshot(String ipAddress) {

        byte[] bytes = restClient.get()
                .uri("http://" + ipAddress + ":" + PORT + "/snapshot")
                .accept(MediaType.IMAGE_JPEG)
                .retrieve()
                .body(byte[].class);

        return new ByteArrayResource(bytes);
    }
}