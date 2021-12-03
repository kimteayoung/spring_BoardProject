create database spring_kty3;
create user spring_kty3@localhost identified by '1234';
grant all privileges on spring_kty3.* to spring_kty3@localhost;
select user();
drop user spring_kty3@localhost;