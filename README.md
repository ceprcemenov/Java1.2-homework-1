# Отчет о тестировании приложения Money Transfer

## Краткое описание

16.02.2020 было создано и протестировано java-приложение с рабочим названием Money Transfer. 
В качестве тестовых данных заказчиком предложены следующие:
* текущий баланс счёта клиента - переменная типа `int`, значение - 2_000_000_000 (два миллиарда рублей)*
* сумма перевода - переменная типа `int`, значение - 500_000_000 (пятьсот миллионов рублей)
* переменная для хранения итогового значения - тип `int`

Переменные, использованные для приложения:
* deposit, тип `int` - текущий баланс;
* incoming_transfer, тип `int` - сумма перевода;
* deposit_new, тип `int` - итоговое значение.

Вычисления проводились по формуле:
```
deposit_new = deposit + incoming_transfer
```

Требовалось протестировать поведение приложения с такими данными. В данном отчете описаны использованные тест-кейсы, приведены результаты тестирования и сформулированы рекомендации для дальнейшего развития приложения.

## Описание тестов

Всего было проведено 5 тестов - smoke-тест приложения, и далее 4 функциональных теста методом белого ящика с использованием эквивалентных значений:

1. (passed) smoke-тест - в качестве входных данных использованы deposit=2, incoming_transfer=2. Приложение вернуло в качестве результата deposit_new=4;
1. (failed) всем переменным назначен тип `int`. Ожидаемый результат 2 500 000 000, фактический -1 794 967 296;
1. (passed) всем переменным назначен тип `long`. Ожидаемый результат 2 500 000 000, фактический 2 500 000 000;
1. (failed) переменным deposit и incoming_transfer назначен тип `int`, deposit_new - тип `long`. Ожидаемый результат 2 500 000 000, фактический -1 794 967 296;
1. (passed) переменной deposit назначен тип `int`, а переменным incoming_transfer и deposit_new - тип `long`. Ожидаемый результат 2 500 000 000, фактический 2 500 000 000;

## Итоги 

1. пройдено успешно 3 из 5 тестов (60%) 
2. Ссылки на баг-репорты
3. В процессе тестирования изучена особенность Java производить операции с разными типами данных, например два `int` не складываются в `long`, хотя, если один из операндов имеет тип `long`, а второй `int`, Java корректно обработает такое действие и правильно запишет результат в переменную с назначенным типом `long`. Вывод - аккуратно следить за типами переменных.

## Общие рекомендации

В процессе тестирования обнаружено несоответствие выбранного заказчиком типа для хранения данных `int`, т.к. реальные суммы депозитов или/и переводов могут превысить границы типа `int` - 2 147 483 647. В данной ситуации следует использовать тип `long`, позволяющий хранить значения до 9 223 372 036 854 775 807 (9 квинтиллионов 223 квадриллиона 372 триллиона 36 миллиардов 854 миллиона 775 тысяч 807) денежных единиц.
 




