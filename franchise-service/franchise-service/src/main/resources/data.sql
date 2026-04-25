use franchise;
INSERT INTO franchises (name, description, enabled, created_at)
VALUES
('Franchise A', 'Fast food chain', 1, NOW()),
('Franchise B', 'Coffee shops', 1, NOW()),
('Franchise C', 'Tech stores', 1, NOW()),
('Franchise D', 'Clothing brand', 1, NOW()),
('Franchise E', 'Supermarkets', 1, NOW());

INSERT INTO branch (name, address, id_franchise, enabled, created_at)
VALUES
('Branch A1', 'Street 1', 1, 1, NOW()),
('Branch A2', 'Street 2', 1, 1, NOW()),
('Branch B1', 'Street 3', 2, 1, NOW()),
('Branch B2', 'Street 4', 2, 1, NOW()),
('Branch C1', 'Street 5', 3, 1, NOW()),
('Branch C2', 'Street 6', 3, 1, NOW()),
('Branch D1', 'Street 7', 4, 1, NOW()),
('Branch D2', 'Street 8', 4, 1, NOW()),
('Branch E1', 'Street 9', 5, 1, NOW()),
('Branch E2', 'Street 10', 5, 1, NOW());

INSERT INTO products (name, description, price, stock, id_branch, enabled, created_at) VALUES
-- Branch 1
('Burger', 'Food', 10.00, 50, 1, 1, NOW()),
('Fries', 'Food', 5.00, 30, 1, 1, NOW()),
('Soda', 'Drink', 3.00, 80, 1, 1, NOW()),
('Combo', 'Meal', 15.00, 20, 1, 1, NOW()),
('Ice Cream', 'Dessert', 4.00, 60, 1, 1, NOW()),

-- Branch 2
('Burger2', 'Food', 11.00, 25, 2, 1, NOW()),
('Fries2', 'Food', 6.00, 70, 2, 1, NOW()),
('Soda2', 'Drink', 3.50, 40, 2, 1, NOW()),
('Combo2', 'Meal', 16.00, 90, 2, 1, NOW()),
('Ice Cream2', 'Dessert', 4.50, 10, 2, 1, NOW()),

-- Branch 3
('Coffee', 'Drink', 8.00, 100, 3, 1, NOW()),
('Latte', 'Drink', 9.00, 60, 3, 1, NOW()),
('Tea', 'Drink', 7.00, 30, 3, 1, NOW()),
('Cake', 'Dessert', 12.00, 20, 3, 1, NOW()),
('Sandwich', 'Food', 10.00, 80, 3, 1, NOW()),

-- Branch 4
('Coffee2', 'Drink', 8.50, 55, 4, 1, NOW()),
('Latte2', 'Drink', 9.50, 95, 4, 1, NOW()),
('Tea2', 'Drink', 7.50, 15, 4, 1, NOW()),
('Cake2', 'Dessert', 12.50, 65, 4, 1, NOW()),
('Sandwich2', 'Food', 10.50, 45, 4, 1, NOW()),

-- Branch 5
('Laptop', 'Tech', 800.00, 5, 5, 1, NOW()),
('Mouse', 'Tech', 20.00, 200, 5, 1, NOW()),
('Keyboard', 'Tech', 50.00, 150, 5, 1, NOW()),
('Monitor', 'Tech', 300.00, 75, 5, 1, NOW()),
('USB', 'Tech', 10.00, 300, 5, 1, NOW()),

-- Branch 6
('Laptop2', 'Tech', 850.00, 12, 6, 1, NOW()),
('Mouse2', 'Tech', 22.00, 220, 6, 1, NOW()),
('Keyboard2', 'Tech', 55.00, 180, 6, 1, NOW()),
('Monitor2', 'Tech', 320.00, 60, 6, 1, NOW()),
('USB2', 'Tech', 12.00, 310, 6, 1, NOW()),

-- Branch 7
('Shirt', 'Clothing', 25.00, 100, 7, 1, NOW()),
('Pants', 'Clothing', 40.00, 70, 7, 1, NOW()),
('Jacket', 'Clothing', 80.00, 30, 7, 1, NOW()),
('Shoes', 'Clothing', 60.00, 90, 7, 1, NOW()),
('Hat', 'Clothing', 15.00, 110, 7, 1, NOW()),

-- Branch 8
('Shirt2', 'Clothing', 28.00, 120, 8, 1, NOW()),
('Pants2', 'Clothing', 42.00, 65, 8, 1, NOW()),
('Jacket2', 'Clothing', 85.00, 40, 8, 1, NOW()),
('Shoes2', 'Clothing', 65.00, 95, 8, 1, NOW()),
('Hat2', 'Clothing', 18.00, 130, 8, 1, NOW()),

-- Branch 9
('Milk', 'Food', 2.00, 200, 9, 1, NOW()),
('Bread', 'Food', 1.50, 180, 9, 1, NOW()),
('Eggs', 'Food', 3.00, 160, 9, 1, NOW()),
('Cheese', 'Food', 5.00, 140, 9, 1, NOW()),
('Butter', 'Food', 4.00, 120, 9, 1, NOW()),

-- Branch 10
('Milk2', 'Food', 2.20, 210, 10, 1, NOW()),
('Bread2', 'Food', 1.70, 190, 10, 1, NOW()),
('Eggs2', 'Food', 3.20, 170, 10, 1, NOW()),
('Cheese2', 'Food', 5.20, 150, 10, 1, NOW()),
('Butter2', 'Food', 4.20, 130, 10, 1, NOW());

