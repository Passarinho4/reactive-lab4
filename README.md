# reactive-lab4
Akka persistence examples

Polecam przepisać na commands and events całą FSM Auction. Można to zrobić dużo fajniej, ale cóż.. Może kiedyś. 
Testy performance to już wgl jakaś farsa w tym wydaniu, ale może przejdzie. 

(20 pkt) Proszę dodać persystencję dla aktora Auction
Auction zapisuje zdarzenia reprezentujące aktualny stan aukcji oraz zmiany kontekstu aktora (przejścia).
W dzienniku zdarzeń należy zapisać też czas trwania aukcji, a przy odtwarzaniu stanu aktora (komunikat RecoveryCompleted) uwzględnić ten czas przy ustalaniu nowego BidTimer.

(10 pkt) Przetestować scenariusz, w którym przed upływem końca aukcji aplikacja zostaje wyłączona (np. poprzez system.shutdown()). Po ponownym uruchomieniu aplikacji stan aktorów Auction powinien być odtworzony z dziennika, natomiast aktorzy Seller, Buyer oraz AuctionSearch mogą być zainicjalizowani od nowa. Kupujący powinni powrócić do licytowania zgodnie ze swoją strategią. Proszę sprawdzić, czy wielokrotne przerywanie i ponowne uruchamianie systemu aktorów umożliwia kontunuowanie licytacji.

(10 pkt) Proszę porównać wydajność różnych mechanizmów persystencji (np. LevelDB z opcją native = true/false, InMemory, itp., lista wtyczek) i oszacować średni czas zapisu/odczytu zdarzenia.
