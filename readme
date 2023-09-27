Handling XML and JSON Formats in REST APIs
In today's world of APIs, flexibility and adaptability are required key.
I will show you three different ways or methods to handle response format specifically XML and JSON,
Method 1: Using produces attribute inside method handler annotations such as @GetMapping. 
Step 1: Add the jackson-dataformat-xml dependency to your pom.xml:
<dependency>
 <groupId>com.fasterxml.jackson.dataformat</groupId>
 <artifactId>jackson-dataformat-xml</artifactId>
</dependency>
Step 2: Configure your method to produce XML format:
 for example : 
@GetMapping(value = "/employee", produces = {"application/xml"})
public Employee employeeMethod(){
 return new Employee(1, "Ashit Kumar Rai", "100000");
}
This method is simple to implement, but the drawback is that you need to specify the desired response format inside each method handler annotation.

Method 2: Here is the better way using Content Negotiation with WebMvcConfigurer To achieve a more flexible solution, you can use content negotiation to generate media types based on the client's request paramater (@ReqeustParam). Here's how you can set it up:
Step 1: Add the same jackson-dataformat-xml dependency to your pom.xml (same as in Method 1).
Step 2: create new class Configure content negotiation:
@Configuration
@EnableWebMvc
public class MediaTypeConfiguration implements WebMvcConfigurer {
    
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer
            .defaultContentType(MediaType.APPLICATION_JSON) // Set the default media type
            .mediaType("json", MediaType.APPLICATION_JSON)   // Map "json" to JSON
            .mediaType("xml", MediaType.APPLICATION_XML);     // Map "xml" to XML
    }
}
With this configuration, you don't need to specify the produces attribute:
@GetMapping(value = "/employee")
public Employee employeeMethod() {
    return new Employee(1, "Ashit Kumar Rai", "100");
}
Now, you can pass a mediaType request parameter to specify the response format:
JSON: http://localhost:8080/employee?mediaType=json
XML: http://localhost:8080/employee?mediaType=xml
Default (JSON): http://localhost:8080/employee

Method 3: Just Define Format in the Request Header The third method is my preferred way,
Step 1: Add the jackson-dataformat-xml dependency to your pom.xml (same as in the previous methods).

OR
No additional configuration is required. Simply call the API while adding the Accept request header with "application/xml" or "application/json" to specify the desired format (see the example images for reference). The API will automatically respond in the requested format.