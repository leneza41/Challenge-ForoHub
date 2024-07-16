CREATE TABLE answers (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    message TEXT NOT NULL,
    topic_id BIGINT NOT NULL,
    created_date DATETIME NOT NULL,
    author_id BIGINT NOT NULL,
    FOREIGN KEY (author_id) REFERENCES users(id),
    FOREIGN KEY (topic_id) REFERENCES topics(id)
);