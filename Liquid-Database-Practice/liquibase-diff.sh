#!/usr/bin/env bash
mvn liquibase:diff \
  -Dliquibase.referenceUrl=jdbc:mysql://localhost:3306/db_liquibase_ref \
  -Dliquibase.referenceUsername=db_user \
  -Dliquibase.referencePassword=Abcd1234$ \
  -Dliquibase.url=jdbc:mysql://localhost:3306/db_user_liquid_database_practice \
  -Dliquibase.username=db_user \
  -Dliquibase.password=Abcd1234$ \
  -Dliquibase.driver=com.mysql.cj.jdbc.Driver \
  -DoutputChangeLogFile=src/main/resources/db/changelog/diff.mysql.sql
