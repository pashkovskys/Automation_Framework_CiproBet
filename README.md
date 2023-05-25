# Test automation framework for CiproBet



##### Run login tests on dev environment
example:
```bash
mvn -DsuiteXmlFile=login.xml -P dev,headless test
```

##### Run authentication-registration tests on dev environment
example:
```bash
mvn -DsuiteXmlFile=registration.xml -P dev,headless test
```

##### Run homeUI tests on dev environment
example:
```bash
mvn -DsuiteXmlFile=homeUi.xml -P dev,headless test
```
