#!/bin/sh

## 1. Run the date command ##
#mvn clean package > 1_compile.log
./gradlew build

if [ $? -eq 0 ]
then
  echo "Success: Compile."
else
  echo "Failure: Compile" >&2
  exit 1
fi

java -jar ./target/migration-sql-1.0.2.jar
#java -jar -Dspring.profiles.active=migration ./target/migration-sql-1.0.2.jar > 3_migration.log

if [ $? -eq 0 ]
then
  echo "Success: migration."
else
  echo "Failure: migration" >&2
  exit 1
fi

