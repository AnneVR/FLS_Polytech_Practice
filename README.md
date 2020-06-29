# FLS_Polytech_Practice
FLS Политех НИР + практика 2019-2020

# Исследование данных
Используемые данные:

      "SK_ID_CURR",             айди человека
      "TARGET",                 0 1 - обманул или нет 
      "NAME_CONTRACT_TYPE",     то как он получил деньги 
      "CODE_GENDER",            пол
      "FLAG_OWN_CAR",           есть ли машина
      "FLAG_OWN_REALTY",        есть ли у него недвижимость
      "CNT_CHILDREN",           сколько у него детей
      "AMT_INCOME_TOTAL",       суммарный доход
      "AMT_CREDIT",             суммарный размер его кредитов
      "AMT_ANNUITY",            сколько денег заплатит за год
      "AMT_GOODS_PRICE",        сколько стоят товары на которые он взял деньги
      "NAME_TYPE_SUITE",        кто пришел с ним оформлять кредит
      "NAME_INCOME_TYPE",       каким образом зарабатывает
      "NAME_EDUCATION_TYPE",    какое у него образование
      "NAME_FAMILY_STATUS",     семейное положение
      "NAME_HOUSING_TYPE",              какой тип жилья
      "REGION_POPULATION_RELATIVE",     средняя плотность населения там где он живет
      "DAYS_BIRTH",                     сколько дней со дня рождения
      "DAYS_EMPLOYED",                  сколько дней прошло с момента последнего трудоустройства
      "DAYS_REGISTRATION",              сколько дней с регистрации
      "DAYS_ID_PUBLISH",                сколько дней получил паспорт
      "OWN_CAR_AGE",                    сколько лет его машине
      "FLAG_MOBIL",                     есть ли телефон
      "FLAG_CONT_MOBILE",               когда ему звонили взял ли он сам трубку
      "FLAG_EMAIL",                     оставил ли почту
      "OCCUPATION_TYPE",                род занятий
      "CNT_FAM_MEMBERS",                количество 
      "REGION_RATING_CLIENT",           оценка региона где он живет по шкале какой-то
      "REGION_RATING_CLIENT_W_CITY",    оценка города 
      "WEEKDAY_APPR_PROCESS_START",     день недели когда он пришел подавать заявление
      "HOUR_APPR_PROCESS_START",        час когда он пришел подавать заявление
      "REG_REGION_NOT_LIVE_REGION",     указаный адесс не совпадает с адресом проживания
      "REG_REGION_NOT_WORK_REGION"      указаный адресс не совпадает с адресом работы




# МЕТРИКИ (ключ, значение) -> ключ из словаря (ключ, значение)

"NAME_CONTRACT_TYPE"                сколько стоят в среднем товары которые для каждого типа
"CODE_GENDER"                       процент добросовестности у трех самых популярных профессий у мужчин и у женщин
"NAME_TYPE_SUITE"                   ----
"NAME_INCOME_TYPE"                  процент добросовестности  у десяти самых распространенных
"NAME_EDUCATION_TYPE"               процент добросовестности для каждого типа образование
"NAME_FAMILY_STATUS"                ----
"NAME_HOUSING_TYPE"                 процент добросовестности у трех самых популярных мест проживания
"OCCUPATION_TYPE"                   процент добросовестности для первых 20 самых добросовестностных работ и для других
"WEEKDAY_APPR_PROCESS_START"        график обмана по дням недели

# Таблицы

1: таблица dl_analytics_contract_type           словарь dl_dict_contract_type
2: таблица dl_analytics_gender                  словарь dl_dict_gender
3: таблица dl_analytics_income_type             словарь dl_dict_income_type
4: таблица dl_analytics_education_type          словарь dl_dict_education_type
5: таблица dl_analytics_housing_type            словарь dl_dict_housing_type
6: таблица dl_analytics_occupation_type         словарь dl_dict_occupation_type
7: таблица dl_analytics_day_of_week_applied     словарь dl_dict_day_of_week_applied
