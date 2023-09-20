package com.cos.photogramstart.web.dto.subscribe;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SubscribeDto {
	private int id; // "구독하기", "구독취소" 시 api 호출할 때, 현재 로그인한 사용자와 누구를 구독할지에 해당하는 toUserId가 필요하기 때문
	private String username; 
	private String profileImageUrl; // 사진
	private Integer subscribeState; // 구독 여부
	private Integer equalUserState; // 현재 로그인한 사용자라면, "구독하기" 버튼 필요 없음.
}
