delete from user_role;
delete from usr;

insert into usr(id, username, password, active) values
(1, 'r', '$2a$08$FVhgRWtsz4jN1aT/5r0ESu1BQ0ufWzHk6TFDIqOySiCRPvn9dimqW', true),
(2, 'mike', '$2a$08$FVhgRWtsz4jN1aT/5r0ESu1BQ0ufWzHk6TFDIqOySiCRPvn9dimqW', true);

insert into user_role(user_id, roles) values
(1, 'ADMIN'), (1, 'USER'),
(2, 'USER');