package edu.mamontova.task6_annotations.api;/*
  @author tanus
  @project task6_annotations
  @class ItemRestController
  @version 1.0.0
  @since 05.11.2025 - 00.56
*/


import org.springframework.security.access.prepost.PreAuthorize;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemRestController {


    @GetMapping
    @PermitAll
    public List<ItemDto> getAll() {
        return List.of(new ItemDto(1L, "First"), new ItemDto(2L, "Second"));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER','MANAGER','ADMIN')")
    public ItemDto getOne(@PathVariable Long id) {
        return new ItemDto(id, "Item #" + id);
    }


    @PostMapping
    @PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
    public ItemDto create(@RequestBody ItemDto dto) {
        return dto; // мок
    }


    @PutMapping("/{id}")
    @RolesAllowed({"MANAGER"})
    public ItemDto update(@PathVariable Long id, @RequestBody ItemDto dto) {
        return new ItemDto(id, dto.name() + " (updated)");
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String delete(@PathVariable Long id) {
        return "deleted " + id;
    }

    @PostMapping("/{id}/publish")
    @PreAuthorize("hasAnyRole('MANAGER','ADMIN')")
    public String publish(@PathVariable Long id) {
        return "published " + id;
    }


    @GetMapping("/my")
    @PreAuthorize("hasRole('USER')")
    public List<ItemDto> myItems() {
        return List.of(new ItemDto(101L, "Mine-1"));
    }

    @PatchMapping("/{id}/rename")
    @PreAuthorize("hasAnyRole('MANAGER','ADMIN')")
    public ItemDto rename(@PathVariable Long id, @RequestParam String name) {
        return new ItemDto(id, name + " (renamed)");
    }

    @GetMapping("/stats")
    @PreAuthorize("hasAnyRole('USER','MANAGER','ADMIN')")
    public String stats() {
        return "stats OK";
    }

    @GetMapping("/manager/report")
    @PreAuthorize("hasRole('MANAGER')")
    public String managerReport() {
        return "manager report OK";
    }

    @GetMapping("/admin/report")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminReport() {
        return "admin report OK";
    }

    @GetMapping("/secret")
    @PreAuthorize("hasRole('ADMIN')")
    public String secret() {
        return "Top secret data";
    }

}
