Stappenplan
===================
Voor deze workshop gaat er met sockets gewerkt worden. Er zal een Android applicatie gemaakt worden en deze applicatie zal via sockets gaan communiceren met een webserver.

De basis doelstelling is het de bedoeling om je naam via een socketverbinding te versturen naar de webserver. Als extra zou het leuk zijn om te chatten met iedereen die een socketverbinding heeft op de webserver

> **De volgende benodigdheden nodig:**

> - Android Studio.
> - Template project van deze repository

Het template project bevat de layout die benodigd is voor deze workshop. De functionaliteit moet zelf geïmplementeerd worden. 

De URL voor de webserver is: http://node156.tezzt.nl:3001

----------
Basis doelstelling: naam versturen naar de webserver
-------------
Stap 1: Zorg ervoor dat de applicatie gebruik kan maken van een **internetverbinding**.

Stap 2: Maak een Socket van **Socket.IO** in de activity.

Stap 3: De juiste **URL** voor de Socket moet gezet worden.

Stap 4a: Vang je naam op van de **AlertDialog**.

Stap 4b: Er moet een **emit** gestuurd worden naar het event "register" op de webserver met jouw naam.

----------
Extra doelstelling: chatten met de webserver
-------------

Stap 1: Gebruik een **ArrayAdapter** voor de listView.

Stap 2: De Socket moet luisteren(**on**) naar het volgende event "chat" en de ArrayAdapter updaten.

Stap 3.a: Om een bericht te versturen moet de **click** van de button opgevangen worden.

Stap 3.b: Nu moet er een **emit** gestuurd worden naar het event "chat" op de webserver met jouw bericht uit het textfield.

----------
