package com.rodev.tickets.services;

import com.rodev.tickets.domain.entities.QrCode;
import com.rodev.tickets.domain.entities.Ticket;

public interface QrCodeService {

    QrCode generateQrCode(Ticket ticket);

}
