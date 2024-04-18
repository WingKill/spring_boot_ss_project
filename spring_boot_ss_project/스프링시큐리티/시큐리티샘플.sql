create TABLE users(
    username VARCHAR2(50) primary key,
    password VARCHAR2(100) not null,
    enabled CHAR(1) DEFAULT '1'
)

create TABLE authorities(
    username VARCHAR2(50) not null,
    authority VARCHAR2(50) not null,
    CONSTRAINT fk_authorities_users FOREIGN KEY(username) REFERENCES users(username)
)

insert into users(username, password) values ('admin','admin');
insert into users(username, password) values ('user','user');
insert into users(username, password) values ('member','member');

INSERT into authorities(username,authority) values ('admin','ROLE_ADMIN');
INSERT into authorities(username,authority) values ('admin','ROLE_MANAGER');
INSERT into authorities(username,authority) values ('admin','ROLE_USER');
INSERT into authorities(username,authority) values ('member','ROLE_MANAGER');
INSERT into authorities(username,authority) values ('user','ROLE_USER');

select * from users;
select * from authorities;

commit;
desc users;