package com.rodev.tickets.repositories;

import com.rodev.tickets.domain.entities.QrCode;
import com.rodev.tickets.domain.entities.QrCodeStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface QrCodeRepository extends JpaRepository<QrCode, UUID> {
    Optional<QrCode> findByTicketIdAndTicketPurchaserId(UUID ticketId, UUID ticketPurchaserId);
    Optional<QrCode> findByIdAndStatus(UUID Id, QrCodeStatusEnum qrCodeStatusEnum);
}
