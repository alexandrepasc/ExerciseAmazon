# ExerciseAmazon

Durante o desenvolvimento dos testes, deparei-me com alguns problemas. <br><br>
O teste do trailer não consigo que corra com o Firefox, quando o browser chega à parte do vídeo avisa que está a 
instalar pluins para correr o vídeo, mas não os instala. <br><br>
A minha conta da Amazon não tem os requisitos para criar reviews a produtos, logo não consegui desenvolver o teste para 
esse Test Case. O teste "addCommentTest" foi desativado. <br><br>
Também tem havido contratempos com "captcha" no login, ecrãs para adicionar telemóvel esporadicamente, popups com 
publicidade a e-books. Não tenho conseguido prevenir todos estes problemas, o que faz que haja testes a falhar sem que 
realmente o componente em teste tenha problemas. <br><br>
Os testes têm corrido melhor com o Chrome e com GUI, com o Firefox, e em modo headless (em ambos os browsers) têm tido 
vários problemas. <br>
<br><br>
Este projeto foi desenvolvido em ambiente Windows, mas está preparado para também correr em Linux. Na descrição está 
descrito algumas alterações que se deve fazer. <br>
Este projecto tem uma release com versão Windows e Linux, pode ser feito o download na tab "releases" do projecto no 
GitHub. <br>
https://github.com/alexandrepasc/ExerciseAmazon/releases <br>
<br><br>
Para correr o exercício deve ter instalado o Java Running Enviornment 8. <br>
Na linha de comandos executar a linha a baixo.<br>
<br>
`java -jar ExerciseAmazon.jar` <br>
<br><br>
Por pré-definição a aplicação executa o Firefox em modo headless (sem GUI). Para alterar o browser ou o modo podemos 
passar os argumentos "firefox" ou "chrome" para escolher o browser. E "yes" ou "no" para executar em modo headless ou 
não. <br><br>
`java -jar ExerciseAmazon.jar chrome` <br>
`java -jar ExerciseAmazon.jar yes` <br>
`java -jar ExerciseAmazon.jar firefox yes` <br>
<br><br>
Para alguns dos testes é necessário a existencia de uma conta na Amazon, essa conta deve ser configurada no ficheiro 
"setting.xml". Este ficheiro deve estar na mesma pasta que o ficheiro ".jar". <br>
Devemos configurar os dados da seguinte forma: <br><br>
`<?xml version="1.0" encoding="UTF-8"?>` <br>
`<user>` <br>
    `<email>user@mail.com</email>` <br>
    `<pwd>password</pwd>` <br>
`</user>` <br>
<br><br>
Dois dos tests vão criar screen shots na pasta da aplicação. Para a suite do Avengers o ficheiro é "videoScreenshot.png"
, para a pesquisa por Brand o ficheiro é "brandScreenshot.png". <br>
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
Para além de compilar e criar os .jar, o Maven vai copiar para a pasta os ficheiros necessários para a execução da 
aplicação (drivers, e setting). <br>
Caso se queira compilar e executar em Linux devemos alterar os drivers para as versões compativeis com o SO 
(aplicações, versões e links descritos no final do documento). <br>
E alterar no ficheiro de configuração do maven ("pom.xml") as linhas que copiam estes ficheiros na compilação. <br>
`<plugin>` <br>
     `<groupId>org.apache.maven.plugins</groupId>` <br>
     `<artifactId>maven-antrun-plugin</artifactId>`<br>
     `<executions>`<br>
         `<execution>`<br>
             `(code...)` <br>
             `<configuration>`<br>
                 `<tasks>`<br>
                     `<echo>Using env.test.properties</echo>`<br>
                     `<copy file="setting.xml" tofile="${basedir}/target/setting.xml"/>`<br>
                     `<copy file="geckodriver.exe" tofile="${basedir}/target/geckodriver.exe"/>`<br>
                     `<copy file="chromedriver.exe" tofile="${basedir}/target/chromedriver.exe"/>`<br>
                 `</tasks>`<br>
             `</configuration>`<br>
         `</execution>`<br>
     `</executions>`<br>
`</plugin>`<br>
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
