--changeset v.bukharkin:1

CREATE TABLE users (
    id uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    first_name VARCHAR(255),
    second_name VARCHAR(255),
    birthday TIMESTAMP,
    biography VARCHAR(1000),
    city VARCHAR(255),
    password VARCHAR(255)
);