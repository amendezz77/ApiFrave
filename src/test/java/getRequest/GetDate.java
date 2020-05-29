package getRequest;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.Request;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetDate {
	
	@Test
	public void testPrimero()
	{
		String key="query";
		String value="lagunitas";
		Response resp =  RestAssured.get("https://api.openbrewerydb.org/breweries/autocomplete?"+key+'='+value);
		int code = resp.getStatusCode();	
		String data = resp.asString();
		System.out.print("Registro"+ data);
	    Assert.assertEquals(code,200);
	}
	
	@Test
	public void testSegundo()
	{
		String name="name";
		String valueseg="Lagunitas Brewing Co";
		String keyseg ="query";
		String valuesegs ="lagunitas";
		Response respseg =  RestAssured.get("https://api.openbrewerydb.org/breweries/autocomplete?"+keyseg+'='+valuesegs+'&'+name+'='+valueseg);	
		int code = respseg.getStatusCode();
		String data = respseg.asString();
		System.out.print("Status code"+ data);
       Assert.assertEquals(code,200);
	}
	
	@Test
	public void testTercero()
	{
		String idTer= "761";
		String keyTer="state";
	    String valueter="California";
		 Response respTer =  RestAssured.get("https://api.openbrewerydb.org/breweries/"+idTer+'?'+keyTer+'='+valueter);	

		int code = respTer.getStatusCode();	
		System.out.print("Status code"+ code);
	    Assert.assertEquals(code,200);
	}
	
	@Test
	public void testCuarto()
	{
		JSONObject cerveResul = new JSONObject();			
		cerveResul.put("phone","7077694495");
		cerveResul.put("street","1280 N McDowell Blvd");
		cerveResul.put("name","Lagunitas Brewing Co");
		cerveResul.put("id",761);
		
		Response resp =  RestAssured.get("https://api.openbrewerydb.org/breweries/762?state=California");
		String data = resp.asString();
	    System.out.print("Response time" + resp.getTime());
	    System.out.print(data);
	   Assert.assertEquals(data, cerveResul); 
	}
	
}
