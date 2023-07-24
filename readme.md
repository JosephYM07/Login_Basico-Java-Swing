# Integrantes
1. Joseph Yépez
2. Jared Valenzuela
3. Alejandro Moreira

# Introducción

__Tema:__ Programa de Registro e Inicio de Sesión

Este es un programa de registro e inicio de sesión desarrollado en Java utilizando la biblioteca Swing para la interfaz gráfica. El programa consta de tres formularios diferentes:

### 1. Formulario de Login
El formulario de login permite a los usuarios ingresar sus credenciales (nombre de usuario y contraseña). Luego, pueden hacer clic en el botón "Iniciar Sesión" para verificar si las credenciales son correctas. Si las credenciales son válidas, el programa muestra el formulario de Información. Si las credenciales son incorrectas, se muestra un mensaje de error.

### 2. Formulario de Registro
El formulario de registro permite a los usuarios crear una nueva cuenta. Los usuarios deben ingresar un nombre de usuario, una contraseña y sus nombres completos. Una vez que los campos están completos, pueden hacer clic en el botón "Registrarse" para crear una nueva cuenta. Después de registrar una nueva cuenta, el usuario será redirigido al formulario de login.

### 3. Formulario de Información
El formulario de información muestra la información del usuario una vez que ha iniciado sesión correctamente. En este formulario, se muestra un mensaje de bienvenida con el nombre de usuario del usuario que ha iniciado sesión. Además, hay un botón "Cerrar Sesión" que permite al usuario cerrar su sesión actual y volver al formulario de login.

### Funcionalidades adicionales
- Cargar datos de usuarios desde un archivo (`usuarios.dat`) al iniciar el programa. Esto permite que los usuarios registrados previamente se carguen automáticamente cuando se inicia el programa.
- Guardar nuevos registros de usuarios en el archivo `usuarios.dat` después de que se haya realizado el registro exitosamente.
- Validar las credenciales ingresadas en el formulario de login para permitir el inicio de sesión solamente a usuarios registrados.
- Utilizar una clase `Usuario` en el paquete "Class" para representar los datos de cada usuario, que incluye el nombre de usuario, la contraseña y los nombres completos.

El programa utiliza la interfaz gráfica de usuario proporcionada por la biblioteca Swing, lo que permite una interacción intuitiva y amigable con los usuarios.

## Instrucciones de Uso
1. Al iniciar el programa, se mostrará el formulario de login. Deberá cargar los datos mediante el botón "cargar datos" donde  previamente, se cargarán automáticamente desde el archivo `usuarios.dat`.
2. Si es un nuevo usuario, haga clic en el botón "Registrarse" para abrir el formulario de registro. Complete los campos requeridos y haga clic en "Registrarse" para crear una nueva cuenta.
3. Si es un usuario registrado, ingrese su nombre de usuario y contraseña en el formulario de login. Haga clic en "Iniciar Sesión" para acceder al formulario de información.
4. Una vez que haya iniciado sesión, verá un mensaje de bienvenida con su nombre de usuario en el formulario de información.
5. Para cerrar la sesión actual, haga clic en el botón "Cerrar Sesión". Se cerrará el formulario de información y volverá al formulario de login.

# Login_Form
