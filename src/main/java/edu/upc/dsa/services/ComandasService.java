package edu.upc.dsa.services;


import edu.upc.dsa.ProductManager;

import edu.upc.dsa.ProductManagerImpl;
import edu.upc.dsa.clases.Pedido;
import edu.upc.dsa.clases.Producto;
import edu.upc.dsa.clases.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;
import java.util.Date;
import java.util.logging.Logger;

@Api(value = "/Comandas", description = "Endpoint to Text Service")
@Path("Comandas")
public class ComandasService {

    private ProductManager pm;

    public ComandasService() {
        this.pm = ProductManagerImpl.getInstance();

        if (this.pm.getUserSize() == 0) {
            //Creamos los usuarios
            User usuario1 = new User("1111", 1);
            User usuario2 = new User("2222", 2);
            User usuario3 = new User("3333", 3);

            //Añadimos los usuarios al HashMap
            this.pm.addUser(usuario1);
            this.pm.addUser(usuario2);
            this.pm.addUser(usuario3);
        }

        if (this.pm.getProductosSize() == 0) {
            //Creamos los productos
            Producto producto1 = new Producto("Cocacola", 2); //Declaramos productos y precios
            Producto producto2 = new Producto("CafeLlet", 1.5);
            Producto producto3 = new Producto("Donut", 2.5);

            //Añadimos los productos (Carta)
            pm.addProducto(producto1);
            pm.addProducto(producto2);
            pm.addProducto(producto3);
        }

        if (this.pm.getPedidosSize() == 0) {
            //Creamos Pedidos de prueba
            Pedido pedido1 = new Pedido();
            Pedido pedido2 = new Pedido();
            Pedido pedido3 = new Pedido();

            pedido1.addLP("Cocacola", 2);
            pedido1.addLP("CafeLlet", 3);
            pedido1.setUser("1111");
            pm.addPedido(pedido1);

            pedido2.addLP("Donut", 6);
            pedido2.addLP("CafeLlet", 7);
            pedido2.setUser("1111");
            pm.addPedido(pedido2); //Push2

            pedido3.addLP("Cocacola", 3);
            pedido3.addLP("Donut", 3);
            pedido3.setUser("3333");
            pm.addPedido(pedido3); //Push2
        }

    }

    @GET
    @ApiOperation(value = "get all Users", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class, responseContainer = "List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuarios() {

        Collection<User> usuarios = this.pm.usersDisp();


        GenericEntity<Collection<User>> entity = new GenericEntity<Collection<User>>(usuarios) {
        };
        return Response.status(201).entity(entity).build();

    }


    @POST /*Añadimos una nuevo usuario */
    @ApiOperation(value = "create a new User", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/adduser/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newUser(@PathParam("id") String idUser) {

        /* if (track.getSinger()==null || track.getTitle()==null)  return Response.status(500).entity(track).build();*/
        User user = this.pm.addUserById(idUser);
        return Response.status(201).entity(user).build();
    }
}
