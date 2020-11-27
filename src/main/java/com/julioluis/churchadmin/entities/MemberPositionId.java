package com.julioluis.churchadmin.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MemberPositionId implements Serializable {

    @Column(name = "member_id")
    @Basic(optional = false)
    private Long memberId;
    @Basic(optional = false)
    @Column(name = "position_id")
    private Long positionId;


    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberPositionId that = (MemberPositionId) o;
        return memberId.equals(that.memberId) &&
                positionId.equals(that.positionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, positionId);
    }

    @Override
    public String toString() {
        return "MemberPositionId{" +
                "memberId=" + memberId +
                ", positionId=" + positionId +
                '}';
    }
}
