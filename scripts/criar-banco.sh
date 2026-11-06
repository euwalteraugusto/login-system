#!/bin/sh
# Compila o projeto e gera users.db a partir de database/database.sql.
# Uso (na raiz do projeto): sh scripts/criar-banco.sh [--recriar]
set -e
JAR=lib/sqlite-jdbc-3.53.1.0.jar
mkdir -p out
javac -d out -cp "$JAR" $(find src tools -name '*.java')
java -cp "out:$JAR" CriarBanco "$@"
