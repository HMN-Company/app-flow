package org.example.flow.services;

import org.example.flow.dtos.ProductDTO;
import org.example.flow.models.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface BlogService extends BaseService<Blog> {
    Page<Blog> findByTitleContaining(String title, Pageable pageable);
    public boolean createBlog(Blog blog, MultipartFile background, MultipartFile avatarAuthor,MultipartFile image1,MultipartFile image2);

}
