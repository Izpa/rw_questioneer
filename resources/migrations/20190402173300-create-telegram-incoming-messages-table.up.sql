CREATE TABLE IF NOT EXISTS telegram_incoming_messages
(id INTEGER SERIAL PRIMARY KEY,
telegram_id INTEGER,
message_text TEXT,
chat_id INTEGER REFERENCES telegram_chats(id),
user_id INTEGER REFERENCES telegram_users(id),
message_timestamp TIMESTAMP);
