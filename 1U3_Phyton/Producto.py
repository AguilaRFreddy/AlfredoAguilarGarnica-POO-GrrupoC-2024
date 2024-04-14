class Producto:
    CANTIDAD_PRODUCTOS = 0

    def __init__(self, nombre, precio, fecha_importacion, stock):
        Producto.CANTIDAD_PRODUCTOS += 1
        self.nombre = nombre
        self.precio = precio
        self.fecha_importacion = fecha_importacion
        self.stock = stock
        self.numero_serie = Producto.CANTIDAD_PRODUCTOS

    def agregar_stock(self, cantidad):
        self.stock += cantidad

    def eliminar_stock(self, cantidad):
        if self.validar_stock():
            print("")
        else:
            self.stock -= cantidad

    def validar_stock(self):
        return self.stock == 0

    def obtener_informacion(self):
        return f"Nombre: {self.nombre}, precio: {self.precio}, fecha importacion: {self.fecha_importacion}, stock: {self.stock}, numero de serie: {self.numero_serie}"

    def get_numero_serie(self):
        return self.numero_serie

    def get_nombre(self):
        return self.nombre

    def get_stock(self):
        return self.stock
    
class Limpieza(Producto):
    def __init__(self, nombre, precio, fecha_importacion, stock, marca):
        super().__init__(nombre, precio, fecha_importacion, stock)
        self.marca = marca

    def obtener_informacion_con_marca(self):
        return f"{super().obtener_informacion()}, Marca: {self.marca}"
    
class Electrodomestico(Producto):
    def __init__(self, nombre, precio, fecha_importacion, stock, voltaje):
        super().__init__(nombre, precio, fecha_importacion, stock)
        self.voltaje = voltaje

    def obtener_informacion_con_voltaje(self):
        return f"{super().obtener_informacion()}, Voltaje: {self.voltaje}"

class Alimento(Producto):
    def __init__(self, nombre, precio, fecha_importacion, stock, caducidad):
        super().__init__(nombre, precio, fecha_importacion, stock)
        self.caducidad = caducidad

    def obtener_informacion_con_caducidad(self):
        return f"{super().obtener_informacion()}, Caducidad: {self.caducidad}"


class Maquillaje(Producto):
    def __init__(self, nombre, precio, fecha_importacion, stock, color):
        super().__init__(nombre, precio, fecha_importacion, stock)
        self.color = color

    def obtener_informacion_con_color(self):
        return f"{super().obtener_informacion()}, Color: {self.color}"
