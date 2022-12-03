package br.com.LeiloaBoardgames.controller;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@WebMvcTest
@AutoConfigureWebMvc
@ContextConfiguration(classes = JogoController.class)
class JogoControllerTest {
//
//    private final String USER_API = "/jogos";
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private JogoService service;
//    @MockBean
//    private JogoMapper mapper;
//
//    @Test
//    @DisplayName("Teste de cadastro de usuário")
//    public void create() throws Exception {
//
//        JogoCreateRequest jogoCreateRequest = DataBuilder.jogoCreateRequestMock();
//        JogoRespose response = DataBuilder.jogoResponseMock();
//        Jogo jogoSalvo = DataBuilder.jogoMock();
//
//        String json = new ObjectMapper().findAndRegisterModules().writeValueAsString(jogoCreateRequest);
//
//        when(service.save(any(Jogo.class))).thenReturn(jogoSalvo);
//        when(mapper.toEntity(any(JogoCreateRequest.class))).thenReturn(jogoSalvo);
//        when(mapper.toResponse(any(Jogo.class))).thenReturn(response);
//
//        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(USER_API)
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(json);
//
//        mockMvc.perform(request)
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("nome").value(response.getNome()));
//    }
}