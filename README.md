# hasMutant

El proyecto que detecta si una persona tiene diferencias genéticas basándose en
su secuencia de ADN y utiliza la siguiente funcion para calcularlo.
```
boolean hasMutation(String[] dna);
```

### Ejecucion Local

Para Ejecutar localmente se neceita clonar le proyecto de este repositorio
las tecnologías que ocupa son 

* Java 8
* Springboot
* Gradle
* Azure Devops
* Azure AppService

Despues de clonar podemos utilzia Intellij para ejecutarlo localmente, la api tiene unsolo endpoint ```/mutation``` que recibe una lista de secuencias de ADN
de la siguiente manera
```
{
   "dna":["ATGCAG", "CTGTAC", "TTGAGT", "AGAGGG", "TCCCGA", "ACACTG"]
}
```

la cadena solo puede contener las letras ATGC ademas de un alogitud de 6 secuencias 

### Pruebas

Para poder probar la api se puede consultar con enviando un ```POST /mutation ``` con el siguiente body 

```
{
   "dna":["ATGCAG", "CTGTAC", "TTGAGT", "AGAGGG", "TCCCGA", "ACACTG"]
}
```
y haciendo peticones al suiguiente endpoint donde se encuatra la api [https://gurosapi.azurewebsites.net/] 


