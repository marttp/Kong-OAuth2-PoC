#!/bin/bash

# Build backend app
cd bookstore
mvn clean package

cd ..

# Start docker compose
# docker compose up -d
docker compose up --build -d
