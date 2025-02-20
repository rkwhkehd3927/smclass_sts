package com.java.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OauthToken {
	
	private String access_token;
	private String refresh_token;
	private String token_type;
	private int expires_in;
	private String scope;
	private int refresh_token_expires_in;
	
	
}
