CREATE TABLE UALAdmin(
   admin_id INT NOT NULL,
   login_date DATE NOT NULL,
   login_time TIME NOT NULL,
   logout_date DATE,
   logout_time TIME
);
INSERT INTO UALAdmin(admin_id, login_date, login_time, logout_date, logout_time)
VALUES
(1, '2021-04-16', '16:08:00', '2021-06-16', '17:08:00'),
(1, '2021-04-16', '16:08:00', null, null);

INSERT INTO UALAdmin(admin_id, login_date, login_time)
VALUES
(1, '2021-04-16', '16:08:00');
