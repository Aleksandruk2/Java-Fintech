#!/bin/bash

echo "Docker login..."
docker login

echo "Building Docker image api..."
docker build -t p32-java .

echo "Tagging Docker image api..."
docker tag p32-java:latest avalentyn/p32-java:latest

echo "Pushing Docker image api to repository..."
docker push avalentyn/p32-java:latest

echo "Done ---api---!"
read -p "Press Enter to continue..."
 