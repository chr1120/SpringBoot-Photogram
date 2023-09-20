package com.cos.photogramstart.web.dto.auth;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.cos.photogramstart.domain.user.User;

import lombok.Data;

@Data // Getter, Setter
public class SignupDto {
	
	@Size(min=2, max=20)
	@NotBlank
	private String username;
	@NotBlank
	private String password;
	@NotBlank
	private String email;
	@NotBlank
	private String name;
	
	public User toEntity() {
		return User.builder()
				.username(username) // 이름을 기재 안했으면 DB에 공백이 들어가는 문제 발생. - Validation 체크!!
				.password(password) // 패스워드를 기재 안했으면 DB에 공백이 들어가는 문제 발생. - Validation 체크!!
				.email(email)
				.name(name)
				.build();
	}
}
