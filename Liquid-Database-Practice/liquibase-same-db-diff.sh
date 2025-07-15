#!/usr/bin/env bash
mvn liquibase:diffChangeLog \
  -Dliquibase.referenceUrl=hibernate:spring:your.package.Model?dialect=org.hibernate.dialect.MySQL8Dialect \
  -Dliquibase.outputChangeLogFile=src/main/resources/db/changelog/diff.mysql.sql