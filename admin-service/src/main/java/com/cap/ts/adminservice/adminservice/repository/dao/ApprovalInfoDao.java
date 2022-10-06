package com.cap.ts.adminservice.adminservice.repository.dao;


import com.cap.ts.adminservice.adminservice.entity.ApprovalInfo;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Component
@Slf4j
public class ApprovalInfoDao{

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public  int updateLeaveStatus(ApprovalInfo approvalInfo){

        try {
            final int i = entityManager.createNativeQuery("INSERT INTO ApprovalInfo (approvalId, userId, idTobeApproved, approvalStatus, comments, approvedTimeStamp) " +
                            "VALUES (:approvalId, :userId, :idTobeApproved, :approvalStatus, :comments, :approvedTimeStamp)")
                    .setParameter("approvalId", approvalInfo.getApprovalId())
                    .setParameter("userId", approvalInfo.getUserId())
                    .setParameter("idTobeApproved", approvalInfo.getIdTobeApproved())
                    .setParameter("comments", approvalInfo.getComments())
                    .setParameter("approvalStatus", approvalInfo.getApprovalStatus())
                    .setParameter("approvedTimeStamp", LocalDateTime.now()).executeUpdate();

            if(i!=0){
                log.info("Number of rows updated {}", i);
                return i;
            }

        }catch (HibernateException e){
            log.info("Error while updating leave status {} ", e.getMessage(),e);

        }
        return 0;

    }
}
