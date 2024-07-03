package com.bazan.devquiz.data.database.data

import com.bazan.devquiz.data.database.dao.QuestionDao
import com.bazan.devquiz.data.database.entities.QuestionEntity

object QuestionData {
    suspend fun populate(questionDao: QuestionDao) {
        // Preguntas de JavaScript Nivel Junior
        questionDao.insert(
            QuestionEntity(
                question = "¿Qué es JavaScript?",
                answer = "JavaScript es un lenguaje de programación de alto nivel, dinámico y orientado a objetos, principalmente utilizado para crear contenido interactivo en páginas web.",
                technology = 2,
                difficulty = 1
            )
        )
        questionDao.insert(
            QuestionEntity(
                question = "¿Qué es una variable y cómo se declara en JavaScript?",
                answer = "Una variable es un contenedor para almacenar datos. Se puede declarar usando var, let o const, por ejemplo: let nombre = 'Juan';.",
                technology = 2,
                difficulty = 1
            )
        )
        questionDao.insert(
            QuestionEntity(
                question = "¿Qué es una función en JavaScript y cómo se define?",
                answer = "Una función es un bloque de código diseñado para realizar una tarea particular. Se define usando la palabra clave function, por ejemplo: function saludar() { console.log('Hola'); }",
                technology = 2,
                difficulty = 1
            )
        )
        questionDao.insert(
            QuestionEntity(
                question = "¿Qué es un array y cómo se crea en JavaScript?",
                answer = "Un array es una estructura de datos que almacena una colección de elementos. Se crea usando corchetes, por ejemplo: let frutas = ['manzana', 'naranja', 'plátano'];.",
                technology = 2,
                difficulty = 1
            )
        )
        questionDao.insert(
            QuestionEntity(
                question = "¿Qué es un objeto en JavaScript?",
                answer = "Un objeto es una colección de propiedades, cada una con un nombre y un valor. Se define usando llaves {}, por ejemplo: let persona = { nombre: 'Juan', edad: 30 };.",
                technology = 2,
                difficulty = 1
            )
        )
        questionDao.insert(
            QuestionEntity(
                question = "¿Qué es el DOM?",
                answer = "El DOM (Document Object Model) es una representación en memoria de un documento HTML o XML que permite a los lenguajes de programación manipular su estructura, estilo y contenido.",
                technology = 2,
                difficulty = 1
            )
        )
        questionDao.insert(
            QuestionEntity(
                question = "¿Cómo se accede a un elemento HTML usando JavaScript?",
                answer = "Se puede acceder a un elemento usando métodos como document.getElementById('id'), document.querySelector('selector'), entre otros.",
                technology = 2,
                difficulty = 1
            )
        )
        questionDao.insert(
            QuestionEntity(
                question = "¿Qué es un evento en JavaScript?",
                answer = "Un evento es una acción o ocurrencia que sucede en la página web (como un clic, una pulsación de tecla, etc.) y puede ser detectada y manejada con JavaScript.",
                technology = 2,
                difficulty = 1
            )
        )
        questionDao.insert(
            QuestionEntity(
                question = "¿Qué es JSON y para qué se utiliza?",
                answer = "JSON (JavaScript Object Notation) es un formato de intercambio de datos ligero y fácil de leer/escribir para los humanos y de parsear/generar para las máquinas. Se utiliza principalmente para enviar y recibir datos entre un servidor y una aplicación web.",
                technology = 2,
                difficulty = 1
            )
        )
        questionDao.insert(
            QuestionEntity(
                question = "¿Qué hace el método Array.prototype.push?",
                answer = "El método push agrega uno o más elementos al final de un array y devuelve la nueva longitud del array.",
                technology = 2,
                difficulty = 1
            )
        )

// Preguntas de JavaScript Nivel Mid-Level
        questionDao.insert(
            QuestionEntity(
                question = "¿Qué es la propagación de eventos en JavaScript?",
                answer = "La propagación de eventos es el proceso por el cual un evento se propaga a través del DOM desde el elemento que lo desencadenó hacia arriba (fase de burbujeo) o hacia abajo (fase de captura).",
                technology = 2,
                difficulty = 2
            )
        )
        questionDao.insert(
            QuestionEntity(
                question = "¿Cuál es la diferencia entre == y === en JavaScript?",
                answer = "== compara valores después de hacer una conversión de tipo si es necesario, mientras que === compara tanto el valor como el tipo sin hacer conversiones.",
                technology = 2,
                difficulty = 2
            )
        )
        questionDao.insert(
            QuestionEntity(
                question = "¿Qué es una promesa (Promise) en JavaScript?",
                answer = "Una promesa es un objeto que representa la eventual finalización (o falla) de una operación asíncrona y su valor resultante.",
                technology = 2,
                difficulty = 2
            )
        )
        questionDao.insert(
            QuestionEntity(
                question = "¿Qué es async y await en JavaScript?",
                answer = "async y await son sintaxis que permiten trabajar con promesas de una manera más sencilla y legible. async se usa para declarar una función asíncrona y await se usa para esperar la resolución de una promesa.",
                technology = 2,
                difficulty = 2
            )
        )
        questionDao.insert(
            QuestionEntity(
                question = "¿Cómo se maneja el contexto this en JavaScript?",
                answer = "this se refiere al objeto desde el cual se llama una función. Su valor puede cambiar dependiendo de cómo se llama la función, y puede ser manipulado explícitamente con call, apply, o bind.",
                technology = 2,
                difficulty = 2
            )
        )
        questionDao.insert(
            QuestionEntity(
                question = "¿Qué es el Event Loop en JavaScript?",
                answer = "El Event Loop es un mecanismo que permite a JavaScript manejar operaciones asíncronas. Se encarga de coordinar la ejecución del código, la recolección de eventos y la ejecución de sub-tareas en cola.",
                technology = 2,
                difficulty = 2
            )
        )
        questionDao.insert(
            QuestionEntity(
                question = "¿Qué es el hoisting en JavaScript?",
                answer = "El hoisting es el comportamiento de JavaScript en el cual las declaraciones de variables y funciones se mueven a la parte superior de su contexto (scope) antes de que se ejecute el código.",
                technology = 2,
                difficulty = 2
            )
        )
        questionDao.insert(
            QuestionEntity(
                question = "¿Qué es una función de callback?",
                answer = "Una función de callback es una función que se pasa como argumento a otra función y se ejecuta después de que la función principal haya completado su tarea.",
                technology = 2,
                difficulty = 2
            )
        )
        questionDao.insert(
            QuestionEntity(
                question = "¿Qué es el módulo y cómo se usa en JavaScript?",
                answer = "Un módulo es un fragmento de código que se puede importar y exportar entre archivos JavaScript. Se usan las palabras clave import y export para trabajar con módulos.",
                technology = 2,
                difficulty = 2
            )
        )
        questionDao.insert(
            QuestionEntity(
                question = "¿Qué es y cómo se utiliza Array.prototype.map?",
                answer = "map es un método que crea un nuevo array con los resultados de aplicar una función a cada uno de los elementos del array original. Por ejemplo: let numeros = [1, 2, 3]; let dobles = numeros.map(num => num * 2);",
                technology = 2,
                difficulty = 2
            )
        )

// Preguntas de JavaScript Nivel Senior
        questionDao.insert(
            QuestionEntity(
                question = "¿Cómo funciona el Event Loop con las tareas micro y macro en JavaScript?",
                answer = "El Event Loop maneja la cola de tareas (macro-tareas como setTimeout) y la cola de micro-tareas (como promesas resueltas). Micro-tareas se ejecutan antes de que el Event Loop procese las macro-tareas pendientes.",
                technology = 2,
                difficulty = 3
            )
        )
        questionDao.insert(
            QuestionEntity(
                question = "¿Qué es la delegación de eventos y por qué es útil?",
                answer = "La delegación de eventos es una técnica en la que un único controlador de eventos se añade a un elemento padre para manejar eventos de sus hijos. Es útil para mejorar el rendimiento y simplificar la gestión de eventos dinámicos.",
                technology = 2,
                difficulty = 3
            )
        )
        questionDao.insert(
            QuestionEntity(
                question = "¿Cómo se implementa un debounce en JavaScript?",
                answer = "Debounce es una técnica que asegura que una función no se ejecute más de una vez cada cierto tiempo. Se puede implementar así: function debounce(func, wait) { let timeout; return function(...args) { clearTimeout(timeout); timeout = setTimeout(() => func.apply(this, args), wait); }; }",
                technology = 2,
                difficulty = 3
            )
        )
        questionDao.insert(
            QuestionEntity(
                question = "¿Qué es el patrón de diseño Module y cómo se implementa en JavaScript?",
                answer = "El patrón Module es una forma de encapsular código dentro de una función y devolver solo las partes que necesitan ser públicas. Por ejemplo: const miModulo = (function() { let privado = 'Soy privado'; return { publico: function() { console.log(privado); } }; })();",
                technology = 2,
                difficulty = 3
            )
        )
        questionDao.insert(
            QuestionEntity(
                question = "¿Qué son los Generadores en JavaScript y cómo funcionan?",
                answer = "Los generadores son funciones que pueden pausar su ejecución (yield) y reanudarla posteriormente, permitiendo la creación de iteradores personalizados. Se definen con function* y se utilizan con el método next(). function* contador() { let i = 0; while (true) { yield i++; } }",
                technology = 2,
                difficulty = 3
            )
        )
        questionDao.insert(
            QuestionEntity(
                question = "¿Qué es la currificación en JavaScript y cómo se implementa?",
                answer = "La currificación es el proceso de transformar una función que toma múltiples argumentos en una serie de funciones que toman un solo argumento. Por ejemplo: function suma(a) { return function(b) { return a + b; }; }",
                technology = 2,
                difficulty = 3
            )
        )

        //Preguntas React js nivel Junior
        questionDao.insert(
            QuestionEntity(
                question = "¿Qué es React JS?",
                answer = "React JS es una biblioteca de JavaScript utilizada para construir interfaces de usuario interactivas y eficientes, desarrollada por Facebook.",
                technology = 1,
                difficulty = 1
            )
        )
        questionDao.insert(
            QuestionEntity(
                question = "¿Qué es un componente en React?",
                answer = "Un componente en React es una pieza reutilizable de la interfaz de usuario que puede tener su propio estado y lógica.",
                technology = 1,
                difficulty = 1
            )
        )
        questionDao.insert(
            QuestionEntity(
                question = "¿Cómo se crea un componente funcional en React?",
                answer = "Un componente funcional en React se crea como una función que devuelve un elemento JSX. Por ejemplo: function Saludo() { return <h1>Hola</h1>; }",
                technology = 1,
                difficulty = 1
            )
        )
        questionDao.insert(
            QuestionEntity(
                question = "¿Qué es JSX?",
                answer = "JSX es una extensión de la sintaxis de JavaScript que permite escribir HTML dentro de JavaScript. Se utiliza en React para describir la interfaz de usuario.",
                technology = 1,
                difficulty = 1
            )
        )
        questionDao.insert(
            QuestionEntity(
                question = "¿Qué es el estado (state) en React?",
                answer = "El estado (state) en React es un objeto que almacena datos que pueden cambiar con el tiempo y que afectan la representación del componente.",
                technology = 1,
                difficulty = 1
            )
        )
        questionDao.insert(
            QuestionEntity(
                question = "¿Cómo se pasa información entre componentes en React?",
                answer = "La información se pasa entre componentes en React a través de props, que son argumentos que se pasan a un componente hijo desde un componente padre.",
                technology = 1,
                difficulty = 1
            )
        )
        questionDao.insert(
            QuestionEntity(
                question = "¿Qué es el ciclo de vida de un componente en React?",
                answer = "El ciclo de vida de un componente en React se refiere a las fases por las que pasa un componente (montaje, actualización y desmontaje) y los métodos asociados a cada fase.",
                technology = 1,
                difficulty = 1
            )
        )
        questionDao.insert(
            QuestionEntity(
                question = "¿Cómo se manejan los eventos en React?",
                answer = "Los eventos en React se manejan mediante el uso de atributos en JSX, que se pasan como funciones de manejo de eventos. Por ejemplo: <button onClick={handleClick}>Click me</button>",
                technology = 1,
                difficulty = 1
            )
        )
        questionDao.insert(
            QuestionEntity(
                question = "¿Qué es un hook en React?",
                answer = "Un hook en React es una función especial que permite usar el estado y otras características de React en componentes funcionales. Por ejemplo: useState y useEffect.",
                technology = 1,
                difficulty = 1
            )
        )
        questionDao.insert(
            QuestionEntity(
                question = "¿Qué hace el hook useState?",
                answer = "El hook useState permite añadir estado a un componente funcional. Devuelve un par: el estado actual y una función para actualizarlo.",
                technology = 1,
                difficulty = 1
            )
        )

        //Preguntas React js mid-level
        questionDao.insert(
            QuestionEntity(
                question = "¿Qué es el hook useEffect y para qué se utiliza?",
                answer = "El hook useEffect se utiliza para realizar efectos secundarios en componentes funcionales, como obtener datos, suscribirse a servicios, o manipular el DOM.",
                technology = 1,
                difficulty = 2
            )
        )
        questionDao.insert(
            QuestionEntity(
                question = "¿Cómo se maneja la actualización de un componente en React?",
                answer = "Un componente se actualiza cuando cambian sus props o su estado. React compara la representación actual con la nueva y actualiza solo las partes necesarias del DOM.",
                technology = 1,
                difficulty = 2
            )
        )
        questionDao.insert(
            QuestionEntity(
                question = "¿Qué es el Context API en React?",
                answer = "El Context API permite compartir datos globales entre componentes sin necesidad de pasar props manualmente en cada nivel del árbol de componentes.",
                technology = 1,
                difficulty = 2
            )
        )
        questionDao.insert(
            QuestionEntity(
                question = "¿Cómo se optimiza el rendimiento de un componente en React?",
                answer = "Se puede optimizar el rendimiento de un componente utilizando técnicas como React.memo, useMemo, useCallback, y evitando renders innecesarios.",
                technology = 1,
                difficulty = 2
            )
        )
        questionDao.insert(
            QuestionEntity(
                question = "¿Qué es un portal en React?",
                answer = "Un portal en React permite renderizar un hijo en un nodo DOM diferente al de su padre. Se utiliza para renderizar componentes fuera de la jerarquía principal del DOM.",
                technology = 1,
                difficulty = 2
            )
        )
        questionDao.insert(
            QuestionEntity(
                question = "¿Cómo se implementa el enrutamiento en una aplicación React?",
                answer = "El enrutamiento en una aplicación React se implementa utilizando bibliotecas como React Router, que permiten definir rutas y navegarlas sin recargar la página.",
                technology = 1,
                difficulty = 2
            )
        )
        questionDao.insert(
            QuestionEntity(
                question = "¿Qué es Redux y cómo se usa con React?",
                answer = "Redux es una biblioteca de gestión de estado predecible para aplicaciones JavaScript. Se usa con React para manejar el estado global de la aplicación mediante el uso de un store centralizado.",
                technology = 1,
                difficulty = 2
            )
        )
        questionDao.insert(
            QuestionEntity(
                question = "¿Qué es el hook useReducer y cómo se diferencia de useState?",
                answer = "useReducer es un hook que se utiliza para manejar estados más complejos. Se diferencia de useState en que utiliza un reductor para gestionar las actualizaciones del estado.",
                technology = 1,
                difficulty = 2
            )
        )
        questionDao.insert(
            QuestionEntity(
                question = "¿Cómo se utilizan las refs en React?",
                answer = "Las refs se utilizan en React para acceder directamente a un elemento DOM o a un componente hijo, permitiendo manipularlo o consultar sus propiedades.",
                technology = 1,
                difficulty = 2
            )
        )
        questionDao.insert(
            QuestionEntity(
                question = "¿Qué es la Suspense en React y para qué se utiliza?",
                answer = "Suspense es una característica de React que permite esperar la carga de componentes asíncronos, mostrando una interfaz de espera mientras se carga el contenido.",
                technology = 1,
                difficulty = 2
            )
        )

        //Preguntas React js nivel Senior
        questionDao.insert(
            QuestionEntity(
                question = "¿Qué es el Server-Side Rendering (SSR) en React y cuáles son sus beneficios?",
                answer = "El Server-Side Rendering (SSR) es una técnica para renderizar una aplicación React en el servidor y enviar el HTML al cliente. Sus beneficios incluyen un mejor rendimiento inicial y SEO.",
                technology = 1,
                difficulty = 3
            )
        )
        questionDao.insert(
            QuestionEntity(
                question = "¿Cómo funciona la reconciliación en React?",
                answer = "La reconciliación es el proceso por el cual React actualiza el DOM para que coincida con el estado actual del componente. Utiliza un algoritmo de comparación para determinar qué partes del DOM necesitan cambios.",
                technology = 1,
                difficulty = 3
            )
        )
        questionDao.insert(
            QuestionEntity(
                question = "¿Qué son los higher-order components (HOC) en React?",
                answer = "Los higher-order components (HOC) son patrones de diseño avanzados en React que permiten reutilizar la lógica de componentes. Un HOC es una función que toma un componente y devuelve un nuevo componente con funcionalidades adicionales.",
                technology = 1,
                difficulty = 3
            )
        )
        questionDao.insert(
            QuestionEntity(
                question = "¿Qué es un hook personalizado en React y cómo se crea?",
                answer = "Un hook personalizado es una función que reutiliza lógica de estado o efectos en componentes funcionales. Se crea combinando hooks existentes dentro de una nueva función que se puede reutilizar en varios componentes.",
                technology = 1,
                difficulty = 3
            )
        )
        questionDao.insert(
            QuestionEntity(
                question = "¿Qué es React Fiber y cuáles son sus ventajas?",
                answer = "React Fiber es una reescritura del núcleo de React que permite una mejor gestión de la conciliación y la representación de componentes, mejorando el rendimiento y la capacidad de respuesta de la interfaz de usuario.",
                technology = 1,
                difficulty = 3
            )
        )
        questionDao.insert(
            QuestionEntity(
                question = "¿Cómo se implementan las rutas dinámicas en React Router?",
                answer = "Las rutas dinámicas en React Router se implementan utilizando parámetros en las rutas, que se pueden definir con el símbolo de dos puntos. Por ejemplo: <Route path='/user/:id' component={UserComponent} />.",
                technology = 1,
                difficulty = 3
            )
        )
        questionDao.insert(
            QuestionEntity(
                question = "¿Qué es el renderizado anticipado (pre-rendering) y cómo se implementa en Next.js?",
                answer = "El renderizado anticipado (pre-rendering) es una técnica que genera HTML en el momento de la compilación. En Next.js se implementa usando getStaticProps y getServerSideProps para obtener datos antes de la renderización.",
                technology = 1,
                difficulty = 3
            )
        )
        questionDao.insert(
            QuestionEntity(
                question = "¿Cómo se maneja la autenticación en una aplicación React?",
                answer = "La autenticación en una aplicación React se maneja utilizando bibliotecas como Firebase, Auth0 o implementaciones personalizadas con JWT. Se protegen las rutas y se maneja el estado de autenticación en el contexto global.",
                technology = 1,
                difficulty = 3
            )
        )
        questionDao.insert(
            QuestionEntity(
                question = "¿Cómo se implementa la internacionalización (i18n) en React?",
                answer = "La internacionalización en React se implementa usando bibliotecas como react-i18next, que permite gestionar traducciones y cambiar el idioma de la aplicación dinámicamente.",
                technology = 1,
                difficulty = 3
            )
        )

    }
}