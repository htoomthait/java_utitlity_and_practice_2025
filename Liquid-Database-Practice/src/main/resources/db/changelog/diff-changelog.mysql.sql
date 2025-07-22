-- liquibase formatted sql

-- changeset htoomaungthait:1753205173231-1
ALTER TABLE comments ADD hide BIT DEFAULT 0 NULL;

