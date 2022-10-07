# AirGnSAssignment (UI)

##  Short description about the framework :

I created the framework in Java as a **Cucumber/BDD** framework along with Gherkin language in feature files.



### Tools used :



Tools | Purpose

------------ | -------------

Java | Main language

Maven | Build management tool to manage dependencies

Intellij | IDE

Cucumber | BDD Framework (Added as a dependency and as a plugin)

Gherkin | Used in feature files for scenarios (Added as plugin in IDE )

JUnit | For assertions and annotations

Git&Github | Version Control System

Maven cucumber reporting | Generate reports


### Design :



Design of the framework is Cucumber Behavior Driven Development framework. 



* **runners**

   - Runner classes are where I execute testing via Cucumber Options.  It includes **CukesRunner** and **FailedRunner**(to run failed cases) classes.

   - I am holding and managing some cucumber option features like **plugin**,**features**,**glue**,**tags**,**publish** etc.

* **step_definitions**

   - Step Definition classes are in step_definitons package and keeps respective behavioral steps regarding Feature File which is in resources directory. 

* **utilities**

   - Utilities package in which I store **BrowserUtils**(common methods in order to call when needed), **ConfigurationReader**(to read baseurls,keys etc. from configuration.properties), **Driver**(singleton design pattern is implemented to use same driver instance in entire framework etc), **ButtonGenerator**(includes all click actions for avoiding code smells), **TestDataGenerator**(generate random alphanumerics) classes has common ready methods that I’m implementing during creating test scripts.

* **resources**

   - features

     - Feature File represents the scenarios written in Gherkin language from end-user perspective. 

* **configuration.properties**

   - Configuration properties file is keeping data based on key and value structure.

  

- **Maven** is used as a build management tool and it helps me to manage the dependencies.


- **Git&Github** is used as VCS.

 ### Instructions to run :



**Start the application**


You can run the application based on the instructions that provided in the assignment readme file.
































