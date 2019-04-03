CREATE TABLE IF NOT EXISTS telegram_outgoing_messages
(id SERIAL PRIMARY KEY,
telegram_id INTEGER,
message_text TEXT,
chat_id INTEGER REFERENCES telegram_chats(id),
message_timestamp TIMESTAMP DEFAULT current_timestamp);
