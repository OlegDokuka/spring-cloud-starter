start %cd%/gradlew bootRun -Dspring.profiles.active=subject,discovery-first-bootstrap
SLEEP 5
start %cd%/gradlew bootRun -Dspring.profiles.active=verb,discovery-first-bootstrap
SLEEP 5
start %cd%/gradlew bootRun -Dspring.profiles.active=article,discovery-first-bootstrap
SLEEP 10
start %cd%/gradlew bootRun -Dspring.profiles.active=adjective,discovery-first-bootstrap
SLEEP 10
start %cd%/gradlew bootRun -Dspring.profiles.active=noun,discovery-first-bootstrap
SLEEP 15
start %cd%/gradlew bootRun -Dspring.profiles.active=subject-ru,discovery-first-bootstrap
SLEEP 15
start %cd%/gradlew bootRun -Dspring.profiles.active=verb-ru,discovery-first-bootstrap
SLEEP 15
start %cd%/gradlew bootRun -Dspring.profiles.active=article-ru,discovery-first-bootstrap
SLEEP 20
start %cd%/gradlew bootRun -Dspring.profiles.active=adjective-ru,discovery-first-bootstrap
SLEEP 20
start %cd%/gradlew bootRun -Dspring.profiles.active=noun-ru,discovery-first-bootstrap
SLEEP 20

