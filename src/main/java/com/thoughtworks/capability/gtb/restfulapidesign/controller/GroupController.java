package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.entity.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.service.IGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ description:
 * @ Author: Ezio Liu
 * @ Date: 2021/2/26 2:29 下午
 */
@RestController
@RequestMapping("/groups")
@RequiredArgsConstructor
public class GroupController {

    private final IGroupService groupService;

    @PostMapping("/grouping")
    public void groupStudent() {
        groupService.groupStudent();
    }

    @GetMapping
    public List<Group> getAllGroup() {
        return groupService.getAll();
    }

    @PutMapping("/{id}")
    public Group updateGroupName(@PathVariable("id") long id, @RequestParam String name) {
        return groupService.updateName(id, name);
    }

    @GetMapping("/{id}")
    public Group getGroup(@PathVariable("id") long id) {
        return groupService.findById(id);
    }
}
