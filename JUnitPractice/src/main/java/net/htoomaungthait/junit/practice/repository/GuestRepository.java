package net.htoomaungthait.junit.practice.repository;

import net.htoomaungthait.junit.practice.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
}
