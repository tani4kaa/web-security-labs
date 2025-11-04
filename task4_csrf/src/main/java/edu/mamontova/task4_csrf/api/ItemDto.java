package edu.mamontova.task4_csrf.api;/*
  @author tanus
  @project task4_CSRF
  @class ItemDto
  @version 1.0.0
  @since 04.11.2025 - 20.20
*/


public class ItemDto {
    private String name;

    public ItemDto() {}
    public ItemDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
