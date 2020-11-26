package com.julioluis.churchadmin.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "member_position")
public class MemberPosition implements Serializable {

    @EmbeddedId
    private MemberPositionId memberPositionId;
    @Column(name = "elected_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date electedDate;

    public MemberPositionId getMemberPositionId() {
        return memberPositionId;
    }

    public void setMemberPositionId(MemberPositionId memberPositionId) {
        this.memberPositionId = memberPositionId;
    }

    public Date getElectedDate() {
        return electedDate;
    }

    public void setElectedDate(Date electedDate) {
        this.electedDate = electedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberPosition that = (MemberPosition) o;
        return memberPositionId.equals(that.memberPositionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberPositionId);
    }

    @Override
    public String toString() {
        return "MemberPosition{" +
                "memberPositionId=" + memberPositionId +
                ", electedDate=" + electedDate +
                '}';
    }
}
