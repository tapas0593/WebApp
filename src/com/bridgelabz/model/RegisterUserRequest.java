package com.bridgelabz.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class RegisterUserRequest {
	private String name;
	private String email;
	private String password;

}
