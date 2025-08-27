# Database ER Diagram

## Tables

### 1. `users`
- `id` (PK)
- `email`
- `password`
- `role` (STUDENT, RECRUITER, ADMIN)
- `full_name`

### 2. `job`
- `id` (PK)
- `title`
- `company`
- `location`
- `type` (Internship/Job)
- `description`

### 3. `application`
- `id` (PK)
- `user_id` (FK → users.id)
- `job_id` (FK → job.id)
- `status` (APPLIED, SHORTLISTED, REJECTED)

---

## Relationships
- One **user** can apply to many **jobs** → (`users.id` → `application.user_id`)
- One **job** can have many **applications** → (`job.id` → `application.job_id`)
- Many-to-Many relationship between **users** and **jobs** resolved via **application** table
