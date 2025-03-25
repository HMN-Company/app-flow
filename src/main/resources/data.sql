-- Insert sample data for Product
INSERT INTO product (id, created_at, updated_at, name, price) VALUES
('1', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Laptop', 999.99),
('2', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Smartphone', 599.99),
('3', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Headphones', 149.99),
('4', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Tablet', 399.99),
('5', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Smartwatch', 249.99);

-- Insert sample data for Media
INSERT INTO media (id, created_at, updated_at, url, product_id) VALUES
('1', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'https://example.com/laptop1.jpg', '1'),
('2', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'https://example.com/laptop2.jpg', '1'),
('3', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'https://example.com/smartphone1.jpg', '2'),
('4', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'https://example.com/headphones1.jpg', '3'),
('5', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'https://example.com/tablet1.jpg', '4'),
('6', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'https://example.com/smartwatch1.jpg', '5'),
('7', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'https://example.com/smartwatch2.jpg', '5');