1. write 2 endpoints
   first endpoint: query university by name
   2nd endpoint: query unitversity by country name
2. create different method
   https://stackoverflow.com/questions/15853035/create-two-method-for-same-url-pattern-with-different-arguments
3. create service impl + interface
4. create configuration class=> get resttemplate as bean
   return new RestTemplate();
5. autowired rest template bean in service
6. restTemplate.getObject(url, UserInfo.class)
   {
   “name”:”Tom”,
   “address”: {
   “street”: “xx”,
   “zipcode”: xx    
   }
   }
   @Data
   class UserInfo {
   @JsonProperty(“name”)
   private String user_name;
   private Address address;
   }
   @Data
   class Address {
   private String street;
   private int zipcode;
   }