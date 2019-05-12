package co.nz.wone;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import co.nz.wone.model.*;

import static co.nz.wone.jsonutils.JsonNodeBuilders.array;
import static co.nz.wone.jsonutils.JsonNodeBuilders.object;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testJsonNodeModifier()
    {
        CreateUser c = new co.nz.wone.jsonutils.JsonNodeModifiers<>(new CreateUser()).with($-> {
            $.setUserName("username");
            $.setCustCRSNo("12326446");
        }).modify();

        assertTrue( c.getUserName().equalsIgnoreCase("username") );
        assertTrue( c.getCustCRSNo().equalsIgnoreCase("12326446") );
    }

    public void testJsonNodeBuilder()
    {
       Object jsonObject = object("username", "varun").with("address", array(object("street", "tory st", "pin", "6011"))).end();
       String jsonString = object("username", "varun").with("address", array(object("street", "tory st", "pin", "6011"))).end().toString();
       assertTrue( jsonObject.toString().equalsIgnoreCase(jsonString));
    }

//    public void testApp2()
//    {
//        RestAssured.baseURI = "https://api.trademe.co.nz/v1/";
//        RestAssured.basePath = "Categories/{number}.json";
//
//        Map<String, String> catId = new HashMap<>();
//        catId.put("number", "0001");
//        Response resp = new CrudOperations().get().usingURL(RestAssured.baseURI + RestAssured.basePath)
//                .with($->  $.templateParams(catId) ).send();
//
//        assertEquals(200, resp.getStatusCode());
//    }

}
