package com.cap.ts.adminservice.adminservice.repository;

import com.cap.ts.adminservice.adminservice.entity.AuthorizationInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorizationRepository  extends JpaRepository<AuthorizationInfo,String> {

    @Query(value = "SELECT ai.password FROM AuthorizationInfo ai WHERE ai.userId = :userId", nativeQuery = true)
    Optional<String> findPasswordByUserId(String userId);


}
