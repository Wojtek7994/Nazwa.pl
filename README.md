# Nazwa.pl

Przedmiotem Testów jest sprawdzenie funkcjonalności logowania do serwisu nazwa.pl

Testy zostały przeprowadzone w aplikacji IntelliJ ver 2021.3, na systemi Windows 10 ver 10.0.19043.1348
Do testów zostały użyte takie biblioteki jak. 

-JUnit 
-Selenium Web Driver
-Maven
-ChromeDriver

Testy były pisane w języku Java OpenJDK ver 17.0.1

Przed rozpoczęciem pisania testów stworzyłem konto testowe w serwisie. 

Zaproponowałem kilka przypadków testowych

-Logowanie z poprawnymi danymi ( poprawny login, poprawne hasło )
-Logowanie z niepoprawnymi danymi ( niepoprawny login, niepoprawne hasło ) 
-Logowanie z częściowo popranymi danymi ( poprawny login, niepoprawne hasło) 
-Logowanie z częściowo niepoprawnymi danymi ( niepoprawny login, poprawne hasło) 

Podczas testowania z danymi poprawnymi, serwis przepuszczał nas do kolejnego kroku jakim jest weryfikacja dwuetapowa.
Założyłem, że przeniesienie do tego kroku pokazuje że dane, które podałem są prawidłowe i jesteśmy zalogowani. Wiem że nie jest to do końca zgodne z prawdą bo po to jest ten drugi etap weryfikacji ale nie miałem dostępu do jakiegoś zewnętrznego serwisu, który umożliwił by mi łatwiejsze przejście tego kroku więc stwierdziłem że dane są poprawne i test jest ok. 
Z tytułu tego, że testy wykonywałem kilkanaście razy strona prosiła mnie również o to, żebym potwierdził że nie jestm robotem przez  reCAPTCHA jak pewnie będzie widoczne w moim teście, dorzuciłem w nim warunek który po pojawieniu się reCAPTCHA daje nam test pozytywny. 

Zdaję sobie sprawę, że jest jeszcze kilka innych przypadków testowych dla PANELU LOGOWANIA jednak stwierdziłem, że przetestuję te najbardziej popularne.
