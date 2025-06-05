CREATE SCHEMA IF NOT EXISTS pricing;

CREATE TABLE pricing.prices (
        prices_id UUID PRIMARY KEY,
        prices_brand_id UUID NOT NULL,
        prices_start_date TIMESTAMP NOT NULL,
        prices_end_date TIMESTAMP NOT NULL,
        prices_price_list INT NOT NULL,
        prices_product_id UUID NOT NULL,
        prices_priority INT NOT NULL,
        prices_price DECIMAL(10, 2) NOT NULL,
        prices_currency VARCHAR(3) NOT NULL
);
