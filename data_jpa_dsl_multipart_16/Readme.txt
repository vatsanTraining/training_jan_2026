Create a Entity Customer 
Create a Record as a subset of Customer name it suitably
Create a Repository for Customer
Create a Service and Inject Repository
update the application.yml with h2 database related settings
Access the service in the main methd and observe the result

============
Store a Image File in the classpath
Create a Entity class with @Lob and byte[] array type 
repeat steps 3 to 6
================

@WebMvcTest(LoanApplicationController.class)
class LoanApplicationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CustomerService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getCustomerId_ShouldReturnCustomer_WhenIdExists() throws Exception {

  Customer customer = new Customer();
          customer.setId(1);
          customer.setName("John Doe");
          
        Mockito.when(service.findById(1)).thenReturn(customer);

        // Act & Assert
        mockMvc.perform(get("/api/v1/customer/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customerName").value("John Doe"));
    }

    @Test
    void createLoan_ShouldReturn201() throws Exception {

        
          Customer customer = new Customer();

        Mockito.when(service.save(any(LoanApplicationDto.class))).thenReturn(customer);

        mockMvc.perform(post("/api/v1/customers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(customer)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.customerId").value(1));
    }
}
\


@DataJpaTest 
class LoanApplicationRepoTest {

    @Autowired
    private CustomerRepo repo;

    
    @Test
    void save_ShouldPersistLoanApplication() {

  Customer customer = new Customer();
          customer.setId(1);
          customer.setName("John Doe");

        // Act
        Customer savedCustomer = repo.save(customer);

        // Assert
        assertThat(savedCustomer.getId()).isNotNull();
        assertThat(savedLoan.getCustomerName()).isEqualTo("John Doe Smith");
    }

    @Test
    void findById_ShouldReturnEmpty_WhenIdDoesNotExist() {
        var result = repo.findById(999);
        assertThat(result).isEmpty();
    }
}
