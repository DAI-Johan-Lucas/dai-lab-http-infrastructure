FROM postgres:11.5-alpine
COPY init_database_dai-lab-http-infrastructure.sql /docker-entrypoint-initdb.d/
COPY populate_dai-lab-http-infrastructure.sql /docker-entrypoint-initdb.d/