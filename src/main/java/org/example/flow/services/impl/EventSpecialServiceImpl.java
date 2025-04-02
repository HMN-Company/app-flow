package org.example.flow.services.impl;

import org.example.flow.models.EventSpecial;
import org.example.flow.repositories.EventSpecialRepository;
import org.example.flow.services.EventSpecialService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;


@Service
public class EventSpecialServiceImpl implements EventSpecialService {
    private final EventSpecialRepository eventSpecialRepository;
    public EventSpecialServiceImpl(EventSpecialRepository eventSpecialRepository) {
        this.eventSpecialRepository = eventSpecialRepository;
    }
    @Override
    public void save(EventSpecial entity) {

    }

    @Override
    public void update(EventSpecial entity) {
        eventSpecialRepository.save(entity);
    }

    @Override
    public void delete(EventSpecial entity) {

    }

    @Override
    public EventSpecial get(String id) {
        return eventSpecialRepository.getReferenceById(id);
    }

    @Override
    public Collection<EventSpecial> getAll() {
        return List.of();
    }
}
