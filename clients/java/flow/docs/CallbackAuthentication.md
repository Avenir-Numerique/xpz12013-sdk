

# CallbackAuthentication

The authentication mode required for the callback call

## oneOf schemas
* [BasicAuthentication](BasicAuthentication.md)
* [OAuth2Authentication](OAuth2Authentication.md)

## Example
```java
// Import classes:
import fr.neotimo.xpz12013.flow.model.CallbackAuthentication;
import fr.neotimo.xpz12013.flow.model.BasicAuthentication;
import fr.neotimo.xpz12013.flow.model.OAuth2Authentication;

public class Example {
    public static void main(String[] args) {
        CallbackAuthentication exampleCallbackAuthentication = new CallbackAuthentication();

        // create a new BasicAuthentication
        BasicAuthentication exampleBasicAuthentication = new BasicAuthentication();
        // set CallbackAuthentication to BasicAuthentication
        exampleCallbackAuthentication.setActualInstance(exampleBasicAuthentication);
        // to get back the BasicAuthentication set earlier
        BasicAuthentication testBasicAuthentication = (BasicAuthentication) exampleCallbackAuthentication.getActualInstance();

        // create a new OAuth2Authentication
        OAuth2Authentication exampleOAuth2Authentication = new OAuth2Authentication();
        // set CallbackAuthentication to OAuth2Authentication
        exampleCallbackAuthentication.setActualInstance(exampleOAuth2Authentication);
        // to get back the OAuth2Authentication set earlier
        OAuth2Authentication testOAuth2Authentication = (OAuth2Authentication) exampleCallbackAuthentication.getActualInstance();
    }
}
```


