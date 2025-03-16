# Projeto Spring Boot - CRUD de Clientes

## Descrição
Este projeto consiste na criação de um CRUD completo de web services REST utilizando Spring Boot. O CRUD permite acessar um recurso de clientes, implementando as cinco operações básicas: busca paginada, busca por ID, inserção, atualização e deleção de clientes.

## Requisitos
- **Backend**: Spring Boot com Maven.
- **Banco de dados**: H2 (banco em memória para testes).
- **Linguagem**: Java.

### Operações CRUD:
- Busca paginada de recursos
- Busca de recurso por ID
- Inserir novo recurso
- Atualizar recurso
- Deletar recurso

### A entidade Client contém os seguintes campos:
- nome (não pode ser vazio)
- cpf
- renda
- data de nascimento (não pode ser data futura)
- quantidade de filhos

### Exceções a serem tratadas
- **ID não encontrado** (para GET por ID, PUT e DELETE) – Retorno de código 404.
- **Erro de validação** (para inserção e atualização) – Retorno de código 422 e mensagens customizadas para campos inválidos. As regras de validação são:
  - Nome: não pode ser vazio.
  - Data de nascimento: não pode ser data futura (use a anotação `@PastOrPresent`).

## Especificações
- A classe `Client` deve seguir os nomes de atributos conforme o diagrama fornecido.
- O campo `birthDate` será convertido para `birth_date` no banco de dados devido ao padrão do JPA que converte camelCase para snake_case.
- Ao realizar o seed dos dados, devem ser gerados pelo menos 10 clientes com dados significativos.

## Rotas
- **GET /clients/{id}**: Busca cliente por ID.
- **GET /clients**: Busca paginada de clientes. Exemplo: `GET /clients?page=0&size=6&sort=name`
- **POST /clients**: Insere um novo cliente. Exemplo:
```json
{
  "name": "Maria Silva",
  "cpf": "12345678901",
  "income": 6500.0,
  "birthDate": "1994-07-20",
  "children": 2
}
```
### PUT /clients/{id}: Atualiza um cliente existente. Exemplo:
```json
{
  "name": "Maria Silvaaa",
  "cpf": "12345678901",
  "income": 6500.0,
  "birthDate": "1994-07-20",
  "children": 2
}
```
### DELETE /clients/{id}: Deleta um cliente existente.

## Requisitos de Implementação
- O projeto deve ser configurado para acesso ao banco de dados H2.
- O ambiente de testes deve ser configurado adequadamente.
- O Maven deve ser usado como gerenciador de dependências.
- Seed de pelo menos 10 clientes com dados significativos.

## Configuração do Banco de Dados
- Certifique-se de que o campo `birthDate` seja convertido para `birth_date` no banco de dados, devido ao padrão do JPA. O script SQL para criar a tabela deve seguir este padrão de nomenclatura.

## Excluindo Arquivos Desnecessários
- Não inclua no projeto arquivos e pastas que não devem ser versionados no Git, como a pasta `.metadata` do Eclipse ou `.idea` do IntelliJ.

## Como o Trabalho Será Corrigido

### 1) Importação do Projeto
Realizar um simples clone do projeto no GitHub, importar e executar o projeto na IDE sem configurações especiais.

### 2) Testes Manuais no Postman
O professor realizará testes manuais usando o Postman. As seguintes requisições devem funcionar corretamente:

#### 2.1) Busca de Cliente por ID
- **GET /clients/1**

#### 2.2) Busca Paginada de Clientes
- **GET /clients?page=0&size=6&sort=name**

#### 2.3) Inserção de Novo Cliente
- **POST /clients** (Exemplo de corpo da requisição):
```json
{
  "name": "Maria Silva",
  "cpf": "12345678901",
  "income": 6500.0,
  "birthDate": "1994-07-20",
  "children": 2
}
```
#### 2.4) Atualização de Cliente
- **PUT /clients/1** (Exemplo de corpo da requisição):
```json
{
  "name": "Maria Silvaaa",
  "cpf": "12345678901",
  "income": 6500.0,
  "birthDate": "1994-07-20",
  "children": 2
}
```
#### 2.5) Deleção de Cliente
- **DELETE /clients/1**

---

## Checklist de Funcionalidade
- A busca por ID retorna o cliente existente.
- A busca por ID retorna 404 para cliente inexistente.
- A busca paginada retorna a listagem correta de clientes.
- A inserção de cliente funciona com dados válidos.
- A inserção de cliente retorna 422 e mensagens customizadas para dados inválidos.
- A atualização de cliente funciona com dados válidos.
- A atualização de cliente retorna 404 para cliente inexistente.
- A atualização de cliente retorna 422 e mensagens customizadas para dados inválidos.
- A deleção de cliente funciona corretamente.
- A deleção de cliente retorna 404 para cliente inexistente.
