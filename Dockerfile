# Этап сборки
# Ключевое слово `as builder` создаёт именованный этап сборки.
FROM maven:3.9.6-eclipse-temurin-21 as builder
#Устанавливает рабочую директорию `/opt/app` внутри контейнера.
WORKDIR /opt/app
#Копирует файл `pom.xml` из текущей директории на хосте в рабочую директорию контейнера.
COPY pom.xml ./
#Копирует директорию `src` из текущей директории на хосте в рабочую директорию контейнера.
COPY ./src ./src
#В результате сборки создаётся файл JAR в директории `target`.
RUN mvn clean install -DskipTests

# Этап выполнения
FROM eclipse-temurin:21-jre-jammy
WORKDIR /opt/app
EXPOSE 8080
#Копирует файл JAR из этапа сборки (builder) в рабочую директорию контейнера.
COPY --from=builder /opt/app/target/*.jar /opt/app/*.jar
#Устанавливает команду по умолчанию для выполнения при запуске контейнера, которая запускает JAR файл
ENTRYPOINT ["java", "-jar", "/opt/app/*.jar"]

