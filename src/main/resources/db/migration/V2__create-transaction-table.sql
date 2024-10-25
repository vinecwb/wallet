CREATE TABLE transactions (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    amount INTEGER NOT NULL,
    action VARCHAR(255) NOT NULL,
    source JSONB NOT NULL,
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    wallet_id UUID,
    FOREIGN KEY (wallet_id) REFERENCES wallet(id) ON DELETE CASCADE
);
