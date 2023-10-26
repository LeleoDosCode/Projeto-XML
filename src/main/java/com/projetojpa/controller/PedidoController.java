package com.projetojpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetojpa.entity.Pedido;
import com.projetojpa.service.PedidoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Pedido", description = "API REST DE GERENCIAMENTO DE PEDIDOS")
@RestController
@RequestMapping("/pedido")

public class PedidoController {

	private final PedidoService pedidoService;
	
	@Autowired
	public PedidoController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}
	
	@GetMapping("/(id)")
	@Operation(summary = "Localiza pedido por ID")
	public ResponseEntity<Pedido> buscarId(@PathVariable Long id){
		Pedido pedido = pedidoService.buscarId(id);
		if(pedido != null) {
			return ResponseEntity.ok(pedido);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/")
	@Operation(summary = "Apresenta todos os pedidos")
	public ResponseEntity<List<Pedido>> buscarTodos(){
		List<Pedido> pedidos = pedidoService.buscarTodos();
		return ResponseEntity.ok(pedidos);
	}
	
	@PostMapping("/")
	@Operation(summary = "Inserindo dados")
	public ResponseEntity<Pedido> salvar(@RequestBody @Valid Pedido pedido){
		Pedido salvar = pedidoService.salvar(pedido);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvar);
	}
}
