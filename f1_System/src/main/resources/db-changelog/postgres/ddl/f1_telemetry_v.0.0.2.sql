CREATE TABLE car_telemetry (
    id SERIAL PRIMARY KEY,
    car_id INT REFERENCES cars(id) ON DELETE CASCADE,
    timestamp TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    speed FLOAT,        -- Speed in km/h
    tire_pressure FLOAT, -- Tire pressure in PSI
    fuel_level FLOAT,   -- Fuel level in liters
    engine_temp FLOAT,  -- Engine temperature in Celsius
    battery_voltage FLOAT, -- Battery voltage in volts
    gps_latitude FLOAT,  -- GPS latitude
    gps_longitude FLOAT  -- GPS longitude
);
