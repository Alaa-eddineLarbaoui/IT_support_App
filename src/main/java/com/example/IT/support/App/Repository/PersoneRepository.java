package com.example.IT.support.App.Repository;

import com.example.IT.support.App.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersoneRepository extends JpaRepository<Person ,Long> {
}
