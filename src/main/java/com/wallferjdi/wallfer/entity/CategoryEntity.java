package com.wallferjdi.wallfer.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "category")
public class CategoryEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column(name = "completed_count")
    private Long completedCount;
    @Column(name = "uncompleted_count")
    private Long uncompletedCount;
    @OneToMany(mappedBy = "categoryByCategoryId")
    private Collection<TaskEntity> tasksById;


    public CategoryEntity() {
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


    public Long getCompletedCount() {
        return completedCount;
    }

    public void setCompletedCount(Long completedCount) {
        this.completedCount = completedCount;
    }



    public Long getUncompletedCount() {
        return uncompletedCount;
    }

    public void setUncompletedCount(Long uncompletedCount) {
        this.uncompletedCount = uncompletedCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryEntity that = (CategoryEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (completedCount != null ? !completedCount.equals(that.completedCount) : that.completedCount != null)
            return false;
        if (uncompletedCount != null ? !uncompletedCount.equals(that.uncompletedCount) : that.uncompletedCount != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (completedCount != null ? completedCount.hashCode() : 0);
        result = 31 * result + (uncompletedCount != null ? uncompletedCount.hashCode() : 0);
        return result;
    }


}
