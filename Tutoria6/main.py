from numpy import prod
from Producto import Producto

productos=[]

def agregar():
    global productos

    p1= Producto('manzana',2.5)
    p2= Producto('pera', 3.5)
    p3= Producto('coco', 4.5)

    productos.append(p1)
    productos.append(p2)
    productos.append(p3)

    for producto in productos:
        if producto.getNombre() == 'pera':
            print('esta es la informacion de la pera\n')
            print(producto)
        elif producto.getNombre() == 'manzana':
            print('esta es la informacion de la manzana\n')
            print(producto)
        else: 
            print('esta es la informacion de la coco\n')
            print(producto)

    print('---------------------')
    for i in range(len(productos)):
        print(productos[i])



if __name__=='__main__':
    agregar()
