package com.afconsult.planner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @AbsenceInfoRepository repository class for AbsenceInfo.
 */
@Repository
public interface AbsenceInfoRepository extends JpaRepository<AbsenceInfo,Integer> {
    AbsenceInfo findAbsenceInfoByUserId(int userId);
    List<AbsenceInfo> findAllBy();
}
