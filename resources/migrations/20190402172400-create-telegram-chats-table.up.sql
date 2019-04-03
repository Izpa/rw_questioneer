CREATE TABLE IF NOT EXISTS telegram_chats
(id INTEGER SERIAL PRIMARY KEY,
telegram_id INTEGER,
first_name VARCHAR(100),
last_name VARCHAR(100),
username VARCHAR(100),
title VARCHAR(100),
chat_type VARCHAR(100),
all_members_are_administrators BOOLEAN);
