drop table if exists t_user;
drop table if exists t_login_log;

--创建用户表
CREATE TABLE t_user (
   user_id   INT AUTO_INCREMENT PRIMARY KEY,
   user_name VARCHAR(30),
   password  VARCHAR(32),
   last_visit datetime,
   last_ip  VARCHAR(23)
);

--创建用户登录日志表
CREATE TABLE t_login_log (
   login_log_id  INT AUTO_INCREMENT PRIMARY KEY,
   user_id   INT,
   ip  VARCHAR(23),
   login_datetime datetime
);

--插入初始化数据
INSERT INTO t_user (user_name,password) 
             VALUES('admin','123456');
COMMIT;