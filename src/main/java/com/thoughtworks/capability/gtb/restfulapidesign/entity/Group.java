package com.thoughtworks.capability.gtb.restfulapidesign.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @ description:
 * @ Author: Ezio Liu
 * @ Date: 2021/2/24 8:18 下午
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "`groups`")
@Builder
public class Group extends BaseEntity implements Serializable {
    @Id
    @Column(nullable = false, unique = true, updatable = false)
    private long id;

    @Column(nullable = false, name = "name")
    @NotBlank
    private String name;

    @Column(name = "note")
    @NotBlank
    private String note;

    @Version
    private Long version;
}
