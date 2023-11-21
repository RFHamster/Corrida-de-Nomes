<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Bar Chart Race</title>
    <link rel="stylesheet" type="text/css" href="./inspector.css">
    <style>
        .observablehq {
            visibility: hidden;
            display: none;
        }

        
    </style>
</head>


<body>
    <h1>Resultado da busca:</h1>
    <div id="container"></div>

    <script type="module">

        import define from "./index.js";
        import { Runtime, Inspector } from "./runtime.js";

        const runtime = new Runtime();
        const main = runtime.module(define, Inspector.into(document.getElementById('container')));

    </script>
<?php
//header('Access-Control-Allow-Origin: 127.0.0.1');

if ($_SERVER["REQUEST_METHOD"] === "POST") {
    // Verifica se o campo 'dados' está presente no FormData
    if (isset($_POST['dados'])) {
        // Obtém o JSON do campo 'dados'
        $jsonString = $_POST['dados'];

        echo '<script>var dadosPHP = ' . json_encode($jsonString) . ';</script>';
        $jsonData = json_decode($jsonString, true);
    } else {
        // Se o campo 'dados' não estiver presente, envie uma resposta de erro
        http_response_code(400);
        echo 'Campo "dados" não encontrado no FormData';
    }

    exit; // Evita execução desnecessária de código PHP
}
?>

</body>
</html>
