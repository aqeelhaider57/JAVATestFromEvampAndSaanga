Github Repository
https://github.com/aqeelhaider57/JAVATestFromEvampAndSaanga

Primary API functions:

1 – Create Customer
curl --location --request POST 'localhost:8086/customer/create' \
--header 'Content-Type: application/json' \
--data-raw '{
    "customerName":"test Name",
    "email":"aqeelhaider57@gmail.com",
    "dateOfBirth":"2000-12-22"
}'


2 – Create Sim
curl --location --request POST 'localhost:8086/sim/create' \
--header 'Content-Type: application/json' \
--data-raw '{
    "simNumber":"123456789"
}'


3 – Link Sim to customer
curl --location --request POST 'localhost:8086/sim/getByCustomerId' \
--header 'Content-Type: application/json' \
--data-raw '{
    "customerId":2
}'


4 – Retrieve customer Sims
curl --location --request POST 'localhost:8086/sim/getByCustomerId' \
--header 'Content-Type: application/json' \
--data-raw '{
    "customerId":2
}'


5 – Retrieve all Sims
curl --location --request GET 'localhost:8086/sim/getAll'

Questions Answers

1 - The decisions you made along the way
Answer: 
My action of taking decisions and choosing the action plan accordingly my given instruction as above to solve problem analytically.

2 - what you focused on
Answer:
I always focus on task timeline and It is always my standard to follow the standard in programming to writing code less error prone and bugs.

3 - what you didn't focus on and why
Answer:
I never consider time because I love with my profession.
I am human being and chance of mistakes possibility is sure. But my technical skills and lot of practice is giving me prefection in my learning phase.

4 - as well as how to run and use the program.
Answer:
Simple Clone from github repository with source tree and import app in spring tool suit via maven existing project option and MYSQL database.
Database name is = testdb
table query for customer
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

table query for Sim
CREATE TABLE `sim` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sim_number` int(11) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgj84tvbjj2ernn74x19mysvat` (`customer_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci





