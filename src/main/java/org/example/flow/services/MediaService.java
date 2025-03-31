package org.example.flow.services;

import org.example.flow.models.Media;

import java.util.Collection;

public interface MediaService extends BaseService<Media>{
    Collection<String> getMediasByProductId(String id);
}
