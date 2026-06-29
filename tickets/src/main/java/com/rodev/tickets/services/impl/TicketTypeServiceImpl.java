package com.rodev.tickets.services.impl;

import com.rodev.tickets.domain.entities.Ticket;
import com.rodev.tickets.domain.entities.TicketStatusEnum;
import com.rodev.tickets.domain.entities.TicketType;
import com.rodev.tickets.domain.entities.User;
import com.rodev.tickets.exceptions.TicketSoldOutException;
import com.rodev.tickets.exceptions.TicketTypeNotFoundException;
import com.rodev.tickets.exceptions.UserNotFoundException;
import com.rodev.tickets.repositories.TicketRepository;
import com.rodev.tickets.repositories.TicketTypeRepository;
import com.rodev.tickets.repositories.UserRepository;
import com.rodev.tickets.services.QrCodeService;
import com.rodev.tickets.services.TicketTypeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TicketTypeServiceImpl implements TicketTypeService {

    private final UserRepository userRepository;
    private final TicketTypeRepository ticketTypeRepository;
    private final TicketRepository ticketRepository;
    private final QrCodeService qrCodeService;


    @Override
    @Transactional
    public Ticket purchaseTicket(UUID userId, UUID ticketTypeId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(
                String.format("User with id %s not found", userId)
        ));

        TicketType ticketType = ticketTypeRepository.findByIdWithLock(ticketTypeId)
                .orElseThrow(() -> new TicketTypeNotFoundException(
                    String.format("Ticket type with id %s not found", ticketTypeId)
        ));

        int purchasedTickets = ticketRepository.countByTicketTypeId(ticketType.getId());
        Integer totalAvailable = ticketType.getTotalAvailable();

        if(purchasedTickets + 1 > totalAvailable) {
            throw new TicketSoldOutException();
        }

        Ticket ticket = new Ticket();
        ticket.setStatus(TicketStatusEnum.PURCHASED);
        ticket.setTicketType(ticketType);
        ticket.setPurchaser(user);

        Ticket savedTicket = ticketRepository.save(ticket);
        qrCodeService.generateQrCode(savedTicket);

        return ticketRepository.save(savedTicket);
    }
}
