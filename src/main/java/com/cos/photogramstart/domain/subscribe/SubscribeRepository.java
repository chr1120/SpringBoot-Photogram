package com.cos.photogramstart.domain.subscribe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface SubscribeRepository extends JpaRepository<Subscribe, Integer>{
	
	@Modifying // INSERT, DELETE, UPDATE를 네이티브 쿼리로 작성하려면 해당 어노테이션이 필요
	@Query(value="INSERT INTO subscribe(fromUserId, toUserId, createDate) VALUES(:fromUserId, :toUserId, now())", nativeQuery=true)
	void mSubscribe(int fromUserId, int toUserId); 
	
	@Modifying // INSERT, DELETE, UPDATE를 네이티브 쿼리로 작성하려면 해당 어노테이션이 필요
	@Query(value="DELETE FROM subscribe WHERE fromUserId = :fromUserId AND toUserId = :toUserId", nativeQuery=true)
	void mUnSubscribe(int fromUserId, int toUserId); 
	
	// 구독 여부 (ssar(1)로 로그인, chr(2) 페이지로 감)
	@Query(value="SELECT COUNT(*) FROM subscribe WHERE fromUserId=:principalId AND toUserId=:pageUserId", nativeQuery=true)
	int mSubscribeState(int principalId, int pageUserId);
	
	// 구독수 확인
	@Query(value="SELECT COUNT(*) FROM subscribe WHERE fromUserId=:pageUserId", nativeQuery=true)
	int mSubscribeCount(int pageUserId);
}
