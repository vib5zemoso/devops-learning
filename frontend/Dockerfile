FROM node:latest as build-stage

RUN mkdir /usr/app

COPY . /usr/app

WORKDIR /usr/app

RUN npm install

ENV PATH /usr/src/app/node_modules/.bin:$PATH

RUN npm run build
