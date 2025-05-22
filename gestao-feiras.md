# Sistema de Gestão de Feira de Produtores Locais

## Descrição

Este sistema tem como objetivo gerenciar a organização de uma feira periódica de produtores locais, permitindo o controle de produtores, produtos, bancas (ou estandes), agendamentos de participação em edições da feira e vendas realizadas.

A feira acontece regularmente (por exemplo, semanalmente ou mensalmente), e os produtores precisam se inscrever para participar de cada edição. Cada produtor possui uma banca onde comercializa seus produtos, que podem ser de categorias diversas como alimentos, bebidas, artesanato, entre outros.

O sistema permite o gerenciamento de edições da feira, com controle de data, local e número de bancas disponíveis. Também permite o registro de vendas feitas durante cada edição, possibilitando análise de desempenho e relatórios consolidados.

## Requisitos Funcionais

### 1. Gerenciamento de Produtores

- **REQ01**: Permitir o cadastro de produtores com nome, CPF/CNPJ, telefone, e-mail e categoria de atuação (ex: hortifruti, laticínios, artesanato etc.).
- **REQ02**: Associar cada produtor a seus produtos e às edições da feira em que participou.

### 2. Gerenciamento de Produtos

- **REQ03**: Permitir o cadastro de produtos com nome, descrição, preço médio e categoria.
- **REQ04**: Associar cada produto a um produtor, respeitando suas categorias permitidas.

### 3. Gerenciamento de Edições da Feira

- **REQ05**: Permitir o cadastro de edições da feira com data, horário, local e número máximo de bancas.
- **REQ06**: Controlar o número de bancas disponíveis e impedir novas inscrições quando o limite for atingido.

### 4. Agendamento de Participação

- **REQ07**: Permitir que produtores se inscrevam para participar de edições futuras da feira.
- **REQ08**: Registrar em qual banca o produtor será alocado na edição.
- **REQ09**: Permitir cancelamento da participação com prazo mínimo de antecedência, para liberar a vaga.

### 5. Controle de Vendas

- **REQ10**: Permitir o registro de vendas por produtor, produto e edição da feira.
- **REQ11**: Calcular automaticamente o valor total vendido por banca em uma edição.
- **REQ12**: Permitir inserção de observações nas vendas, como forma de pagamento ou promoções aplicadas.

### 6. Consultas e Histórico

- **REQ13**: Permitir a consulta de edições anteriores da feira e os produtores que participaram.
- **REQ14**: Permitir a visualização do histórico de vendas por produtor, produto e edição.

### 7. Relatórios e Exportações

- **REQ15**: Gerar relatórios de vendas por edição da feira, por produtor e por produto.
- **REQ16**: Gerar relatório de participação por produtor, mostrando frequência e vendas médias.
- **REQ17**: Permitir exportação de relatórios em **PDF** e **CSV**, com agrupamento por categorias de produto.

### 8. Regras e Restrições

- **REQ18**: Um produtor não pode se inscrever em mais de uma banca na mesma edição.
- **REQ19**: Um produto não pode ser vendido em uma edição se não estiver previamente cadastrado para o produtor.
- **REQ20**: Impedir a participação de produtores inativos ou com pendências administrativas.

## Possíveis APIs/Bibliotecas a Serem Usadas

- **JavaFX** – Interface para cadastro, agendamento e relatórios.
- **JDBC / Hibernate** – Acesso a banco de dados e persistência.
- **Java Time API** – Controle de datas e horários das edições da feira.
- **iText / JasperReports** – Geração de relatórios em PDF.
- **Apache POI** – Exportação de dados para CSV ou Excel.
- **JUnit / Mockito** – Testes para regras de participação e controle de vendas.
