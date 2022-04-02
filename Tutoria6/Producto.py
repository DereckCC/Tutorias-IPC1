class Producto:
    def __init__(self, nombre, precio):
        self.nombre= nombre
        self.precio= precio
    
    def getNombre(self):
        return self.nombre
    
    def getPrecio(self):
        return self.precio
    
    def setNombre(self,nombre):
        self.nombre=nombre
    
    def setPrecio(self, nombre):
        self.precio=self.precio
    
    def __str__(self):
        return 'nombre: ' + self.nombre + '\nprecio: ' + str(self.precio)
