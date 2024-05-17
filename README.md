# practica5
Codigo para calcular la distnacia entre 2 vertices 
Este código implementa una clase Graph que representa un grafo no dirigido utilizando una lista de adyacencia. Aquí está un resumen de lo que hace:
addVertex(V v): Añade un vértice al grafo si no está presente. Retorna true si el vértice se añadió correctamente, o false si ya estaba presente.
addEdge(V v1, V v2): Añade un arco entre dos vértices al grafo. Si alguno de los vértices no está presente, se añade. Retorna true si se añadió el arco correctamente, o false si el arco ya estaba presente.
obtainAdjacents(V v): Obtiene el conjunto de vértices adyacentes a un vértice dado.
containsVertex(V v): Comprueba si el grafo contiene un vértice dado.
toString(): Retorna una cadena de caracteres con la lista de adyacencia del grafo.
shortestPath(V v1, V v2): Obtiene el camino más corto entre dos vértices en el grafo. Retorna una lista con la secuencia de vértices del camino más corto entre v1 y v2, o null si no existe un camino

Ademas cuenta con una clase llamada Graph test la cual verificara si el algoritmo se ha desarrolado correctamente y cumple con sus objetivos

Para ejecutar este codigo sera necesario tener instalado git bash en su dispositivo 

Copyright [2024] [Pilar Fernandez Adillo] Licensed under the Apache License, Version 2.0 (the "License");you may not use this file except in compliance with the License.You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0Unless required by applicable law or agreed to in writing, softwaredistributed under the License is distributed on an "AS IS" BASIS,WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.See the License for the specific language governing permissions andlimitations under the License.