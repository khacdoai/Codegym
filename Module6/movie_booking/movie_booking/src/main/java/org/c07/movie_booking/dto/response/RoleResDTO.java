package org.c07.movie_booking.dto.response;
public class RoleResDTO {
    private Long id;
    private String name;

    public RoleResDTO() {
    }

    public RoleResDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
