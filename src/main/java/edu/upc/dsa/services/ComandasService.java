package edu.upc.dsa.services;


import edu.upc.dsa.ProductManager;

import edu.upc.dsa.ProductManagerImpl;
import edu.upc.dsa.clases.LP;
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
import java.util.List;
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
            pm.servir();

            pedido2.addLP("Donut", 6);
            pedido2.addLP("CafeLlet", 7);
            pedido2.setUser("1111");
            pm.addPedido(pedido2); //Push2
            pm.servir();


            pedido3.addLP("Cocacola", 3);
            pedido3.addLP("Donut", 3);
            pedido3.setUser("3333");
            pm.addPedido(pedido3); //Push2

        }

    }

    /*
    @GET
    @ApiOperation(value = "GET all pedidos por usuario (4)", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Pedido.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "Pedido not found")

    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPedidos(@PathParam("id") String user) {

        List<Pedido> pedidos = this.pm.getPedidoUser(user);


        GenericEntity<List<Pedido>> entity = new GenericEntity<List<Pedido>>(pedidos) {
        };

        if (pedidos != null) return Response.status(201).entity(entity).build();
        else return Response.status(404).entity(entity).build();

    }
    */


    //(1) Listado de productos ordenado (ascendentemente) por precio

    /*
    @GET
    @ApiOperation(value = "get productosByPrice ascendente", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Producto.class, responseContainer = "List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductoByPrice() {

        List<Producto> productos = this.pm.sortByPrice();
        GenericEntity<List<Producto>> entity = new GenericEntity<List<Producto>>(productos) {
        };
        return Response.status(201).entity(entity).build();
    }


*/

    @POST //Añadimos una nuevo usuario
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


    //(2) Realizar un pedido (que puede estar formado por diferentes productos y en
    //diferentes cantidades) por parte de un usuario identificado

    @POST
    @ApiOperation(value = "create a new Pedido", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Pedido.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newTrack(Pedido pedido) {

        if (pedido.getUser() == null || pedido.getLPs() == null)
            return Response.status(500).entity(pedido).build();
        this.pm.addPedido(pedido);
        return Response.status(201).entity(pedido).build();
    }


    //(5) Listado de productos ordenado (descendentemente) por número de ventas

    @GET
    @ApiOperation(value = "get productosBySells descendente", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Producto.class, responseContainer = "List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductosDescBySales() {

        List<Producto> productos2 = this.pm.sortBySells();
        GenericEntity<List<Producto>> entity = new GenericEntity<List<Producto>>(productos2) {
        };
        return Response.status(201).entity(entity).build();
    }



    //(3) Servir un pedido. Los servicios se realizan en orden de llegadas

    @POST
    @ApiOperation(value = "Sirve un pedido", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Pedido.class),
            @ApiResponse(code = 500, message = "Pedido no encontrado")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response servirPedido() {

        Pedido pedido = pm.servir();
        if (pedido==null)  return Response.status(500).entity(pedido).build();
        this.pm.servir();
        return Response.status(201).entity(pedido).build();
    }






}
