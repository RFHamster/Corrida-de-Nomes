<?php
header('Access-Control-Allow-Origin: *');
header('Content-Type: application/json');
if ($_SERVER["REQUEST_METHOD"] === "POST") {
    $jsonString = $_POST['dados']; // 'dados' é o nome que você definiu ao anexar o JSON ao FormData
    $jsonData = json_decode($jsonString, true); // Decodifica a string JSON para um array associativo

    // Faça o que quiser com os dados JSON recebidos
    var_dump($jsonData);
}

?>