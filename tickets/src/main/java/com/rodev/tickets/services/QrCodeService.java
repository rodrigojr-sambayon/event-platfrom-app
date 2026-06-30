package com.rodev.tickets.services;

import com.rodev.tickets.domain.entities.QrCode;
import com.rodev.tickets.domain.entities.Ticket;

import java.util.UUID;

public interface QrCodeService {

    QrCode generateQrCode(Ticket ticket);
    byte[] getQrCodeImageForUserAndTicket(UUID userId, UUID ticketId);
}
