-- Users Table
CREATE TABLE IF NOT EXISTS users (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  email VARCHAR(255) UNIQUE NOT NULL,
  password VARCHAR(255) NOT NULL,
  role VARCHAR(32) NOT NULL,
  full_name VARCHAR(255)
);

-- Job Table
CREATE TABLE IF NOT EXISTS job (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(255),
  company VARCHAR(255),
  location VARCHAR(255),
  type VARCHAR(64),
  description CLOB
);

-- Application Table
CREATE TABLE IF NOT EXISTS application (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  user_id BIGINT,
  job_id BIGINT,
  status VARCHAR(64),
  CONSTRAINT fk_app_user FOREIGN KEY (user_id) REFERENCES users(id),
  CONSTRAINT fk_app_job FOREIGN KEY (job_id) REFERENCES job(id)
);
