package br.com.LeiloaBoardgames.controller;

import br.com.LeiloaBoardgames.domain.Usuario;
import br.com.LeiloaBoardgames.domain.request.UsuarioCreateRequest;
import br.com.LeiloaBoardgames.domain.response.UsuarioResponse;
import br.com.LeiloaBoardgames.exceptions.BusinessException;
import br.com.LeiloaBoardgames.service.UsuarioService;
import br.com.LeiloaBoardgames.utils.DataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@WebMvcTest
@AutoConfigureWebMvc
public class UsuarioControllerTest {


    private final String USER_API = "/usuarios";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioService service;
    @MockBean
    private ModelMapper mapper;

    @Test
    @DisplayName("Teste de cadastro de usuário")
    public void createUser() throws Exception {

        UsuarioCreateRequest usuarioCreateRequest = DataBuilder.getUsuarioRequestMock();
        UsuarioResponse response = DataBuilder.getUsuarioResponseMock();
        Usuario usuarioSalvo = DataBuilder.getUsuarioMock();

        String json = new ObjectMapper().findAndRegisterModules().writeValueAsString(usuarioCreateRequest);

        when(service.save(any(Usuario.class))).thenReturn(usuarioSalvo);
        when(mapper.map(any(UsuarioCreateRequest.class), any())).thenReturn(usuarioSalvo);
        when(mapper.map(any(Usuario.class), any())).thenReturn(response);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(USER_API)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json);

        mockMvc.perform(request)
                .andExpect(status().isCreated())
                .andExpect(jsonPath("id").isNotEmpty())
                .andExpect(jsonPath("nome").value(response.getNome()))
                .andExpect(jsonPath("usuario").value(response.getUsuario()))
                .andExpect(jsonPath("email").value(response.getEmail()))
                .andExpect(jsonPath("senha").value(response.getSenha()));
    }

    @Test
    @DisplayName("Teste de cadastro de usuário com dados inválidos")
    public void createUserWithError() throws Exception {
        UsuarioCreateRequest userRequest = new UsuarioCreateRequest();
        String json = new ObjectMapper().findAndRegisterModules().writeValueAsString(userRequest);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(USER_API)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json);

        mockMvc.perform(request)
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("errors", hasSize(7)));

    }

    @Test
    @DisplayName("Teste de cadastro de usuário com cpf já cadastrado")
    public void createUserWithCpfAlreadyExists() throws Exception {

        UsuarioCreateRequest usuarioCreateRequest = DataBuilder.getUsuarioRequestMock();
        Usuario usuarioSalvo = DataBuilder.getUsuarioMock();

        String json = new ObjectMapper().findAndRegisterModules().writeValueAsString(usuarioCreateRequest);
        when(mapper.map(any(UsuarioCreateRequest.class), any())).thenReturn(usuarioSalvo);
        given(service.save(any(Usuario.class))).willThrow(new BusinessException("CPF já cadastrado"));

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(USER_API)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json);

        mockMvc.perform(request)
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("errors", hasSize(1)))
                .andExpect(jsonPath("errors[0]").value("CPF já cadastrado"));

    }

    @Test
    @DisplayName("Teste de cadastro de usuário com email já cadastrado")
    public void createUserWithEmailAlreadyExists() throws Exception {

        UsuarioCreateRequest usuarioCreateRequest = DataBuilder.getUsuarioRequestMock();
        Usuario usuarioSalvo = DataBuilder.getUsuarioMock();

        String json = new ObjectMapper().findAndRegisterModules().writeValueAsString(usuarioCreateRequest);
        when(mapper.map(any(UsuarioCreateRequest.class), any())).thenReturn(usuarioSalvo);
        given(service.save(any(Usuario.class))).willThrow(new BusinessException("Email já cadastrado"));

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(USER_API)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json);

        mockMvc.perform(request)
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("errors", hasSize(1)))
                .andExpect(jsonPath("errors[0]").value("Email já cadastrado"));

    }

    @Test
    @DisplayName("Teste de cadastro de usuário com usuário já cadastrado")
    public void createUserWithUserAlreadyExists() throws Exception {

        UsuarioCreateRequest usuarioCreateRequest = DataBuilder.getUsuarioRequestMock();
        Usuario usuarioSalvo = DataBuilder.getUsuarioMock();

        String json = new ObjectMapper().findAndRegisterModules().writeValueAsString(usuarioCreateRequest);
        when(mapper.map(any(UsuarioCreateRequest.class), any())).thenReturn(usuarioSalvo);
        given(service.save(any(Usuario.class))).willThrow(new BusinessException("Usuário já cadastrado"));

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(USER_API)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json);

        mockMvc.perform(request)
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("errors", hasSize(1)))
                .andExpect(jsonPath("errors[0]").value("Usuário já cadastrado"));

    }
}
