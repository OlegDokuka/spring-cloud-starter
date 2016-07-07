start %cd%/gradlew bootRun -Dspring.profiles.active=subject
ping 127.0.0.1 -n 6 > nul
start %cd%/gradlew bootRun -Dspring.profiles.active=verb
ping 127.0.0.1 -n 6 > nul
start %cd%/gradlew bootRun -Dspring.profiles.active=article
ping 127.0.0.1 -n 6 > nul
start %cd%/gradlew bootRun -Dspring.profiles.active=adjective
ping 127.0.0.1 -n 6 > nul
start %cd%/gradlew bootRun -Dspring.profiles.active=noun

