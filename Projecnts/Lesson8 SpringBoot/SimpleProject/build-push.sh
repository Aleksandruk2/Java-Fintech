#!/bin/bash

echo "Docker login..."
docker login

echo "Building Docker image mvc..."
docker build -t p32-java .

echo "Tagging Docker image mvc..."
docker tag p32-java:latest avalentyn/p32-java:latest

echo "Pushing Docker image mvc to repository..."
docker push avalentyn/p32-java:latest

echo "Done ---mvc---!"
read -p "Press Enter to continue..."
 