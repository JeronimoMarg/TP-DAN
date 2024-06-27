package isi.dan.msclientes.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import isi.dan.msclientes.dao.ClienteRepository;
import isi.dan.msclientes.model.Cliente;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

   @Value("${cliente.maximo_descubierto.default}")
   private BigDecimal defaultMaximoDescubierto;

   @Autowired
   private ClienteRepository clienteRepository;

   public List<Cliente> findAll() {
      return clienteRepository.findAll();
   }

   public Optional<Cliente> findById(Integer id) {
      return clienteRepository.findById(id);
   }

   public Cliente save(Cliente cliente) {
      // Establecer el valor por defecto para maximoDescubierto si no se proporcionó
      if (cliente.getMaximoDescubierto() == null || cliente.getMaximoDescubierto().compareTo(BigDecimal.ZERO) == 0) {
         cliente.setMaximoDescubierto(defaultMaximoDescubierto);
      }
      return clienteRepository.save(cliente);
   }

   public Cliente update(Cliente cliente) {
      return clienteRepository.save(cliente);
   }

   public void deleteById(Integer id) {
      clienteRepository.deleteById(id);
   }
}
