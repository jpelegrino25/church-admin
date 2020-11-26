package com.julioluis.churchadmin.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "money_raise")
public class MoneyRaise implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "money_raise_type")
    @ManyToOne
    private MoneyRaiseType moneyRaiseType;
    private BigDecimal amount;
    @Column(name = "collected_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date collectedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MoneyRaiseType getMoneyRaiseType() {
        return moneyRaiseType;
    }

    public void setMoneyRaiseType(MoneyRaiseType moneyRaiseType) {
        this.moneyRaiseType = moneyRaiseType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getCollectedDate() {
        return collectedDate;
    }

    public void setCollectedDate(Date collectedDate) {
        this.collectedDate = collectedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoneyRaise that = (MoneyRaise) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "MoneyRaise{" +
                "id=" + id +
                ", moneyRaiseType=" + moneyRaiseType +
                ", amount=" + amount +
                ", collectedDate=" + collectedDate +
                '}';
    }
}
