package com.example.financialaccountingapplication.controller;

import com.example.financialaccountingapplication.model.dto.StatusDTO;
import com.example.financialaccountingapplication.service.StatusService;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/statuses")
public class StatusController {

    private final StatusService statusService;

    @GetMapping("/")
    public List<StatusDTO> getAllStatuses() {
        return statusService.getAllStatuses();
    }

    @GetMapping("/{id}")
    public StatusDTO getStatusById(@PathVariable Long id) {
        return statusService.getStatusById(id);
    }

    @PostMapping("/")
    public StatusDTO createStatus(@RequestBody StatusDTO statusDTO) {
        return statusService.saveStatus(statusDTO);
    }

    @PutMapping("/{id}")
    public StatusDTO updateStatus(@PathVariable Long id, @RequestBody StatusDTO statusDTO) {
        return statusService.updateStatus(id, statusDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteStatus(@PathVariable Long id) {
        statusService.deleteStatus(id);
    }
}


