# Corrida de Nomes

O Projeto utiliza a API do IBGE de nomes para mostrar uma corrida dos nomes mais registrados entre os anos selecionados. A API suporta as decadas de 1930 até 2010, além de funcionar por estado e por sexo. Assim, o front-end é basico, apenas pega os dados e passa para o back-end, que foi feito em Spring Boot. O back-end, por sua vez, manipula os dados no banco de dados, atraves das API de GET, POST, PUT e DELETE requisitados pelo front-end. Ele também consome a API do IBGE retornando um JSON próprio, paronizado para a plotagem no gráfico feito pelo D3.

Foram padrões de projeto, boas práticas e frameworks no back-end, como o padrão MVC, os frameworks Spring MVC (Web) e Spring Data.

Cada pacote tem sua função, desde configurar os atributos do projeto, modelar o banco de dados com anotações e controlar o acesso dos dados para uma API Rest com os controllers e services.

