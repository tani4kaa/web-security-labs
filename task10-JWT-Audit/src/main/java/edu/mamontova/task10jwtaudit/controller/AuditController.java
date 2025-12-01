package edu.mamontova.task10jwtaudit.controller;/*
  @author tanus
  @project task10-JWT-Audit
  @class AuditController
  @version 1.0.0
  @since 28.11.2025 - 21.56
*/


import edu.mamontova.task10jwtaudit.model.AuditNote;
import edu.mamontova.task10jwtaudit.repository.AuditNoteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/notes")
public class AuditController {

    private final AuditNoteRepository repository;

    public AuditController(AuditNoteRepository repository) {
        this.repository = repository;
    }

    // Запит 1: POST (Створення)
    @PostMapping
    public ResponseEntity<AuditNote> createNote(@RequestBody AuditNote newNote) {
        AuditNote savedNote = repository.save(newNote);
        return ResponseEntity.ok(savedNote);
    }

    // Запит 2: PUT (Оновлення)
    @PutMapping("/{id}")
    public ResponseEntity<AuditNote> updateNote(@PathVariable Long id, @RequestBody AuditNote noteDetails) {
        Optional<AuditNote> noteOptional = repository.findById(id);

        if (noteOptional.isPresent()) {
            AuditNote existingNote = noteOptional.get();
            // Цей рядок тепер має працювати завдяки явному @Getter/@Setter
            existingNote.setContent(noteDetails.getContent());

            AuditNote updatedNote = repository.save(existingNote);
            return ResponseEntity.ok(updatedNote);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}