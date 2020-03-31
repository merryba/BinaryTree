DROP TABLE IF EXISTS users;
 
CREATE TABLE users (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  email VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL
);


 
INSERT INTO users (id, email, password) VALUES
  (1, 'test@gmail.com', '$2a$10$hbxecwitQQ.dDT4JOFzQAulNySFwEpaFLw38jda6Td.Y/cOiRzDFu'),
  (2, 'test@yahoo.com', 'test');
  
  