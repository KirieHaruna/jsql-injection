## Description
**jSQL Injection** is a lightweight application used to find database information from a distant server with speed.

It is **free**, **open source** and **cross-platform** (Windows, Linux, Mac OS X).

![Kali Linux logo](https://github.com/ron190/jsql-injection/raw/master/web/images/kali_favicon.png "Kali Linux logo") jSQL Injection is also part of the official penetration testing distribution [Kali Linux](http://www.kali.org/) and is included in other distributions like [Pentest Box](https://pentestbox.com/), [Parrot Security OS](https://www.parrotsec.org), [ArchStrike](https://archstrike.org/) or [BlackArch Linux](http://www.blackarch.org/).

This software is developed using open source libraries like [Spring](https://spring.io), [Spock](http://spockframework.org) and [Hibernate](https://hibernate.org), and it uses platform [Travis CI](https://travis-ci.org) for continuous integration.

Each program update is tested in the cloud on Travis CI using Java version 8 through 13, and against various MySQL, PostgreSQL and H2 databases. Source code is open to pull request and to any contribution about multi-threading, devops, optimization, unit and integration tests. 

[![Twitter Follow](https://img.shields.io/twitter/follow/ron190jsql.svg?style=social&label=ron190)](https://twitter.com/ron190jsql)<br>
[![Java 8 to 13](https://img.shields.io/badge/Java-8%20to%2013-orange)](http://www.oracle.com/technetwork/java/javase/downloads/)
[![JUnit 5](https://img.shields.io/badge/JUnit-5-50940f)](http://junit.org)
[![Maven 3.1](https://img.shields.io/badge/Maven-3.1-a2265a)](https://maven.apache.org/)
[![GitHub](https://img.shields.io/github/license/ron190/jsql-injection)](http://www.gnu.org/licenses/old-licenses/gpl-2.0.html)<br>
[![Travis Build Status](https://travis-ci.org/ron190/jsql-injection.svg?branch=master)](https://travis-ci.org/ron190/jsql-injection)
[![Sonar Status](https://sonarcloud.io/api/project_badges/measure?project=jsql-injection%3Ajsql-injection&metric=alert_status)](https://sonarcloud.io/dashboard?id=jsql-injection%3Ajsql-injection)
[![Sonar Test Count](https://img.shields.io/sonar/total_tests/jsql-injection%3Ajsql-injection?server=https%3A%2F%2Fsonarcloud.io)](https://sonarcloud.io/dashboard?id=jsql-injection%3Ajsql-injection)<br>
[![Codecov](https://codecov.io/gh/ron190/jsql-injection/branch/master/graph/badge.svg)](https://codecov.io/gh/ron190/jsql-injection)
[![Codacy Badge](https://api.codacy.com/project/badge/Coverage/e7ccb247f9b74d489a1fa9f9483c978f)](https://www.codacy.com/manual/ron190/jsql-injection?utm_source=github.com&utm_medium=referral&utm_content=ron190/jsql-injection&utm_campaign=Badge_Coverage)
[![Codebeat badge](https://codebeat.co/badges/457d8c76-c470-4457-ad06-310a6d8b4b3e)](https://codebeat.co/projects/github-com-ron190-jsql-injection-master)

## Features
- Automatic injection of 23 kinds of databases: Access, CockroachDB, CUBRID, DB2, Derby, Firebird, H2, Hana, HSQLDB, Informix, Ingres, MaxDB, Mckoi, MySQL, Neo4j, NuoDB, Oracle, PostgreSQL, SQLite, SQL Server, Sybase, Teradata and Vertica
- Multiple injection strategies: Normal, Error, Blind and Time
- Multiple injection structures: Standard, Zipped, Dump In One Shot
- SQL injection expressions programming at runtime
- JavaScript/Java tampering methods programming at runtime
- Injection of multiple targets
- Search for administration pages
- Creation and visualization of Web shell and SQL shell
- Read and write files on host using injection
- Bruteforce of password's hash
- Encode and decode a string

## Installation [[jsql-injection-v0.82.jar](https://github.com/ron190/jsql-injection/releases/download/v0.82/jsql-injection-v0.82.jar)]
Install [Java 8](http://java.com) up to Java 13, then download the latest [release](https://github.com/ron190/jsql-injection/releases/) and double-click on the file `jsql-injection-v0.82.jar` to launch the software.<br>
You can also type `java -jar jsql-injection-v0.82.jar` in your terminal to start the program.<br>
If you are using Kali Linux then get the latest release using command `sudo apt-get -f install jsql`, or make a system full upgrade with `apt update` then `apt full-upgrade`.

## [[Test-bed scripts](https://github.com/ron190/jsql-injection/tree/master/web/test-bed)]
Use the sample scripts to test injection on your local environment. First install a development environment like [EasyPHP](http://www.easyphp.org), then download the [test-bed PHP scripts](https://github.com/ron190/jsql-injection/tree/master/web/test-bed) and place them into `www/`.
```php
<?php
# http://127.0.0.1/mysql/strategy/get-normal.php?id=0

$link = mysqli_connect('localhost', 'root', '', 'my_database');

$result = $link->query("SELECT col1, col2 FROM my_table where id=$_GET[id]");

while ($row = $result->fetch_array($result, MYSQLI_NUM))
    echo join(',', $row);
```


## Screenshots and [[video](https://youtu.be/ZZkQRE3OL8E)]
[![Default](https://github.com/ron190/jsql-injection/raw/master/web/images/v0.75/default-mini.png "Default")](https://github.com/ron190/jsql-injection/raw/master/web/images/v0.75/default.png)
[![Database](https://github.com/ron190/jsql-injection/raw/master/web/images/v0.75/database-mini.png "Database")](https://github.com/ron190/jsql-injection/raw/master/web/images/v0.75/database.png)
[![SQL Engine](https://github.com/ron190/jsql-injection/raw/master/web/images/v0.78/sqlengine-mini.png "SQL Engine")](https://github.com/ron190/jsql-injection/raw/master/web/images/v0.78/sqlengine.png)
[![Batch scan](https://github.com/ron190/jsql-injection/raw/master/web/images/v0.75/scan-mini.png "Batch scan")](https://github.com/ron190/jsql-injection/raw/master/web/images/v0.75/scan.png)
[![Web shell](https://github.com/ron190/jsql-injection/raw/master/web/images/v0.75/webshell-mini.png "Web shell")](https://github.com/ron190/jsql-injection/raw/master/web/images/v0.75/webshell.png)
[![SQL shell](https://github.com/ron190/jsql-injection/raw/master/web/images/v0.75/sqlshell-mini.png "SQL shell")](https://github.com/ron190/jsql-injection/raw/master/web/images/v0.75/sqlshell.png)
[![Panels](https://github.com/ron190/jsql-injection/raw/master/web/images/v0.75/panels-mini.png "Panel")](https://github.com/ron190/jsql-injection/raw/master/web/images/v0.75/panels.png)
[![Admin page](https://github.com/ron190/jsql-injection/raw/master/web/images/v0.75/admin-mini.png "Admin page")](https://github.com/ron190/jsql-injection/raw/master/web/images/v0.75/admin.png)
[![File](https://github.com/ron190/jsql-injection/raw/master/web/images/v0.75/file-mini.png "File")](https://github.com/ron190/jsql-injection/raw/master/web/images/v0.75/file.png)
[![Upload](https://github.com/ron190/jsql-injection/raw/master/web/images/v0.75/upload-mini.png "Upload")](https://github.com/ron190/jsql-injection/raw/master/web/images/v0.75/upload.png)
[![Bruteforce](https://github.com/ron190/jsql-injection/raw/master/web/images/v0.75/bruter-mini.png "Bruteforce")](https://github.com/ron190/jsql-injection/raw/master/web/images/v0.75/bruter.png)
[![Coder](https://github.com/ron190/jsql-injection/raw/master/web/images/v0.75/coder-mini.png "Coder")](https://github.com/ron190/jsql-injection/raw/master/web/images/v0.75/coder.png)

## [[Roadmap](https://github.com/ron190/jsql-injection/projects)]
`Burp integration, Crawler, Database: Netezza, Full Path Disclosure, Injection strategies: DIOS RoutedQuery OOB, Dictionnary attack, WAF detection.`

## In progress
`Tampering.`

## Since latest release
`Test-bed scripts for php5 and php7 shared on Github, SOAP injection, Fix multi-params injection, Fix adding items to Scan list, Fix translation dialog`

## Change log

**v0.82** `Tampering options, Refactoring for Cloud and multithreading compatibility`

**v0.81** `Test all parameters including JSON, Parse forms and Csrf tokens, Databases: CockroachDB Mckoi Neo4j NuoDB Hana and Vertica, Translation complete: Russian, Chinese`

**v0.79** `Error Strategies for MySQL and PostgreSQL compatible with Order/Group By, Wider range of Characters Insertion including multibyte %bf`

**v0.78** `SQL Engine, MySQL Error strategy: DOUBLE, Translations: es pt de it nl id, 18 Database flavors including Access`

**v0.76** `Translation: cz, 17 Database flavors including SQLite`

**v0.75** `URI injection point, Source code mavenification, Upgrade to Java 7`

**v0.73** `Authentication: Basic Digest Negotiate NTLM and Kerberos, Database flavor selection`

**v0.7** `Scan multiple URLs, Github Issue reporter, 16 Database flavors including Cubrid Derby H2 HSQLDB MariaDB and Teradata`

**alpha-v0.6** `Speed x2: No more hex encoding, 10 Database flavors including MySQL Oracle SQLServer PostgreSQL DB2 Firebird Informix Ingres MaxDb and Sybase, JUnit tests, Log4j, GUI translation`

**0.5** `SQL Shell, File Uploader`

**0.4** `Admin page finder, Bruteforce hashes like MD5 and MySQL, Encode and decode string with methods like Base64, Hex and MD5`

**0.3** `File injection, Web Shell with integrated CLI, Persistence of application parameters, Update checker`

**0.2** `Strategy Time, Multi-thread control: Start Pause Resume and Stop, Log URL calls`

**0.0-0.1** `Method GET POST Header and Cookie, Strategies Normal Error and Blind, Best strategy selection, Progression bars, Simple evasion, Proxy settings, MySQL only`

## Disclaimer
Attacking web-server is illegal without prior mutual consent. The end user is responsible and obeys all applicable laws.
Developers assume no liability and are not responsible for any misuse or damage caused by this program.
