CREATE TABLE IF NOT EXISTS telegram_users
(id INTEGER PRIMARY KEY AUTO_INCREMENT,
telegram_id INTEGER,
first_name VARCHAR(100),
last_name VARCHAR(100),
username VARCHAR(100),
is_bot BOOLEAN,
language_code VARCHAR(2));
