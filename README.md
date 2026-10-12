# PrimoBottone

Piccola applicazione didattica realizzata per sperimentare
le basi di JavaFX: creazione di un'interfaccia, gestione degli
eventi, personalizzazione con CSS, riproduzione audio e animazioni.

Il progetto permette inoltre di esercitarsi nella compilazione
e nell'esecuzione di un'applicazione Java fuori da Eclipse,
utilizzando Maven e Maven Wrapper, e nella preparazione di
un pacchetto eseguibile per Windows.

## Funzionalità

Premendo il bottone:
- viene riprodotto un applauso;
- compare un messaggio di congratulazioni;
- vengono generati coriandoli animati nella finestra principale.

L'aspetto della finestra e del bottone è personalizzato con CSS.

## Tecnologie

- Java, con compilazione configurata per Java 17.
- JavaFX 21.0.12.
- Maven 3.10.0 tramite Maven Wrapper.

## Requisiti per eseguire dai sorgenti

- JDK 17 o successivo compatibile.
- Variabile d'ambiente `JAVA_HOME` impostata sulla cartella del JDK.
- Connessione Internet al primo utilizzo per scaricare
  Maven e le dipendenze.

Non è necessario installare manualmente Maven o JavaFX:
il Wrapper recupera Maven e Maven scarica le dipendenze
dichiarate nel `pom.xml`.

Compilazione e avvio verificati su Windows 11 con JDK 20.0.2.

## Avvio su Windows

Aprire PowerShell nella cartella che contiene `pom.xml`
ed eseguire:

```powershell
.\mvnw.cmd javafx:run
```

## Compilazione

Per compilare senza avviare l'applicazione:

```powershell
.\mvnw.cmd compile
```

Maven genera i risultati nella cartella `target`,
esclusa dal repository tramite `.gitignore`.

## Struttura del progetto

```text
PrimoBottone/
├── .mvn/wrapper/
├── src/main/
│   ├── java/
│   │   ├── module-info.java
│   │   └── application/Main.java
│   └── resources/application/
│       ├── application.css
│       └── applauso.wav
├── .gitignore
├── mvnw
├── mvnw.cmd
└── pom.xml
```

## Pacchetto Windows

Il progetto è stato anche confezionato con `jpackage`
come applicazione Windows con runtime Java incluso.

Il pacchetto completo permette di avviare l'applicazione
senza installare separatamente Java o Maven.
L'EXE deve essere mantenuto insieme alle cartelle
che accompagnano il pacchetto.

## Risorsa audio

Applauso: “Applause about 25-50 people #1” di Joseph Sardin,
distribuito da BigSoundBank sotto CC0.

Fonte: https://bigsoundbank.com/applaudissements-25-50-pers-1-s0812.html

Licenza: https://creativecommons.org/publicdomain/zero/1.0/