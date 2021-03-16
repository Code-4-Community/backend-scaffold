CREATE TABLE IF NOT EXISTS notes (
    id          SERIAL          PRIMARY KEY,
    created     TIMESTAMP       NOT NULL    DEFAULT CURRENT_TIMESTAMP,
    title       VARCHAR(255)    NOT NULL,
    body        TEXT            NOT NULL,
    user_id     INTEGER         NOT NULL,
    CONSTRAINT notes_user_id_fk FOREIGN KEY (user_id)
        REFERENCES users (id)
);