
Atividade Prática: Sistema de Gestão de Supermercado (Backend)

## Contexto do Projeto
Estamos desenvolvendo uma API para um **Supermercado**. O módulo de Cadastro de Usuários já foi iniciado. Agora, precisamos finalizar as funcionalidades de usuários e implementar o coração do sistema: o **Cadastro de Produtos**.

## Objetivo
Consolidar os conhecimentos de **Arquitetura em Camadas** (Controller, Service, Repository) e o padrão **DTO (Data Transfer Object)** com mapeamento manual, garantindo que a aplicação seja segura e escalável.

---

## Parte 1: Finalizando o Módulo de Usuários
No seu projeto base, o `UsuarioController` e o `UsuarioService` já possuem a listagem e o cadastro. Complete o ciclo de vida da entidade implementando:

1.  **Atualização de Cadastro (PUT):** O endpoint deve receber o `id` na URL e um `UsuarioRequest` no corpo. Deve-se atualizar o nome, e-mail e senha do usuário.
2.  **Remoção de Usuário (DELETE):** O endpoint deve receber o `id` e apagar o registro do banco de dados. Caso o ID não exista, deve-se lançar uma exceção de "Usuário não encontrado".

> **Status HTTP** de sucesso esperado para a remoção: `204 No Content`.

---

##  Parte 2: Novo Módulo de Produtos
Você deve criar do zero o CRUD completo para a entidade **Produto**, seguindo rigorosamente a arquitetura do projeto.

### **Especificações da Entidade (ProdutoEntity):**
* **Tabela no Banco (H2):** `TB_PRODUTO`
* **Atributos:**
    * `id` (Long, Autoincremento)
    * `nome` (String, Ex: "Arroz 5kg")
    * `codigoBarras` (String, Único)
    * `preco` (Double ou BigDecimal)
    * `quantidadeEstoque` (Integer)

### **Requisitos de Implementação:**

* **DTOs:** Use **Records** para criar o `ProdutoRequest` (entrada) e `ProdutoResponse` (saída - deve retornar todos os campos menos dados sensíveis de sistema).
* **Mapper:** Crie a classe `ProdutoMapper` para converter manualmente entre Entidade e DTO.
* **Camadas:** Implementar `ProdutoRepository`, `ProdutoService` (com lógica de negócio) e `ProdutoController` (com os endpoints `/v1/produtos`).

---

### **Critérios de Avaliação**
* [ ] Separação correta de responsabilidades entre as camadas.
* [ ] Uso adequado dos métodos HTTP (GET, POST, PUT, DELETE).
* [ ] Implementação correta dos Mappers sem expor a Entidade no Controller.