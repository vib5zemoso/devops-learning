#!/bin/bash
set -e

docker-php-ext-install mysqli

apache2-foreground

