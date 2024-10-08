package com.example.IT.support.App.Repository;

import com.example.IT.support.App.Model.TicketOfSupport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<TicketOfSupport , Long> {
    List<TicketOfSupport> findTicketOfSupportByTechnicienIT_Id(Long technicienId);

    List<TicketOfSupport> findTicketOfSupportByUser_Id(Long userId);

}
