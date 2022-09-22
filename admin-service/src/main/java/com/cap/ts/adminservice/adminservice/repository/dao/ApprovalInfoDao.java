package com.cap.ts.adminservice.adminservice.repository.dao;


import com.cap.ts.adminservice.adminservice.entity.ApprovalInfo;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Component
@Slf4j
public class ApprovalInfoDao{

    @PersistenceContext
    EntityManager entityManager;
    @Transactional
    public  int updateLeaveStatus(ApprovalInfo approvalInfo){
        final Session session = entityManager.unwrap(Session.class);
        try {
            /*inal Query query = session.getNamedQuery("ApprovalInfo.updateLeaveStatus");
            query.setParameter("approvalId", approvalInfo.getApprovalId());
            query.setParameter("userId", approvalInfo.getUserId());
            query.setParameter("leaveId", approvalInfo.getLeaveId());
            query.setParameter("approvalStatus", approvalInfo.getApprovalStatus());
            query.setParameter("approvedTimeStamp", LocalDateTime.now());*/
            final int i = entityManager.createNativeQuery("INSERT INTO ApprovalInfo (approvalId, userId, leaveId, approvalStatus, approvedTimeStamp) " +
                            "VALUES (:approvalId, :userId, :leaveId, :approvalStatus, :approvedTimeStamp)")
                    .setParameter("approvalId", approvalInfo.getApprovalId())
                    .setParameter("userId", approvalInfo.getUserId())
                    .setParameter("leaveId", approvalInfo.getLeaveId())
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
