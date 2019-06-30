# ExerciseAmazon

Para correr o exercício deve ter instalado o Java Running Enviornment 8. <br>
Na linha de comandos executar a linha a baixo.<br>
<br>
java -jar ExerciseAmazon.jar <br>
<br><br>
Por pré-definição a aplicação executa o Firefox em modo headless (sem GUI). Para alterar o browser ou o modo podemos 
passar os argumentos "firefox" ou "chrome" para escolher o browser. E "yes" ou "no" para executar em modo headless ou 
não. <br><br>
java -jar ExerciseAmazon.jar chrome <br>
java -jar ExerciseAmazon.jar yes <br>
java -jar ExerciseAmazon.jar firefox yes <br>
<br><br>
Para alguns dos testes é necessário a existencia de uma conta na Amazon, essa conta deve ser configurada no ficheiro 
"setting.xml". Este ficheiro deve estar na mesma pasta que o ficheiro ".jar". <br>
Devemos configurar os dados da seguinte forma: <br><br>
\<?xml version="1.0" encoding="UTF-8"?> <br>
\<user> <br>
    \<email>user@mail.com\</email> <br>
    \<pwd>password\</pwd> <br>
\</user> <br>
<br><br>
Two of the tests will create screen shots at the root folder of the aplication. For the Avenger suite the file is 
"videoScreenshot.png", for the brand search the file is "brandScreenshot.png". <br>
<br><br>
Para a aplicação correr também é necessário ter os drivers na pasta. O geckodriver é o driver para o Firefox, e o 
chromedriver para o Chrome. Existe para cada um deles uma versão windows e uma para linux, ao correr os testes com o 
IDE não devemos ter a versão linux e a windows no projecto. <br>
<br><br>
Se quisermos compilar a aplicação, devemos instalar a aplicação Maven. <br>
Na raiz do projecto executar o seguinte comando: <br>
mvn clean install <br>
Este comando vai compilar as classes, dependencias e criar uma pasta "target" e colocar nela dois ficheiros ".jar" da 
aplicação. <br>
Um desses ficheiros tem "-jar-with-dependencies" no nome, e é este que deve ser executado. <br>
<br><br>
<b>Aplicações</b><br>
Java 8u211 <br>
https://www.java.com/pt_BR/download/ <br>
<br>
Maven 3.6.1 <br>
http://maven.apache.org/download.cgi <br>
<br>
Selenium Java 3.141.59 <br>
https://www.seleniumhq.org/ <br>
<a href="https://bit.ly/2zm3ZzF">Download</a> <br>
<br>
Geckodriver 0.24.0 <br>
https://github.com/mozilla/geckodriver/releases <br>
<br>
ChromeDriver 75.0.3770.90 <br>
https://chromedriver.storage.googleapis.com/index.html?path=75.0.3770.90/ <br>