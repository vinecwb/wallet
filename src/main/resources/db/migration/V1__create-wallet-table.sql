CREATE TABLE wallet(
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    amount INTEGER NOT NULL,
    userId UUID NOT NULL,
    status BOOLEAN NOT NULL,
    createdAt TIMESTAMP DEFAULT NOW() NOT NULL,
    updatedAt TIMESTAMP DEFAULT NOW()
);