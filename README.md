**CALCULATOR API**
Test para ITERIAM / SANITAS 

Requisitos Obligatorios:
- Usar JDK8.

**OBLIGATORIO PARA EJECUTAR EL PROGRAMA:**

- Instalacion del jar externo de Trace en el repositorio local de maven: 

mvn org.apache.maven.plugins:maven-install-plugin:2.5.2:install-file  \
    -Dfile=C:/Users/Gabriel/Desktop/tracer-1.0.0.jar \
    -DgroupId=io.corp.calculator -DartifactId=tracer \
    -Dversion=1.0.0 -Dpackaging=jar \
    -DlocalRepositoryPath=C:/Users/Gabriel/.m2/repository
	
- Con esto ya lo puedo añadir como dependencia al pom y empezar a importarlo y usarlo.

**inDTO para SUMA:**

{
  "elem1": 1,
  "elem2": 2,
  "operation": "+"
}

**DTO para RESTA:**

{
  "elem1": 1,
  "elem2": 2,
  "operation": "+-"
}

**DECISIONES VARIAS**
	
- He decidido hacer la Clase Operacion como clase padre (Y abstracta) a partir de la que el resto de Operaciones hereden. He reflexionado sobre la posibilidad de incluirla como una interfaz  con un metodo default de Java 8 para imprimir. Pero el hecho de tener que usar Trace para imprimir el resultado ha hecho que opte por no usar una Interfaz finalmente. Ademas, no estoy acostumbrado y no me gusta eso de poner implementaciones de metodo en interfaces.

- He incluido los primeros Test Unitarios para las Operaciones de Suma y Resta. Tambien he añadido un Test para verificar que salta bien la excepcion deseada si no se reconocer la Operacion.

- Debido al hecho de que los argumentos de entrada pueden evolucionar y ser muchos, me parece mejor usar la opcion del RequestBody porque no hay limitación de caracteres como con los parametros de URL. Además a medida que se aumentan los parametros en la llamada, es bastante mas sencillo de leer y manejar un JSON, que un flujo de parametros metidos en la URL.

- En este ejemplo no está claro si es mejor el GET o el POST (no vemos claramente si recuperamos o guardamos un recurso), además el RequestBody genera problemas si se usa con el GET, asi que el POST me pareció la mejor opción. El hecho de usar un DTO de entrada (y usar @RequestBody) hacen que no pueda usar una Peticion GET, por eso uso POST.

- Añado Swagger2 para testeo del Microservicio porque la Interfaz Web me parece muy intuitiva y facil de entender y usar. Además de esto, por la facilidad de crear y exponer la documentación en dicha Interfaz.

- Uso de Logger o Trace. El tracer imprime por defecto la palabra "result ::", lo que da a entender que solo deberia usarse para trazar el resultado o alguna excepcion. El LOGGER es para el resto de casos.

- Añado un Manejador de Excepciones globales para manipular la salida de los Errores (en este momento para las validaciones de los parametros
 de entrada y para el caso de la Excepcion personalizada de OperationNotValidException.java)
 
 
