# Exceptions.Login-Password
программа проверяет корректность введенных данных логина и пароля

Создан новый класс и в нем — статический метод, который принимает на вход три параметра: login, password и confirmPassword.
Вводные по данным:
Логин содержит в себе только латинские буквы, цифры и знак подчеркивания.
Длина логина может быть от 1 до 20 символов. Если логин не указан или длиннее заданной формы, содержит в себе другие знаки, то нужно выбросить 
WrongLoginException
.
Password содержит в себе только латинские буквы, цифры и знак подчеркивания. Длина password может быть от 1 до 20 символов. Password и confirmPassword должны быть равны. Если password не указан или длиннее заданной формы, содержит в себе другие знаки, password и confirmPassword не равны, то нужно выбросить 
WrongPasswordException
.
WrongPasswordException
 и 
WrongLoginException
 — пользовательские классы исключения с двумя конструкторами: один по умолчанию, второй принимает сообщение исключения и передает его в конструктор класса 
Exception
.
