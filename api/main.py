import bcrypt
import psycopg2
from fastapi import FastAPI, HTTPException
from pydantic import BaseModel, EmailStr

app = FastAPI()

def get_conn():
    return psycopg2.connect(
        host="localhost",
        dbname="LinguaViva",
        user="postgres",
        password="jj08012007ps",
    )

class RegistroIn(BaseModel):
    nome: str
    email: EmailStr
    senha: str

@app.post("/register", status_code=201)
def register(dados: RegistroIn):
    nome = dados.nome.strip()
    email = dados.email.lower()

    if len(nome) <= 3:
        raise HTTPException(400, "Nome muito curto")
    if len(dados.senha) < 6:
        raise HTTPException(400, "A senha precisa ter pelo menos 6 caracteres")

    senha_hash = bcrypt.hashpw(dados.senha.encode(), bcrypt.gensalt()).decode()

    conn = get_conn()
    try:
        with conn, conn.cursor() as cur:
            cur.execute(
                "INSERT INTO usuarios (nome, email, senha_hash) "
                "VALUES (%s, %s, %s) RETURNING id",
                (nome, email, senha_hash),
            )
            novo_id = cur.fetchone()[0]
    except psycopg2.errors.UniqueViolation:
        raise HTTPException(409, "Email já cadastrado")
    finally:
        conn.close()

    return {"id": novo_id, "nome": nome, "email": email}