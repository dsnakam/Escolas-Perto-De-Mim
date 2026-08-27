# Escolas Perto de Mim SP

Aplicação web que permite a professores e outros usuários encontrarem as escolas estaduais mais próximas de um endereço informado, na cidade de São Paulo.

## 🎯 Motivação

Professores da rede estadual muitas vezes não têm uma forma simples de visualizar quais escolas ficam mais próximas de sua residência. Este projeto resolve esse problema cruzando dados públicos de escolas com geocoding de endereços, calculando a distância até cada uma.

## 🛠️ Tecnologias

- **Java** + **Spring Boot**
- **Spring Web** (RestClient para geocoding)
- API de geocoding: [Nominatim (OpenStreetMap)](https://nominatim.org/)
- **JUnit** e **Mockito** para testes
- **HTML, CSS e JavaScript** (front-end simples, consumindo a API via `fetch`)

## ⚙️ Funcionalidades

- Importação automática de dados de escolas (estaduais, com plano de incluir municipais) a partir de dataset público
- Geocoding do endereço informado pelo usuário
- Cálculo de distância (fórmula de Haversine) entre o endereço e cada escola
- Listagem das escolas mais próximas, ordenadas por distância
- Tratamento de erro para endereços não encontrados

## 🚀 Como rodar localmente

```bash
# clone o repositório
git clone <https://github.com/dsnakam/Escolas-Perto-De-Mim>
cd <Escolas-Perto-De-Mim>

# rode com Maven
./mvnw spring-boot:run
```

A aplicação sobe em `http://localhost:8080`.

## 📋 Endpoints

| Método | Rota                             | Descrição |
|--------|----------------------------------|-----------|
| GET | `/escolas-proximas?q={endereco}` | Retorna as escolas mais próximas do endereço informado |

## 🧪 Testes

```bash
./mvnw test
```

Cobertura inclui testes unitários do cálculo de distância e testes com Mockito do controller (casos de sucesso e de endereço não encontrado).

## 🔮 Próximos passos

- Deploy
- Containerização com Docker
- Filtros de busca por Diretoria de Ensino
- Avaliar substituição/complemento do cálculo de distância em linha reta por uma API de roteamento real (ex: OSRM)

## 👤 Autor

Daniel dos Santos Nakamura