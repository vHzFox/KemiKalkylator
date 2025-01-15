<?php
    include("databas.php");
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Atom Info och Bindnings Kalkylator</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="container">
        <h1>Atom Info och Bindnings Kalkylator</h1>

        <!-- Atom Info Section -->
        <div id="atom-info-section">
            <h2>Atom Information</h2>
            <form id="atom-info-form" method="POST">
                <label for="atom-name">Ange atom namn eller symbol:</label>
                <input type="text" id="atom-name" name="atom-name" required>
                <button type="submit">Hämta info</button>
            </form>
            <div id="atom-info-result"></div>
        </div>

        <!-- Bonding Calculator Section -->
        <div id="bonding-calculator-section">
            <h2>Bindnings Kalkylator</h2>
            <form id="bonding-calculator-form" method="POST">
                <label for="atom1">Atom 1</label>
                <input type="text" id="atom1" name="atom1" required>

                <label for="atom2">Atom 2</label>
                <input type="text" id="atom2" name="atom2" required>

                <button type="submit">Räkna Bindning</button>
            </form>
            <div id="bonding-result"></div>
        </div>
    </div>
    
    <script src="script.js"></script>
</body>
</html>
