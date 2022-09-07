package com.wallferjdi.wallfer.entity;

import javax.persistence.*;

@Entity
@Table(name = "stat")
public class StatEntity {


    @Id
    @Column
    private Long id;
    @Column(name = "completed_total")
    private Long completedTotal;
    @Column(name = "uncompleted_total")
    private Long uncompletedTotal;

    public StatEntity() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public Long getCompletedTotal() {
        return completedTotal;
    }

    public void setCompletedTotal(Long completedTotal) {
        this.completedTotal = completedTotal;
    }



    public Long getUncompletedTotal() {
        return uncompletedTotal;
    }

    public void setUncompletedTotal(Long uncompletedTotal) {
        this.uncompletedTotal = uncompletedTotal;
    }


}
