-- Script: DDL initial
-- Description:Create schema and table for pricing data
-- Author: John Macias
-- Creation Date: 2025-06-06

CREATE SCHEMA IF NOT EXISTS pricing;

CREATE TABLE pricing.prices (
        prices_id SERIAL PRIMARY KEY,
        prices_brand_id INTEGER NOT NULL,
        prices_start_date TIMESTAMP NOT NULL,
        prices_end_date TIMESTAMP NOT NULL,
        prices_price_list INTEGER NOT NULL,
        prices_product_id INTEGER NOT NULL,
        prices_priority INTEGER NOT NULL,
        prices_price DECIMAL(10, 2) NOT NULL,
        prices_currency VARCHAR(3) NOT NULL
);

