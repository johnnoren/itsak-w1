# Exercise week 1

## Uppgift: OWASP Top 10 Sårbarhetsutmaning för Java-utvecklare (2021)

### Syfte:
Att få en djupare förståelse för säkerhetsrisker inom webbutveckling genom att skapa och sedan åtgärda exempel på två vanliga sårbarheter enligt OWASP Top 10 (2021).

### Instruktioner:

1. **Val av sårbarheter:** 
   - Välj två sårbarheter från OWASP Top 10 (2021)-listan. Nedan nämnda sårbarheter är bara exempel, och ni är fria att välja vilka som helst från listan som ni finner intressanta att utforska:
     - **A03:2021** - Injection (Inklusive Cross-site Scripting)
     - **A02:2021** - Cryptographic Failures

2. **Skapa en sårbar webbapplikation (EXEMPEL):** 
   - Använd Java (till exempel med Spring Boot eller JSP/Servlets) för att utveckla en enkel webbapplikation som demonstrerar dessa två sårbarheter.
     - För **Injection:** Skapa en inloggningssida eller ett sökfält där indata hanteras på ett osäkert sätt, så att det är möjligt att utföra en injektionsattack.
     - För **Cryptographic Failures:** Lagra användares lösenord i klartext i databasen och visa en administrativ sida där dessa lösenord kan läsas av de som har tillgång till sidan, utan någon form av autentisering eller auktorisering.

3. **Dokumentera sårbarheterna:** 
   - När ni har implementerat sårbarheterna, skapa en rapport som beskriver:
     - Hur sårbarheten kan utnyttjas
     - Vilka potentiella risker den för med sig
     - Exempel på attacker mot den sårbara applikationen (screenshots, beskrivningar, etc.)
   - Rekommenderas att inkludera relevanta CWE-nummer i er dokumentation när det är lämpligt.

4. **Åtgärda sårbarheterna:** 
   - När ni har demonstrerat och dokumenterat sårbarheterna, arbeta tillsammans som grupp för att korrigera dessa sårbarheter i er kod. Implementera best practices för att förhindra dessa typer av attacker i framtiden.

<div style="page-break-after: always;"></div>

5. **Presentation:** 
   - Förbered en presentation för klassen där ni:
     - Demonstrerar sårbarheten och hur den kan utnyttjas
     - Visar hur ni åtgärdade sårbarheten
     - Diskuterar lärandepunkter från övningen
   
   > **Observera:** Läraren kommer att välja ut några grupper som får presentera sina resultat för hela klassen.

### Bedömning:
Ni kommer att bedömas enligt följande kriterium (IG/G).

### Tidsram:
Arbetsvecka från `2023-08-21` till `2023-08-25` (måndag - fredag).

**Lycka till!**
