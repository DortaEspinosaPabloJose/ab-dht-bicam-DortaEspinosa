# ---------- Etapa 1: construcción con Maven ----------
FROM maven:3.9-eclipse-temurin-17 AS builder
WORKDIR /build

# Primero el pom: aprovecha la caché de capas para las dependencias
COPY pom.xml .
RUN mvn -B -q dependency:go-offline

COPY src ./src
# Las pruebas y los análisis de calidad se ejecutan en CI, no al construir la imagen
RUN mvn -B -q clean package -DskipTests -Djacoco.skip=true

# ---------- Etapa 2: imagen de ejecución ligera ----------
# (openjdk:17-jre-slim ya no existe en Docker Hub; Temurin JRE es el equivalente)
FROM eclipse-temurin:17-jre
WORKDIR /app

# Ejecutar sin privilegios de root
RUN useradd --system --no-create-home biciam
COPY --from=builder /build/target/BiCIAM-*.jar app.jar
COPY --from=builder /build/target/lib ./lib
USER biciam

ENTRYPOINT ["java", "-jar", "app.jar"]