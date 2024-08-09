package com.example.IT.support.App.Repository;

import com.example.IT.support.App.Enum.EtatPanne;
import com.example.IT.support.App.Model.Panne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PanneRepository extends JpaRepository<Panne , Long> {





}
