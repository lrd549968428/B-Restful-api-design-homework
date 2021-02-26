package com.thoughtworks.capability.gtb.restfulapidesign.service.impl;

import com.thoughtworks.capability.gtb.restfulapidesign.entity.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.entity.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.GroupNotFoundException;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.GroupRepository;
import com.thoughtworks.capability.gtb.restfulapidesign.service.IGroupService;
import com.thoughtworks.capability.gtb.restfulapidesign.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @ description:
 * @ Author: Ezio Liu
 * @ Date: 2021/2/26 2:41 下午
 */
@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements IGroupService {

    private static final int COUNT_OF_GROUP = 6;

    private final IStudentService studentService;

    private final GroupRepository groupRepository;

    @Override
    public void addGroup(Group group) {
        groupRepository.save(group);
    }

    @Override
    public List<Group> getAll() {
        return groupRepository.findAll();
    }

    @Override
    public Group findById(long id) {
        return groupRepository.findById(id).orElseThrow(GroupNotFoundException::new);
    }

    @Override
    public Group updateName(long id, String name) {
        Group group = findById(id);
        group.setName(name);
        return groupRepository.save(group);
    }

    @Override
    public void groupStudent() {
        List<Student> allStudent = studentService.findAllStudent(null);
        Collections.shuffle(allStudent);
        createGroup();
        saveStudent(allStudent);
    }

    private void saveStudent(List<Student> students) {
        int i = 1;
        while (students.size() > 0) {
            String studentMessage = students.remove(0).toString();
            Group group = findById(i);
            String note = group.getNote();
            group.setNote(note + studentMessage + ";");
            groupRepository.save(group);
            i++;

            if (i > COUNT_OF_GROUP) {
                i = 1;
            }
        }
    }

    private void createGroup() {
        for (int i = 0; i < COUNT_OF_GROUP; i++) {
            addGroup(Group.builder()
                    .id(i + 1)
                    .name("NO." + (i + 1))
                    .note("content:")
                    .build());
        }
    }
}
