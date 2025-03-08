    package com.shoroukkhaled.F1_Telemetery.shared.entities;

    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;
    import org.hibernate.annotations.CreationTimestamp;
    import org.hibernate.annotations.UpdateTimestamp;

    import javax.persistence.Column;
    import javax.persistence.MappedSuperclass;
    import javax.persistence.PrePersist;
    import javax.persistence.PreUpdate;
    import java.sql.Timestamp;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @MappedSuperclass

    public abstract class BaseEntity {

        @Column(name = "created_by", updatable = false)
        private Long createdBy;

        @CreationTimestamp
        @Column(name = "created_time", updatable = false)
        private Timestamp creationTime;

        @Column(name = "last_update_by")
        private Long lastUpdatedBy ;

        @UpdateTimestamp
        @Column(name = "last_updated_time")
        private Timestamp lastUpdatedTime;

        @PrePersist
        public void prePersist() {
            lastUpdatedTime = creationTime = new Timestamp(System.currentTimeMillis());
        }

        @PreUpdate
        public void preUpdate() {
            lastUpdatedTime = new Timestamp(System.currentTimeMillis());
        }

    }