package edu.mamontova.task4_csrf.api;/*
  @author tanus
  @project task4_CSRF
  @class ItemController
  @version 1.0.0
  @since 04.11.2025 - 20.19
*/


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final Map<Long, String> items = new LinkedHashMap<>();
    private final AtomicLong seq = new AtomicLong(0);

    @GetMapping
    public List<Map<String, Object>> list() {
        List<Map<String, Object>> out = new ArrayList<>();
        items.forEach((id, name) -> {
            Map<String, Object> row = new LinkedHashMap<>();
            row.put("id", id);
            row.put("name", name);
            out.add(row);
        });
        return out;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody ItemDto dto) {
        long id = seq.incrementAndGet();
        items.put(id, dto.getName());
        Map<String, Object> body = Map.of("id", id, "name", dto.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(body);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable long id, @RequestBody ItemDto dto) {
        if (!items.containsKey(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        items.put(id, dto.getName());
        Map<String, Object> body = Map.of("id", id, "name", dto.getName());
        return ResponseEntity.ok(body);
    }
}
