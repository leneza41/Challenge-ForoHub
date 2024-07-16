CREATE TABLE topics (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    message TEXT NOT NULL,
    created_date DATETIME NOT NULL,
    status ENUM('OPEN', 'CLOSED', 'DELETED') NOT NULL,
    author_id BIGINT NOT NULL,
    course_id BIGINT NOT NULL,
    FOREIGN KEY (author_id) REFERENCES users(id),
    FOREIGN KEY (course_id) REFERENCES courses(id)
);