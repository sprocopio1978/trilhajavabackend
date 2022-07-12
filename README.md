| Desafio 5 - Qual é a responsabilidade das camadas ,entity, controller, repository e service. | 
|:--------------------------------------------------------------------------------------------:|

|                                                                                                                                          Entity                                                                                                                                           |
|:-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|
|O Entity Framework permite que os desenvolvedores trabalhem com dados na forma de objetos e propriedades específicos de domínio, como clientes e endereços de clientes, sem ter que se preocupar com as tabelas e colunas de banco de dados subjacentes em que esses data são armazenados. |


|                                                                                                       Controller                                                                                                        |
|:-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|
|Sua função é ser uma camada intermediária entre a camada de apresentação (View) e a camada de negócios (Model). Deste modo, toda requisição criada pelo usuário deve passar pelo controller, e este então se comunica com o model. |

|                                                                                      Repository                                                                                       |
|:-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|
| é um padrão de projeto que visa mediar a pesquisa de objetos de dominio entre a camada de dominio e a camada de mapeamento de dados usando uma interface semelhante à de uma coleção. |



|                                                         Service                                                          |
|:------------------------------------------------------------------------------------------------------------------------:|
|O conceito de camada de serviços não é novo, já é utilizado no mercado há algum tempo. Ele surgiu da necessidade de uma camada responsável por fazer as tratativas de regras de negócios, tentando desacoplar a camada de Controladores da camada de Modelos. Essa separação de camadas é uma das formas de arquitetar a sua aplicação, mas existem muitas outras, e elas são utilizadas para atender requisitos não funcionais, como manutenibilidade, reusabilidade, desempenho e etc.|
