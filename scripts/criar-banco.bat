@echo off
rem Compila o projeto e gera users.db a partir de database\database.sql.
rem Uso (na raiz do projeto): scripts\criar-banco.bat [--recriar]
set JAR=lib\sqlite-jdbc-3.53.1.0.jar
if not exist out mkdir out
dir /s /b src\*.java tools\*.java > out\fontes.txt
javac -d out -cp "%JAR%" @out\fontes.txt || exit /b 1
java -cp "out;%JAR%" CriarBanco %*
