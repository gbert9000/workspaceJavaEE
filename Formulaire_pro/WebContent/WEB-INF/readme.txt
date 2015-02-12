Nous avons ainsi avec succès mis en place une architecture MVC pour le traitement de notre formulaire :

1>    les données saisies et envoyées par le client arrivent à la méthode doPost() de la servlet ;

2>    celle-ci ordonne alors le contrôle des données reçues en appelant la méthode inscrireUtilisateur() de l'objet métier InscriptionForm ;

3>    l'objet InscriptionForm effectue les traitements de validation de chacune des données reçues ;

4>    il les enregistre par la même occasion dans le bean Utilisateur ;

5>    la méthode doPost() récupère enfin les deux objets du modèle, et les transmet à la JSP via la portée requête ;

6>    la JSP va piocher les données dont elle a besoin grâce aux différentes expressions EL mises en place, qui lui donnent un accès direct aux objets du modèle transmis par la servlet ;

7>    pour finir, la JSP met à jour l'affichage du formulaire en se basant sur les nouvelles données.

8>    Il faut utiliser un bean pour stocker les données du formulaire.

9>    Il faut déplacer la validation et le traitement des données dans un objet métier.

10>    La servlet ne fait alors plus qu'aiguiller les données : contrôle > appels aux divers traitements > renvoi à la JSP.

11>    La méthode doGet() s'occupe des requêtes GET, la méthode doPost() des requêtes POST. Tout autre usage est fortement déconseillé.

12>    La page JSP accède dorénavant aux données directement à travers les objets du modèle mis en place, et non plus depuis la requête.