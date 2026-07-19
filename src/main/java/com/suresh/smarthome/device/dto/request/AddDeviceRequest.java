package com.suresh.smarthome.device.dto.request;

import com.suresh.smarthome.device.enums.DeviceLocation;
import com.suresh.smarthome.device.enums.DeviceType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor 
public class AddDeviceRequest {
	
	@NotBlank(message="Device name is required")
	@Size(min = 3, max = 50,
    message = "Device name must be between 3 and 50 characters")

	private String name;
	
	@NotNull(message="Device type is required")
	private DeviceType type;
	
	@NotNull(message="Device location is required")
	private DeviceLocation location;
	
}
