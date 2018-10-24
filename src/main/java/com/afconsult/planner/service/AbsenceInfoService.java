package com.afconsult.planner.service;

import com.afconsult.planner.repository.AbsenceInfo;
import com.afconsult.planner.repository.AbsenceInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * @AbsenceInfoService serivce class for AbsenceInfo.
 */
@Service
public class AbsenceInfoService {

    @Autowired
    private AbsenceInfoRepository absenceInfoRepository;

    public Optional<AbsenceInfo> getAbscenseInfoByUser(int userId) {
        return Optional.ofNullable(absenceInfoRepository.findAbsenceInfoByUserId(userId));
    }

    public AbsenceInfo createAbscense(AbsenceInfo absenceInfo,int userId){
        AbsenceInfo info = AbsenceInfo.createInfo(absenceInfo);
        info.setUserId(userId);
        absenceInfoRepository.saveAndFlush(info);
        return info;
    }

    public List<AbsenceInfo> getAllAbscenses(){
        return absenceInfoRepository.findAllBy();
    }
}
