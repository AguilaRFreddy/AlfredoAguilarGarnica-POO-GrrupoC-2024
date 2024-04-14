class Cliente:
    contadorClientes = 0

    def __init__(self, nombre, direccion):
        Cliente.contadorClientes += 1
        self.id = Cliente.contadorClientes
        self.nombre = nombre
        self.direccion = direccion

    def get_id(self):
        return self.id

    def obtener_informacion(self):
        return f"Id: {self.id} Nombre: {self.nombre} y direccion: {self.direccion}"

    def get_nombre(self):
        return self.nombre
