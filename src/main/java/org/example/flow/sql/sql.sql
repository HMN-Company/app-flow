use `app-flow`;
INSERT INTO product (id, created_at, updated_at, description, discount, name, price) VALUES
                                                                                         (1, '2024-03-01 10:00:00', '2024-03-05 12:00:00', 'Sản phẩm 1 mô tả', 10.5, 'Sản phẩm 1', 100000),
                                                                                         (2, '2024-03-02 11:00:00', '2024-03-06 14:00:00', 'Sản phẩm 2 mô tả', 5.0, 'Sản phẩm 2', 150000),
                                                                                         (3, '2024-03-03 09:30:00', '2024-03-07 16:00:00', 'Sản phẩm 3 mô tả', 8.0, 'Sản phẩm 3', 200000),
                                                                                         (4, '2024-03-04 15:45:00', '2024-03-08 18:30:00', 'Sản phẩm 4 mô tả', 12.0, 'Sản phẩm 4', 250000),
                                                                                         (5, '2024-03-05 08:20:00', '2024-03-09 20:15:00', 'Sản phẩm 5 mô tả', 15.0, 'Sản phẩm 5', 300000),
                                                                                         (6, '2024-03-06 12:10:00', '2024-03-10 21:45:00', 'Sản phẩm 6 mô tả', 20.0, 'Sản phẩm 6', 350000),
                                                                                         (7, '2024-03-07 14:50:00', '2024-03-11 22:10:00', 'Sản phẩm 7 mô tả', 7.5, 'Sản phẩm 7', 400000),
                                                                                         (8, '2024-03-08 16:30:00', '2024-03-12 23:00:00', 'Sản phẩm 8 mô tả', 9.0, 'Sản phẩm 8', 450000),
                                                                                         (9, '2024-03-09 18:40:00', '2024-03-13 23:50:00', 'Sản phẩm 9 mô tả', 11.0, 'Sản phẩm 9', 500000),
                                                                                         (10, '2024-03-10 19:55:00', '2024-03-14 23:59:00', 'Sản phẩm 10 mô tả', 13.0, 'Sản phẩm 10', 550000);

INSERT INTO orders (id, created_at, updated_at, address, email, full_name, phone, status) VALUES
                                                                                              (1, '2024-03-15 08:30:00', '2024-03-15 08:30:00', '123 Đường ABC, Hà Nội', 'customer1@example.com', 'Nguyễn Văn A', '0987654321', 'PENDING'),
                                                                                              (2, '2024-03-16 10:00:00', '2024-03-16 10:15:00', '456 Đường XYZ, TP HCM', 'customer2@example.com', 'Trần Thị B', '0976543210', 'CONFIRMED'),
                                                                                              (3, '2024-03-17 12:45:00', '2024-03-17 12:50:00', '789 Đường LMN, Đà Nẵng', 'customer3@example.com', 'Lê Văn C', '0965432109', 'CANCELLED'),
                                                                                              (4, '2024-03-18 14:20:00', '2024-03-18 14:25:00', '987 Đường DEF, Hải Phòng', 'customer4@example.com', 'Phạm Thị D', '0954321098', 'CONFIRMED'),
                                                                                              (5, '2024-03-19 16:10:00', '2024-03-19 16:15:00', '654 Đường GHI, Cần Thơ', 'customer5@example.com', 'Hoàng Văn E', '0943210987', 'DELIVERED'),
                                                                                              (6, '2024-03-20 18:35:00', '2024-03-20 18:40:00', '321 Đường JKL, Nha Trang', 'customer6@example.com', 'Đặng Văn F', '0932109876', 'PENDING'),
                                                                                              (7, '2024-03-21 20:45:00', '2024-03-21 20:50:00', '159 Đường MNO, Huế', 'customer7@example.com', 'Lý Thị G', '0921098765', 'CANCELLED'),
                                                                                              (8, '2024-03-22 22:10:00', '2024-03-22 22:15:00', '753 Đường PQR, Đà Lạt', 'customer8@example.com', 'Tô Văn H', '0910987654', 'CONFIRMED'),
                                                                                              (9, '2024-03-23 08:20:00', '2024-03-23 08:25:00', '357 Đường STU, Bình Dương', 'customer9@example.com', 'Trương Thị I', '0909876543', 'CONFIRMED'),
                                                                                              (10, '2024-03-24 10:50:00', '2024-03-24 10:55:00', '951 Đường VWX, Quảng Ninh', 'customer10@example.com', 'Ngô Văn J', '0898765432', 'DELIVERED');

