# Corrida de Nomes

O Projeto utiliza a API do IBGE de nomes para mostrar uma corrida dos nomes mais registrados entre os anos selecionados. A API suporta as decadas de 1930 até 2010, além de funcionar por estado e por sexo. Assim, o front-end é basico, apenas pega os dados e passa para o back-end, que foi feito em Spring Boot. O back-end, por sua vez, manipula os dados no banco de dados, atraves das API de GET, POST, PUT e DELETE requisitados pelo front-end. Ele também consome a API do IBGE retornando um JSON próprio, paronizado para a plotagem no gráfico feito pelo D3.

Foram padrões de projeto, boas práticas e frameworks no back-end, como o padrão MVC, os frameworks Spring MVC (Web) e Spring Data.

Cada pacote tem sua função, desde configurar os atributos do projeto, modelar o banco de dados com anotações e controlar o acesso dos dados para uma API Rest com os controllers e services.

## Pagina Inicial do Projeto

![Pag Inicial](https://user-images.githubusercontent.com/71076681/284689887-0a5b5693-3dc1-42d2-b482-b8b3fbf0cbfa.png)

## Gráfico Resultante

Lembre-se que ele é uma forma de corrida, a cada ano do intervalo ele vai aumentando ou diminuindo as barras de forma interativa, então isso é uma captura de um momento dele.

![Grafico](https://user-images.githubusercontent.com/71076681/284690433-be363d5f-e6b6-4c9d-b8f6-83d305e85f46.png)

## Estrutura do Projeto Principal (Back-end)

Esta estrutura não conta o gráfico, caso queria saber mais sobre ele, abra a pasta gráfico do projeto e leia acerca do D3.

![Estrutura](https://user-images.githubusercontent.com/71076681/284690984-5f12f01b-4df8-4ca2-9e22-912d7ee8cbf2.png)

## Exemplo de uma Parte da Estrutura da API com Spring Boot

![EstruturaAPI](https://user-images.githubusercontent.com/71076681/284691495-d7150f0f-abb6-4c75-90cf-fc11015827b4.png)
