// package com.example.diy4rent.demo.service;

// import com.example.diy4rent.demo.model.Carrito;
// import com.example.diy4rent.demo.model.Herramientas;
// import com.example.diy4rent.demo.model.Usuarios;
// import com.example.diy4rent.demo.repo.ICarritoRepo;
// import com.example.diy4rent.demo.repo.IHerramientaRepo;
// import com.example.diy4rent.demo.repo.IUsuarioRepo;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import java.util.UUID;

// @Service
// public class CarritoServicio {
//     @Autowired
//     private ICarritoRepo carritoRepo;
//     @Autowired
//     private IHerramientaRepo herramientaRepo;
//     @Autowired
//     private IUsuarioRepo usuarioRepo;
//     public Carrito addToCart(String herramientaId, UUID usuarioId) {
//         Herramientas herramienta = herramientaRepo.findById(herramientaId).get();
//         Usuarios usuario = null;
//         if (usuarioId != null) {
//             usuario = usuarioRepo.findById(usuarioId).get();
//         }
//         if (herramienta != null && usuario != null) {
//             Carrito carrito = new Carrito(herramienta.getUuid(), usuario.getUuid());
//             return carritoRepo.save(carrito);
//         }
//         return null;
//     }

// }
