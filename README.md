# AutomationSetelAssessment
Setel Assessment for Web Automation task

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Platform: Windows](#platform-windows)
* [Install](#install)

## General info
This project is a simple web automation task. AutomationSetelAssessment is used to Automate search product in 2 E-commerce website and sort the product in ascending order.
	
## Technologies
Project is created with:
* Eclipse Version: 2021-12 (4.22.0)
* JavaSE- 1.8 (jdk-17.0.1)
* ChromeDriver version 97.0.4692.36

## Platform: Windows
ChromeDriver used: If this versions becomes outdated or gives problem download the latest version from [Download Link](https://chromedriver.chromium.org/downloads).

## Install
**Download Java SE Development Kit 17.0.1**
1. Link to download - [Download Java](https://www.oracle.com/java/technologies/downloads/).
2. Install the Java Development Kit

**Download Eclipse IDE**
1. Link to download - [Download Eclipse](https://www.eclipse.org/downloads/).
2. Install the Eclipse

**Download Selenium Server (Grid) and Selenium Clients and WebDriver Language Bindings**
1. Link to download - [Download Selenium](https://www.selenium.dev/downloads/).
2. Download selenium-server-4.1.1.jar
3. Download selenium-java-4.1.0.zip

**Download ChromeDriver**
1. Link to download - [Download ChromeDriver](https://chromedriver.chromium.org/downloads).
2. After finish downloaded the driver - Save the folder location of the driver

**Setup Project using Eclipse IDE**
1. Go to File > New > Java Project 
2. Input Project name > In JRE section select JavaSE- 1.8 > Click Finish

**Add jar file**
1. Right-click on the created project name > Build Path > Configure Build Path...
2. Go to Libraries tab > Click Add External JARs...
3. Add selenium-server-4.1.1.jar and selenium-java-4.1.0.zip that has been downloaded > Click OK

**Create Folder for Chrome Driver**
1. Right-click on the created project name > New > Folder
2. Input the Folder name > Click Finish
3. Find the downloaded chromedriver and copy the chromedriver.exe and paste into the created folder in Eclipse
