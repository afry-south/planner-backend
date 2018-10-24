package com.afconsult.planner.repository;

import javax.persistence.*;
import java.util.Date;

/**
 * @AbsenceInfo Entity data class.
 */

@Entity
@Table(name="abscense_info")
public class AbsenceInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="userId")
    private Integer userId;
    @Column(name="approvedById")
    private Integer approvedById;
    @Enumerated(value = EnumType.STRING)
    private Reason reason;
    @Column(name="startDate")
    private Date startDate;
    @Column(name="endDate")
    private Date endDate;
    @Column(name="created")
    private Date created;
    @Column(name="modified")
    private Date modified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getApprovedById() {
        return approvedById;
    }

    public void setApprovedById(Integer approvedById) {
        this.approvedById = approvedById;
    }

    public Reason getReason() {
        return reason;
    }

    public void setReason(Reason reason) {
        this.reason = reason;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public enum Reason {
        VACCATION,
        SICK,
        TRAVELING,
        INVALIDREASON,
    }

    public static AbsenceInfo createInfo(AbsenceInfo absenceInfo){
        AbsenceInfo info = new AbsenceInfo();
        info.setUserId(absenceInfo.userId);
        info.setApprovedById(absenceInfo.approvedById);
        info.setId(absenceInfo.id);
        info.setCreated(absenceInfo.created);
        info.setModified(absenceInfo.modified);
        info.setEndDate(absenceInfo.endDate);
        info.setReason(absenceInfo.reason);
        info.setStartDate(absenceInfo.startDate);
        return info;
    }

    public AbsenceInfo(){
    }
}
