package com.suresh.smarthome.auth.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter

public class AuthMeResponse {

	private String username;
	private String role;
}
