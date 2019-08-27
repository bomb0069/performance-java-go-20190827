# Java vs GO : Performance Testing Project

this project creating to proved that golang is faster than java

## Using SCK-MOTOR Database

### Start SCK-MOTOR Database

start MySQL's docker image with initial sample data

> docker run --rm --name sck-database -e MYSQL_DATABASE=sck-motor -e MYSQL_ROOT_PASSWORD=my-secret-pw -v $(pwd)/data/:/docker-entrypoint-initdb.d -d mysql

### Run MYSQL command

to access docker bash shell to run mysql command
> docker exec -it sck-database /bin/bash

run msql command to confirm about working database
> mysql --user=root --password sck-motor

use this password to access database
> my-secret-pw

using query to get data from table customer
>mysql\>select * from customers;

### Stop SCK-MOTOR Database

stop MySQL's docker container

>docker container stop sck-database

## API Testing

using newman to run api testing

### RUN API Testing on Development Environment

run api testing with newman in development environment
>newman run tests/api/get_customers.json -e tests/api/environment/development.json
