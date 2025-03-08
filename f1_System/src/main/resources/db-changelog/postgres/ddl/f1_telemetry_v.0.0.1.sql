-- ==========================
-- Table: teams
-- ==========================
CREATE TABLE teams (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    country VARCHAR(100) NOT NULL,
    is_deleted BOOLEAN DEFAULT FALSE,
    created_by BIGINT,
    created_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update_by BIGINT,
    last_updated_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- ==========================
-- Table: drivers
-- ==========================
CREATE TABLE drivers (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    driver_number BIGINT NOT NULL UNIQUE,
    country VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    weight INT,
    height INT,
    image TEXT,
    biography TEXT,
    is_deleted BOOLEAN DEFAULT FALSE,   -- Added this field
    is_retired BOOLEAN DEFAULT FALSE,   -- Added this field
    team_id INT REFERENCES teams(id) ON DELETE SET NULL,
    created_by BIGINT,
    created_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update_by BIGINT,
    last_updated_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- ==========================
-- Table: cars
-- ==========================
CREATE TABLE cars (
    id SERIAL PRIMARY KEY,
    model VARCHAR(255) NOT NULL,
    engine VARCHAR(255) NOT NULL,
    is_deleted BOOLEAN DEFAULT FALSE,   -- Added this field
    team_id INT REFERENCES teams(id) ON DELETE SET NULL,
    driver_id INT UNIQUE REFERENCES drivers(id) ON DELETE SET NULL,
    created_by BIGINT,
    created_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update_by BIGINT,
    last_updated_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
