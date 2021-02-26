package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.entity.Group;

import java.util.List;

/**
 * @ description:
 * @ Author: Ezio Liu
 * @ Date: 2021/2/26 2:39 下午
 */
public interface IGroupService {
    void addGroup(Group group);

    List<Group> getAll();

    Group findById(long id);

    Group updateName(long id, String name);

    void groupStudent();
}
