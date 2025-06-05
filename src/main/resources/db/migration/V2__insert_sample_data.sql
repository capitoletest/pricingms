
INSERT INTO pricing.prices (
    prices_id, prices_brand_id, prices_start_date, prices_end_date,
    prices_price_list, prices_product_id, prices_priority, prices_price, prices_currency
)
VALUES
    (CAST('a1b2c3d4-e5f6-4a7b-88c9-123456789abc' AS UUID), CAST('1a2b3c4d-5e6f-4a7b-91d2-abcdefabcdef' AS UUID), '2020-06-14 00:00:00', '2020-12-31 23:59:59', 1, CAST('11111111-2222-4333-9444-555566667777' AS UUID), 0, 35.50, 'EUR'),
    (CAST('b2c3d4e5-f6a7-4b88-91c2-9876543210ab' AS UUID), CAST('2b3c4d5e-6f7a-4b91-a2d3-bcdefabcdeff' AS UUID), '2020-06-14 15:00:00', '2020-06-14 18:30:00', 2, CAST('22222222-3333-4444-8555-666677778888' AS UUID), 1, 25.45, 'EUR'),
    (CAST('c3d4e5f6-a7b8-4c99-b1d3-aabbccddeeff' AS UUID), CAST('3c4d5e6f-7a8b-4c91-b2d4-cdefabcdefab' AS UUID), '2020-06-15 00:00:00', '2020-06-15 11:00:00', 3, CAST('33333333-4444-4555-8666-777788889999' AS UUID), 1, 30.50, 'EUR'),
    (CAST('d4e5f6a7-b8c9-4d00-c2d4-ddeeff001122' AS UUID), CAST('4d5e6f7a-8b9c-4d91-c3d5-defdefdefdef' AS UUID), '2020-06-15 16:00:00', '2020-12-31 23:59:59', 4, CAST('44444444-5555-4666-9777-888899990000' AS UUID), 1, 38.95, 'EUR');