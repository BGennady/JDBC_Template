   SELECT joins_homework.ORDERS.product_name
   FROM joins_homework.CUSTOMERS
   JOIN joins_homework.ORDERS ON joins_homework.CUSTOMERS.id = joins_homework.ORDERS.customer_id
   WHERE LOWER(joins_homework.CUSTOMERS.name) = :name;