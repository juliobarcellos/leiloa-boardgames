package br.com.LeiloaBoardgames.controller;

import br.com.LeiloaBoardgames.domain.entities.Usuario;
import br.com.LeiloaBoardgames.domain.request.usuario.UsuarioAtualizarRequest;
import br.com.LeiloaBoardgames.domain.request.usuario.UsuarioCreateRequest;
import br.com.LeiloaBoardgames.domain.response.usuario.UsuarioCreateResponse;
import br.com.LeiloaBoardgames.domain.response.usuario.UsuarioRespose;
import br.com.LeiloaBoardgames.exceptions.BusinessException;
import br.com.LeiloaBoardgames.mapper.UsuarioMapper;
import br.com.LeiloaBoardgames.service.UsuarioService;
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
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
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
    private UsuarioMapper mapper;

    @Test
    @DisplayName("Teste de cadastro de usuário")
    public void createUser() throws Exception {

        UsuarioCreateRequest usuarioCreateRequest = DataBuilder.getUsuarioRequestMock();
        UsuarioCreateResponse response = DataBuilder.getUsuarioCreateResponseMock();
        Usuario usuarioSalvo = DataBuilder.getUsuarioAtivoMock();

        String json = new ObjectMapper().findAndRegisterModules().writeValueAsString(usuarioCreateRequest);

        when(service.save(any(Usuario.class))).thenReturn(usuarioSalvo);
        when(mapper.toEntity(any(UsuarioCreateRequest.class))).thenReturn(usuarioSalvo);
        when(mapper.toCreateResponse(any(Usuario.class))).thenReturn(response);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(USER_API)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json);

        mockMvc.perform(request)
                .andExpect(status().isCreated())
                .andExpect(jsonPath("nome").value(response.getNome()))
                .andExpect(jsonPath("usuario").value(response.getUsuario()))
                .andExpect(jsonPath("email").value(response.getEmail()));
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
                .andExpect(jsonPath("errors", hasSize(12)));

    }

    @Test
    @DisplayName("Teste de cadastro de usuário com cpf já cadastrado")
    public void createUserWithCpfAlreadyExists() throws Exception {

        UsuarioCreateRequest usuarioCreateRequest = DataBuilder.getUsuarioRequestMock();
        Usuario usuarioSalvo = DataBuilder.getUsuarioAtivoMock();

        String json = new ObjectMapper().findAndRegisterModules().writeValueAsString(usuarioCreateRequest);
        when(mapper.toEntity(any(UsuarioCreateRequest.class))).thenReturn(usuarioSalvo);
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
        Usuario usuarioSalvo = DataBuilder.getUsuarioAtivoMock();

        String json = new ObjectMapper().findAndRegisterModules().writeValueAsString(usuarioCreateRequest);
        when(mapper.toEntity(any(UsuarioCreateRequest.class))).thenReturn(usuarioSalvo);
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
        Usuario usuarioSalvo = DataBuilder.getUsuarioAtivoMock();

        String json = new ObjectMapper().findAndRegisterModules().writeValueAsString(usuarioCreateRequest);
        when(mapper.toEntity(any(UsuarioCreateRequest.class))).thenReturn(usuarioSalvo);
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

    @Test
    @DisplayName("Teste de atualização de usuário com sucesso")
    public void updateUserWithSuccess() throws Exception {

        Usuario usuario = DataBuilder.getUsuarioAtivoMock();
        UsuarioAtualizarRequest usuarioUpdateRequest = DataBuilder.getUsuarioAtualizarRequestMock();
        String json = new ObjectMapper().findAndRegisterModules().writeValueAsString(usuarioUpdateRequest);
        when(mapper.toEntity(any(UsuarioAtualizarRequest.class))).thenReturn(usuario);
        given(service.atualizar(anyInt(), any(UsuarioAtualizarRequest.class))).willReturn(usuario);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.put(USER_API + "/usuarios/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json);

        mockMvc.perform(request)
                .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("Teste de atualização de usuário com usuário não encontrado")
    public void updateUserWithUserNotFound() throws Exception {

        UsuarioAtualizarRequest usuarioUpdateRequest = DataBuilder.getUsuarioAtualizarRequestMock();
        String json = new ObjectMapper().findAndRegisterModules().writeValueAsString(usuarioUpdateRequest);
        when(mapper.toEntity(any(UsuarioAtualizarRequest.class))).thenReturn(new Usuario());
        given(service.atualizar(anyInt(), any(UsuarioAtualizarRequest.class))).willThrow(new NoSuchElementException("Usuário não encontrado"));

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.put(USER_API + "/usuarios/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json);

        mockMvc.perform(request)
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("errors", hasSize(1)))
                .andExpect(jsonPath("errors[0]").value("Usuário não encontrado"));
    }

    @Test
    @DisplayName("Teste busca de usuário por id com sucesso")
    public void findUserByIdWithSuccess() throws Exception {

        Usuario usuario = DataBuilder.getUsuarioAtivoMock();
        given(service.buscarPorId(anyInt())).willReturn(usuario);
        given(mapper.toResponse(any(Usuario.class))).willReturn(DataBuilder.getUsuarioResponseMock());

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(USER_API + "/usuarios/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("idUsuario").value(1))
                .andExpect(jsonPath("nome").value("zé da silva"))
                .andExpect(jsonPath("email").value("ze@email.com"));
    }

    @Test
    @DisplayName("Teste busca de usuário por id com usuário não encontrado")
    public void findUserByIdWithUserNotFound() throws Exception {

        given(service.buscarPorId(anyInt())).willThrow(new NoSuchElementException("Usuário não encontrado"));

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(USER_API + "/usuarios/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("errors", hasSize(1)))
                .andExpect(jsonPath("errors[0]").value("Usuário não encontrado"));
    }

    @Test
    @DisplayName("Teste de exclusão de usuário com sucesso")
    public void deleteUserWithSuccess() throws Exception {

        given(service.deletar(anyInt())).willReturn(1);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.delete(USER_API + "/usuarios/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("Teste de exclusão de usuário com usuário não encontrado")
    public void deleteUserWithUserNotFound() throws Exception {

        given(service.deletar(anyInt())).willThrow(new NoSuchElementException("Usuário não encontrado"));

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.delete(USER_API + "/usuarios/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("errors", hasSize(1)))
                .andExpect(jsonPath("errors[0]").value("Usuário não encontrado"));
    }

    @Test
    @DisplayName("Teste de exclusão de usuário já excluído")
    public void deleteUserAlreadyDeleted() throws Exception {

        given(service.deletar(anyInt())).willThrow(new BusinessException("Usuário já excluído"));

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.delete(USER_API + "/usuarios/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("errors", hasSize(1)))
                .andExpect(jsonPath("errors[0]").value("Usuário já excluído"));
    }

    @Test
    @DisplayName("Teste de buscar todos os usuários com sucesso")
    public void findAllUsersWithSuccess() throws Exception {

        List<Usuario> usuarios = List.of(DataBuilder.getUsuarioAtivoMock());
        List<UsuarioRespose> usuariosResposta = List.of(DataBuilder.getUsuarioResponseMock());
        given(service.buscarTodos()).willReturn(usuarios);
        given(mapper.toListResponse(any())).willReturn(usuariosResposta);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(USER_API + "/usuarios")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    @DisplayName("Deve retornar vazio ao buscar todos os usuários")
    public void findAllUsersWithEmptyList() throws Exception {

        given(service.buscarTodos()).willReturn(new ArrayList<>());

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(USER_API + "/usuarios")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }
}
