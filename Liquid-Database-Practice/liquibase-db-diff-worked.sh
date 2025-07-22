mvn liquibase:diff \
  -Dliquibase.diffChangeLogFile=src/main/resources/db/changelog/diff-changelog.mysql.sql \
  -Dliquibase.referenceUrl='jdbc:mysql://localhost:3306/db_user_liquid_database_practice?useSSL=false&serverTimezone=Asia/Yangon' \
  -Dliquibase.referenceUsername=db_user \
  -Dliquibase.referencePassword='Abcd1234$' \
  -Dliquibase.url='jdbc:mysql://localhost:3306/db_liquibase_ref?useSSL=false&serverTimezone=Asia/Yangon' \
  -Dliquibase.username=db_user \
  -Dliquibase.password='Abcd1234$'




