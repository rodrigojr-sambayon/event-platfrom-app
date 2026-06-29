package com.rodev.tickets.services;

import com.rodev.tickets.domain.entities.Ticket;

import java.util.UUID;

public interface TicketTypeService {
    Ticket purchasseTicket(UUID userId, UUID ticketTypeId);
}
