# Parcial 2 AREP

## Donde llegamos?

Se llego a implementar de forma sencilla las dos busquedas: 

![image](https://github.com/user-attachments/assets/2569ded3-ef4f-4a18-92ee-3038a5584660)
 
![image](https://github.com/user-attachments/assets/e3053970-d0be-4cf4-80c8-5f7de330eab7)


![image](https://github.com/user-attachments/assets/e57860d1-a6fe-4a90-a036-e47c54b95d54)

Vemos que se pudieron implementar los EndPoints para que el backend haga las intrucciones de busqueda

Ademas se pudo implementar el roundrobin a espera del link correspondiente a los dos EC2

![image](https://github.com/user-attachments/assets/ecba46fd-4d98-42da-8382-5b6f061ca2c5)


## Que nos falta?

El siguiente paso seria adaptar el front para que pueda leer JSon y ademas adaptar el back para que envie los JSon en forma correcta

Luego de ello el siguiente paso seria crear las dos EC2 donde se instalen ambos microservicios de math, para luego añadir los links de dichos EC2 al roundRobin y montarlo en una tercera maquina EC2 junto a un front que haga las solicutides de manera distribuida a ambos microservicios ya montados

Como ultimo paso seria configurar para que la conexion entre todas las EC2 se de correctamente

## Arquitectura deseada

La arquitectura seria la siguiente:

![image](https://github.com/user-attachments/assets/e78334a1-1e3a-4e7d-b376-97d243bab1ec)

Donde el roundRobin actua como un balanceo de cargas entre los dos microservicios

