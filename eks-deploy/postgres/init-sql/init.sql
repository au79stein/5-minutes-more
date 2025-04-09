CREATE TABLE IF NOT EXISTS users (
  id SERIAL PRIMARY KEY,
  username TEXT NOT NULL,
  email TEXT NOT NULL
);

INSERT INTO users (username, email) VALUES ('admin', 'admin@example.com')
ON CONFLICT DO NOTHING;