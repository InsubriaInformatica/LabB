Prima di procedere alla creazione del DataBase assicurarsi di avere scaricato e installato "PostreSQL" con il proprio tool grafico "PgAdmin".
Il Database verrà successivamente creato in automatico all'avvio server, la procedura dettagliata è riportata nel manuale utente.

Per eseguire i moduli, aprire due schermate terminale/prompt dei comandi in base al sistema operativo che si sta utilizzando: 

----------
Avvio applicazione con sistema operativo MacOS:
Come primo passo, nella prima schermata recarsi alla directory src/ServerLAB/target, mediante comando:
cd ServerLAB/target 
Successivamente eseguire:
chmod +x ServerLAB-1.0-SNAPSHOT.jar
java -jar ServerLAB-1.0-SNAPSHOT.jar

Nella seconda schermata recarsi alla directory src/ClientLAB/target, mediante comando:
cd ClientLAB/target
Successivamente eseguire: 
chmod +x ClientLAB-1.0-SNAPSHOT.jar
java -jar CLientLAB-1.0-SNAPSHOT.jar
-----------

Avvio applicazione con sistema operativo Windows:
Nella prima schermata recarsi alla directory src/ServerLAB/target, mediante comando:
cd ServerLAB/target
Successivamente eseguire:
\java -jar ServerLAB-1.0-SNAPSHOT.jar

Nella seconda schermata recarsi alla directory src/ClientLAB/target, mediante comando:
cd ClientLAB/target
Successivamente eseguire:
\java -jar ClientLAB-1.0-SNAPSHOT.jar
----------

Per consultare il Javadoc di ogni progetto, recarsi nella directory target/apidocs