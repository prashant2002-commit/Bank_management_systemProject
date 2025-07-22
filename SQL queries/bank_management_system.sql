create database bankmanagementsystem;

use bankmanagementsystem;
create table signup(formNo varchar(20), name varchar(20),Father_Name varchar(20),Date_Of_Birth varchar(20),Gender varchar(20),EMail varchar(30),MaritalStatus varchar(20),Address varchar(40),city varchar(20),state varchar(25),pincode varchar(20));
create table signuptwo(formNo varchar(20),Religion varchar(20),Category varchar(20),Income varchar(20),Education varchar(20),Occupation varchar(20),aadhar varchar(20),pan varchar(20),SeniorCitizen varchar(20),existingAccount varchar(20));
create table signupthree(formNo varchar(20),accountType varchar(20),cardNumber varchar(20),pin varchar(20),facility varchar(60));
create table bank(pin varchar(10),Date varchar(50),type varchar(20),amount varchar(20));
create table login(formNo varchar(20),CardNumber varchar(20),PIN varchar(20));

select * from login;


