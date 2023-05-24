# Test automation framework for CiproBet



##### Run authentication-registration  tests on dev environment
example:
```bash
mvn -DsuiteXmlFile=login.xml -P dev,headless_enabled tests
```

##### Run authentication-registration tests on dev environment
example:
```bash
mvn -DsuiteXmlFile=registration.xml -P dev,headless_enabled tests
```

##### Run homeUI tests on dev environment
example:
```bash
mvn -DsuiteXmlFile=homeUI.xml -P dev,headless_enabled tests
```
