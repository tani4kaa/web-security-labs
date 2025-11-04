package edu.mamontova.task5_multi_user.api;/*
  @author tanus
  @project task5_multi_user
  @class AccessController
  @version 1.0.0
  @since 04.11.2025 - 23.51
*/



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AccessController {

    @GetMapping("/public")
    public String pub() { return "public OK"; }

    @GetMapping("/common")
    public String common() { return "common for any authenticated role"; }

    @GetMapping("/user/profile")
    public String userProfile() { return "user profile OK"; }

    @GetMapping("/user/orders")
    public String userOrders() { return "user orders OK"; }

    @GetMapping("/manager/dashboard")
    public String managerDashboard() { return "manager dashboard OK"; }

    @GetMapping("/manager/reports")
    public String managerReports() { return "manager reports OK"; }

    @GetMapping("/manager-or-admin/config")
    public String managerOrAdminConfig() { return "manager-or-admin config OK"; }

    @GetMapping("/admin/panel")
    public String adminPanel() { return "admin panel OK"; }

    @GetMapping("/admin/metrics")
    public String adminMetrics() { return "admin metrics OK"; }

    @PostMapping("/admin/reload")
    public ResponseEntity<String> adminReload() { return ResponseEntity.ok("admin reload OK"); }
}
