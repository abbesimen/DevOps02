@RunWith(MockitoJUnitRunner.class)
public class OperateurControllerTest {

  @Mock
  private IOperateurService operateurService;

  @InjectMocks
  private OperateurController operateurController;

  private MockMvc mockMvc;

  @Before
  public void setup() {
    mockMvc = MockMvcBuilders.standaloneSetup(operateurController).build();
  }

  @Test
  public void testGetOperateurs() throws Exception {
    // Create a list of Operateur objects
    List<Operateur> operateurs = new ArrayList<>();
    operateurs.add(new Operateur(1L, "Orange"));
    operateurs.add(new Operateur(2L, "Ooredoo"));
    operateurs.add(new Operateur(3L, "Tunisie Telecom"));

    // Mock the behavior of the operateurService
    when(operateurService.retrieveAllOperateurs()).thenReturn(operateurs);

    // Perform the request and assert the response
    mockMvc.perform(get("/operateur/retrieve-all-operateurs"))
        .andExpect(status().isOk())
        .andExpect(content().json("[{'id':1, 'nom':'Orange'}, {'id':2, 'nom':'Ooredoo'}, {'id':3, 'nom':'Tunisie Telecom'}]"));
  }

  @Test
  public void testRetrieveOperateur() throws Exception {
    // Create an Operateur object
    Operateur operateur = new Operateur(1L, "Orange");

    // Mock the behavior of the operateurService
    when(operateurService.retrieveOperateur(1L)).thenReturn(operateur);

    // Perform the request and assert the response
    mockMvc.perform(get("/operateur/retrieve-operateur/1"))
        .andExpect(status().isOk())
        .andExpect(content().json("{'id':1, 'nom':'Orange'}"));
  }

  @Test
  public void testAddOperateur() throws Exception {
    // Create an Operateur object
    Operateur operateur = new Operateur(1L, "Orange");

    // Mock the behavior of the operateurService
    when(operateurService.addOperateur(operateur)).thenReturn(operateur);

    // Perform the request and assert the response
    mockMvc.perform(post("/operateur/add-operateur")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"id\":1, \"nom\":\"Orange\"}"))
        .andExpect(status().isOk())
        .andExpect(content().json("{'id':1, 'nom':'Orange'}"));
  }

  @Test
  public void testRemoveOperateur() throws Exception {
    // Perform the request
    mockMvc.perform(delete("/operateur/remove-operateur/1"))
        .andExpect(status().isOk());

    // Verify that the operateurService method was called with the correct parameter
    verify(operateurService).deleteOperateur(1L);
  }

  @Test
  public void testModifyOperateur() throws Exception {
    // Create an Operateur object
    Operateur operateur = new Operateur(1L, "Orange");

    // Mock the behavior of the operateurService
    when(operateurService.updateOperateur(operateur)).thenReturn(operateur);

    // Perform the request and assert the response
    mockMvc.perform(put("/operateur/modify-operateur")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"id\":1, \"nom\":\"Orange\"}"))
        .andExpect(status().isOk())
        .andExpect(content().json("{'id':1, 'nom':'Orange'}"));
  }

}
