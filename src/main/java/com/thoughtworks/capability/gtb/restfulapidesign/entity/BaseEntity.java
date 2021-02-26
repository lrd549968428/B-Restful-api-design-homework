package com.thoughtworks.capability.gtb.restfulapidesign.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

/**
 * @ description:
 * @ Author: Ezio Liu
 * @ Date: 2021/2/24 8:23 下午
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @Column(name = "create_time")
    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private long createTime;

    @Column(name = "last_modified_time")
    @LastModifiedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private long updateTime;

    @Column(name = "create_by")
    @CreatedBy
    private String createBy;

    @Column(name = "last_modified_by")
    @LastModifiedBy
    private String lastModifiedBy;

}
