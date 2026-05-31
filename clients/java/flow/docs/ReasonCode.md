

# ReasonCode

A predefined set of reason code values + ability to extend this set

## oneOf schemas
* [ReasonCodeEnum](ReasonCodeEnum.md)
* [String](String.md)

## Example
```java
// Import classes:
import fr.neotimo.xpz12013.flow.model.ReasonCode;
import fr.neotimo.xpz12013.flow.model.ReasonCodeEnum;
import fr.neotimo.xpz12013.flow.model.String;

public class Example {
    public static void main(String[] args) {
        ReasonCode exampleReasonCode = new ReasonCode();

        // create a new ReasonCodeEnum
        ReasonCodeEnum exampleReasonCodeEnum = new ReasonCodeEnum();
        // set ReasonCode to ReasonCodeEnum
        exampleReasonCode.setActualInstance(exampleReasonCodeEnum);
        // to get back the ReasonCodeEnum set earlier
        ReasonCodeEnum testReasonCodeEnum = (ReasonCodeEnum) exampleReasonCode.getActualInstance();

        // create a new String
        String exampleString = new String();
        // set ReasonCode to String
        exampleReasonCode.setActualInstance(exampleString);
        // to get back the String set earlier
        String testString = (String) exampleReasonCode.getActualInstance();
    }
}
```


