-- Clue #1: We recently got word that someone fitting Carmen Sandiego's description has been
-- traveling through Southern Europe. She's most likely traveling someplace where she won't be noticed,
-- so find the least populated country in Southern Europe, and we'll start looking for her there.

SELECT name, population
FROM country
WHERE region = 'Southern Europe'
ORDER BY population ASC
LIMIT 1;


-- Clue #2: Now that we're here, we have insight that Carmen was seen attending language classes in
-- this country's officially recognized language. Check our databases and find out what language is
-- spoken in this country, so we can call in a translator to work with you.

SELECT cl.language
FROM countrylanguage cl
JOIN country c ON c.code = cl.countrycode
WHERE c.name = 'Holy See (Vatican City State)'


-- Clue #3: We have new news on the classes Carmen attended – our gumshoes tell us she's moved on
-- to a different country, a country where people speak only the language she was learning. Find out which
-- nearby country speaks nothing but that language.

SELECT c.name , cl.language
FROM country c
JOIN countrylanguage cl ON cl.countrycode = c.code
where cl.language LIKE '%Italian%';


-- Clue #4: We're booking the first flight out – maybe we've actually got a chance to catch her this time.
-- There are only two cities she could be flying to in the country. One is named the same as the country – that
-- would be too obvious. We're following our gut on this one; find out what other city in that country she might
-- be flying to.

SELECT ci.name
FROM city ci
JOIN country c ON c.code = ci.countrycode
WHERE c.name = 'San Marino'
  AND ci.name <> c.name;


-- Clue #5: Oh no, she pulled a switch – there are two cities with very similar names, but in totally different
-- parts of the globe! She's headed to South America as we speak; go find a city whose name is like the one we were
-- headed to, but doesn't end the same. Find out the city, and do another search for what country it's in. Hurry!

SELECT ci.name AS city, c.name AS country
FROM city ci
JOIN country c ON c.code = ci.countrycode
WHERE c.continent = 'South America'
  AND ci.name LIKE 'Serra%'
  AND ci.name <> 'Serravalle';



-- Clue #6: We're close! Our South American agent says she just got a taxi at the airport, and is headed towards
-- the capital! Look up the country's capital, and get there pronto! Send us the name of where you're headed and we'll
-- follow right behind you!

SELECT cap.name AS capital
FROM country c
JOIN city cap ON cap.id = c.capital
WHERE c.name = (
  SELECT c2.name
  FROM city ci2
  JOIN country c2 ON c2.code = ci2.countrycode
  WHERE c2.continent = 'South America'
    AND ci2.name LIKE 'Serra%'
    AND ci2.name <> 'Serravalle'
  LIMIT 1
);


-- Clue #7: She knows we're on to her – her taxi dropped her off at the international airport, and she beat us to
-- the boarding gates. We have one chance to catch her, we just have to know where she's heading and beat her to the
-- landing dock.
--
-- "In a city of ninety-one thousand and now, eighty five."
-- Find the city (in the same country from clue #5) with population close to 85,000–91,000.

SELECT ci.name AS city, ci.population
FROM city ci
JOIN country c ON c.code = ci.countrycode
WHERE c.name = (
  SELECT c2.name
  FROM city ci2
  JOIN country c2 ON c2.code = ci2.countrycode
  WHERE c2.continent = 'South America'
    AND ci2.name LIKE 'Serra%'
    AND ci2.name <> 'Serravalle'
  LIMIT 1
)
  AND ci.population BETWEEN 85000 AND 91000
ORDER BY ci.population;


-- She's in Brasília.