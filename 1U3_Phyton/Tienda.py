from datetime import date

from Cliente import Cliente
from Producto import Limpieza
from Producto import Electrodomestico
from Producto import Alimento
from Producto import Maquillaje


class Tienda:
    def __init__(self):
        self.clientes = []
        self.productos_maquillaje = []
        self.productos_limpieza = []
        self.productos_alimento = []
        self.productos_electrodomestico = []
        self.compra = []
        self.ids_cliente = []
        self.serie_lista = []

    def registrar_cliente(self):
        print("\n *** Elegiste registrar un cliente ***")
        nombre = input("Ingresa el nombre: ")
        direccion = input("Ingresa la direccion: ")
        cliente = Cliente(nombre, direccion)
        self.clientes.append(cliente)
        print("¡Cliente registrado con exito!")

    def consultar_clientes(self):
        print("*** CLIENTES ***")
        for cliente in self.clientes:
            print(cliente.obtener_informacion())
    def registrar_datos_comun(self):
        datos = []
        nombre = input("Ingresa un nombre: ")
        datos.append(nombre)
        precio = float(input("Ingresa el precio: "))
        datos.append(str(precio))
        fecha = input("Ingresa la fecha de importacion: ")
        datos.append(fecha)
        stock = int(input("Ingresa el stock del producto: "))
        datos.append(str(stock))
        return datos

    def registrar_producto_limpieza(self):
        print("\n *** Elegiste registrar un producto de la categoria limpieza ***")
        datos_usuario = self.registrar_datos_comun()
        nombre = datos_usuario[0]
        precio = float(datos_usuario[1])
        fecha = datos_usuario[2]
        stock = int(datos_usuario[3])
        marca = input("Ingresa la marca: ")
        limpieza = Limpieza(nombre, precio, fecha, stock, marca)
        self.productos_limpieza.append(limpieza)

    def consultar_productos_limpieza(self):
        print("*** PRODUCTOS LIMPIEZA ***")
        for producto in self.productos_limpieza:
            print(producto.obtener_informacion_con_marca())

    def registrar_producto_electrodomestico(self):
        print("\n *** Elegiste registrar un producto de la categoria Electrodomestico ***")
        datos_usuario = self.registrar_datos_comun()
        nombre = datos_usuario[0]
        precio = float(datos_usuario[1])
        fecha = datos_usuario[2]
        stock = int(datos_usuario[3])
        voltaje = input("Ingresa el voltaje: ")
        electrodomestico = Electrodomestico(
            nombre, precio, fecha, stock, voltaje)
        self.productos_electrodomestico.append(electrodomestico)

    def consultar_productos_electrodomestico(self):
        print("*** PRODUCTOS ELECTRODOMESTICO ***")
        for producto in self.productos_electrodomestico:
            print(producto.obtener_informacion_con_voltaje())

    def registrar_producto_alimento(self):
        print("\n *** Elegiste registrar un producto de la categoria Alimento ***")
        datos_usuario = self.registrar_datos_comun()
        nombre = datos_usuario[0]
        precio = float(datos_usuario[1])
        fecha = datos_usuario[2]
        stock = int(datos_usuario[3])
        caducidad = input("Ingresa la caducidad: ")
        alimento = Alimento(nombre, precio, fecha, stock, caducidad)
        self.productos_alimento.append(alimento)

    def consultar_productos_alimento(self):
        print("*** PRODUCTOS ALIMENTO ***")
        for producto in self.productos_alimento:
            print(producto.obtener_informacion_con_caducidad())

    def registrar_producto_maquillaje(self):
        print("\n *** Elegiste registrar un producto de la categoria Maquillaje ***")
        datos_usuario = self.registrar_datos_comun()
        nombre = datos_usuario[0]
        precio = float(datos_usuario[1])
        fecha = datos_usuario[2]
        stock = int(datos_usuario[3])
        color = input("Ingresa el color: ")
        maquillaje = Maquillaje(nombre, precio, fecha, stock, color)
        self.productos_maquillaje.append(maquillaje)

    def consultar_productos_maquillaje(self):
        print("*** PRODUCTOS MAQUILLAJE ***")
        for producto in self.productos_maquillaje:
            print(producto.obtener_informacion_con_color())

    def aumentar_stock(self):
        print("Ingrese el numero de serie del producto:")
        numero_serie = int(input())
        encontrado = False
        for limpieza in self.productos_limpieza:
            if limpieza.get_numero_serie() == numero_serie:
                print("Se encontro el producto solicitado en la clase limpieza")
                cantidad = int(input("Ingresa la cantidad a aumentar stock: "))
                limpieza.agregar_stock(cantidad)
                encontrado = True
                break
        if not encontrado:
            for electrodomestico in self.productos_electrodomestico:
                if electrodomestico.get_numero_serie() == numero_serie:
                    print(
                        "Se encontro el producto solicitado en la clase Electrodomestico")
                    cantidad = int(
                        input("Ingresa la cantidad a aumentar stock: "))
                    electrodomestico.agregar_stock(cantidad)
                    encontrado = True
                    break
        if not encontrado:
            for alimento in self.productos_alimento:
                if alimento.get_numero_serie() == numero_serie:
                    print("Se encontro el producto solicitado en la clase Alimento")
                    cantidad = int(
                        input("Ingresa la cantidad a aumentar stock: "))
                    alimento.agregar_stock(cantidad)
                    encontrado = True
                    break
        if not encontrado:
            for maquillaje in self.productos_maquillaje:
                if maquillaje.get_numero_serie() == numero_serie:
                    print("Se encontro el producto solicitado en la clase Maquillaje")
                    cantidad = int(
                        input("Ingresa la cantidad a aumentar stock: "))
                    maquillaje.agregar_stock(cantidad)
                    encontrado = True
                    break
        if not encontrado:
            print("No se encontro el producto")

    def realizar_registrar_compra(self):
        print("Ingresa Id del cliente: ...")
        validar_id_cliente = int(input())
        for cliente in self.clientes:
            if cliente.get_id() == validar_id_cliente:
                fecha_actual = date.today().strftime("%Y/%m/%d")
                print("El cliente fue encontrado")
                print("Ingresa numero de serie del producto: ...")
                validar_num_serie = int(input())
                while True:
                    print("Ingresa la categoria")
                    print("1.- Limpieza")
                    print("2.- Electrodomestico")
                    print("3.- Alimento")
                    print("4.- Maquillaje")
                    print("5.- SALIR")
                    op = int(input())
                    if op == 1:
                        for limpieza in self.productos_limpieza:
                            if limpieza.get_numero_serie() == validar_num_serie:
                                print("Ingresa la cantidad a comprar")
                                cantidad = int(input())
                                if cantidad <= limpieza.get_stock():
                                    limpieza.eliminar_stock(cantidad)
                                    nombre = cliente.get_nombre()
                                    producto = limpieza.get_nombre()
                                    compra_realizada = f"El usuario {nombre}, ha comprado {
                                        cantidad}, {producto} en la fecha {fecha_actual}"
                                    self.compra.append(compra_realizada)
                                    print("Compra realizada")
                                    self.ids_cliente.append(
                                        str(validar_id_cliente))
                                    self.serie_lista.append(
                                        str(validar_num_serie))
                                    return
                        print("No se encontro el producto de limpieza")
                    elif op == 2:
                        for electrodomestico in self.productos_electrodomestico:
                            if electrodomestico.get_numero_serie() == validar_num_serie:
                                print("Ingresa la cantidad a comprar")
                                cantidad = int(input())
                                if cantidad <= electrodomestico.get_stock():
                                    electrodomestico.eliminar_stock(cantidad)
                                    nombre = cliente.get_nombre()
                                    producto = electrodomestico.get_nombre()
                                    compra_realizada = f"El usuario {nombre}, ha comprado {
                                        cantidad}, {producto} en la fecha {fecha_actual}"
                                    self.compra.append(compra_realizada)
                                    print("Compra realizada")
                                    self.ids_cliente.append(
                                        str(validar_id_cliente))
                                    self.serie_lista.append(
                                        str(validar_num_serie))
                                    return
                        print("No se encontro el producto electrodomestico")
                    elif op == 3:
                        for alimento in self.productos_alimento:
                            if alimento.get_numero_serie() == validar_num_serie:
                                print("Ingresa la cantidad a comprar")
                                cantidad = int(input())
                                if cantidad <= alimento.get_stock():
                                    alimento.eliminar_stock(cantidad)
                                    nombre = cliente.get_nombre()
                                    producto = alimento.get_nombre()
                                    compra_realizada = f"El usuario {nombre}, ha comprado {
                                        cantidad}, {producto} en la fecha {fecha_actual}"
                                    self.compra.append(compra_realizada)
                                    print("Compra realizada")
                                    self.ids_cliente.append(
                                        str(validar_id_cliente))
                                    self.serie_lista.append(
                                        str(validar_num_serie))
                                    return
                        print("No se encontro el producto Alimento")
                    elif op == 4:
                        for maquillaje in self.productos_maquillaje:
                            if maquillaje.get_numero_serie() == validar_num_serie:
                                print("Ingresa la cantidad a comprar")
                                cantidad = int(input())
                                if cantidad <= maquillaje.get_stock():
                                    maquillaje.eliminar_stock(cantidad)
                                    nombre = cliente.get_nombre()
                                    producto = maquillaje.get_nombre()
                                    compra_realizada = f"El usuario {nombre}, ha comprado {
                                        cantidad}, {producto} en la fecha {fecha_actual}"
                                    self.compra.append(compra_realizada)
                                    print("Compra realizada")
                                    self.ids_cliente.append(
                                        str(validar_id_cliente))
                                    self.serie_lista.append(
                                        str(validar_num_serie))
                                    return
                        print("No se encontro el producto maquillaje")
                    elif op == 5:
                        break
        print("Compra terminada")

    def consultar_compras(self):
        for compra in self.compra:
            print(compra)

    def eliminar_producto(self):
        print("Ingresa el numero de serie del producto:")
        eliminar = input()

        if eliminar in self.serie_lista:
            print("El producto ya ha sido comprado, imposible eliminar")
            return

        id_eliminacion = int(eliminar)

        for limpieza in self.productos_limpieza:
            if limpieza.get_numero_serie() == id_eliminacion:
                print("Se encontro el producto solicitado en la clase limpieza")

                for j in range(len(self.productos_limpieza)):
                    limpieza = self.productos_limpieza[j]
                    atributo_serie = str(limpieza.get_numero_serie())
                    if atributo_serie == eliminar:
                        del self.productos_limpieza[j]  # Eliminar el objeto
                        print("Producto eliminado")
                        return

        for electrodomestico in self.productos_electrodomestico:
            if electrodomestico.get_numero_serie() == id_eliminacion:
                print("Se encontro el producto solicitado en la clase electrodomestico")

                for j in range(len(self.productos_electrodomestico)):
                    electrodomestico = self.productos_electrodomestico[j]
                    atributo_serie = str(electrodomestico.get_numero_serie())
                    if atributo_serie == eliminar:
                        # Eliminar el objeto
                        del self.productos_electrodomestico[j]
                        print("Producto eliminado")
                        return

        for alimento in self.productos_alimento:
            if alimento.get_numero_serie() == id_eliminacion:
                print("Se encontro el producto solicitado en la clase alimento")

                for j in range(len(self.productos_alimento)):
                    alimento = self.productos_alimento[j]
                    atributo_serie = str(alimento.get_numero_serie())
                    if atributo_serie == eliminar:
                        del self.productos_alimento[j]  # Eliminar el objeto
                        print("Producto eliminado")
                        return

        for maquillaje in self.productos_maquillaje:
            if maquillaje.get_numero_serie() == id_eliminacion:
                print("Se encontro el producto solicitado en la clase maquillaje")

                for j in range(len(self.productos_maquillaje)):
                    maquillaje = self.productos_maquillaje[j]
                    atributo_serie = str(maquillaje.get_numero_serie())
                    if atributo_serie == eliminar:
                        del self.productos_maquillaje[j]  # Eliminar el objeto
                        print("Producto eliminado")
                        return

        print("No se encontro el producto")


    def eliminar_cliente(self):
        print("Ingresa el Id del cliente:")
        eliminar = input()

        for cadena in self.IDs_cliente:
            if cadena == eliminar:
                print("El cliente ya ha realizado una compra")
                return

        int_eliminar = int(eliminar)

        for cliente in self.clientes:
            if cliente.get_id() == int_eliminar:
                print("Se encontro el cliente")

                for j in range(len(self.clientes)):
                    cliente = self.clientes[j]
                    id_string = str(cliente.get_id())
                    if id_string == eliminar:
                        del self.clientes[j]  # Eliminar el objeto
                        print("Cliente eliminado")
                        return

        print("El cliente no ha sido encontrado")
                     