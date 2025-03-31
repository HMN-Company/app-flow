package org.example.flow.services.impl;

import org.example.flow.models.Media;
import org.example.flow.repositories.MediaRepository;
import org.example.flow.services.MediaService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MediaServiceImpl implements MediaService {

    private final MediaRepository mediaRepository;

    public MediaServiceImpl(MediaRepository mediaRepository) {
        this.mediaRepository = mediaRepository;
    }

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
        var media = mediaRepository.findById(id).orElse(null);
        if (media == null) {
            throw new RuntimeException();
        }
        return media;
    }

    @Override
    public Collection<Media> getAll() {
        return mediaRepository.findAll();
    }

    @Override
    public Collection<String> getMediaUrlsByProductId(String id) {
        return mediaRepository.findMediaUrlByProductId(id);
    }
}
