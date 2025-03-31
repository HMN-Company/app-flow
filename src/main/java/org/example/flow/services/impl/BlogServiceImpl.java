package org.example.flow.services.impl;

import org.example.flow.models.Blog;
import org.example.flow.repositories.BlogRepository;
import org.example.flow.services.BlogService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.UUID;


@Service
public class BlogServiceImpl implements BlogService {
    private final BlogRepository blogRepository;
    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }


    @Override
    public void save(Blog entity) {
        blogRepository.save(entity);

    }

    @Override
    public void update(Blog entity) {
        blogRepository.save(entity);
    }

    @Override
    public void delete(Blog entity) {
        blogRepository.delete(entity);
    }

    @Override
    public Blog get(String id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public Collection<Blog> getAll() {
        return blogRepository.findAll();
    }

    @Override
    public Page<Blog> findByTitleContaining(String title, Pageable pageable) {
        return blogRepository.findByTitleContaining(title, pageable);
    }

    @Override
    public boolean createBlog(Blog blog, MultipartFile background, MultipartFile avatarAuthor, MultipartFile image1, MultipartFile image2) {
        try {
            if (background != null && !background.isEmpty()) {
                blog.setBackground(uploadFile(background));
            }
            if (avatarAuthor != null && !avatarAuthor.isEmpty()) {
                blog.setAvatarAuthor(uploadFile(avatarAuthor));
            }
            if (image1 != null && !image1.isEmpty()) {
                blog.setImage1(uploadFile(image1));
            }
            if (image2 != null && !image2.isEmpty()) {
                blog.setImage2(uploadFile(image2));
            }
            blogRepository.save(blog);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public String uploadFile(MultipartFile file) {
        try {
            // **🔹 Đường dẫn thư mục lưu ảnh**
            String uploadDir = "src/main/resources/static/assets/media/products/";
            File directory = new File(uploadDir);
            if (!directory.exists()) {
                directory.mkdirs(); // Tạo thư mục nếu chưa có
            }

            // **🔹 Lưu ảnh**
            String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
            Path filePath = Paths.get(uploadDir, fileName);
            Files.write(filePath, file.getBytes());

            // **🔹 Trả về đường dẫn để hiển thị ảnh**
            return fileName; // Truy cập ảnh qua http://localhost:8080/uploads/{fileName}
        } catch (IOException e) {
            throw new RuntimeException("Lỗi khi tải lên file: " + e.getMessage());
        }
    }
}
