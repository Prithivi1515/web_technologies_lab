<!DOCTYPE html>
<html>
<head>
    <title>Movie List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 20px;
        }
        h1 {
            text-align: center;
        }
        ul {
            list-style-type: none;
            padding: 0;
            margin: 0;
        }
        li {
            background-color: #ffffff;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin: 10px;
            padding: 10px;
        }
    </style>
</head>
<body>
    <h1>Movie List</h1>
    <ul>

    <?php
    $xmlFile = "movies.xml"; // Your XML file

    if (file_exists($xmlFile)) {
        $xml = simplexml_load_file($xmlFile);

        if ($xml) {
            foreach ($xml->movie as $movie) {
                $title = $movie->title;
                $director = $movie->director;
                $year = $movie->year;

                echo "<li>$title ($year) - Directed by $director</li>";
            }
        } else {
            echo "Error loading XML data";
        }
    } else {
        echo "XML file not found";
    }
    ?>
    </ul>
</body>
</html>
