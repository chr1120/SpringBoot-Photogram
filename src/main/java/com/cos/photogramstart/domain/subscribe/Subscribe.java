package com.cos.photogramstart.domain.subscribe;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cos.photogramstart.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//JPA - Java Persistence API (자바로 데이터를 영구적으로 저장(DB)할 수 있는 API를 제공)

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity // DB에 테이블을 생성
@Table (
		uniqueConstraints= {
				@UniqueConstraint(
						name="subscribe_uk",
						columnNames= {"fromUserId", "toUserId"}
				)
		}
)
public class Subscribe {
	@Id // Primary Key // entity에 대한 식별자
	@GeneratedValue(strategy=GenerationType.IDENTITY) // 번호 증가 전략이 데이터베이스를 따라간다.
	private int id;
	
	// 구독 하는 user
	@JoinColumn(name="fromUserId")
	@ManyToOne
	private User fromUser;
	
	// 구독 받는 user
	@JoinColumn(name="toUserId")
	@ManyToOne
	private User toUser;
	
	private LocalDateTime createDate;
	
	@PrePersist // DB에 INSERT 되기 직전에 실행
	public void createDate() {
		this.createDate=LocalDateTime.now();
	}
}
