CREATE TABLE IF NOT EXISTS open_weather (
    id binary(16) DEFAULT (uuid_to_bin(uuid())) PRIMARY KEY,
    response_code INT,
    city VARCHAR(3000),
    time_stamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    response_data json
);