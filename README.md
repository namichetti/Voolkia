# Investigación / Script

## Descripción

En este proyecto, haciendo uos de la [API](https://developers.mercadolibre.com.ar/es_ar/api-docs-es) de Mercadolibre, se obtiene tanto en formato JSON en archivos txt los siguientes resultados:


1. Todos los ítems publicados por el seller_id = ```179571326``` del site_id = "```MLA```".
```bash
/list/MLA/179571326
```
Resultados en ```items.txt ```

2. Todos los ítems publicados por el seller_id y site_id genéricos, a ingresar.
```bash
/list/{site_id}/{seller_id}
```

En este caso hice uso de site_id = "```MLA```" y seller_id = ```132961968```.
Resultados en ```itemsById.txt```


#### Los resultados están con el siguiente formato: 
```bash
"id" del ítem, "title" del item, "category_id" donde está
publicado, "name" de la categoría.
```


## Tecnología utlizadas

* Spring boot 2.5.2
* Java 11
