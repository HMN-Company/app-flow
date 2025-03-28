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