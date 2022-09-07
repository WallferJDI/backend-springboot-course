package com.wallferjdi.wallfer.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "task")
public class TaskEntity {

    @Id
    @Column
    private Long id;

    @Column
    private String title;
    @Column
    private Integer completed;
    @Column
    private Timestamp date;
    @Column(name = "priority_id")
    private Long priorityId;
    @Column(name="category_id")
    private Long categoryId;
    @ManyToOne
    @JoinColumn(name = "priority_id",insertable = false,updatable = false)
    private PriorityEntity priorityByPriorityId;

    @ManyToOne
    @JoinColumn(name = "category_id",insertable = false,updatable = false)
    private CategoryEntity categoryByCategoryId;


    public TaskEntity() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Integer getCompleted() {
        return completed;
    }

    public void setCompleted(Integer completed) {
        this.completed = completed;
    }


    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Long getPriorityId() {
        return priorityId;
    }

    public void setPriorityId(Long priorityId) {
        this.priorityId = priorityId;
    }


    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }


    public PriorityEntity getPriorityByPriorityId() {
        return priorityByPriorityId;
    }

    public void setPriorityByPriorityId(PriorityEntity priorityByPriorityId) {
        this.priorityByPriorityId = priorityByPriorityId;
    }

    public CategoryEntity getCategoryByCategoryId() {
        return categoryByCategoryId;
    }

    public void setCategoryByCategoryId(CategoryEntity categoryByCategoryId) {
        this.categoryByCategoryId = categoryByCategoryId;
    }
}
