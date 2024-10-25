CREATE TABLE wallet(
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    amount INTEGER NOT NULL,
    user_id UUID NOT NULL,
    enabled BOOLEAN NOT NULL,
    created_at TIMESTAMP DEFAULT NOW() NOT NULL,
    updated_at TIMESTAMP DEFAULT NOW()
);