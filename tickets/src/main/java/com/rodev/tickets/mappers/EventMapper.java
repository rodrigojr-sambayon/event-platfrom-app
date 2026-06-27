package com.rodev.tickets.mappers;

import com.rodev.tickets.domain.CreateEventRequest;
import com.rodev.tickets.domain.CreateTicketTypeRequest;
import com.rodev.tickets.domain.dtos.CreateEventRequestDto;
import com.rodev.tickets.domain.dtos.CreateEventResponseDto;
import com.rodev.tickets.domain.dtos.CreateTicketTypeRequestDto;
import com.rodev.tickets.domain.entities.Event;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {
    CreateTicketTypeRequest fromDto(CreateTicketTypeRequestDto dto);

    CreateEventRequest fromDto(CreateEventRequestDto dto);

    CreateEventResponseDto toDto(Event event);




}
