package com.projetojpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entity.Pedido;
import com.projetojpa.repository.PedidoRepository;

@Service
public class PedidoService {
	private PedidoRepository pedidoRepository;
	
	@Autowired
	public PedidoService(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}
	
	public List<Pedido> buscarTodos(){
		return pedidoRepository.findAll();
	}
	
	public Pedido buscarId(Long id) {
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		return pedido.orElse(null);
	}
	
	public Pedido salvar(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}
	
	public Pedido alterar(Long id,Pedido alterarPedido) {
		Optional<Pedido> existe = pedidoRepository.findById(id);
		if (existe.isPresent()) {
			alterarPedido.setId(id);
			return pedidoRepository.save(alterarPedido);
		}
		return null;
	}
	
	public boolean apagar(Long id) {
		Optional<Pedido> existe = pedidoRepository.findById(id);
		if (existe.isPresent()) {
			pedidoRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
