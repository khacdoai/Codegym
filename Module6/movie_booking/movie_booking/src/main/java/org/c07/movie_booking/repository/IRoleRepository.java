package org.c07.movie_booking.repository;
import org.c07.movie_booking.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role, Long> {
}
