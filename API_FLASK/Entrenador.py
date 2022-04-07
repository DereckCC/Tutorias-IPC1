class Entrenador:
    def __init__(self, nombre, Pokemon):
        self.nombre = nombre
        self.Pokemon = Pokemon

    def getNombre(self):
        return self.nombre

    def setNombre(self, nombre):
        self.nombre = nombre 

    def getPokemon(self):
        return self.Pokemon

    def setPokemon(self, Pokemon):
        self.Pokemon = Pokemon 