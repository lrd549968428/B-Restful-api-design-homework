package com.thoughtworks.capability.gtb.restfulapidesign.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @ description:
 * @ Author: Ezio Liu
 * @ Date: 2021/2/24 8:17 下午
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student extends BaseEntity implements Serializable {
    @Id
    @Column(nullable = false, unique = true, updatable = false)
    private long id;

    @Column(nullable = false, name = "name")
    @NotBlank
    private String name;

    @Column(nullable = false, name = "gender")
    @NotBlank
    private String gender;

    @Column(name = "note")
    private String note;

    @Version
    private Long version;
}
