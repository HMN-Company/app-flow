package org.example.flow.services.impl;

import org.example.flow.models.Media;
import org.example.flow.services.MediaService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class MediaServiceImpl implements MediaService {
    @Override
    public void save(Media entity) {

    }

    @Override
    public void update(Media entity) {

    }

    @Override
    public void delete(Media entity) {

    }

    @Override
    public Media get(String id) {
        return null;
    }

    @Override
    public Collection<Media> getAll() {
        return List.of();
    }
}
