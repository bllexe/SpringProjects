# Thymeleaf CRUD example

# Prerequisites
Before run this project, make sure postgresql is running.Can use Docker image below 
docker run --name postgres-sql -e POSTGRES_PASSWORD=yourPassword -d -p 5432:5432 postgres:latest
# Connect Postgresql
docker exec -it postgres-sql psql -U postgres
# Create database
CREATE DATABASE dbName;
# Connect database
"\c" dbName
"\dt"
select *from db_name;

