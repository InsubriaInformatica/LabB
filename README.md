# Progetto Vacciniamo 
Corso di Laboratorio interdisciplinare B, Laurea Triennale in Informatica presso Università degli Studi dell'Insubria con sede a Varese.

PROGETTO REALIZZATO DA:

1. ADEMI QALDO, matricola `746362` [qademi@studenti.uninsubria.it](mailto:qademi@studenti.uninsubria.it)
2. BATTAGLIA SIMONE, matricola `744514`[sbattaglia2@studenti.uninsubria.it](mailto:sbattaglia2@studenti.uninsubria.it)
3. BRULLO ENRICO, matricola `744949` [ebrullo@studenti.uninsubria.it](mailto:ebrullo@studenti.uninsubria.it)
4. SASSI GABRIELE. matricola `745081` [gsassi2@studenti.uninsubria.it](mailto:gsassi2@studenti.uninsubria.it)
---------------------------------------------------------------------------


## Vacciniamo
```
Il funzionamento generale dell’applicazione consiste in un semplice software in grado di gestire la campagna vaccinale COVID-19. 
In particolare, gli operatori vaccinali possono amministrare il form dedicato all’aggiornamento dello stato delle vaccinazioni. 
I cittadini possono visualizzare informazioni sull’andamento della campagna vaccinale attraverso la propria area personale sono in grado di gestire funzionalità riguardanti la propria vaccinazione.
```
---------------------------------------------------------------------------

## REQUISITI DI SISTEMA

Per poter eseguire l'applicazione è necessario aver installato sul proprio computer:

* `Java 8;`
* `PostgreSQL (solo per terminali server);`
* `Maven (per compilare da sorgente);`
* `Risoluzione: 1280 x 720 pixel o superiore;`
* `RAM: 4GB o superiore;`
* `Spazio su disco disponibile: 2GB o superiore;`
* `Processore: 1GHz o superiore;`
* `Connessione Internet stabile.`

**Sistema Operativo minimo richiesto**

* `Windows 10 e versioni successive.`
* `Ubuntu Linux 14.x e versioni successive.`
* `Mac OS X.`
---------------------------------------------------------------------------

## Installazione del programma
```
L'applicazione non necessita di installazione: Per l'esecuzione dell'applicazione avviare direttamente ServerLAB-1.0-SNAPSHOT.jar e ClientLAB-1.0-SNAPSHOT.jar.
```

### Avviare l'applicazione 
Dopo aver scaricato ed estratto il file **.zip**, seguire i seguenti passaggi:

Per avviare l'applicazione fare doppio click sul file nella cartella `target/`del modulo che si vuole eseguire:

* `ServerLAB-1.0-SNAPSHOT.jar` se si vuole usare l'applicazione **Server**;
* `ClientLAB-1.0-SNAPSHOT.jar` se si vuole usare l'applicazione **Client**.

se lanciando direttamente gli eseguibili si riscontrano problemi, in alternativa è possibile avviare il programma da terminale, con i seguenti comandi in base al sistema operativo: 

**WINDOWS**
* `cd {nome del percorso in cui è presente il file Server .jar}`;
* `\java -jar ServerLAB-1.0-SNAPSHOT.jar`, per avviare il jar. 

* `cd {nome del percorso in cui è presente il file Client .jar}`;
* `\java -jar ClientLAB-1.0-SNAPSHOT.jar`, per avviare il jar. 

**MAC OS**
* `cd {nome del percorso in cui è presente il file Server .jar}`;
* `chmod +x ServerLAB-1.0-SNAPSHOT .jar`, per aggiungere permessi al file
* `java -jar ServerLAB-1.0-SNAPSHOT .jar`, per avviare il jar.

* `cd {nome del percorso in cui è presente il file Client .jar}`;
* `chmod +x ClientLAB-1.0-SNAPSHOT .jar`, per aggiungere permessi al file;
* `java -jar ClientLAB-1.0-SNAPSHOT .jar`, per avviare il jar.
---------------------------------------------------------------------------

## Extra
L'esecuzione dell'applicazione è supportata dal Manuale Utente, il file `pdf` può essere scaricato e visionato recandosi presso la cartella `documentazione/`.

--------------------------------------------------------------------------------------------------------------------------------------------------------------------