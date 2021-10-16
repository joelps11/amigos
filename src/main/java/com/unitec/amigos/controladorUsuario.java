package com.unitec.amigos;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.FacesRequestAttributes;

import java.util.List;

@RestController
@RequestMapping("/api")
public class controladorUsuario {
    //Aqui va un metodo que representa cada uno de los estados que vamos a
    //tansferir, es decir: GET, POST, PUT Y DELETE

    //Aqui viene el uso de la inversion de control
    @Autowired RepositorioUsuario repoUsuario;

    //Implementamos el codigo para guardar un usuario en MongoDB
    @PostMapping("/usuario")
    public Estatus guardar(@RequestBody String json) throws Exception{
        //Primero leemos y convertimos el objeto JSon a objeto Java
        ObjectMapper mapper = new ObjectMapper();
        usuario u = mapper.readValue(json, usuario.class);
        //Este usuario ya en formato json lo guardamos en MongoDB
        repoUsuario.save(u);
        //Creamos un objeto de tipo status y lo retornamos al cliente para saber si hicimos el registro
        Estatus estatus = new Estatus();
        estatus.setSuccess(true);
        estatus.setMensaje("Tu usuario se guardo con exito!!");
        return estatus;
    }

    //Buscador por usuario
    @GetMapping("/usuario/{id}")
        public usuario obtenerPorID(@PathVariable String id){
            /*Usuario fake
            usuario u = new usuario();
            u.setEdad(21);
            u.setNombre("Joel");
            u.setEmail("joel@prueba.com");*/
            //Leemos un usuario buscandolo por el argumento id que es el email
            //Siempre apoyandonos de repo usuario
            usuario u=repoUsuario.findById(id).get();
            return u;
        }

    //Buscar todos
    @GetMapping("/usuario")
        public List<usuario> buscartodos(){
            return repoUsuario.findAll();
        }

    //Metodo para actualizar
    @PutMapping("/usuario")
        public Estatus actualizar(@RequestBody String json) throws Exception{
            //Primero verificamos que ya exista el usuario, para eso lo buscamos
            ObjectMapper mapper = new ObjectMapper();
            usuario u = mapper.readValue(json, usuario.class);
            Estatus e = new Estatus();
            if(repoUsuario.findById(u.getEmail()).isPresent()){
                //Lo volvemos a guardar
                repoUsuario.save(u);
                e.setSuccess(true);
                e.setMensaje("Usuario se actualizo con exito");
            }
            else {
                //mandamos el mensaje de que no existe
                e.setSuccess(false);
                e.setMensaje("El usuario no existe, no se actualizara");
            }
            return e;
    }
    //Eliminar usuario por id
    @DeleteMapping("/usuario/{id}")
        public Estatus borrarPorId(@PathVariable String id){
            //Primero verificamos que ya exista el usuario, para eso lo buscamos
            Estatus e = new Estatus();
            if(repoUsuario.findById(id).isPresent()){
                //Lo volvemos a eliminar
                repoUsuario.deleteById(id);
                e.setSuccess(true);
                e.setMensaje("Usuario borrado con exito");
            }
            else {
                //Mandamos el mensaje de que no existe
                e.setSuccess(false);
                e.setMensaje("El usuario no existe");
            }
            return e;
        }
}
