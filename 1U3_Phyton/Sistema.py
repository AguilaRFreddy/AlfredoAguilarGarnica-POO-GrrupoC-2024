
from Tienda import Tienda


class Sistema:
    CONTRASEÑA = "qwerty"

    def __init__(self):
        self.tienda = Tienda()
        # self.scanner = Scanner()

    def ejecutarPrograma(self):
        contraseñaValida = False

        while not contraseñaValida:
            print("*** BIENVENIDO ***")
            contraseña = input("INGRESA LA CONTRASEÑA PARA PODER ACCEDER AL SISTEMA: ")

            if self.validarContraseña(contraseña):
                contraseñaValida = True
                self.mostrarMenuSistema()
            else:
                print("Contraseña invalida intenta de nuevo.\n")

    def validarContraseña(self, contraseña):
        return contraseña == self.CONTRASEÑA

    def mostrarMenuSistema(self):
        opcion = 0

        while opcion != 12:
            print("ELIGE UNA OPCION PARA CONTINUAR")
            print("*** BIENVENIDOS ***")
            print("1.- Agregar cliente")
            print("2.- Agregar producto")
            print("3.- Añadir a stock")
            print("4.- Realizar Compra")
            print("5.- Listar clientes")
            print("6.- Listar productos")
            print("7.- Consultar productos por categoria")
            print("8.- Consultar compras")
            print("9.- Consultar total de productos y clientes")
            print("10.- Eliminar productos")
            print("11.- Eliminar clientes")
            print("12.- Salir")

            opcion = int(input("Ingresa la opcion: "))

            if opcion == 1:
                self.tienda.registrar_cliente()
            
            elif opcion == 2:
                opcionProducto = int(input("Ingresa el tipo de producto que deseas agregar: "))
                if opcionProducto == 1:
                    self.tienda.registrar_producto_limpieza()
                elif opcionProducto == 2:
                    self.tienda.registrar_producto_electrodomestico()
                elif opcionProducto == 3:
                    self.tienda.registrar_producto_alimento()
                elif opcionProducto == 4:
                    self.tienda.registrar_producto_maquillaje()
            elif opcion == 3:
                self.tienda.aumentar_stock()
            elif opcion == 4:
                self.tienda.realizar_registrar_compra()
            elif opcion == 5:
                self.tienda.consultar_clientes()
            elif opcion == 6:
                self.tienda.consultar_productos_limpieza()
                self.tienda.consultar_productos_electrodomestico()
                self.tienda.consultar_productos_alimento()
                self.tienda.consultar_productos_maquillaje()
            elif opcion == 7:
                opcionProductoConsulta = int(input("Ingresa el tipo de producto que deseas consultar: "))
                if opcionProductoConsulta == 1:
                    self.tienda.consultar_productos_limpieza()
                elif opcionProductoConsulta == 2:
                    self.tienda.consultar_productos_electrodomestico()
                elif opcionProductoConsulta == 3:
                    self.tienda.consultar_productos_alimento()
                elif opcionProductoConsulta == 4:
                    self.tienda.consultar_productos_maquillaje()
            elif opcion == 8:
                self.tienda.consultar_compras()
            elif opcion == 9:
                self.tienda.consultar_clientes()
                self.tienda.consultar_productos_limpieza()
                self.tienda.consultar_productos_electrodomestico()
                self.tienda.consultar_productos_alimento()
                self.tienda.consultar_productos_maquillaje()
            elif opcion == 10:
                self.tienda.eliminar_producto()
            elif opcion == 11:
                self.tienda.eliminar_cliente()
