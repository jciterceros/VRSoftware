## Rodando Postgres e PGAdmin diretamente pelo Docker

#### Verificando se tem Containers atualmente rodando

docker ps

#### Verificando se tem Containers parados

docker ps -a

#### Eliminando todos os Containers

docker system prune -a

#### Configurando uma rede para os Containers rodarem juntos

docker network create --driver bridge my-network

#### Verificando todas redes

docker network ls

### Criando um Container Postgres e passando com qual rede ele vai trabalhar

docker run --name my-postgres --network=my-network -p 5433:5432 -e POSTGRES_PASSWORD=postgres -d postgres

### Verificando se o Container esta configurado na mesma rede

docker inspect my-network

### Criando um Container pgAdmin e passando com qual rede ele vai trabalhar

docker run --name my-pgadmin --network=my-network -p 15432:80 -e PGADMIN_DEFAULT_EMAIL=teste@gmail.com -e PGADMIN_DEFAULT_PASSWORD=postgres -d dpage/pgadmin4

### Verificando se o Container esta configurado na mesma rede

docker inspect my-network

#### Verificando se tem Containers atualmente rodando

docker ps

#### Acessando Container PgAdmin atualmente rodando

http://localhost:15432
Usuario: teste@gmail.com
Senha: postgres

#### Configurando conexao com Banco Postgres atualmente rodando

Dentro da interface do pgAdmin

Aba Geral:

- name: Docker

Aba Connection:

- Host name/address: my-postgres
- Port:5432
- Maintenance database: postgres
- Username: postgres
- Password: postgres
- Save password?: true

#### Caso feche o WSL e precise levantar os Containers postgres e pgAdmin

docker start my-postgres
docker start my-pgadmin

Referencia: https://www.youtube.com/watch?v=CdoBvd_bPdk&ab_channel=Prof.DiegoPinho-Programa%C3%A7%C3%A3o

#### Caso nao tenha instalado Ubuntu no WSL

Referencia: https://www.youtube.com/watch?v=trto4i0Olwg&ab_channel=DevSuperior

### Caso prefira docker-compose.yml

# Iniciar os serviços

docker-compose up -d

# Verificar o status dos serviços

docker-compose ps

# Iniciar os serviços novamente

docker-compose start
