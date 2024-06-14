# PROJECTE_FINAL_WEB_JG

INSTRUCCIONS PER AL DESPLEGAMENT DE L'APLICACIÓ

Per al  desplegament de l’aplicació en un entorn local cal seguir els següents passos:

1.	Obrir MySQL per la creació i us de la base de dades així com la gestió i edició de les taules i la informació de registres corresponents. Executar “USE nom base de dades corresponent; “.

2.	Comprobar que estas en la sessió oberta amb usuari (root) i pasword () corresponent. 

3.	Obrir NetBeans per la creació dels arxius Java de les classes corresponents. 

4.	Al NetBeans cal actualitzar l’arxiu POM.XML dins la carpeta del projecte COMOBA tal com s’ha vist a l’apartat 5.2.

5.	Dins la carpeta src >main copiar la carpeta resources que conté la carpeta static i l’arxiu application.properties que cal configurar amb el port local i el nom de la base de dades. jdbc:mysql://localhost:3306/comoba.

6.	Dins la carpeta static hi ha la carpeta CSS i la carpeta JS que conte els arxius html.

7.	Dins la carpeta main > java > com > mycompany > comoba hi ha tots els arxius java amb la classe main i les altres classes.

8.	Cada classe ha de tenir un arxiu amb els seus parametres i constructor, un arxiu amb el nom + Controller que controla les sol·licituds i un arxiu amb el nom+Repository que ajuda a la connexió amb la base de dades. 

9.	Configurar l’arxiu WebConfig.java.

10.	Un cop estan tots els arxius configurats i estructurats, cal executar “build” a Netbeans.

11.	Executar “Run” per comprovar que no hi ha herrades i deixar el programa connectat (actiu en “run”).

12.	Fer servir l’aplicatiu web Postman per gestionar les sol·licituds GET, POST, PUT i DELETE entre els arxius i les classes de java i la base de dades en SQL.  

CONFIGURACIONS NECESSÀRIES:

Es necessari disposar de l’aplicatiu Netbeans amb el paquet de jbk que és el controlador per la base de dades.