INSERT INTO joins_homework.CUSTOMERS (name, surname, age, phone_number)
VALUES
('Ivan', 'Ivanov', 30, '1234567890'),
('John', 'Smith', 25, '9876543210'),
('Maria', 'Lopez', 35, '5558887777'),
('Sophia', 'Brown', 28, '4445556666');

INSERT INTO joins_homework.ORDERS (date, customer_id, product_name, amount)
VALUES
   ('2025-01-15', 1, 'Laptop', 1),
   ('2025-01-16', 2, 'Smartphone', 2),
   ('2025-01-17', 3, 'Tablet', 3),
   ('2025-01-18', 4, 'Monitor', 1);