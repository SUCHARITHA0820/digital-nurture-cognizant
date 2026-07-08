# Country REST Service — Setup Instructions

This zip contains only the **new files** to drop into your existing
`spring-learn` Maven project. Copy each folder into the matching location
in your project (merge, don't overwrite existing files).

## Files included

```
src/main/java/com/cognizant/springlearn/model/Country.java
src/main/java/com/cognizant/springlearn/controller/CountryController.java
src/main/resources/applicationContext.xml
```

## Steps to integrate

1. **Copy the Java files** into your existing package structure:
   - `Country.java` → `src/main/java/com/cognizant/springlearn/model/`
   - `CountryController.java` → `src/main/java/com/cognizant/springlearn/controller/`

2. **Copy `applicationContext.xml`** into `src/main/resources/`.
   - If you already have an `applicationContext.xml`, just add the
     `<bean id="india" ...>` block into your existing file instead of
     overwriting it.

3. **Make sure the XML bean file is loaded** by Spring Boot. Add this
   annotation to your main application class (or any `@Configuration`
   class):

   ```java
   @ImportResource("classpath:applicationContext.xml")
   ```

4. **Run the application** and test:

   ```
   GET http://localhost:8083/country
   ```

   Expected response:

   ```json
   {
     "code": "IN",
     "name": "India"
   }
   ```

5. **Check response headers** (for the SME walkthrough):
   - Browser: DevTools → Network tab → click the `country` request → Headers tab
   - Postman: send the GET request → click the "Headers" tab below the response body
   - Look for `Content-Type: application/json` — proof that Spring's Jackson
     message converter serialized the `Country` bean into JSON.
