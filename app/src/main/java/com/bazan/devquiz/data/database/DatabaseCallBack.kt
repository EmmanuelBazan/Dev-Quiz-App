package com.bazan.devquiz.data.database

import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.bazan.devquiz.data.database.dao.DifficultyDao
import com.bazan.devquiz.data.database.dao.QuestionDao
import com.bazan.devquiz.data.database.dao.TechnologyDao
import com.bazan.devquiz.data.database.entities.DifficultyEntity
import com.bazan.devquiz.data.database.entities.QuestionEntity
import com.bazan.devquiz.data.database.entities.TechnologyEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

class DatabaseCallBack @Inject constructor(
    private val technologyDaoProvider: Provider<TechnologyDao>,
    private val difficultyDaoProvider: Provider<DifficultyDao>,
    private val questionDaoProvider: Provider<QuestionDao>,
) : RoomDatabase.Callback() {

    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)
        CoroutineScope(Dispatchers.IO).launch {
            populateDatabase(
                technologyDaoProvider.get(),
                difficultyDaoProvider.get(),
                questionDaoProvider.get()
            )
        }
    }

    private suspend fun populateDatabase(
        technologyDao: TechnologyDao,
        difficultyDao: DifficultyDao,
        questionDao: QuestionDao
    ) {
        // Insertar dificultades
        difficultyDao.insert(DifficultyEntity(name = "Fácil", description = ""))
        difficultyDao.insert(DifficultyEntity(name = "Intermedio", description = ""))
        difficultyDao.insert(DifficultyEntity(name = "Difícil", description = ""))

        // Insertar tecnologías
        technologyDao.insert(TechnologyEntity(name = "React", icon = 1, description = ""))
        technologyDao.insert(TechnologyEntity(name = "JavaScript", icon = 2, description = ""))

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
    }
}
