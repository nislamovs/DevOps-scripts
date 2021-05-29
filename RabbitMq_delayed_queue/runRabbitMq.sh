#!/usr/bin/env bash

docker-compose up ;
docker exec -it rabbitmq rabbitmqadmin -q import /etc/rabbitmq/definitions.json ;