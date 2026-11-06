# LinguaViva

O **LinguaViva* é um aplicativo para auxiliar na **alfabetização fônica**, com um front-end Android moderno e um back-end robusto em Python. O projeto inclui autenticação de usuário(cadastro e login) e uma interface limpa e intuitiva, contruída a partir do Jetpack Compose junto ao kotliin.

 ## Estrutura do projeto

 O repositório do **LinguaViva** é organizado em dois componentes principais:

- 📁 `/app`: aplicativo Android nativo, feito com Kotlin e Jetpack Compose. Cuida totalmente da interface e da comunicação com o back-end.
- 📁 `/api`: servidor back-end feito com FastAPI (Python). Gerencia os dados dos usuários, a autenticação e a logica de negócio.

  ## Funcionalidades

  - **Cadastro de usuário:** criação de contas com nome, e-mail e senha
  - **Login:** autenticação de usuário já cadastrado.
  - **Senha protegida:** as senha são criptografadas com `bcrypt` antes da serem salvas no banco de dados.
  - **Interface intuitiva:** telas de apresentação, login e cadastro simples e agráveis.
  - **Arquitetura cliente-servidor:** front-end e back-end separados, que se comunicam por API REST, facilitando a manutenção e a evolução do projeto.
 
    ## Tecnologias

    ### Back-end (`/api`)

    - **Framework:** FastAPI
    - **Linguagem:** Python
    - **Banco de dados:** PostgremSQL
    - **Hash de senhas:** bcrypt
    - **Drive do banco:** psycopg2
   
    ## Front-end (`/app`)

    - **Linguagem:** Kotlin
    - **Interface:** Jetpack Compose
    - **Rede:** Retrofit e Gson
    - **Navegação:** Navigation Compose
    - **Build:** Gradle
   
    ## Como executar

    Siga as instruções abaixo passo a passo para rodar uma cópia local do **LinguaViva** para desenvolvimento e testes.

    ### Pré-requisitos

    - Android Studio
    - Python 3.8
    - Servidor no PostgreSQL
    - Emulador Android ou dispositivo físico
   
    ### 1. Configurar o back-end (`/api`)

    1. Acessa a pasta API:

    ```bash
cd api
```

2. Crie e ative um ambiente virtual:

```bash
# Linux/macOS
python3 -m venv venv
source venv/bin/activate

# Windows
python -m venv venv
.\venv\Scripts\activate
```

3. Instale as dependências:

```bash
pip install fastapi "uvicorn[standard]" psycopg2-binary bcrypt
```

4. Configure o banco de dados PostgreSQL:
   - Verifique se o servidor PostgreSQL está em execução.
   - Crie um banco chamado `LinguaViva`.
   - Conecte-se a ele e execute o comando abaixo para criar a tabela:

```sql
CREATE TABLE usuarios (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    senha_hash VARCHAR(100) NOT NULL
);
```

5. Configure a conexão com o banco:
   - Abra o arquivo `api/main.py`.
   - Atualize a função `get_conn` com os dados da sua conexão PostgreSQL (host, dbname, user e password).
   - **Importante:** não envie sua senha real para o GitHub. Prefira ler os dados de variáveis de ambiente (por exemplo, `os.getenv("DB_PASSWORD")`).

6. Inicie o servidor:

```bash
uvicorn main:app --host 0.0.0.0 --reload
```
