| Desafio 5 - Qual é a responsabilidade das camadas ,entity, controller, repository e service. | 
|:--------------------------------------------------------------------------------------------:|

|                                                                                                                                          Entity                                                                                                                                           |
|:-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|
|O Entity Framework permite que os desenvolvedores trabalhem com dados na forma de objetos e propriedades específicos de domínio, como clientes e endereços de clientes, sem ter que se preocupar com as tabelas e colunas de banco de dados subjacentes em que esses data são armazenados. |


|                                                                                                       Controller                                                                                                        |
|:-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|
|A camada de controle é responsável por intermediar as requisições enviadas pelo View com as respostas fornecidas pelas camadas de Serviço, processando os dados que o usuário informou e repassando para outras camadas. |

|                         Repository                          |
|:-----------------------------------------------------------:|
|E a camada que fará comunicação entre o Serviço e a Entidade |



|                                                         Service                                                          |
|:------------------------------------------------------------------------------------------------------------------------:|
|É a camada de serviços onde estarao presentes os serviços que faram a manipulação dos dados para enviar pro  Repositorio. |
