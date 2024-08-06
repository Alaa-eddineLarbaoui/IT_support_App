package com.example.IT.support.App.Repository;

import com.example.IT.support.App.Model.Panne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PanneRepository extends JpaRepository<Panne , Long> {
}
