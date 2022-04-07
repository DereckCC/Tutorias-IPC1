from flask import Flask, jsonify, request
from flask_cors import CORS

from Pokemon import Pokemon
from Entrenador import Entrenador

Pokemons = []
Entrenadores = []

Pokemons.append(Pokemon(1, "Bulbasur", "Planta"))
Pokemons.append(Pokemon(2, "Ivysaur", "Planta"))
Pokemons.append(Pokemon(3, "Venasour", "Planta"))
Pokemons.append(Pokemon(4, "Charmander", "Fuego"))

app = Flask(__name__)
CORS(app)

@app.route('/hola-mundo', methods=["GET"])
def holaMundo():
    print("Hola mundo")
    return None

@app.route('/pokemons', methods=["GET"])
def getPokemons():
    global Pokemons
    Datos = []
    for pokemon in Pokemons:
        objeto = {
            'codigo': pokemon.getCodigo(),
            'nombre': pokemon.getNombre(),
            'tipo': pokemon.getTipo()
        }
        Datos.append(objeto)

    return(jsonify(Datos))

@app.route("/buscar-poke/<int:id>", methods=['GET'])
def getPokemon(id):
    global Pokemons
    for pokemon in Pokemons:
        if(pokemon.getCodigo() == id):
            objeto = {
                'codigo': pokemon.getCodigo(),
                'nombre': pokemon.getNombre(),
                'tipo': pokemon.getTipo()
            }
            return(jsonify(objeto))

@app.route('/entrenador', methods=['POST'])
def addEntradores():
    global Entrenadores
    nombre = request.json['nombre']
    pokemon = request.json['pokemons']

    nuevoEntrador = Entrenador(nombre, pokemon)
    Entrenadores.append(nuevoEntrador)
    return jsonify({'mensaje': "Se agrego correctamente el entrenador"})


if __name__ == "__main__":
    app.run(host="0.0.0.0", port=3000, debug=True)