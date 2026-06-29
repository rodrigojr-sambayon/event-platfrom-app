package com.rodev.tickets.mappers;

import com.rodev.tickets.domain.dtos.ListTicketResponseDto;
import com.rodev.tickets.domain.dtos.ListTicketTicketTypeResponseDto;
import com.rodev.tickets.domain.entities.Ticket;
import com.rodev.tickets.domain.entities.TicketType;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TicketMapper {

    ListTicketTicketTypeResponseDto toListTicketTicketTypeResponseDto(TicketType ticketType);

    ListTicketResponseDto toListTicketResponseDto(Ticket ticket);
}
