package co.nz.wone;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


import java.util.HashMap;
import java.util.Map;

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
    public void testApp()
    {
        assertTrue( true );
    }

    public void testApp2()
    {
        RestAssured.baseURI = "https://api.trademe.co.nz/v1/";
        RestAssured.basePath = "Categories/{number}.json";

        Map<String, String> catId = new HashMap<>();
        catId.put("number", "0001");
        Response resp = new CrudOperations().get().usingURL(RestAssured.baseURI + RestAssured.basePath)
                .with($->  $.templateParams(catId) ).send();

        assertEquals(200, resp.getStatusCode());
    }
}
