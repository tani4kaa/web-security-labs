package edu.mamontova.task10jwtaudit.repository;/*
  @author tanus
  @project task10-JWT-Audit
  @class AuditNoteRepository
  @version 1.0.0
  @since 28.11.2025 - 21.56
*/


import edu.mamontova.task10jwtaudit.model.AuditNote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditNoteRepository extends JpaRepository<AuditNote, Long> {
}