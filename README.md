# calculator
Test para ITERIAM / SANITAS 

OBLIGATORIO PARA EJECUTAR EL PROBLEMA:

- Instalacion del jar externo de Trace en el repositorio local de maven: 

mvn org.apache.maven.plugins:maven-install-plugin:2.5.2:install-file  \
    -Dfile=C:/Users/Gabriel/Desktop/tracer-1.0.0.jar \
    -DgroupId=io.corp.calculator -DartifactId=tracer \
    -Dversion=1.0.0 -Dpackaging=jar \
    -DlocalRepositoryPath=C:/Users/Gabriel/.m2/repository
	
- Con esto ya lo puedo añadir como dependencia al pom y empezar a importarlo y usarlo.

DECISIONES VARIAS
	
- He decidido hacer la Clase Operacion como clase padre (Y abstracta) a partir de la que el resto de Operaciones hereden. He reflexionado sobre la posibilidad de incluirla como una interfaz 
con un metodo default de Java 8 para imprimir. Pero el hecho de tener que usar Trace para imprimir el resultado ha hecho que opte por no usar una Interfaz finalmente. Ademas, no estoy
acostumbrado y no me gusta eso de poner implementaciones de metodo en interfaces.

- He incluido los primeros Test Unitarios para las Operaciones de Suma y Resta. Tambien he añadido un Test para verificar que salta bien la excepcion deseada si no se reconocer la Operacion.

- Decido usar DTOs de entrada y salida para el controlador porque me parece mas realista. El hecho de usar un DTO de entrada (y usar @RequestBody) haven que no pueda usar una Peticion GET, por eso uso POST.

- Añado Swagger para testeo del Microservicio mediante navegador porque estoy acostumbrado a trabajar con él y me gusta su interfaz.

- Añado DTOs de Entrada y Salida para que se asemeje más a un caso real.

- Añado un Manejador de Excepciones globales para manipular la salida de los Errores (en este momento para las validaciones de los parametros
 de entrada y para el caso de la Excepcion personalizad de OperationNotValidException.java)
 
 