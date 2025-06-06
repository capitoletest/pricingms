-- Script: Insert example data into the pricing.prices table
-- Description: Inserts base prices for products according to date range, priority, and brand.
-- Author: John Macias
-- Creation Date: 2025-06-06

INSERT INTO pricing.prices (
    prices_brand_id, prices_start_date, prices_end_date,
    prices_price_list, prices_product_id, prices_priority, prices_price, prices_currency
)
VALUES
    (1, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 1, 35455, 0, 35.50, 'EUR'),
    (1, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 2, 35455, 1, 25.45, 'EUR'),
    (1, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 3, 35455, 1, 30.50, 'EUR'),
    (1, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 4, 35455, 1, 38.95, 'EUR');