package com.rodev.tickets.services;

import com.rodev.tickets.domain.CreateEventRequest;
import com.rodev.tickets.domain.entities.Event;

import java.util.UUID;

public interface EventService {
    Event createEvent(UUID organizerId, CreateEventRequest event);
}
