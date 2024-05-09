# API de Google Scholar

> La API de Google Scholar proporciona acceso programático a la vasta base de datos de Google Scholar, que incluye información sobre publicaciones académicas, autores y citas. Su propósito principal es permitir a los desarrolladores integrar datos académicos y de investigación en sus aplicaciones, herramientas y servicios.
> 

## Endpoints

Los endpoints principales de la API de Google Scholar: 

> **`/v1/publications`** permitiendo endpoint permite buscar y recuperar información sobre publicaciones académicas.
> 
1. **Parámetros de la petición**:
    1. **`q`** (obligatorio): Consulta de búsqueda. Puede ser el título de la publicación, el nombre del autor, palabras clave, etc.
    2. **`author`**: Filtro para limitar los resultados a publicaciones de un autor específico.
    3. **`year`**: Filtro para limitar los resultados a publicaciones de un año específico.
    4. **`num_results`**: Número máximo de resultados a devolver.

**Método HTTP**: GET: Devuelve una lista de publicaciones que coinciden con los criterios de búsqueda en formato JSON.

```bash
bashCopy code
GET /v1/publications?q=deep+learning&num_results=10
```

> **`/v1/authors`** este endpoint permite buscar y recuperar información sobre autores académicos.
> 
1. **Parámetros de la Petición**:
    1. **`q`** (obligatorio): Consulta de búsqueda. Puede ser el nombre del autor, palabras clave, etc.
    2. **`num_results`**: Número máximo de resultados a devolver.

**Método HTTP**: GET una vez que ya lo definimos en este caso podemos ver el siguiente ejemplo:

```bash
bashCopy code
GET /v1/authors?q=John+Doe&num_results=5
```

> **`/v1/institutions`** Este endpoint permite buscar y recuperar información sobre instituciones académicas.
> 
- **Parámetros de la Petición**:
    - **`q`** (obligatorio): Consulta de búsqueda. Puede ser el nombre de la institución, palabras clave, etc.
    - **`num_results`**: Número máximo de resultados a devolver.
- **Método HTTP**: GET

```bash
bashCopy code
GET /v1/institutions?q=Harvard+University&num_results=1
```

# **Ejemplos de uso**

### **Ejemplo 1: Búsqueda de Publicaciones**

```
httpCopy code
GET /v1/publications?q=deep+learning&num_results=10
```

**Descripción**: Este ejemplo busca publicaciones relacionadas con "deep learning" y devuelve hasta 10 resultados.

### **Ejemplo 2: Búsqueda de Autores**

```
httpCopy code
GET /v1/authors?q=John+Doe&num_results=5
```

**Descripción**: Este ejemplo busca autores con el nombre "John Doe" y devuelve hasta 5 resultados.

### **Ejemplo 3: Búsqueda de Instituciones**

```
httpCopy code
GET /v1/institutions?q=Harvard+University&num_results=1

```

**Descripción**: Este ejemplo busca la institución con el nombre "Harvard University" y devuelve hasta 1 resultado.

### **Ejemplo 4: Búsqueda Avanzada de Publicaciones**

```
httpCopy code
GET /v1/publications?q=author:"John Doe"+year:2022&num_results=5

```

**Descripción**: Este ejemplo realiza una búsqueda avanzada de publicaciones escritas por el autor "John Doe" en el año 2022 y devuelve hasta 5 resultados.

# Consultas

Para realizar consultas privadas o acceder a funciones avanzadas, es posible que necesites autenticarte utilizando credenciales de Google.

### **Proceso de descarga**

1. Dirígete al [Google Cloud Console](https://console.cloud.google.com/).
2. Crea un nuevo proyecto o selecciona uno existente.
3. Seleccionar Google Scholar en la biblioteca de APIs.
4. Crea una cuenta de servicio y descarga el archivo JSON que contiene las claves de autenticación.

### **Formato de Respuesta**

La API de Google Scholar devuelve respuestas en formato JSON de la siguiente forma:

```json
jsonCopy code
{
  "results": [
    {
      "title": "Título del Artículo",
      "authors": ["Autor 1", "Autor 2"],
      "publication_year": 2022,
      "venue": "Nombre de la Revista o Conferencia",
      "citations": 100,
      "url": "URL del Artículo"
    },
    {
      "title": "Otro Título del Artículo",
      "authors": ["Autor 3", "Autor 4"],
      "publication_year": 2021,
      "venue": "Otra Revista",
      "citations": 150,
      "url": "Otra URL"
    },
    ...
  ]
}
```

- **title**: El título del artículo.
- **authors**: Una lista de autores del artículo.
- **publication_year**: El año de publicación del artículo.
- **venue**: El nombre de la revista o conferencia donde se publicó el artículo.
- **citations**: El número de citas recibidas por el artículo.
- **url**: El enlace URL al artículo.

# GitHub