package com.projetojpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetojpa.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
