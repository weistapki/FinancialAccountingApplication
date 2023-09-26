package com.example.financialaccountingapplication.controller;

import com.example.financialaccountingapplication.model.entity.Status;
import com.example.financialaccountingapplication.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/statuses")
public class StatusController {

    private final StatusService statusService;

    @Autowired
    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping("/")
    public List<Status> getAllStatuses() {
        return statusService.getAllStatuses();
    }

    @GetMapping("/{id}")
    public Status getStatusById(@PathVariable Long id) {
        return statusService.getStatusById(id).orElse(null);
    }

    @PostMapping("/")
    public Status createStatus(@RequestBody Status status) {
        return statusService.saveStatus(status);
    }

    @PutMapping("/{id}")
    public Status updateStatus(@PathVariable Long id, @RequestBody Status status) {
        if (statusService.getStatusById(id).isPresent()) {
            status.setId(id);
            return statusService.saveStatus(status);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteStatus(@PathVariable Long id) {
        statusService.deleteStatus(id);
    }
}

