INSERT INTO CATEGORY
    (country)
VALUES
    ('Polska'),
    ('Włochy'),
    ('Francja');
INSERT INTO RECIPE
    (name, category_id, likes, ingredients, description)
VALUES
    ('Jajecznica', 1, 3, 'jajka, masło, szczypiorek, sól, pieprz',
     'Rozbij jajka do miseczki, a następnie lekko roztrzep widelcem, dodaj pieprz i sól. Pokrój drobno szczypiorek.' ||
     'W międzyczasie rozgrzej patelnię, a na niej masło. Wlej jajka i chwilę energicznie mieszaj. Gdy jajka się częściowo zetną, dorzuć szczypiorek,' ||
     'Mieszaj jeszcze przez chwilę do osiągnięcia oczekiwanej konsystencji. Po wyłożeniu jajecznicy na talerz możesz dodać jeszcze trochę szczypiorku.'),
    ('Spaghetti Bolognese',  2, 5, 'wołowina, boczek, pomidory w kawałkach, czosnek, oliwa z oliwek',
     'Przygotuj sobie średnią patelnię z grubym dnem. Zacznij ją nagrzewać. Dodaj dwie łyżki oleju do smażenia.' ||
     'Na patelnię wyłóż obraną i drobno posiekaną cebulę. Podsmażaj cebulkę na średniej mocy palnika przez około 8 ' ||
     'minut, aż zrobi się rumiana. Po tym czasie dodaj tej dwa ząbki czosnku. Obierz je wcześniej i pokrój w plasterki. Cebulę z czosnkiem podsmażaj jeszcze dwie minuty.'),
    ('Zupa Ceulowa',  3, 1, 'cebula, masło, białe wino, czosnek',
     'Do masła dodaj obrane i pokrojone w piórka cebule. Przyznaję, że nie kroję cebuli jakoś specjalnie cienko. W procesie' ||
     ' karmelizacji cebula bardzo się kurczy i jest super miękka. Mogłoby się wydawać, że obranie i pokrojenie kilograma cebuli' ||
     ' zajmuje strasznie dużo czasu, jednak to tylko kilka minut płaczu :)');