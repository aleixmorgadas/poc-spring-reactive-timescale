#!/bin/bash

cd frontend
npm install
npm run build
npm run generate
cd ..
mkdir -p ./src/main/resources/static/
mv frontend/dist/** ./src/main/resources/static/
./gradlew build