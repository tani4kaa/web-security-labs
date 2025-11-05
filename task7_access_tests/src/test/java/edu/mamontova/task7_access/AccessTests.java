package edu.mamontova.task7_access;/*
  @author tanus
  @project task7_access_tests
  @class AccessTests
  @version 1.0.0
  @since 05.11.2025 - 02.17
*/



import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AccessTests {

    @Autowired
    MockMvc mvc;

    final String u = "alice";
    final String up = "alice123";
    final String m = "bob";
    final String mp = "bob123";
    final String a = "carol";
    final String ap = "carol123";

    @Test
    @DisplayName("1) GET /api/items - public - 200")
    void itemsListPublic_200() throws Exception {
        mvc.perform(get("/api/items"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("2) GET /api/items/1 - anonymous - 401")
    void getItem_anon_401() throws Exception {
        mvc.perform(get("/api/items/1"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @DisplayName("3) GET /api/items/1 - USER - 200")
    void getItem_user_200() throws Exception {
        mvc.perform(get("/api/items/1").with(httpBasic(u, up)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("4) POST /api/items - USER - 403")
    void create_user_403() throws Exception {
        mvc.perform(post("/api/items")
                        .with(httpBasic(u, up))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                     {"id":3,"name":"Third"}
                     """))
                .andExpect(status().isForbidden());
    }

    @Test
    @DisplayName("5) POST /api/items - MANAGER - 200")
    void create_manager_200() throws Exception {
        mvc.perform(post("/api/items")
                        .with(httpBasic(m, mp))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                     {"id":3,"name":"Third"}
                     """))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("6) PUT /api/items/2 - MANAGER - 200")
    void update_manager_200() throws Exception {
        mvc.perform(put("/api/items/2")
                        .with(httpBasic(m, mp))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                     {"id":2,"name":"Updated"}
                     """))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("7) PUT /api/items/2 - USER - 403")
    void update_user_403() throws Exception {
        mvc.perform(put("/api/items/2")
                        .with(httpBasic(u, up))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                     {"id":2,"name":"Updated"}
                     """))
                .andExpect(status().isForbidden());
    }

    @Test
    @DisplayName("8) DELETE /api/items/1 - MANAGER - 403")
    void delete_manager_403() throws Exception {
        mvc.perform(delete("/api/items/1")
                        .with(httpBasic(m, mp)))
                .andExpect(status().isForbidden());
    }

    @Test
    @DisplayName("9) DELETE /api/items/1 - ADMIN - 200")
    void delete_admin_200() throws Exception {
        mvc.perform(delete("/api/items/1")
                        .with(httpBasic(a, ap)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("10) GET /api/items/manager/report - MANAGER - 200")
    void managerReport_manager_200() throws Exception {
        mvc.perform(get("/api/items/manager/report")
                        .with(httpBasic(m, mp)))
                .andExpect(status().isOk());
    }
}