INSERT INTO order_details (id, created_at, updated_at, quantity, order_id, product_id) VALUES
                                                                                           (1, '2024-03-15 08:31:00', '2024-03-15 08:31:00', 2, 1, 3),
                                                                                           (2, '2024-03-16 10:05:00', '2024-03-16 10:10:00', 1, 2, 5),
                                                                                           (3, '2024-03-17 12:46:00', '2024-03-17 12:48:00', 3, 3, 7),
                                                                                           (4, '2024-03-18 14:21:00', '2024-03-18 14:22:00', 5, 4, 2),
                                                                                           (5, '2024-03-19 16:11:00', '2024-03-19 16:12:00', 4, 5, 1),
                                                                                           (6, '2024-03-20 18:36:00', '2024-03-20 18:37:00', 2, 6, 9),
                                                                                           (7, '2024-03-21 20:46:00', '2024-03-21 20:47:00', 6, 7, 4),
                                                                                           (8, '2024-03-22 22:11:00', '2024-03-22 22:12:00', 1, 8, 6),
                                                                                           (9, '2024-03-23 08:21:00', '2024-03-23 08:22:00', 3, 9, 8),
                                                                                           (10, '2024-03-24 10:51:00', '2024-03-24 10:52:00', 2, 10, 10),
                                                                                           (11, '2024-03-24 10:52:00', '2024-03-24 10:53:00', 3, 10, 7),
                                                                                           (12, '2024-03-24 10:53:00', '2024-03-24 10:54:00', 1, 5, 5),
                                                                                           (13, '2024-03-24 10:54:00', '2024-03-24 10:55:00', 4, 8, 2),
                                                                                           (14, '2024-03-24 10:55:00', '2024-03-24 10:56:00', 2, 7, 3),
                                                                                           (15, '2024-03-24 10:56:00', '2024-03-24 10:57:00', 5, 6, 1);


INSERT INTO category (id, created_at, updated_at, name) VALUES
                                                            (1, '2024-03-01 08:00:00', '2024-03-05 12:00:00', 'Điện thoại'),
                                                            (2, '2024-03-02 09:30:00', '2024-03-06 14:30:00', 'Laptop'),
                                                            (3, '2024-03-03 10:45:00', '2024-03-07 16:15:00', 'Phụ kiện'),
                                                            (4, '2024-03-04 11:20:00', '2024-03-08 18:45:00', 'Thời trang'),
                                                            (5, '2024-03-05 12:10:00', '2024-03-09 20:30:00', 'Đồ gia dụng');

INSERT INTO product_category (id, created_at, updated_at, category_id, product_id) VALUES
                                                                                       (1, '2024-03-01 08:00:00', '2024-03-05 12:00:00', 1, 1),
                                                                                       (2, '2024-03-02 09:30:00', '2024-03-06 14:30:00', 1, 2),
                                                                                       (3, '2024-03-03 10:45:00', '2024-03-07 16:15:00', 2, 3),
                                                                                       (4, '2024-03-04 11:20:00', '2024-03-08 18:45:00', 2, 4),
                                                                                       (5, '2024-03-05 12:10:00', '2024-03-09 20:30:00', 3, 5),
                                                                                       (6, '2024-03-06 13:15:00', '2024-03-10 22:00:00', 3, 6),
                                                                                       (7, '2024-03-07 14:20:00', '2024-03-11 23:30:00', 4, 7),
                                                                                       (8, '2024-03-08 15:25:00', '2024-03-12 01:00:00', 4, 8),
                                                                                       (9, '2024-03-09 16:30:00', '2024-03-13 02:15:00', 5, 9),
                                                                                       (10, '2024-03-10 17:35:00', '2024-03-14 03:45:00', 5, 10);
INSERT INTO media (id, created_at, updated_at, url, product_id) VALUES
                                                                    (1, '2024-03-01 08:00:00', '2024-03-05 12:00:00', 'p-1.png', 1),
                                                                    (2, '2024-03-02 09:30:00', '2024-03-06 14:30:00', 'p-2.png', 2),
                                                                    (3, '2024-03-03 10:45:00', '2024-03-07 16:15:00', 'p-3.png', 3),
                                                                    (4, '2024-03-04 11:20:00', '2024-03-08 18:45:00', 'p-4.png', 4),
                                                                    (5, '2024-03-05 12:10:00', '2024-03-09 20:30:00', 'p-5.png', 5),
                                                                    (6, '2024-03-06 13:15:00', '2024-03-10 22:00:00', 'p-6.png', 6),
                                                                    (7, '2024-03-07 14:20:00', '2024-03-11 23:30:00', 'p-7.png', 7),
                                                                    (8, '2024-03-08 15:25:00', '2024-03-12 01:00:00', 'p-8.png', 8),
                                                                    (9, '2024-03-09 16:30:00', '2024-03-13 02:15:00', 'p-9.png', 9),
                                                                    (10, '2024-03-10 17:35:00', '2024-03-14 03:45:00', 'p-10.png', 10);
 INSERT INTO users (id, created_at, updated_at, password, username) VALUES
                                                                        (1,'2024-03-10 17:35:00', '2024-03-14 03:45:00','$2a$12$l.GrAw6iPppQTYb/R60QhuN2lwwIVu6t.x02ZHYJYyrUzGNrNdLxW','admin');



