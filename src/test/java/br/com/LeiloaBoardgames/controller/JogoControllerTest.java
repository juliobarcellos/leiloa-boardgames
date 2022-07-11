package br.com.LeiloaBoardgames.controller;

import br.com.LeiloaBoardgames.domain.entities.Jogo;
import br.com.LeiloaBoardgames.domain.request.jogo.JogoCreateRequest;
import br.com.LeiloaBoardgames.domain.response.jogo.JogoCreateResponse;
import br.com.LeiloaBoardgames.domain.response.jogo.JogoRespose;
import br.com.LeiloaBoardgames.mapper.JogoMapper;
import br.com.LeiloaBoardgames.service.JogoService;
import br.com.LeiloaBoardgames.utils.DataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@WebMvcTest
@AutoConfigureWebMvc
@ContextConfiguration(classes = JogoController.class)
class JogoControllerTest {

    private final String USER_API = "/jogos";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JogoService service;
    @MockBean
    private JogoMapper mapper;

//    @Test
    @DisplayName("Teste de cadastro de usuário")
    public void create() throws Exception {

        JogoCreateRequest jogoCreateRequest = DataBuilder.jogoCreateRequestMock();
        JogoRespose response = DataBuilder.jogoResponseMock();
        Jogo jogoSalvo = DataBuilder.jogoMock();

        String json = new ObjectMapper().findAndRegisterModules().writeValueAsString(jogoCreateRequest);

        when(service.save(any(Jogo.class))).thenReturn(jogoSalvo);
        when(mapper.toEntity(any(JogoCreateRequest.class))).thenReturn(jogoSalvo);
        when(mapper.toResponse(any(Jogo.class))).thenReturn(response);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(USER_API)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json);

        mockMvc.perform(request)
                .andExpect(status().isCreated())
                .andExpect(jsonPath("nome").value(response.getNome()));
    }
}