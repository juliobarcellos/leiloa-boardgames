package br.com.LeiloaBoardgames.controller;

import br.com.LeiloaBoardgames.domain.Usuario;
import br.com.LeiloaBoardgames.domain.request.UsuarioRequest;
import br.com.LeiloaBoardgames.domain.response.UsuarioResponse;
import br.com.LeiloaBoardgames.service.UsuarioService;
<<<<<<< HEAD
=======
import com.fasterxml.jackson.core.JsonProcessingException;
>>>>>>> e7e4d7d (refact - merge master)
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
<<<<<<< HEAD
import org.modelmapper.ModelMapper;
=======
import org.mockito.Mock;
>>>>>>> e7e4d7d (refact - merge master)
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

import java.time.LocalDate;

<<<<<<< HEAD
import static org.hamcrest.Matchers.hasSize;
=======
>>>>>>> e7e4d7d (refact - merge master)
import static org.mockito.ArgumentMatchers.any;
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
<<<<<<< HEAD
    @MockBean
    private ModelMapper mapper;
=======
>>>>>>> e7e4d7d (refact - merge master)

    @Test
    @DisplayName("Teste de cadastro de usuário")
    public void createUser() throws Exception {

<<<<<<< HEAD
        UsuarioRequest usuarioRequest = getUsuarioRequestMock();
        UsuarioResponse response = getUsuarioResponseMock();
        Usuario usuarioSalvo = getUsuarioMock();

        String json = new ObjectMapper().findAndRegisterModules().writeValueAsString(usuarioRequest);

        when(service.save(any(Usuario.class))).thenReturn(usuarioSalvo);
        when(mapper.map(any(UsuarioRequest.class), any())).thenReturn(usuarioSalvo);
        when(mapper.map(any(Usuario.class), any())).thenReturn(response);
=======
        UsuarioRequest usuarioRequest = new UsuarioRequest();
        String json = new ObjectMapper().writeValueAsString(usuarioRequest);

        UsuarioResponse response = UsuarioResponse.builder()
                .id(1)
                .nome("zé")
                .usuario("seuze")
                .email("ze@email.com")
                .senha("12345")
                .cpf("12345678910")
                .dataNascimento(LocalDate.parse("2000-01-01"))
                .telefone("11912345678")
                .build();
        Usuario usuarioSalvo = Usuario.builder().id(1)
                .nome("zé")
                .usuario("seuze")
                .email("ze@email.com")
                .senha("12345")
                .cpf("12345678910")
                .dataNascimento(LocalDate.parse("2000-01-01"))
                .telefone("11912345678")
                .build();

        when(service.save(any(Usuario.class))).thenReturn(usuarioSalvo);
>>>>>>> e7e4d7d (refact - merge master)
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
<<<<<<< HEAD
        UsuarioRequest userRequest = new UsuarioRequest();
        String json = new ObjectMapper().findAndRegisterModules().writeValueAsString(userRequest);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(USER_API)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json);

        mockMvc.perform(request)
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("errors", hasSize(7)));

    }

    private UsuarioRequest getUsuarioRequestMock() {
        UsuarioRequest usuarioRequest = new UsuarioRequest();
        usuarioRequest.setNome("zé");
        usuarioRequest.setUsuario("seuze");
        usuarioRequest.setEmail("ze@email.com");
        usuarioRequest.setSenha("12345");
        usuarioRequest.setCpf("12345678910");
        usuarioRequest.setDataNascimento(LocalDate.parse("2000-01-01"));
        usuarioRequest.setTelefone("11912345678");
        return usuarioRequest;
    }
    
    private Usuario getUsuarioMock() {
        return Usuario.builder().id(1)
                    .nome("zé")
                    .usuario("seuze")
                    .email("ze@email.com")
                    .senha("12345")
                    .cpf("12345678910")
                    .dataNascimento(LocalDate.parse("2000-01-01"))
                    .telefone("11912345678")
                .build();
    }

    private UsuarioResponse getUsuarioResponseMock() {
        return UsuarioResponse.builder()
                .id(1)
                .nome("zé")
                .usuario("seuze")
                .email("ze@email.com")
                .senha("12345")
                .cpf("12345678910")
                .dataNascimento(LocalDate.parse("2000-01-01"))
                .telefone("11912345678")
                .build();
=======

>>>>>>> e7e4d7d (refact - merge master)
    }
}
