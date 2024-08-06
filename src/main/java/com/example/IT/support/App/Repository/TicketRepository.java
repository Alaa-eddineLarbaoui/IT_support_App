package com.example.IT.support.App.Repository;

import com.example.IT.support.App.Model.TicketOfSupport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TicketOfSupport , Long> {
}