INSERT INTO blog (
    id, created_at, updated_at, author, author_sub_content, background,
    content1, content2, content3, content4, content5,
    image1, image2, sub_content, title, avatar_author
) VALUES
      (1, NOW(), NOW(), 'Nguyễn Văn A', 'Chuyên gia công nghệ', 'bg1.jpg',
       'Nội dung 1 - Phần 1', 'Nội dung 1 - Phần 2', 'Nội dung 1 - Phần 3', 'Nội dung 1 - Phần 4', 'Nội dung 1 - Phần 5',
       'img1_1.jpg', 'img1_2.jpg', 'Tóm tắt bài viết 1', 'Tiêu đề bài viết 1', 'avatar1.jpg'),

      (2, NOW(), NOW(), 'Trần Thị B', 'Blogger du lịch', 'bg2.jpg',
       'Nội dung 2 - Phần 1', 'Nội dung 2 - Phần 2', 'Nội dung 2 - Phần 3', 'Nội dung 2 - Phần 4', 'Nội dung 2 - Phần 5',
       'img2_1.jpg', 'img2_2.jpg', 'Tóm tắt bài viết 2', 'Tiêu đề bài viết 2', 'avatar2.jpg'),

      (3, NOW(), NOW(), 'Lê Hoàng C', 'Nhà báo', 'bg3.jpg',
       'Nội dung 3 - Phần 1', 'Nội dung 3 - Phần 2', 'Nội dung 3 - Phần 3', 'Nội dung 3 - Phần 4', 'Nội dung 3 - Phần 5',
       'img3_1.jpg', 'img3_2.jpg', 'Tóm tắt bài viết 3', 'Tiêu đề bài viết 3', 'avatar3.jpg'),

      (4, NOW(), NOW(), 'Phạm Minh D', 'Chuyên viên Marketing', 'bg4.jpg',
       'Nội dung 4 - Phần 1', 'Nội dung 4 - Phần 2', 'Nội dung 4 - Phần 3', 'Nội dung 4 - Phần 4', 'Nội dung 4 - Phần 5',
       'img4_1.jpg', 'img4_2.jpg', 'Tóm tắt bài viết 4', 'Tiêu đề bài viết 4', 'avatar4.jpg'),

      (5, NOW(), NOW(), 'Hoàng Văn E', 'Chuyên gia tài chính', 'bg5.jpg',
       'Nội dung 5 - Phần 1', 'Nội dung 5 - Phần 2', 'Nội dung 5 - Phần 3', 'Nội dung 5 - Phần 4', 'Nội dung 5 - Phần 5',
       'img5_1.jpg', 'img5_2.jpg', 'Tóm tắt bài viết 5', 'Tiêu đề bài viết 5', 'avatar5.jpg'),

      (6, NOW(), NOW(), 'Mai Thị F', 'Chuyên gia ẩm thực', 'bg6.jpg',
       'Nội dung 6 - Phần 1', 'Nội dung 6 - Phần 2', 'Nội dung 6 - Phần 3', 'Nội dung 6 - Phần 4', 'Nội dung 6 - Phần 5',
       'img6_1.jpg', 'img6_2.jpg', 'Tóm tắt bài viết 6', 'Tiêu đề bài viết 6', 'avatar6.jpg'),

      (7, NOW(), NOW(), 'Đỗ Thành G', 'Nhà sáng lập startup', 'bg7.jpg',
       'Nội dung 7 - Phần 1', 'Nội dung 7 - Phần 2', 'Nội dung 7 - Phần 3', 'Nội dung 7 - Phần 4', 'Nội dung 7 - Phần 5',
       'img7_1.jpg', 'img7_2.jpg', 'Tóm tắt bài viết 7', 'Tiêu đề bài viết 7', 'avatar7.jpg');


INSERT INTO event_special
(id, created_at, updated_at, description, status, time, title, url_event)
VALUES
    ('1', NOW(), NOW(), 'Sự kiện giảm giá 50%', 1, '2025-04-10 10:00:00', 'Flash Sale Tháng 4', 'https://example.com/event');


SELECT
    p.id,
    p.name,
    p.description,
    p.price,
    p.discount,
    COALESCE(m.urls, '') AS imageUrls,
    COALESCE(c.names, '') AS categoryNames,
    p.created_at,
    p.updated_at
FROM Product p
         LEFT JOIN (
    SELECT m.product_id, GROUP_CONCAT(m.url SEPARATOR ', ') AS urls
    FROM Media m
    GROUP BY m.product_id
) m ON p.id = m.product_id
         LEFT JOIN (
    SELECT pc.product_id, GROUP_CONCAT(c.name SEPARATOR ', ') AS names
    FROM product_category pc
             JOIN Category c ON pc.category_id = c.id
    GROUP BY pc.product_id
) c ON p.id = c.product_id;



DELETE FROM product_category WHERE product_id = :productId