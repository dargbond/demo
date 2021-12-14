Home Entity Access REST API 
=======
## Property Store/Retrieve business logic


This package defines REST Apis for store/retrieve Home Entity data  and provides skeleton for implementing business logic. 

### Assumptions for the use cases covered:
- Read is more frequent than write.
- In future - need ability to query data.
- 
### Out of scope:
- Spring Wiring. The project is setup with Spring Boot, but configuration is not setup yet.
- Implementation of Data Access layer
- Testing. While package has setup for junit5, I didn't have time to implement any unit tests.  
