package com.avaliacao.back.Controller;

import com.avaliacao.back.DTO.ClienteDTO;
import com.avaliacao.back.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;


    public ResponseEntity<Map<String, Object>> createProfissional(ClienteDTO clienteDTO) {

        ResponseEntity<?> responseEntity = clienteService.salvarPaciente(clienteDTO);
        Map<String, Object> response = new HashMap<>();
        response.put("profissional", responseEntity.getBody());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping("/get")
    public ResponseEntity<List<ClienteDTO>> getClientes() {
        return clienteService.listarCliente();
    }

    @GetMapping("/get/id/{id}")
    public ResponseEntity<?> getClienteById(@PathVariable Long id) {
        Optional<ClienteDTO> profissionalDTO = clienteService.buscarPorId(id);

        if (profissionalDTO.isPresent()) {
            return ResponseEntity.ok(profissionalDTO.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Profissional não encontrado com o ID fornecido.");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String, Object>> updateCliente(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) {
        ResponseEntity<ClienteDTO> responseEntity = clienteService.atualizarCliente(id, clienteDTO);
        Map<String, Object> response = new HashMap<>();
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            response.put("profissional", responseEntity.getBody());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteCliente(@PathVariable Long id) {
        ResponseEntity<Void> responseEntity = clienteService.deletarCliente(id);
        Map<String, Object> response = new HashMap<>();
        if (responseEntity.getStatusCode() == HttpStatus.NO_CONTENT) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
