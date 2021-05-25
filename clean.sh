#!/bin/bash

docker compose down

# Delete old backend app
docker rmi kong-oauth-ms_book-app